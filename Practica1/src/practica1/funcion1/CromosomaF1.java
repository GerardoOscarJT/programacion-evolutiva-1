/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1.funcion1;

import ag.Cromosoma;
import ag.Gen;

/**
 *
 * @author gerardo
 */
public class CromosomaF1 extends Cromosoma {
    
    public CromosomaF1() {
        genes = new Gen[1];
        genes[0] = new Gen(16);

        Aleatorizar();
    }



    public double Fitness() {
        double min=0;
        double max=1;

        double x = min+(max-min)*genes[0].getInt()/(2^16-1);

        return x+Math.abs(Math.sin(32*4*Math.atan(1)*x));
    }

}
