/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

/**
 *
 * @author gerardo
 */
public class AlgoritmoGenetico<C> {
    public int tamano = 100;
    public int num_generaciones = 100;
    public double prob_cruce = 0.1;
    public double prob_mutacion = 0.01;
    
    public PriorityQueue<C> poblacion;

    public void inicializa() {
        poblacion = new PriorityQueue<C>();

        for (int i=0; i<tamano; i++) {
            //poblacion.add();
        }

    }

}
