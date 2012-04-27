/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cruce;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaAlumnos;
import ag.cromosoma.CromosomaStaticArray;
import ag.gen.Gen;
import ag.gen.GenEntero;
import java.util.ArrayList;

/**
 *
 * @author gerardo
 */
public class CruceOrdinal extends Cruce {

    /**
     * Cruza dos cromosomas con los siguiente requisitos:
     * 1º- El cromosoma tiene que heredar de CromosomaStaticArray.
     * 2º- Los genes tienen que heredar de genEntero.
    */
    public void cruza(Cromosoma a, Cromosoma b) {
        CromosomaStaticArray aa = (CromosomaStaticArray)a;
        CromosomaStaticArray bb = (CromosomaStaticArray)b;
        
        int longitud=aa.genes.length;

        //Realizamos las codificacinoes de los cromosomas.
        //Nos creamos los arrayList necesarios y los rellenamos
        ArrayList<Integer> copiaA = new ArrayList(longitud);
        ArrayList<Integer> copiaB = new ArrayList(longitud);
        
        ArrayList<Integer> copiaABorrar = new ArrayList(longitud);
        ArrayList<Integer> copiaBBorrar = new ArrayList(longitud);
        ArrayList<Integer> codA = new ArrayList(longitud);
        ArrayList<Integer> codB = new ArrayList(longitud);
        
        Gen[] reordenacionA = new Gen[longitud];
        Gen[] reordenacionB = new Gen[longitud];
             
        
        for (int i=0;i<longitud;i++){
             int valorA = ((GenEntero)aa.genes[i]).valor;
             int valorB = ((GenEntero)bb.genes[i]).valor;
                     
             copiaA.add(i,valorA);
             copiaB.add(i,valorB);
             copiaABorrar.add(i,valorA);
             copiaBBorrar.add(i,valorB);
             //TODO: Segunda copia;
        }
        for (int i=0;i<longitud;i++){
            int indiceA = getIndice(copiaABorrar,i);
            int indiceB = getIndice(copiaBBorrar,i);
            codA.add(indiceA);
            codB.add(indiceB);
            copiaABorrar.remove(indiceA);
            copiaBBorrar.remove(indiceB);
        }
        int N = codA.size();
        for (int i = N-1, j=0;j<N;i--,j++){
            copiaABorrar.add(codB.get(i),copiaA.get(j));
            copiaBBorrar.add(codA.get(i),copiaB.get(j));
        }
        
        for (int i=0;i<longitud;i++){
            reordenacionA[i]=aa.genes[copiaABorrar.get(i)];
            reordenacionB[i]=bb.genes[copiaBBorrar.get(i)];
        }
        for (int i=0;i<longitud;i++){
            aa.genes[i] = reordenacionA[i];
            bb.genes[i] = reordenacionB[i];
        }
       
        //TODO:Actualizar los cromosomas con los resultados obtenidos.
    }
    
    private int getIndice(ArrayList<Integer> lista, int element){
        
       int n = lista.size();
       for (int i=0;i<n;i++)
                if (lista.get(i)==element) return i;
       return -1;
    }
}
