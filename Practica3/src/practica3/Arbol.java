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

    public Arbol padre = null;
    public Arbol[] hijos;
    protected int _nivel=0;

    /**
     * Devuelve el número de nodos del subárbol contando el propio nodo
     */
    public int num_nodos = 1;

    public abstract void aletorizar();

    public abstract String toString();

    public abstract TipoArbol getTipo();

    public abstract void setNivel(int n);

    public abstract Object clone();

    public int getNivel() {
        return _nivel;
    }

}
