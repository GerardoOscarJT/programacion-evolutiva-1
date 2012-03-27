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
public class CromosomaF2 extends Cromosoma {

    public CromosomaF2() {
        genes = new Gen[2];
        genes[0] = new Gen();
        genes[1] = new Gen();
        Aleatorizar();
    }

    @Override
    public double Fenotipo(int n) {
        switch (n) {
            case 0: {
                double min=-3.0;
                double max=12.1;

                double x = min+(max-min)*genes[0].getInt()/(Math.pow(2,Gen.bits));
                return x;
            }

            case 1: {
                double min=4.1;
                double max=5.8;

                double x = min+(max-min)*genes[1].getInt()/(Math.pow(2,Gen.bits));
                return x;
            }

        }

        return 0;
    }

    @Override
    public double Fitness() {
        double x = Fenotipo(0);
        double y = Fenotipo(1);
        return 21.5 + x*Math.sin(4*Math.PI*x) + y*Math.sin(20*Math.PI*y);

    }

    public double Evaluacion() {
        return Fitness();
    }

    @Override
    public Cromosoma crearNuevo() {
        return new CromosomaF2();
    }

}
