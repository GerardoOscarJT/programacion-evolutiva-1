/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.gen;

/**
 *
 * @author gerardo
 */
public class GenEntero extends Gen {
    public int valor;

    public GenEntero() {
        valor = 0;
    }

    /*public Gen nuevo() {
        return new GenEntero();
    }
     * 
     */


    
    public int dameValor(){
        return valor;
    }

    public Object clone() {
        GenEntero nuevo = new GenEntero();
        nuevo.valor = valor;
        return nuevo;
    }

}
