/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cruce;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaHormiga;
import java.util.ArrayList;
import practica3.Arbol;
import practica3.ArbolNoterminal;
import practica3.TipoArbol;

/**
 *
 * @author gerardo
 */
public class CruceHormiga extends Cruce {

    public void cruza(Cromosoma a, Cromosoma b) {
        /*
        CromosomaHormiga ca = (CromosomaHormiga) a;
        CromosomaHormiga cb = (CromosomaHormiga) b;

        ArrayList<Arbol> la = new ArrayList<Arbol>(); buscarNodo(ca.programa, la);
        ArrayList<Arbol> lb = new ArrayList<Arbol>(); buscarNodo(cb.programa, lb);

        // Elegimos nodos al azar
        ArbolNoterminal padre_a = (ArbolNoterminal) la.get(utiles.Aleatorio.getRandomInt(la.size()));
        ArbolNoterminal padre_b = (ArbolNoterminal) lb.get(utiles.Aleatorio.getRandomInt(lb.size()));

        // Elegimos el hijo derecho / izquierdo
        int ha = utiles.Aleatorio.getRandomInt(2);
        int hb = utiles.Aleatorio.getRandomInt(2);

        Arbol hijo_a = padre_a.hijos[ha];
        Arbol hijo_b = padre_b.hijos[hb];

        // Intercambiamos las movidas
        hijo_b.padre = padre_a;
        hijo_a.padre = padre_b;

        hijo_b.padre = null;
        hijo_a.padre = null;

        padre_a.insertar(ha, hijo_b);
        padre_b.insertar(hb, hijo_a);

        ca.recalcularEvaluacion();
        cb.recalcularEvaluacion();
        */

    }

    private void buscarNodo(Arbol a, ArrayList<Arbol> l) {
        if (a.getTipo() == TipoArbol.NOTERMINAL)
            l.add(a);

        for(Arbol n:a.hijos)
            buscarNodo(n, l);
    }

}
