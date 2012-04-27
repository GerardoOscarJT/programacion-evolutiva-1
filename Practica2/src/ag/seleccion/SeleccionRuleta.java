/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.seleccion;

import ag.cromosoma.Cromosoma;
import java.util.ArrayList;
import java.util.Collections;
import utiles.Aleatorio;

/**
 *
 * @author gerardo
 */

/*
public class Compare1 extends Comparable {

}
 *
 */

public class SeleccionRuleta extends Seleccion {


    public ArrayList<Cromosoma> selecciona(int n, ArrayList<Cromosoma> poblacion) {

        double sumaTotal = 0;
        double aux=Math.abs(Collections.min(poblacion).evaluacion());
        for (Cromosoma v : poblacion){
                sumaTotal+=v.evaluacion()+aux;
        }
        Collections.sort(poblacion);
        Collections.reverse(poblacion);

        double[] acumulado = new double[poblacion.size()+1];
        acumulado[0] = 0;

        for (int i=0; i<poblacion.size(); i++) {
            acumulado[i+1] = acumulado[i]+(poblacion.get(i).evaluacion()+aux)/sumaTotal;
        }
        
        ArrayList<Cromosoma> resultado = new ArrayList<Cromosoma>(n);

        for (int i = 0; i<n; i++) {
            double r = (double) Aleatorio.getRandomInt(10000)/10000;
            boolean encontrado = false;
            for (int j=0; j<poblacion.size() && !encontrado; j++) {
                if (acumulado[j]<=r && r<=acumulado[j+1]) {
                    encontrado = true;
                    resultado.add(poblacion.get(j));
                }
            }
        }

        return resultado;
    }

}
