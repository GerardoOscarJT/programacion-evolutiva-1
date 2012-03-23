/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import ag.Cromosoma;
import ag.Gen;

/**
 *
 * @author Alberto
 */
public class CromosomaF4 extends Cromosoma {
    
    public CromosomaF4(){
        genes = new Gen[2];
        genes[0] = new Gen();
        genes[1] = new Gen();
        Aleatorizar();
    }

    @Override
    public double Fenotipo(int n) {
        
                double min=-10.0;
                double max=10.0;

                double x = min+(max-min)*genes[n].getInt()/(Math.pow(2,Gen.bits));
                return x;
    }

    @Override
    public double Fitness() {
        double x=Fenotipo(0);
        double y=Fenotipo(1);
        double sumatorioIzq = 0.0;
        double sumatorioDer = 0.0;
        for (int i=1;i<=5;i++){
            sumatorioIzq += i*Math.cos((i+1)*x+i);
            sumatorioDer += i*Math.cos((i+1)*y+i);
        }
        return sumatorioIzq*sumatorioDer;
                
                
    }

    @Override
    public Cromosoma crearNuevo() {
        return new CromosomaF4();
    }
    
}
