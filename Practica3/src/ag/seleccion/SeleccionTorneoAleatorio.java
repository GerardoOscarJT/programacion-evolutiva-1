/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.seleccion;

import ag.cromosoma.Cromosoma;
import java.util.ArrayList;
import utiles.Aleatorio;

/**
 *
 * @author gerardo
 */
public class SeleccionTorneoAleatorio extends Seleccion {

    public static int numParticipantes=3;

    public ArrayList<Cromosoma> selecciona(int n, ArrayList<Cromosoma> poblacion) {
        ArrayList<Cromosoma> resultado = new ArrayList<Cromosoma>(n);
        int[] participantes = new int[numParticipantes];
        Cromosoma elegido = null;
        while (n>0){
            for (int i=1;i<numParticipantes;i++){
                int x = Aleatorio.getRandomInt(poblacion.size());
                participantes[i]=x;
                int eleccion = Aleatorio.getRandomInt(numParticipantes);
                elegido = poblacion.get(participantes[eleccion]);
            }
            resultado.add(elegido);
            n--;
        }

        return resultado;
    }
    
    
}
