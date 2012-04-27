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
public class SeleccionTorneoAleatorio extends Seleccion {

    public static int numParticipantes=3;

    public ArrayList<Cromosoma> selecciona(int n, ArrayList<Cromosoma> poblacion) {
        ArrayList<Cromosoma> resultado = new ArrayList<Cromosoma>(n);
        Cromosoma mejor;
        while (n>0){
            int x=utiles.Aleatorio.getRandomInt(poblacion.size());
            mejor=poblacion.get(x);
            for (int i=1;i<numParticipantes;i++){
                int y=utiles.Aleatorio.getRandomInt(poblacion.size());
                if (poblacion.get(y).evaluacion()>mejor.evaluacion())
                    mejor=poblacion.get(x);
            }
            resultado.add(mejor);
            n--;
        }

        return resultado;
    }
    
    
}
