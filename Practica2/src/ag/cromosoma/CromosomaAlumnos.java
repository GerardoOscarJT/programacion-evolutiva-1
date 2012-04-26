/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.cromosoma;

import ag.gen.Gen;
import ag.gen.GenEntero;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import practica2.*;


/**
 *
 * @author gerardo
 */
public class CromosomaAlumnos extends CromosomaStaticArray {

    /** Alumnos */
    static ArrayList<Alumno> alumnos;
    /** Relación de ids, dado el identificador de fichero, devuelve
     el indentificador del array*/
    static Map<Integer, Integer> ids;
    /** Número de grupos */
    private static int g;
    /** Número de alumnos por grupo */
    public static int m = 3;
    /** Factor de desequilibrio (Debe estar entre 0 y 1) */
    public static double a = 0.5;
    public static int numAlumnos = 0;
    public GenEntero[] genesA;
    
    public CromosomaAlumnos() {
        
        ArrayList<Integer> aleatorios = new ArrayList<Integer>(numAlumnos);
        for (int i=0; i<numAlumnos; i++)
            aleatorios.add(i);
        Collections.shuffle(aleatorios);
        
        genes = new GenEntero[numAlumnos];
        genesA = (GenEntero[]) genes;
        for (int i =0; i<numAlumnos;i++){
            genes[i]= new GenEntero();            
            genesA[i].valor=aleatorios.get(i);
        }
    }
    
    

    public Cromosoma nuevo() {
        return new CromosomaAlumnos();
    }

    @Override
    public Cromosoma copia(Cromosoma c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double evaluacion() {

        // Cálculo de la media
        double media = 0;
        int alumnos_size = alumnos.size();

        for (int i=0; i<alumnos_size; i++)
            media += alumnos.get(i).getNota();

        media /= alumnos_size;

        // Calculamos desequilibrio
        double desequilibrio = 0;
        double desequilibrio_grupo = 0;

        for (int i=0; i<alumnos_size; i++) {
            desequilibrio_grupo += alumnos.get(i).getNota()-media;
            if (i%m == (m-1)) {
                desequilibrio += Math.pow(desequilibrio_grupo, 2);
                desequilibrio_grupo = 0;
            }
        }

        // Calculamos incompatibilidades dentro de cada grupo
        double incompatibilidades = 0;
        for (int i = 0; i<g; i++)
            for (int j = i*m; j<(i+1)*m; j++)
                for (int k = i*m; k<(i+1)*m; k++)
                    if (j!=k &&   alumnos.get(k).getEnemigos().contains(alumnos.get(j).getId())) 
                        incompatibilidades++;
                    


        // Calculamos la función de evaluación
        return a*desequilibrio+(1-a)*incompatibilidades;

    }
    public void copyFrom(Cromosoma c) {
        CromosomaAlumnos ca = (CromosomaAlumnos) c;
        genes = new Gen[ca.genes.length];
        for (int i = 0; i<genes.length; i++) {
            Gen g = new GenEntero();
            g.copia(ca.genes[i]);
            genes[i] = g;
        }
    }

    public static void leer(File f) throws FileNotFoundException, IOException {

        String linea;
        String[] datos;
        LeerArchivo manejador = new LeerArchivo();
        linea=manejador.inicializa(f);
        datos=linea.split(" ");
        numAlumnos=Integer.valueOf(datos[0]);
        int incompatibilidades = Integer.valueOf(datos[1]);
        ids = new HashMap<Integer, Integer>(numAlumnos);
        alumnos = new ArrayList<Alumno>(numAlumnos);
        for (int i=0;i<numAlumnos;i++){
            linea = manejador.dameLinea();
            datos=linea.split(" ");
            int id=Integer.valueOf(datos[0]);
            int nota= Integer.valueOf(datos[1]);
            ids.put(id, i);
            Alumno alumno = new Alumno(id,nota);
            alumnos.add(i, alumno);
        }
        for (int i=0;i<incompatibilidades;i++){
            linea = manejador.dameLinea();
            datos=linea.split(" ");
            int alumno=Integer.valueOf(datos[0]);
            int enemigo=Integer.valueOf(datos[1]);
            int idAlumno=ids.get(alumno);
            int idEnemigo= ids.get(enemigo);
            alumnos.get(idAlumno).getEnemigos().add(idEnemigo);
        }
    }
    
    public static void completa(int n){
        int resto = numAlumnos % n;
        if (resto != 0){
            int contador = 0;
            for (int i=resto;i<n;i++){
                Alumno alumno = new Alumno((-contador-1),0);
                ids.put((-contador-1),numAlumnos+contador);
                alumnos.add(numAlumnos+contador, alumno);
                contador++;
            }
        }
    } 


    public void aleatoriza() {
        
    }

    @Override
    public String fenotipo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
