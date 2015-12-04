/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.scoring;

import java.util.ArrayList;

/**
 *
 * @author Matija
 */
public class Sum implements Scoring{

    @Override
    public int getScore(ArrayList<Integer> marks) {
        return marks.stream().mapToInt(Integer::intValue).sum();
    }    
}
