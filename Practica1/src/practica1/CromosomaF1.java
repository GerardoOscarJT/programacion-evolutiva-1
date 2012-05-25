/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1;

import ag.Cromosoma;
import ag.Gen;

/**
 *
 * @author gerardo
 */
public class CromosomaF1 extends Cromosoma {
    
    public CromosomaF1() {
        genes = new Gen[1];
        genes[0] = new Gen();

        Aleatorizar();
    }

    public double Fitness() {
        double x = Fenotipo(0);

        return x+Math.abs(Math.sin(32*Math.PI*x));
    }

    public double Evaluacion() {
        return Fitness();
    }

    public double Fenotipo(int n) {
        switch (n) {
            case 0:

            double min=0;
            double max=1;

            double x = min+(max-min)*genes[0].getInt()/(Math.pow(2,Gen.bits));
            return x;
        }

        return 0;
    }

    public CromosomaF1 crearNuevo() {
        return new CromosomaF1();
    }



}
