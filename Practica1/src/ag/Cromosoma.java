/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;

import ag.Gen;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerardo
 */
public abstract class Cromosoma implements Comparable<Cromosoma>{

    protected Gen genes[];

    public String alelo;


    public Cromosoma() {
        
    }

    public void copyFrom(Cromosoma c) {
        genes = new Gen[c.genes.length];
        for (int i = 0; i<genes.length; i++) {
            Gen g = new Gen();
            g.copyFrom(c.genes[i]);
            genes[i] = g;
        }
    }

    public int compareTo(Cromosoma o) {
        if (Fitness() < o.Fitness())
            return -1;
        else if (Fitness() > o.Fitness())
            return 1;
        else
            return 0;
    }

    public void Cruce(Cromosoma c) {
        // Elegimos un gen de todos los que tenemos
        int g = utiles.Aleatorio.getRandomInt(genes.length);

        // Intercambio los genes que hay a la izquierda
        for (int i=0; i<g; i++) {
            Gen aux = c.genes[i];
            c.genes[i] = genes[i];
            genes[i] = aux;
        }

        // Del gen g elijo un bit e intercambio a nivel de bit
        int b = utiles.Aleatorio.getRandomInt(genes[g].datos.length);

        // Intercambio todos los bits que están a la izquierda
        for (int i=0; i<b; i++) {
            int aux = c.genes[g].datos[i];
            c.genes[g].datos[i] = genes[g].datos[i];
            genes[g].datos[i] = aux;
        }
    }
    public void mutacion(double prob_mutacion){
        for (int i=0;i<genes.length;i++){
            for (int j=0;j<genes[i].datos.length;j++){
                double r = (double) utiles.Aleatorio.getRandomInt(10000)/10000;
                if (r<prob_mutacion)
                    genes[i].datos[j]=1-genes[i].datos[j];
            }
        }
    }


    public abstract double Fenotipo(int i);

    public String Fenotipo() {
        String resultado = "";
        for (int i = 0; i<genes.length; i++) {
            resultado += "[Gen "+i+" = "+Fenotipo(i)+"] ";
        }

        return resultado;
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
