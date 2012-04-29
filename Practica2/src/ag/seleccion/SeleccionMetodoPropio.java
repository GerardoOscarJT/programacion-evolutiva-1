/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.seleccion;

import ag.cromosoma.Cromosoma;
import java.util.ArrayList;

/**
 *
 * @author gerardo
 */
public class SeleccionMetodoPropio extends Seleccion {

    int z = 5; // Número de comparaciones

    /**
     * La idea de este método de selección es seleccionar N cromosomas aleatorios
     * y encontrar la pareja cuya evaluación sea lo más parecida posible.
     * Este método de selección es válido para cualquier cromosoma.
     */
    public ArrayList<Cromosoma> selecciona(int n, ArrayList<Cromosoma> poblacion) {

        ArrayList<Cromosoma> resultado = new ArrayList<Cromosoma>(n);

        for (;n>0;n--) {
            int azar = utiles.Aleatorio.getRandomInt(poblacion.size());
            Cromosoma elegido = poblacion.get(azar);
            double evaluacion = elegido.evaluacion();


            double diferencia = 99999999;
            Cromosoma mejor = null;

            for (int i=0; i<z; i++) {
                Cromosoma tentativa = poblacion.get(utiles.Aleatorio.getRandomInt(poblacion.size()));
                double tentativa_evaluacion = tentativa.evaluacion();

                if (diferencia > Math.abs(evaluacion-tentativa_evaluacion)) {
                    diferencia = Math.abs(evaluacion-tentativa_evaluacion);
                    mejor = tentativa;
                }

            }

            resultado.add(elegido);
            resultado.add(mejor);

            n--;

        }

        return poblacion;
    }

}
