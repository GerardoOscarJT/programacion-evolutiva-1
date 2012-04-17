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
public class CromosomaF3 extends Cromosoma {

    public CromosomaF3() {
        genes = new Gen[1];
        genes[0] = new Gen();
        Aleatorizar();
    }

    @Override
    public double Fenotipo(int n) {
        switch (n) {
            case 0: {
                double min=0;
                double max=25;

                double x = min+(max-min)*genes[0].getInt()/(Math.pow(2,Gen.bits));
                return x;
            }

        }

        return 0;
    }

    @Override
    public double Fitness() {
        double x = Fenotipo(0);
        return Math.sin(x)/(1 + Math.sqrt(x) + (Math.cos(x)/(1+x)));
    }

    public double Evaluacion() {
        return -Fitness();
    }

    @Override
    public Cromosoma crearNuevo() {
        return new CromosomaF3();
    }

}
