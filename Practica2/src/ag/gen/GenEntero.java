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

    public Gen nuevo() {
        return new GenEntero();
    }

    public Gen copia(Gen g) {
        GenEntero nuevo = new GenEntero();
        nuevo.valor = ((GenEntero) g).valor;
        return nuevo;
    }
    
    public int dameValor(){
        return valor;
    }

}
