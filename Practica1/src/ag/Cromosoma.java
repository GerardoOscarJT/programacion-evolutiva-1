/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;

import ag.Gen;

/**
 *
 * @author gerardo
 */
public abstract class Cromosoma implements Comparable<Cromosoma>{

    protected Gen genes[];

    public Cromosoma() {
        
    }

    public int compareTo(Cromosoma o) {
        if (Fitness() < o.Fitness())
            return -1;
        else
            return 1;
    }

    public Cromosoma(Cromosoma c) {
        genes = new Gen[c.genes.length];

        for (int i=0; i<genes.length; i++) {
            genes[i] = new Gen(c.genes[i].datos.length);
        }
    }

    public abstract double Fitness();

    public abstract Cromosoma crearNuevo();

    public void Aleatorizar() {
        for(int i=0; i<genes.length; i++) {
            int n = genes[i].datos.length;
            for (int j=0; j<n; j++) {
                // TODO: intentar optimizar el cálculo de datos[j]
                genes[i].datos[j] = utiles.Aleatorio.getRandomInt(2); // TODO: comprobar que nºs genera
            }
        }
    }

    public String toString() {

        String r = "";

        for (int i=0; i<genes.length; i++) {
            r += "Gen"+i+" = "+genes[i].getInt()+"; ";
        }



        return r;
    }

}
