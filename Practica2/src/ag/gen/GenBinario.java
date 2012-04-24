/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.gen;

/**
 *
 * @author gerardo
 */
public class GenBinario extends Gen {

    public Gen nuevo() {
        return new GenBinario();
    }

    @Override
    public Gen copia(Gen g) {
        // TODO:
        return null;
    }



    // TODO: Reimplementar en un futuro
/*
 *
    public int[] datos;

    public static int bits = 16;

    public GenBinario() {
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

    public void copyFrom(GenBinario g) {
        datos = new int[g.datos.length];
        for (int i = 0; i<datos.length; i++)
            datos[i] = g.datos[i];
    }
 *
 *
 */
}
