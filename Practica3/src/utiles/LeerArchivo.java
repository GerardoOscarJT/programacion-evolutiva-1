/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Alberto
 */
public class LeerArchivo {
    private static BufferedReader br;
    private static File _f;
    private static String linea;
    private static String[] datos;

    
    public void inicializa(File archivo){
        _f = archivo;
        if (archivo == null){
            try{
                br = new BufferedReader(new FileReader("comida.txt"));
                //linea = br.readLine();
            }catch(Exception ex){System.out.println("Error al leer fichero.");}
        }else{
           try{
                br = new BufferedReader(new FileReader(_f));
                //linea = br.readLine();
            }catch(Exception ex){System.out.println("Error al leer fichero.");} 
        }
    };
        
    public String dameLinea() throws FileNotFoundException, IOException{
       try{
           linea = br.readLine();
       }catch(Exception ex){System.out.println("Error al leer fichero.");}
    return linea;
    };
    
}
