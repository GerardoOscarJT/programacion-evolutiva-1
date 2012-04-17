/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class LeerArchivo {
    private static BufferedReader br;
    private static String linea;
    private static String[] datos;
    private static ArrayList <Integer> alumnos;
    
    public static ArrayList leer() throws FileNotFoundException, IOException{
        alumnos = new ArrayList<Integer>();
        try{
        br = new BufferedReader(new FileReader("archivo.txt"));
        linea = br.readLine();
        datos = linea.split(" ");
        int n=Integer.valueOf(datos[0]);int r=Integer.valueOf(datos[1]);
        for (int i=0;i<n;i++){
            linea=br.readLine();
            //Leer el alumno y sunota
            datos = linea.split(" ");
            //nombre = datos[0], nota =datos[1].
            System.out.println("Alumno: "+datos[0]+" Nota: "+datos[1]);
        }
        for (int i=0;i<r;i++){
            linea=br.readLine();
            //Leer el alumno y sunota
            datos = linea.split(" ");
            //nombre = datos[0], nota =datos[1].
            System.out.println("Alumno: "+datos[0]+" Enemigo: "+datos[1]);
        }
        }
        catch(Exception ex){System.out.println("Error al leer fichero.");
        };
    return null;
    };
    
}
