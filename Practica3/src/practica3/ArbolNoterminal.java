/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3;

import ag.cromosoma.CromosomaHormiga;
import java.util.Vector;

/**
 *
 * @author gerardo
 */
public class ArbolNoterminal extends Arbol {

    public Noterminales functor = Noterminales.PROGN2;

    private int _profundidad = 1;

    { // Inicializo la lista de hijos
        hijos = new Vector<Arbol>(2);
        hijos.insertElementAt(null, 0);
        hijos.insertElementAt(null, 1);
    }

    public void aletorizar(int nivel) {

        /**
         * Probabilidad de ser o no ser un terminal:
         */
        double probTerm = 1-Math.pow(1-Math.pow(CromosomaHormiga.factor_de_ajuste, CromosomaHormiga.profundidad_maxima), nivel);

        // TODO: Si hay más restricciones (nodos, profundidad, etc, poner probTerm=1

        int a = utiles.Aleatorio.getRandomInt(2);
        switch (a) {
            case 0:
                functor = Noterminales.SIC;
                break;
            case 1:
                functor = Noterminales.PROGN2;
                break;
        }
        for (int i=0; i<2; i++) {
            Arbol arbol;
            if (probTerm > utiles.Aleatorio.getRandomDouble()) { // Meto un terminal
                arbol = new ArbolTerminal();
            } else { // Meto un noterminal
                arbol = new ArbolNoterminal();
            }
            arbol.aletorizar(nivel+1);
            this.insertar(i, arbol);

        }
    }

    /**
     * Sólo inserta si pos <= que hijos.size()
     */
    public void insertar(int pos, Arbol nodo) {
        if (pos < 2) {
            nodo.padre = this;
            this.num_nodos += nodo.num_nodos;
            this.setProfundidad(nodo.getProfundidad()+1);
            hijos.set(pos, nodo);
        }
    }


    public void setProfundidad(int p) {
        if (p>this._profundidad) {
            this._profundidad = p;
            if (this.padre != null)
                this.padre.setProfundidad(this._profundidad+1);
        }
    }

    public int getProfundidad() {
        return _profundidad;
    }

    public String toString() {
        String resultado = functor.toString() + " ( ";
        for (int i=0; i<hijos.size(); i++) {
            if (i>0) resultado += ", ";
            resultado += hijos.get(i).toString();
        }
        resultado += " )";
        return resultado;
    }

}
