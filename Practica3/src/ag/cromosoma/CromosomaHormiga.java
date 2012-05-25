/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cromosoma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import practica3.Arbol;
import utiles.LeerArchivo;

/**
 *
 * @author gerardo
 */
public class CromosomaHormiga extends Cromosoma {

    /**
     * Parámetros del problema (En teoría sirve para acotar la búsqueda)
     */
    static int profundidad_maxima = 6;
    static int numero_nodos_maximo = 100;
    static int numero_maximo_pasos = 400;
    static int comida_maxima = 89;
    static double factor_de_ajuste = 0.88;
    static int[][] tablero = new int[32][32];

    static int board_width = 32;
    static int board_height = 32;
    static int[][] tablero_inicial = new int[board_height][board_width];

    private double _evaluacion = 0;

    Arbol programa;

    public CromosomaHormiga() {

    }
    
    public CromosomaHormiga(int[][] matriz){
        tablero = matriz;
    }

    public double evaluacion() {
        return _evaluacion;
    }

    public void recalcularEvaluacion() {
        // Ejecutar
    }

    @Override
    public void aleatoriza() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double fenotipo() {
        // No lo usamos
        return 0;
    }

    @Override
    public String toString() {
        // TODO: Devolver el programa
        return "Devolver el programa linea 49 clase CromosomaHormiga\n";
    }

    @Override
    public Cromosoma nuevo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object clone() {
        CromosomaHormiga ca = new CromosomaHormiga();
        // TODO: Copiar arbol, _evaluacion, etc.
        return ca;
    }

    public static void leer(File f) throws FileNotFoundException, IOException {
        LeerArchivo lectura = new LeerArchivo();
        lectura.inicializa(f);
        String linea;
        for (int i=0;i<board_height;i++){
            linea = lectura.dameLinea();
            for (int j=0;j<board_width;j++){
                tablero_inicial[i][j]=linea.charAt(j);
            }
        }
    }

}
