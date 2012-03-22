/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.seleccion;

import ag.Cromosoma;
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

public class SeleccionRuleta implements Seleccion {

    public ArrayList<Cromosoma> Selecciona(int n, ArrayList<Cromosoma> poblacion) {

        double sumaTotal = 0;

        for (Cromosoma v : poblacion)
            sumaTotal += v.Fitness();

        Collections.sort(poblacion);


        double[] acumulado = new double[poblacion.size()+1];
        acumulado[0] = 0;

        for (int i=0; i<poblacion.size(); i++) {
            acumulado[i+1] = acumulado[i]+poblacion.get(i).Fitness()/sumaTotal;
        }




        ArrayList<Cromosoma> resultado = new ArrayList<Cromosoma>(n);

        for (int i = 0; i<n; i++) {
            double r = (double) Aleatorio.getRandomInt(10000)/10000;
            boolean encontrado = false;
            for (int j=0; i<poblacion.size() && !encontrado; j++) {
                if (acumulado[j]<r && r<acumulado[j+1]) {
                    encontrado = true;
                    resultado.add(poblacion.get(j));
                }
            }
        }

        return resultado;
    }

}
