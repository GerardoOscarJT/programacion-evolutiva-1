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
public class SeleccionTorneo extends Seleccion {
    /*
    private int numParticipantes=3;
    private double intervalo = 0.6;
    public int numIndividuos;

    public ArrayList<Cromosoma> Selecciona(int n, ArrayList<Cromosoma> poblacion) {
        ArrayList<Cromosoma> resultado = new ArrayList<Cromosoma>(n);
        Cromosoma mejor;
        numIndividuos=n;
        while (numIndividuos>0){
            int x=utiles.Aleatorio.getRandomInt(poblacion.size());
            mejor=poblacion.get(x);
            for (int i=1;i<numParticipantes;i++){
                int y=utiles.Aleatorio.getRandomInt(poblacion.size());
                if (poblacion.get(y).Evaluacion()>mejor.Evaluacion())
                    mejor=poblacion.get(x);
            }
            resultado.add(mejor);
            numIndividuos--;
        }
        
        return resultado;
    }

    public ArrayList<Cromosoma> selMejorElite(int elite, ArrayList<Cromosoma> poblacion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Cromosoma> selPeorElite(int elite, ArrayList<Cromosoma> poblacion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
*/
}
