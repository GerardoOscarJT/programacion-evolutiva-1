/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ag.mutacion;

import ag.cromosoma.Cromosoma;
import ag.cromosoma.CromosomaAlumnos;
import ag.cromosoma.CromosomaStaticArray;
import java.util.ArrayList;
import java.util.Collections;
import utiles.Aleatorio;

/**
 *
 * @author gerardo
 */
public class MutacionHeuristica extends Mutacion{

    private static int n = 3;

    public void muta(Cromosoma c) {
        CromosomaStaticArray cc = (CromosomaStaticArray)c;
        int tamCromo = cc.genes.length;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        //Elijo tantos genes de un cromosoma como valga la variable n
        for (int i=0;i<n;i++){
            int elegido = Aleatorio.getRandomInt(tamCromo);
            int index = 0;
            if (!lista.contains(i)){
                lista.add(index, elegido);
                index++;
            }   
        }
        Collections.sort(lista);
        int tamano=lista.size();
        String cadena="";
        int pr = getFactorial(tamano); 
        for (int i=0; i< tamano; i++){
            cadena += Integer.toString(i);
        }
	String[] permutaciones = permutar(cadena,pr);
        
        ArrayList<CromosomaStaticArray> posibilidades = new ArrayList<CromosomaStaticArray>(tamano);
        int tamPer = permutaciones.length;
        double mejorEvaluacion = 999999999;
        int mejorCromosoma = 0;
        for (int i=0;i<tamPer;i++){
            CromosomaStaticArray aux = (CromosomaStaticArray)new CromosomaAlumnos();
            int indice = 0;
            for (int j = 0;j<tamCromo;j++){
                if ((indice<tamano)&&(j== lista.get(indice))){
                    String elementoChar="";
                    elementoChar+= permutaciones[i].charAt(indice);
                    int elemento = Integer.decode(elementoChar);
                    aux.genes[j] = cc.genes[lista.get(elemento)];
                    indice++;
                }else{
                    aux.genes[j]=cc.genes[j];
                }
            }
            posibilidades.add(aux);
            double evaluacion = aux.evaluacion();
            if (Math.abs(evaluacion)<mejorEvaluacion){
                mejorEvaluacion = Math.abs(evaluacion);
                mejorCromosoma = i;
            }
        }
        cc = posibilidades.get(mejorCromosoma);
    }

    public static int getFactorial (int n)
	{
		int result;
		if(n==1||n==0)
			return 1;
 
		result = getFactorial(n-1)*n;
		return result;
	}
    
    public static String[]  permutar(String cadena,int p)
	{
            String[] per = new String[p];            
            int l = cadena.length();
            int d=p/l;
            String[] aux = permutacion(cadena);
            int pos =0;
            if(p==1||l==1){
                per[0] = cadena;
		return per;
            }
            for(int i=0;i<aux.length;i++){
		String[] auxiliar = permutar(aux[i].substring(1),getFactorial(l-1)); 
		for(int j=0;j<auxiliar.length;j++){
			per[pos]=aux[i].charAt(0)+auxiliar[j];
			pos++;
		}			
            }
            return per;
 
	}

    private static String[] permutacion(String cadena) {
        int num = cadena.length();
	String temporal="";
	String[] vector = new String[num];
	vector[0]=cadena;
	for(int i=1;i<num;i++){
            for(int j=0;j<num;j++){		
                if(j==num-1) temporal = cadena.charAt(j)+temporal;
		else temporal += cadena.charAt(j);
            }
            cadena=temporal;
            vector[i]=temporal;
            temporal="";
	}
	return vector;
    }
    
}


    
