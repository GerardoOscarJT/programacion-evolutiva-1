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
public class CromosomaFake extends Cromosoma {

    public CromosomaFake() {
        genes = new Gen[1];
        genes[0] = new Gen();
        Aleatorizar();
    }

    @Override
    public double Fenotipo(int i) {
        return 0;
    }

    @Override
    public double Fitness() {
        return genes[0].getInt() - 1000000;
    }

    @Override
    public Cromosoma crearNuevo() {
        return new CromosomaFake();
    }

}
