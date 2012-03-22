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
public interface Seleccion {

    ArrayList<Cromosoma> Selecciona(int n, ArrayList<Cromosoma> poblacion);

}
