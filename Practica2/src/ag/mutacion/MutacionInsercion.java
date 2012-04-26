/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.mutacion;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaAlumnos;

/**
 *
 * @author gerardo
 */
public class MutacionInsercion extends Mutacion {

    @Override
    public void muta(Cromosoma c) {
        CromosomaAlumnos nuevo = new CromosomaAlumnos();
        for (int i=0;i<nuevo.genesA.length;i++){
                int genMuta = utiles.Aleatorio.getRandomInt(nuevo.genesA.length);
                int valorMuta = utiles.Aleatorio.getRandomInt(nuevo.genesA.length);
                    nuevo.genesA[genMuta].valor=valorMuta;
            }
    }
 }
