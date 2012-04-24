/*
 * To change this template, choose Tools | Templates   fffffff
 * and open the template in the editor.
 */

package main;

import ag.*;
import ag.seleccion.*;
import Practica2.*;
import Interfaz.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author gerardo
 *
 * TODO:
 *  Meter una lista ordenada en AlgoritmoGenetico.java, para la _poblacion
 *  Definir la interfaz Seleccion, que tendrá un método "Seleccionar(n)"
 *  Implementar SeleccionRuleta.java
 *  Implementar SeleccionTorneo.java
 *  Introducir un método Calcular() en AlgoritmoGenetico
 *  Introducir un cromosoma 'Mejor' en AlgoritmoGenetico
 *  Introducir la estadística correspondiente en Genetico
 *  Meter la interfaz gráfica
 * 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here   

        //PantallaPrincipal ventana = new PantallaPrincipal();
        //ventana.setVisible(true);
        LeerArchivo lectura = new LeerArchivo();
        lectura.leer();
    }

}
