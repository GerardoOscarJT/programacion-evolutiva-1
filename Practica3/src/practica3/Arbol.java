/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author gerardo
 */
public class Arbol {
    public Arbol padre = null;

    public Boolean es_terminal = false;

    public Vector<Arbol> hijos = new Vector<Arbol>(3);

    private int _profundidad = 0;

    /**
     * Devuelve el número de nodos del subárbol contando el propio nodo
     */
    public int num_nodos = 1;


    public String toString() {
        // TODO: Visualizar el árbol en modo texto
        return "TODO en Arbol lin 31 \n";
    }

    /**
     * Sólo inserta si pos <= que hijos.size()
     */
    public void insertar(int pos, Arbol nodo) {
        if (pos <= hijos.size()) {
            nodo.padre = this;
            this.num_nodos += nodo.num_nodos;
            this.setProfundidad(nodo._profundidad+1);
            hijos.set(pos, nodo);
        }
    }

    private void setProfundidad(int p) {
        if (p>this._profundidad) {
            this._profundidad = p;
            if (this.padre != null)
                this.padre.setProfundidad(this._profundidad+1);
        }
    }

    public int getProfundidad() {
        return _profundidad;
    }




}
