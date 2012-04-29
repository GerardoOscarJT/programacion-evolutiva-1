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
import utiles.Aleatorio;

/**
 *
 * @author gerardo
 */
public class CruceOX extends Cruce {

    public void cruza(Cromosoma a, Cromosoma b) {
        CromosomaStaticArray aa = (CromosomaStaticArray)a;
        CromosomaStaticArray bb = (CromosomaStaticArray)b;
        int longitud=aa.genes.length;
        ArrayList<Integer> copiaA = new ArrayList<Integer>(longitud);
        ArrayList<Integer> copiaB = new ArrayList<Integer>(longitud);
        ArrayList<Integer> reordenA = new ArrayList<Integer>(longitud);
        ArrayList<Integer> reordenB = new ArrayList<Integer>(longitud);
        Gen[] reordenacionA = new Gen[longitud];
        Gen[] reordenacionB = new Gen[longitud];
        
        int ind1 = Aleatorio.getRandomInt(longitud);
        int ind2 = Aleatorio.getRandomInt(longitud);
        int min = Math.min(ind1, ind2);
        int max = Math.max(ind1,ind2);
        for (int i=min;i<=max;i++){
            copiaA.add(((GenEntero)aa.genes[i]).valor);
            copiaB.add(((GenEntero)bb.genes[i]).valor);
        }
        int indiceA=(max+1)%longitud;
        int indiceB=(max+1)%longitud;
        int nA = longitud-(max-min+1);
        int nB = longitud-(max-min+1);
        for (int i=0;i<longitud;i++){
            int indice = (max+i+1)%longitud;
            if((indice>=min) && (indice<=max)){
                reordenA.add(((GenEntero)aa.genes[indice]).valor);
                reordenB.add(((GenEntero)bb.genes[indice]).valor);
            }else{
                while((copiaA.contains(((GenEntero)bb.genes[indiceA%longitud]).valor))&&(nA>0)){
                    indiceA++;
                }
                if (nA>0){
                    reordenA.add(((GenEntero)bb.genes[indiceA%longitud]).valor);
                    indiceA++;
                    nA--;
                }
                
                while((copiaB.contains(((GenEntero)aa.genes[indiceB%longitud]).valor))&&(nB>0)){ 
                    indiceB++;
                }
                if (nB>0){
                    reordenB.add(((GenEntero)aa.genes[indiceB%longitud]).valor);
                    indiceB++;
                    nB--;
                }
            }
        }
        for (int i=0;i<longitud;i++){
            reordenacionA[i]=aa.genes[reordenA.get(i)];
            reordenacionB[i]=bb.genes[reordenB.get(i)];
        }
        for (int i=0;i<longitud;i++){
            aa.genes[i] = reordenacionA[i];
            bb.genes[i] = reordenacionB[i];
        }
        }

}
