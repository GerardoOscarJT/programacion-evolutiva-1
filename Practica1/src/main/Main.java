/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import ag.*;
import ag.seleccion.*;
import practica1.*;

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


        CromosomaF1 c = new CromosomaF1();
        SeleccionRuleta s = new SeleccionRuleta();


        AlgoritmoGenetico ag = new AlgoritmoGenetico(c,s);
        ag.tamano = 10;
        ag.num_generaciones = 100;
        ag.prob_cruce = 0.1;
        ag.prob_mutacion = 0.01;

        ag.inicializa();




    }

}
