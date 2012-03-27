/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.seleccion;

import ag.Cromosoma;
import java.util.ArrayList;

/**
 *
 * @author gerardo
 */
public class SeleccionTorneo implements Seleccion {
    private int numParticipantes=2;
    private double intervalo = 0.6;
    public int numIndividuos;

    public ArrayList<Cromosoma> Selecciona(int n, ArrayList<Cromosoma> poblacion) {
        ArrayList<Cromosoma> resultado = new ArrayList<Cromosoma>(n);
        numIndividuos=n;
        while (numIndividuos>0){
            int x1=utiles.Aleatorio.getRandomInt(poblacion.size());
            int x2=utiles.Aleatorio.getRandomInt(poblacion.size());
            int x3=utiles.Aleatorio.getRandomInt(poblacion.size());


            double f1 = poblacion.get(x1).Evaluacion();
            double f2 = poblacion.get(x2).Evaluacion();
            double f3 = poblacion.get(x3).Evaluacion();


            if ( (f1 > f2) && (f1 > f3) ) {
                resultado.add(poblacion.get(x1));
            } else if (f2 > f1 && f2 > f3) {
                resultado.add(poblacion.get(x2));
            } else {
                resultado.add(poblacion.get(x3));
            }

            /*
            if (poblacion.get(x1).Fitness()>poblacion.get(x2).Fitness())
                    resultado.add(poblacion.get(x1));
            else 
                    resultado.add(poblacion.get(x2));
            */
            numIndividuos--;
        }
        
        return resultado;
    }

}
