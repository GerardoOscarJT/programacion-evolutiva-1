/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.mutacion;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaHormiga;
import java.util.ArrayList;
import practica3.Arbol;
import practica3.TipoArbol;

/**
 *
 * @author gerardo
 */
public class MutacionNoTerminal extends  Mutacion {
    public void muta(Cromosoma c) {
        CromosomaHormiga ch = (CromosomaHormiga) c;

        ArrayList<Arbol> l = new ArrayList<Arbol>();

        buscarNodo(ch.programa, l);
        l.get(utiles.Aleatorio.getRandomInt(l.size())).aletorizar();

        ch.recalcularEvaluacion();
    }

    private void buscarNodo(Arbol a, ArrayList<Arbol> l) {
        if (a.getTipo() == TipoArbol.NOTERMINAL)
            l.add(a);

        for(Arbol n:a.hijos)
            buscarNodo(n, l);
    }
}
