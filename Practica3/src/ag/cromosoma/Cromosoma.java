/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cromosoma;

import ag.gen.Gen;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerardo
 */
public abstract class Cromosoma implements Comparable<Cromosoma>, Cloneable{

    public int compareTo(Cromosoma o) {
        if (evaluacion() < o.evaluacion())
            return -1;
        else if (evaluacion() > o.evaluacion())
            return 1;
        else
            return 0;
        
    }

    /**
     * Devuelve un double que representa la calidad del cromosoma
     */
    public abstract double evaluacion();
    
    public abstract void aleatoriza();
    
    /**
     * Devuelve un String con la representacion del cromosoma
    */
    public abstract double fenotipo();

    public abstract String toString();


    /**
     * Devuelve una instancia del objeto que hereda
     */
    public abstract Cromosoma nuevo();

    /**
     * Dado un gen devolver la copia
     * TODO : Hacer comprobación de tipos
     */

    public abstract Object clone();


}
