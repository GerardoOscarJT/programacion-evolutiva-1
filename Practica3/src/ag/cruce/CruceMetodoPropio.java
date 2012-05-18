/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cruce;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaAlumnos;

/**
 *
 * @author gerardo
 */
public class CruceMetodoPropio extends Cruce {

    /**
     * La idea de este método es la siguiente:
     * Dados los cromosomas A y B y el mejor grupo de cada uno, ma y mb,
     * Consiste en sustituir el peor grupo de A por mb y
     * corregir las incompatibilidades manteniendo la preferencia por mb.
     * Hacer lo mismo con el B.
     *
     * Este método de cruce es exclusivo de CromosomaAlumnos
     */
    public void cruza(Cromosoma a, Cromosoma b) {
        CromosomaAlumnos aa = (CromosomaAlumnos) a;
        CromosomaAlumnos bb = (CromosomaAlumnos) b;

        Integer ma=0, pa=0; mejorypeorGrupo(a, ma, pa);
        Integer mb=0, pb=0; mejorypeorGrupo(b, mb, pb);

        int m = CromosomaAlumnos.m; // Número de alumnos por grupo
        int[] grupoa = new int[m];
        int[] grupob = new int[m];

        // Relleno los grupos correspondientes:
        for (int i=0; i<m; i++) {
            grupoa[i] = aa.genesA[ma*m+i].valor;
            grupob[i] = bb.genesA[ma*m+i].valor;
        }

        insertarGrupo(aa, grupob, pa);
        insertarGrupo(bb, grupoa, pb);

    }

    /**
     * inserta el grupo g en el índice g del cromosoma c
     */
    private void insertarGrupo(Cromosoma c, int[] grupo, int g) {
        CromosomaAlumnos cc = (CromosomaAlumnos) c;

        int m = CromosomaAlumnos.m; // Alumnos por grupo
        int a = cc.genesA.length; // Total de alumnos

        int[] nuevo = new int[a];
        boolean[] usados = new boolean[a];

        // Vacío los usados y nuevos
        for (int i=0; i<a; i++) {
            nuevo[i] = -1;
            usados[i] = false;
        }

        // Paso 1: Copio el grupo nuevo en la posicion g
        for (int i=0; i<m; i++) {
            nuevo[g*m+i] = grupo[i];
            usados[grupo[i]] = true;
        }

        // Paso 2: Relleno con el cromosoma original:
        for (int i=0; i<a; i++)
            if (nuevo[i] == -1) {
                int u = cc.genesA[i].valor;
                if (!usados[u]) {
                    nuevo[i] = u;
                    usados[u] = true;
                }
            }

        // Paso 3: Completo los vacíos para mantener la coherencia
        int ultimo_no_usado = 0;
        for (int i=0; i<a; i++) {
            if (nuevo[i] == -1) {
                while (usados[ultimo_no_usado])
                    ultimo_no_usado++;
                nuevo[i] = ultimo_no_usado;
                usados[ultimo_no_usado] = true;
            }
        }

        // Copio el resultado en el cromosoma original
        for (int i=0; i<a; i++)
            cc.genesA[i].valor = nuevo[i];

    }

    /**
     * Devuelve el mejor grupo del cromosoma c
     */
    private void mejorypeorGrupo(Cromosoma c, Integer mejor, Integer peor) {
        CromosomaAlumnos cc = (CromosomaAlumnos) c;
        int m = CromosomaAlumnos.m; // Número de alumnos por grupo
        int n = cc.genesA.length;
        int g = n/m; // Número de grupos

        mejor = 0;
        peor = 0;
        double mejor_resultado = 999999999;
        double peor_resultado = 0;
        for (int i=0; i<g; i++) {
            // Calculamos la media del grupo i-ésimo
            double media = 0;
            for (int j = 0; j<m; j++)
                media += CromosomaAlumnos.alumnos.get(cc.genesA[i*m+j].valor).getNota();
            media /= m;

            double desequilibrio_grupo = 0;
            for (int j = 0; j<m; j++)
                desequilibrio_grupo += Math.abs(CromosomaAlumnos.alumnos.get(cc.genesA[i*m+j].valor).getNota()-media);

            double incompatibilidades = 0; // TODO: cambiar a entero
            for (int j = i*m; j<(i+1)*m; j++)
                for (int k = i*m; k<(i+1)*m; k++)
                    if (CromosomaAlumnos.alumnos.get(cc.genesA[j].valor).getEnemigos().contains(cc.genesA[k].valor))
                        incompatibilidades++;

            double resultado = CromosomaAlumnos.alfa*desequilibrio_grupo+(1-CromosomaAlumnos.alfa)*incompatibilidades;

            if (resultado<=mejor_resultado) {
                mejor_resultado = resultado;
                mejor = i;
            }

            if (resultado>=peor_resultado) {
                peor_resultado = resultado;
                peor = i;
            }
        }
    }

}
