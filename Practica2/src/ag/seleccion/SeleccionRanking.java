/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.seleccion;

import ag.cromosoma.Cromosoma;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gerardo
 */
public class SeleccionRanking extends Seleccion {

    /**
     * Beta es un parámetro de distribución que debe estar en el rango [1,2]
     * Si beta = 1, el peso se distribuye de forma homogénea
     * Si beta = 2, el peso de distribuye de forma lineal y el último elemento vale 0
     * En cualquier beta, la suma de todos los elementos es igual a 1
     */
    public static double beta=1.5;

    public ArrayList<Cromosoma> selecciona(int c, ArrayList<Cromosoma> poblacion) {

        int n = poblacion.size();

        ArrayList<Cromosoma> resultado = new ArrayList<Cromosoma>(c);

        // Ordeno la población de mayor a menor
        // TODO: Comprobar si esto hace lo mismo que las dos líneas siguientes
        //Collections.sort(poblacion, Collections.reverseOrder());
        Collections.sort(poblacion);
        Collections.reverse(poblacion);
        
        double[] acumulado = new double[n+1];
        acumulado[0] = 0;

        for (int i=1; i<=n; i++) {
            double p = (beta-2*(beta-1)*(i-1)/(n-1))/n;
            acumulado[i]=acumulado[i-1] + p;
        }

        // Obtengo los cromosomas que me piden
        for (;c>0;c--) {
            double a = utiles.Aleatorio.getRandomDouble();
            int i = 0;
            while (a>acumulado[i+1] && i<n)
                i++;

            resultado.add(poblacion.get(i));
        }
        
        return resultado;
    }

}
