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
    protected int _nodos_subarbol=1;

    /**
     * Devuelve el número de nodos del subárbol contando el propio nodo
     */
    public int num_nodos = 1;

    public abstract void aletorizar();

    protected abstract void setProfundidad(int p);

    public abstract int getProfundidad();

    public abstract String toString();

    public abstract TipoArbol getTipo();

    public abstract void setNivel(int n);

    public int getNivel() {
        return _nivel;
    }

    public void actualizarNodosSubarbol() {
        // Actualizo mis nodos
        int n = 1;
        for (Arbol a:hijos)
            if (a != null)
                n += a.getNodosSubarbol();

        // Propago hacia arriba
        if (padre != null)
            padre.actualizarNodosSubarbol();
    }

    public int getNodosSubarbol() {
        return _nodos_subarbol;
    }
}
