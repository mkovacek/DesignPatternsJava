/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.scoring;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Matija
 */
public class Median implements Scoring{

    @Override
    public int getScore(ArrayList<Integer> marks) {
        Collections.sort(marks);
        if (marks.size() % 2 == 1)
            return marks.get((marks.size()+1)/2-1);
        else{
            double lower = marks.get(marks.size()/2-1);
            double upper = marks.get(marks.size()/2);
            return(int) Math.round((lower + upper) / 2.0);
        }
    }    
}
