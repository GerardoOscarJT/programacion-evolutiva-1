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
public abstract class Seleccion {

    public abstract ArrayList<Cromosoma> selecciona(int n, ArrayList<Cromosoma> poblacion);
    
    
    
}
