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
public class MutacionInsercion extends Mutacion {

    public void muta(Cromosoma c) {
        CromosomaStaticArray cc = (CromosomaStaticArray)c;
        int longitud = cc.genes.length;
        
        int a = utiles.Aleatorio.getRandomInt(longitud);
        int b = utiles.Aleatorio.getRandomInt(longitud);
        
        Gen aux = cc.genes[a];
        int delta = 0; // Delta es el incremento
        if (a>b) {
            for (int i=a; i>b; i--)
                cc.genes[i] = cc.genes[i-1];
        } else if (a<b) {
            for (int i=a; i<b; i++)
                cc.genes[i] = cc.genes[i+1];
        }
        
        cc.genes[b] = aux;
     }
 }
