/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cruce;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaAlumnos;

/**
 *
 * @author gerardo
 */
public class CruceVarianteOX extends Cruce {

    double p = 0.33; // Factor de proporcion de los genes que se mantienen

    
    public void cruza(Cromosoma a, Cromosoma b) {
        CromosomaAlumnos aa = (CromosomaAlumnos) a;
        CromosomaAlumnos bb = (CromosomaAlumnos) b;

        int l = aa.genesA.length;
        int L = (int) (p*l);

        int[] hijoA = new int[l];
        int[] hijoB = new int[l];

        boolean[] usadosA = new boolean[l];
        boolean[] usadosB = new boolean[l];

        // Inicializo los dos nuevos hijos a -1
        for (int i=0; i<l; i++) {
            hijoA[i] = -1;
            hijoB[i] = -1;
            usadosA[i] = false;
            usadosB[i] = false;
        }

        // (1) Copio L posiciones aleatorias
        for (int i=0; i<L; i++) {
            int posicion = utiles.Aleatorio.getRandomInt(l);

            int vA = aa.genesA[posicion].valor;
            int vB = bb.genesA[posicion].valor;

            hijoA[posicion] = vB;
            usadosA[vB] = true;

            hijoB[posicion] = vA;
            usadosB[vA] = true;
        }

        // (2) Relleno manteniendo el orden


        int ultimo;

        // Relleno el A
        ultimo = 0;
        for (int i=0; i<l; i++)
            if (hijoA[i] == -1) {
                while (usadosA[aa.genesA[ultimo].valor])
                    ultimo++;

                hijoA[i] = aa.genesA[ultimo].valor;
                usadosA[aa.genesA[ultimo].valor]=true;
            }


        // Relleno el B
        ultimo = 0;
        for (int i=0; i<l; i++)
            if (hijoB[i] == -1) {
                while (usadosB[bb.genesA[ultimo].valor])
                    ultimo++;

                hijoB[i] = bb.genesA[ultimo].valor;
                usadosB[bb.genesA[ultimo].valor]=true;
            }


        // Copio los resultados en los cromosomas originales
        for (int i=0; i<l; i++) {
            aa.genesA[i].valor = hijoA[i];
            bb.genesA[i].valor = hijoB[i];
        }

    }

}
