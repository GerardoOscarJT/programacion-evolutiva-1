/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.mutacion;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaStaticArray;
import ag.gen.Gen;

/**
 *
 * @author gerardo
 */
public class MutacionInversion extends Mutacion {

    public void muta(Cromosoma c) {
        CromosomaStaticArray cc = (CromosomaStaticArray)c;

        int aleatorio1 = utiles.Aleatorio.getRandomInt(cc.genes.length);
        int aleatorio2 = utiles.Aleatorio.getRandomInt(cc.genes.length);

        int puntoA = Math.min(aleatorio1, aleatorio2);
        int puntoB = Math.max(aleatorio1, aleatorio2);

        int n = (int) Math.floor((puntoA+puntoB)/2);

        for (int i=puntoA,j=puntoB; i<n; i++,j--) {
            Gen aux = cc.genes[i];
            cc.genes[i] = cc.genes[j];
            cc.genes[j] = aux;
        }

     }


}
