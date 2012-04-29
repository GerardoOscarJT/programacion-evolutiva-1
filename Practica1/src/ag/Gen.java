/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;

/**
 *
 * @author gerardo
 *
 * Este gen codifica un rango de valores enteros utilizando l bits
 *
 */
public class Gen {
    public int[] datos;

    public static int bits = 16;

    public Gen() {
        datos = new int[bits];
    }

    public int getInt() {
        int n = datos.length;
        int r = 0;
        int pot=1;
        for (int i=0; i<n; i++) {
            r += pot*datos[i];
            pot *= 2;
        }

        return r;
    }

    public void copyFrom(Gen g) {
        datos = new int[g.datos.length];
        for (int i = 0; i<datos.length; i++)
            datos[i] = g.datos[i];
    }

}
