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

    public static int getRandomInt(int n) {
        if (_random == null)
            _random = new Random(2);

        return _random.nextInt(n);
    }

    public static double getRandomDouble() {
        if (_random == null)
            _random = new Random(2);

        return _random.nextDouble();
    }

}
