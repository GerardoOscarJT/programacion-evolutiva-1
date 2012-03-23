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
public class CromosomaF5 extends Cromosoma {

    public static int v = 3;

    public CromosomaF5() {
        genes = new Gen[v];
        for (int i = 0; i<v; i++)
            genes[i] = new Gen();

        Aleatorizar();
    }


    @Override
    public double Fenotipo(int i) {

        double min=0;
        double max=Math.PI;

        double x = min+(max-min)*genes[i].getInt()/(Math.pow(2,Gen.bits));
        return x;

    }

    @Override
    public double Fitness() {
        double resultado = 0;

        for (int i = 0; i<v; i++) {
            double x = Fenotipo(i);
            resultado += Math.sin(x)*Math.pow(Math.sin((i+2)*Math.pow(x,2)/Math.PI),20);
        }

        return -resultado;
    }

    @Override
    public Cromosoma crearNuevo() {
        return new CromosomaF5();

    }

}