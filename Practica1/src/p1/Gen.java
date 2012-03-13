/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package p1;

/**
 *
 * @author gerardo
 */
public class Gen {
    public int[] datos;

    public Gen(int l) {
        datos = new int[l];
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

}
