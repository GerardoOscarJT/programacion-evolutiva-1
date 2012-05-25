/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3;

import java.util.Vector;

/**
 *
 * @author gerardo
 */
public abstract class Arbol {

    public Arbol padre;
    public Vector<Arbol> hijos;

    /**
     * Devuelve el número de nodos del subárbol contando el propio nodo
     */
    public int num_nodos = 1;

    public abstract void aletorizar(int nivel);

    protected abstract void setProfundidad(int p);

    public abstract int getProfundidad();

    public abstract String toString();
}
