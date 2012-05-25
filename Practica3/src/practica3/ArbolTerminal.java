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
public class ArbolTerminal extends Arbol {

    public Terminales functor = Terminales.AVANZA;

    { // Inicializo la lista de hijos
        //hijos = new Vector<Arbol>(0);
        hijos = new Arbol[0];
    }

    public void setProfundidad(int p) {
        // No hace nada, porque es una hoja. La profundidad es siempre 1
    }

    public int getProfundidad() {
        return 1;
    }

    public String toString() {
        return functor.toString();
    }

    public void aletorizar() {
        int a = utiles.Aleatorio.getRandomInt(3);
        switch (a) {
            case 0:
                functor = Terminales.AVANZA;
                break;

            case 1:
                functor = Terminales.DERECHA;
                break;

            case 2:
                functor = Terminales.IZQUIERDA;
                break;
        }
    }

    public TipoArbol getTipo() {
        return TipoArbol.TERMINAL;
    }

    public void setNivel(int n) {
        _nivel = n;
    }


    public void setNodosSubarbol(int n) {
        // No hago nada :)
    }



}
