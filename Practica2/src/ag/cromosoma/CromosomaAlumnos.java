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
    public static ArrayList<Alumno> alumnos;
    /** Relación de ids, dado el identificador de fichero, devuelve
     el indentificador del array*/
    static Map<Integer, Integer> ids;
    static Map<Integer, Integer> idsContrario;
    /** Número de grupos */
    private static int g;
    /** Número de alumnos por grupo */
    public static int m = 3;
    /** Factor de desequilibrio (Debe estar entre 0 y 1) */
    public static double alfa = 0.5;
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
        return -fenotipo();
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
        idsContrario = new HashMap<Integer, Integer>(numAlumnos);
        alumnos = new ArrayList<Alumno>(numAlumnos);
        for (int i=0;i<numAlumnos;i++){
            linea = manejador.dameLinea();
            datos=linea.split(" ");
            int id=Integer.valueOf(datos[0]);
            double nota= Float.valueOf(datos[1]);
            ids.put(id, i);
            idsContrario.put(i,id);
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
    
    public static int completa(int n){
        m = n;
        int resto = numAlumnos % n;
        g = (int)Math.ceil((double)numAlumnos/n);
        int contador = 0;
        if (resto != 0){
            for (int i=resto;i<n;i++){
                Alumno alumno = new Alumno((-contador-1),0);
                ids.put((-contador-1),numAlumnos+contador);
                idsContrario.put(numAlumnos+contador,(-contador-1));
                alumnos.add(numAlumnos+contador, alumno);
                contador++;
            }
        }
        numAlumnos+=contador;
        return contador;
    } 


    public void aleatoriza() {
        
    }

    @Override
    public String toString() {
        String f = "";

        for (int i=0; i<g; i++) {
            f+=" [";
            for (int j=0; j<m; j++) {
                f+= alumnos.get(genesA[i*m+j].valor).getId()+", ";
            }
            f+=" ] ";
        }


        return f;
    }

    public Object clone() {
        CromosomaAlumnos ca = new CromosomaAlumnos();
        for (int i = 0; i<genes.length; i++)
            ca.genes[i] = (Gen) genes[i].clone();
        return ca;
    }

    public double fenotipo() {

        double desequilibrio = 0;

        
        for (int i=0; i<g; i++) {
            // Calculamos la media del grupo i-ésimo
            double media = 0;
            for (int j = 0; j<m; j++)
                media += alumnos.get(genesA[i*m+j].valor).getNota();
            media /= m;
            
            double desequilibrio_grupo = 0;
            for (int j = 0; j<m; j++)
                desequilibrio_grupo += Math.abs(alumnos.get(genesA[i*m+j].valor).getNota()-media);
            
            desequilibrio += Math.pow(desequilibrio_grupo,2);
        }

        // Calculamos incompatibilidades dentro de cada grupo
        double incompatibilidades = 0; // TODO: cambiar a entero
        for (int i = 0; i<g; i++)
            for (int j = i*m; j<(i+1)*m; j++)
                for (int k = i*m; k<(i+1)*m; k++)
                    if (alumnos.get(genesA[j].valor).getEnemigos().contains(genesA[k].valor))
                        incompatibilidades++;



        // Calculamos la función de evaluación
        double resultado = alfa*desequilibrio+(1-alfa)*incompatibilidades;
        return resultado;

    }
    
    public ArrayList<Alumno> dameAlumnos(){return alumnos;}
    public Map<Integer, Integer> dameIds(){return idsContrario;}
    public int dameGrupos(){return g;}
}
