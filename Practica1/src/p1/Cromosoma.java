/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package p1;

/**
 *
 * @author gerardo
 */
public abstract class Cromosoma {

    protected Gen genes[];

    public Cromosoma() {

    }

    public abstract double Fitness();

    public void Aleatorizar() {
        for(int i=0; i<genes.length; i++) {
            int n = genes[i].datos.length;
            for (int j=0; j<n; j++) {
                // TODO: intentar optimizar el cálculo de datos[j]
                genes[i].datos[j] = utiles.Aleatorio.getRandomInt(2); // TODO: comprobar que nºs genera
            }
        }
    }


}
