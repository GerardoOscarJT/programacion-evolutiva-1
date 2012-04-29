/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cruce;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaStaticArray;
import ag.gen.Gen;
import ag.gen.GenEntero;
import java.util.ArrayList;
import java.util.Collections;
import utiles.Aleatorio;

/**
 *
 * @author gerardo
 */
public class CrucePMX extends Cruce {


    public void cruza(Cromosoma a, Cromosoma b) {
        CromosomaStaticArray aa = (CromosomaStaticArray)a;
        CromosomaStaticArray bb = (CromosomaStaticArray)b;
        int longitud=aa.genes.length;
        ArrayList<Integer> copiaA = new ArrayList<Integer>(longitud);
        ArrayList<Integer> copiaB = new ArrayList<Integer>(longitud);
        ArrayList<Integer> insertarA = new ArrayList<Integer>(longitud);
        ArrayList<Integer> insertarB = new ArrayList<Integer>(longitud);
        int[] reordenA = new int[longitud];
        int[] reordenB = new int[longitud];
        Gen[] reordenacionA = new Gen[longitud];
        Gen[] reordenacionB = new Gen[longitud];
      
        int ind1 = Aleatorio.getRandomInt(longitud);
        int ind2 = Aleatorio.getRandomInt(longitud);
        int min = Math.min(ind1,ind2);
        int max = Math.max(ind1,ind2);
        for (int i=min;i<=max;i++){
            copiaA.add(((GenEntero)bb.genes[i]).valor);
            copiaB.add(((GenEntero)aa.genes[i]).valor);
        }
        for (int i=0;i<longitud;i++){
            int indice = (max+i+1)%longitud;
            if (!copiaA.contains(((GenEntero)aa.genes[indice%longitud]).valor))
                insertarA.add(((GenEntero)aa.genes[indice%longitud]).valor);
            if (!copiaB.contains(((GenEntero)bb.genes[indice%longitud]).valor))
                insertarB.add(((GenEntero)bb.genes[indice%longitud]).valor);
        }
        for (int i=0;i<longitud;i++){
            int indice = (max+i+1)%longitud;
            if((indice>=min) && (indice<=max)){
                reordenA[i]=((GenEntero)bb.genes[indice]).valor;
                reordenB[i]=((GenEntero)aa.genes[indice]).valor;
            }else{
                reordenA[i]=insertarA.get(0);
                insertarA.remove(0);
                reordenB[i]=insertarB.get(0);
                insertarB.remove(0);
            }
        }
        for (int i=0;i<longitud;i++){
            reordenacionA[i]=aa.genes[reordenA[i]];
            reordenacionB[i]=bb.genes[reordenB[i]];
        }
        for (int i=0;i<longitud;i++){
            aa.genes[i] = reordenacionA[i];
            bb.genes[i] = reordenacionB[i];
        }
        }

}
