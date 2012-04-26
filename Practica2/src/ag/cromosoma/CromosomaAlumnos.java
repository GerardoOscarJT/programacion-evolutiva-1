/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cromosoma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import practica2.Alumno;

/**
 *
 * @author gerardo
 */
public class CromosomaAlumnos extends CromosomaStaticArray {

    /** Alumnos */
    static ArrayList<Alumno> alumnos;

    /** Relación de ids */
    static Map<Integer, Integer> ids;

    /** Número de grupos */
    private static int g;

    /** Número de alumnos por grupo */
    public static int m = 3;

    /** Factor de desequilibrio (Debe estar entre 0 y 1) */
    public static double a = 0.5;


    public Cromosoma nuevo() {
        return new CromosomaAlumnos();
    }

    @Override
    public Cromosoma copia(Cromosoma c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double evaluacion() {

        // Cálculo de la media
        double media = 0;
        int alumnos_size = alumnos.size();

        for (int i=0; i<alumnos_size; i++)
            media += alumnos.get(i).getNota();

        media /= alumnos_size;

        // Calculamos desequilibrio
        double desequilibrio = 0;
        double desequilibrio_grupo = 0;

        for (int i=0; i<alumnos_size; i++) {
            desequilibrio_grupo += alumnos.get(i).getNota()-media;
            if (i%m == (m-1)) {
                desequilibrio += Math.pow(desequilibrio_grupo, 2);
                desequilibrio_grupo = 0;
            }
        }

        // Calculamos incompatibilidades dentro de cada grupo
        double incompatibilidades = 0;
        for (int i = 0; i<g; i++)
            for (int j = i*m; j<(i+1)*m; j++)
                for (int k = i*m; k<(i+1)*m; k++)
                    if (j!=k &&   alumnos.get(k).getEnemigos().contains(alumnos.get(j).getId())) 
                        incompatibilidades++;
                    


        // Calculamos la función de evaluación
        return a*desequilibrio+(1-a)*incompatibilidades;

    }

    public void leer(String ruta) {

        // TODO: leer nº alumnos y leer nº de relaciones
        int num_alumnos = 8;
        int num_relaciones = 24;

        ids = new HashMap<Integer, Integer>(num_alumnos);

        // TODO: Completar



    }

}
