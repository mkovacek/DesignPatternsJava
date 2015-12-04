/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.scoring;

/**
 *
 * @author Matija
 */
public class ScoringFactory {
    public static Scoring initScoring(String type){
        if(type.equalsIgnoreCase("Sum")){
            return new Sum();
        }else if (type.equalsIgnoreCase("MinMaxIgnore")){
            return new MinMaxIgnore();
        }else if(type.equalsIgnoreCase("Median")){
            return new Median();
        }
        throw new IllegalArgumentException("Class doesn't exists");
    }
}

