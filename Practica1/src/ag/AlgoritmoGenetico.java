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
    public int tamano = 100;
    public int num_generaciones = 100;
    public double prob_cruce = 0.8;
    public double prob_mutacion = 0.01;
    public double mejorAbsoluto = 0.0;
    public double peorAbsoluto = 1000.0; 
    public String fenotipoMejor;
    public String fenotipoPeor;

    protected Cromosoma _c;
    protected Seleccion _s;

    protected ArrayList<Cromosoma> _poblacion;

    public ArrayList<ArrayList<String>> historial;

    public ArrayList<Double> mejor_absoluto;
    public ArrayList<Double> mejor_generacion;
    public ArrayList<Double> peor_generacion;
    public ArrayList<Double> media_generacion;
    public ArrayList<Double> peor_absoluto;


    public AlgoritmoGenetico(Cromosoma c, Seleccion s) {
        _c = c;
        _s = s;

        historial = new ArrayList<ArrayList<String>>();
        mejor_generacion = new ArrayList<Double>();
        peor_generacion = new ArrayList<Double>();
        mejor_absoluto = new ArrayList<Double>();
        peor_absoluto = new ArrayList<Double>();
        media_generacion = new ArrayList<Double>();
    }

    public void evaluarPoblacion() {
        double suma=0.0;

        if (utiles.Configuracion.debugMode()) {
            ArrayList<String> historial_generacion = new ArrayList<String>();

            for(Cromosoma c : _poblacion){
                historial_generacion.add(c.Fitness()+"|"+c.Fenotipo());
            }
            historial.add(historial_generacion);
        }

        for (Cromosoma c : _poblacion)
            suma+=c.Fitness();
        
        media_generacion.add(suma/tamano);           
        
        Cromosoma mejor = Collections.max(_poblacion);
        Cromosoma peor = Collections.min(_poblacion);
        mejor_generacion.add(mejor.Fitness());
        peor_generacion.add(peor.Fitness());
        if (mejor.Fitness()>mejorAbsoluto){
            mejorAbsoluto=mejor.Fitness();
            fenotipoMejor=mejor.Fenotipo();
            mejor_absoluto.add(mejorAbsoluto);
                    }
        else 
            mejor_absoluto.add(mejorAbsoluto);
        if (peor.Fitness()< peorAbsoluto){
            peorAbsoluto=peor.Fitness();
            fenotipoPeor=peor.Fenotipo();
            peor_absoluto.add(peorAbsoluto);
                    }
        else 
            peor_absoluto.add(peorAbsoluto);
        
        System.out.println(mejor.Fenotipo(0));

    }

    public void inicializa() {
        _poblacion = new ArrayList<Cromosoma>(tamano);

        Cromosoma c;
        for (int i = 0; i<tamano; i++) {
            c = _c.crearNuevo();
            _poblacion.add(c);
        }
        
        evaluarPoblacion();

        int num_seleccionados = tamano * 6 / 10;

        while (num_generaciones>0) {
            ArrayList<Cromosoma> seleccionados = _s.Selecciona(num_seleccionados, _poblacion);

            for (int i = 1; i<num_seleccionados-1; i+=2) {
                double r = (double) utiles.Aleatorio.getRandomInt(10000)/10000;
                if (r<prob_cruce) 
                    seleccionados.get(i).Cruce(seleccionados.get(i-1));
            }
            for (int i =0;i<_poblacion.size();i++)
                _poblacion.get(i).mutacion(prob_mutacion);


            evaluarPoblacion();
            num_generaciones--;
        }
    }
    


}
