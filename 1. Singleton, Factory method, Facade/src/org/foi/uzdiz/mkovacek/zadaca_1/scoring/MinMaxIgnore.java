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
public class MinMaxIgnore implements Scoring{

    @Override
    public int getScore(ArrayList<Integer> marks) {
          marks.remove(new Integer(Collections.min(marks)));
          marks.remove(new Integer(Collections.max(marks)));
          return marks.stream().mapToInt(Integer::intValue).sum();
    }    
}
