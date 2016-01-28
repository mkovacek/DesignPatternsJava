/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.util;

import java.util.Random;

/**
 *
 * @author Matija
 */
public class NumberGenerator {
    private static final float min=0.0F;
    private static final float max=1.0F;

    public static float getRandomNumber(){
        return (min+max)*new Random().nextFloat()+min;
    }
}
