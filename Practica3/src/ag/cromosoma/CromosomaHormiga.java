/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cromosoma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import practica3.Arbol;
import practica3.ArbolNoterminal;
import practica3.ArbolOLD;
import practica3.ArbolTerminal;
import practica3.TipoArbol;
import utiles.LeerArchivo;

/**
 *
 * @author gerardo
 */
public class CromosomaHormiga extends Cromosoma {

    /**
     * Parámetros del problema (En teoría sirve para acotar la búsqueda)
     */
    public static int profundidad_maxima = 6;
    public static int numero_nodos_maximo = 100;
    public static int numero_maximo_pasos = 400;
    public static int comida_maxima = 89;
    public static double factor_de_ajuste = 0.82;

    static int board_width = 32;
    static int board_height = 32;
    static int[][] tablero_inicial = new int[board_height][board_width];

    private double _evaluacion = 0;
    private double _fenotipo = 0;

    public Arbol programa;


    /**
     * Los siguientes atributos sirven para emular el comportamiento de la hormiga
     * y así obtener una función de evaluación de puta madre
     */
    int emu_dir_x[] = {1,0,-1,0};
    int emu_dir_y[] = {0,1,0,-1};

    int emu_tablero[][];
    int emu_raciones = 0;
    int emu_avances = 0;

    int emu_pos_x = 0;
    int emu_pos_y = 0;
    int emu_dir = 0;





    public CromosomaHormiga() {
        aleatoriza();
    }
    
    public double evaluacion() {
        //recalcularEvaluacion();
        return _evaluacion;
    }

    public void recalcularEvaluacion() {
        // Inicializo ALL
        emu_dir = 0;
        emu_pos_x = 0;
        emu_pos_y = 0;
        emu_raciones = 0;
        emu_avances = 0;

        // Copio el tablero
        emu_tablero = new int[board_height][board_width];
        for (int i=0; i<board_height; i++)
            for (int j=0; j<board_height; j++)
                    emu_tablero[i][j] = this.tablero_inicial[i][j];

        int p;
        for (p=0; p<(numero_maximo_pasos-emu_avances); p++) {
            ejecutarArbol(programa);
        }

        _fenotipo = emu_raciones;
        _evaluacion = (double) emu_raciones / (double) (p+1);
        _evaluacion = emu_raciones;

        // TODO: si se pasa del nº máximo de nodos, divir por 2
        // TODO: si se pasa de la profundidad máxima, divir otra vez por dos
    }

    private void ejecutarArbol(Arbol a) {
        switch (a.getTipo()) {
            case TERMINAL:
                ArbolTerminal at = (ArbolTerminal) a;
                switch (at.functor) {
                    case AVANZA:
                        emu_avances++;
                        if (emu_tablero[emu_pos_y][emu_pos_x] == 1) {
                            emu_tablero[emu_pos_y][emu_pos_x] = 3;
                            emu_raciones++;
                        } else if (emu_tablero[emu_pos_y][emu_pos_x] == 0) {
                            emu_tablero[emu_pos_y][emu_pos_x] = 2;
                        }
                        emu_pos_x = (emu_pos_x + emu_dir_x[emu_dir] + board_width) % board_width;
                        emu_pos_y = (emu_pos_y + emu_dir_y[emu_dir] + board_height) % board_height;
                        break;
                    case IZQUIERDA:
                        emu_dir = (emu_dir+3) % 4;
                        break;
                    case DERECHA:
                        emu_dir = (emu_dir+1) % 4;
                        break;
                }
                break;

            case NOTERMINAL:
                ArbolNoterminal an = (ArbolNoterminal) a;

                switch (an.functor) {
                    case PROGN2:
                        ejecutarArbol(an.hijos[0]);
                        ejecutarArbol(an.hijos[1]);
                        break;
                    case SIC:
                        int delante_x = (emu_pos_x + emu_dir_x[emu_dir] + board_width) % board_width;
                        int delante_y = (emu_pos_y + emu_dir_y[emu_dir] + board_height) % board_height;

                        if (emu_tablero[delante_y][delante_x] == 1) {
                            ejecutarArbol(an.hijos[0]);
                        } else {
                            ejecutarArbol(an.hijos[1]);
                        }
                        break;
                }
                break;
        }
    }

    public void aleatoriza() {
        programa = new ArbolNoterminal();
        programa.aletorizar();
        recalcularEvaluacion();
    }

    public double fenotipo() {
        return _fenotipo;
    }

    public String toString() {
        // TODO: Devolver el programa
        return programa.toString();
    }

    public String toHTML() {
        String html = "<style type='text/css'>"
                + "TD {width:16px; height:16px; font-size:1px;}"
                + ".dos {background-color:black;}"
                + ".tres {background-color:#9999FF;}"
                + ".cuatro {background-color:#333399;}"
                + "</style>";

        recalcularEvaluacion();

        html += "<table cellpadding=0 cellspacing=0 style='border:solid silver 1px;'>";
        for (int i = 0; i<32; i++) {
            html += "<tr>";
            for (int j=0; j<32; j++) {
                switch(emu_tablero[i][j]) {
                    case 1:
                        html += "<td class='dos'>";
                        break;
                    case 2:
                        html += "<td class='tres'>";
                        break;
                    case 3:
                        html += "<td class='cuatro'>";
                        break;
                    default:
                        html += "<td>";
                }
                html += "&nbsp;</td>";
            }
            html += "</tr>\n";
        }

        html += "</table>";

        return html;
    }

    public Cromosoma nuevo() {
        return new CromosomaHormiga();
    }

    public Object clone() {
        CromosomaHormiga ca = new CromosomaHormiga();
        ca.programa = (Arbol) this.programa.clone();
        ca._evaluacion = this._evaluacion;
        ca._fenotipo = this._fenotipo;
        ca.recalcularEvaluacion();
        return ca;
    }

    public static void leer(File f) throws FileNotFoundException, IOException {
        LeerArchivo lectura = new LeerArchivo();
        lectura.inicializa(f);
        String linea;
        for (int i=0;i<board_height;i++){
            linea = lectura.dameLinea();
            for (int j=0;j<board_width;j++){
                tablero_inicial[i][j]=Integer.parseInt(linea.substring(j, j+1));
            }
        }
    }

}
