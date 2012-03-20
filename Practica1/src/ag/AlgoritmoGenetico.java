/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;

import ag.seleccion.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import practica1.CromosomaF1;

/**
 *
 * @author gerardo
 */
public class AlgoritmoGenetico {
    public int tamano = 10;
    public int num_generaciones = 100;
    public double prob_cruce = 0.1;
    public double prob_mutacion = 0.01;

    protected Cromosoma _c;
    protected Seleccion _s;

    protected ArrayList<Cromosoma> _poblacion;

    public AlgoritmoGenetico(Cromosoma c, Seleccion s) {
        _c = c;
        _s = s;
    }

    public void inicializa() {
        _poblacion = new ArrayList<Cromosoma>(tamano);

        Cromosoma c;
        for (int i = 0; i<tamano; i++) {
            c = _c.crearNuevo();
            _poblacion.add(c);
        }



        while (num_generaciones>0) {









            num_generaciones--;
        }
    }
    


}
