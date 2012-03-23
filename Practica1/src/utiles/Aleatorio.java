/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utiles;

import java.util.Random;

/**
 *
 * @author gerardo
 */
public class Aleatorio {
    private static Random _random;

    /*
    private static Aleatorio _instance;


    private Aleatorio() {
       Random b = new Random(1);
    }

    public int getRandomInt() {
        if (_instance == null)
            _instance = new Aleatorio();

        return 0;
    }*/

    public static int getRandomInt(int n) {
        if (_random == null)
            _random = new Random(2);

        return _random.nextInt(n);
    }

}
