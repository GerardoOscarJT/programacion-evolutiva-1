/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica2;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaStaticArray;
import ag.gen.Gen;

/**
 *
 * @author gerardo
 */
public class CromosomaE1 extends CromosomaStaticArray {

    public static int N = 9; // Número de alumnos
    public static int M = 3; // Número de grupos
    public static double alpha = 0.5; // Coeficiente de balance

    @Override
    public Cromosoma nuevo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int compareTo(Cromosoma o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

/*
    public CromosomaE1() {
        genes = new Gen[1];
        genes[0] = new Gen();
    }

    @Override
    public String Fenotipo() {
        // TODO: String que visualice todos los grupos
        return "";
    }

    public double Fenotipo(int i) {
        // no hace falta
        return 0;
    }

    @Override
    public double Fitness() {
        // TODO: aplicar la función
        return 0;
    }

    @Override
    public double Evaluacion() {
        return Fitness();
    }

    @Override
    public Cromosoma crearNuevo() {
        return new CromosomaE1();
    }

    */

    @Override
    public double evaluacion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cromosoma copia(Cromosoma c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
