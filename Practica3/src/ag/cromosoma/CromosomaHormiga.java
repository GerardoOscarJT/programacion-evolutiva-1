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

    static int board_width = 20;
    static int board_height = 15;
    static int[][] tablero_inicial = new int[board_height][board_width];

    private double _evaluacion = 0;

    Arbol programa;

    public CromosomaHormiga() {
        tablero_inicial[1][2] = 23;
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

        /*
        String linea;
        String[] datos;
        LeerArchivo manejador = new LeerArchivo();
        linea=manejador.inicializa(f);
        datos=linea.split(" ");
        numAlumnos=Integer.valueOf(datos[0]);
        int incompatibilidades = Integer.valueOf(datos[1]);
        ids = new HashMap<Integer, Integer>(numAlumnos);
        idsContrario = new HashMap<Integer, Integer>(numAlumnos);
        alumnos = new ArrayList<Alumno>(numAlumnos);
        for (int i=0;i<numAlumnos;i++){
            linea = manejador.dameLinea();
            datos=linea.split(" ");
            int id=Integer.valueOf(datos[0]);
            double nota= Float.valueOf(datos[1]);
            ids.put(id, i);
            idsContrario.put(i,id);
            Alumno alumno = new Alumno(id,nota);
            alumnos.add(i, alumno);
        }
        for (int i=0;i<incompatibilidades;i++){
            linea = manejador.dameLinea();
            datos=linea.split(" ");
            int alumno=Integer.valueOf(datos[0]);
            int enemigo=Integer.valueOf(datos[1]);
            int idAlumno=ids.get(alumno);
            int idEnemigo= ids.get(enemigo);
            alumnos.get(idAlumno).getEnemigos().add(idEnemigo);
        }
         * 
         */
    }

}
