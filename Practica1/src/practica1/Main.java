/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1;

import ag.AlgoritmoGenetico;
import practica1.funcion1.*;

/**
 *
 * @author gerardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        AlgoritmoGenetico ag = new AlgoritmoGenetico<CromosomaF1>();
        ag.tamano = 100;
        ag.num_generaciones = 100;
        ag.prob_cruce = 0.1;
        ag.prob_mutacion = 0.01;

        ag.inicializa();








    }

}
