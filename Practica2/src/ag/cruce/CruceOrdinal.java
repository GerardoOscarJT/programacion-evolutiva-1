/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cruce;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaAlumnos;
import ag.cromosoma.CromosomaStaticArray;
import ag.gen.GenEntero;

/**
 *
 * @author gerardo
 */
public class CruceOrdinal extends Cruce {

    @Override
    public void cruza(Cromosoma a, Cromosoma b) {
        CromosomaStaticArray aa = (CromosomaStaticArray)a;
        CromosomaStaticArray bb = (CromosomaStaticArray)b;

        //for (int i=0; i<nuevo1.genesA.length; i++) {
            /*// Elegimos un punto de corte
            // Del gen g elijo un bit e intercambio a nivel de bit
            //int b = utiles.Aleatorio.getRandomInt(nuevo1.genes[i].genes[i].datos.length);

            // Intercambio todos los bits que estÃ¡n a la izquierda
            for (int j=0; j<b; j++) {
                int aux = c.genes[i].datos[j];
                c.genes[i].datos[j] = genes[i].datos[j];
                genes[i].datos[j] = aux;
            }
        }*/
        // Elegimos un gen de todos los que tenemos
        int g = utiles.Aleatorio.getRandomInt(aa.genes.length);

        // Intercambio los genes que hay a la izquierda
        for (int i=0; i<g; i++) {
            /*Gen aux = c.genes[i];
            c.genes[i] = genes[i];
            genes[i] = aux;*/
            GenEntero aux =aa.genes;
            nuevo1.genesA[i]=nuevo2.genesA[i];
            nuevo2.genesA[i]=aux;
        }
    }

}
