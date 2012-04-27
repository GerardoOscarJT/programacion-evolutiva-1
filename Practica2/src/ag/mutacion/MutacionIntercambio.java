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
public class MutacionIntercambio extends Mutacion {

    public void muta(Cromosoma c) {
        CromosomaStaticArray cc = (CromosomaStaticArray)c;

        int puntoA = utiles.Aleatorio.getRandomInt(cc.genes.length);
        int puntoB = utiles.Aleatorio.getRandomInt(cc.genes.length);

        Gen aux = cc.genes[puntoA];
        cc.genes[puntoA] = cc.genes[puntoB];
        cc.genes[puntoB] = aux;

     }

}
