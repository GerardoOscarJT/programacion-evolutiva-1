/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.mutacion;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaAlumnos;
import ag.cromosoma.CromosomaStaticArray;
import ag.gen.GenEntero;

/**
 *
 * @author gerardo
 */
public class MutacionInsercion extends Mutacion {

    @Override
    public void muta(Cromosoma c) {
        CromosomaStaticArray cc = (CromosomaStaticArray)c;
        int longitud = cc.genes.length;
        int[] lista = new int[longitud];
        for (int i=0;i<longitud;i++){
            GenEntero genAux;// = new GenEntero();
            genAux=(GenEntero)cc.genes[i].copia(cc.genes[i]);
            lista[i]=genAux.valor;
        }
        /*int g =
        for (int i=0;i<nuevo.genesA.length;i++){
                int genMuta = utiles.Aleatorio.getRandomInt(nuevo.genesA.length);
                int valorMuta = utiles.Aleatorio.getRandomInt(nuevo.genesA.length);
                    nuevo.genesA[genMuta].valor=valorMuta;
            }*/
    }
 }
