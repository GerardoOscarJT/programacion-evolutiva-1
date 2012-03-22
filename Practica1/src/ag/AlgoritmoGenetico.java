/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;

import ag.seleccion.*;
import java.util.ArrayList;
import java.util.Collections;

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

    public void evaluarPoblacion() {

        Cromosoma mejor = Collections.max(_poblacion);
        System.out.println(mejor.Fenotipo());

    }

    public void inicializa() {
        _poblacion = new ArrayList<Cromosoma>(tamano);

        Cromosoma c;
        for (int i = 0; i<tamano; i++) {
            c = _c.crearNuevo();
            _poblacion.add(c);
        }

        evaluarPoblacion();

        int num_seleccionados = 6;

        while (num_generaciones>0) {
            ArrayList<Cromosoma> seleccionados = _s.Selecciona(num_seleccionados, _poblacion);

            for (int i = 1; i<num_seleccionados; i+=2) {
                double r = (double) utiles.Aleatorio.getRandomInt(10000)/10000;
                if (r<prob_cruce) 
                    seleccionados.get(i).Cruce(seleccionados.get(i-1));
            }


            evaluarPoblacion();
            num_generaciones--;
        }
    }
    


}
