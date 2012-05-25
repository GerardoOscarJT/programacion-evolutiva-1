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
        //hijos = new Vector<Arbol>(2);
        hijos = new Arbol[2];
    }

    public void aletorizar() {

        /**
         * Probabilidad de ser o no ser un terminal:
         */
        double probTerm = 1-Math.pow(1-Math.pow(CromosomaHormiga.factor_de_ajuste, CromosomaHormiga.profundidad_maxima), getNivel());

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
            this.insertar(i, arbol);
            arbol.aletorizar();

        }
    }

    /**
     * Sólo inserta si pos <= que hijos.size()
     */
    public void insertar(int pos, Arbol nodo) {
        if (pos < 2) {
            nodo.padre = this;
            //hijos.set(pos, nodo);
            hijos[pos] = nodo;

            // Propagar
            //this.setProfundidad(nodo.getProfundidad()+1);
            nodo.setNivel(this.getNivel()+1);
            this.actualizarNodosSubarbol();
            
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
        for (int i=0; i<hijos.length; i++) {
            if (i>0) resultado += ", ";
            resultado += hijos[i].toString();
        }
        resultado += " )";
        return resultado;
    }

    public void setNivel(int n) {
        _nivel = n;
        for (Arbol a:hijos)
            if (a != null)
                a.setNivel(n+1);
    }


    public TipoArbol getTipo() {
        return TipoArbol.NOTERMINAL;
    }

}
