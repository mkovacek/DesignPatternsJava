/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.helper;

import java.util.Random;

/**
 *
 * @author Matija
 */
public class RandomGenerator {
    private static Random random;

    public RandomGenerator(int num) {
        random = new Random(num);
    }

    public static int random(int i, int min){
        return random.nextInt(i)+ min;
    }
      
}
