/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.util;

import java.util.regex.Pattern;

/**
 *
 * @author Matija
 */
public class ArgumentValidator {
    private static final String sintaksa = "^([1-9][0-9]|100)[\\s+?]([1-4])[\\s+?]([1-9]|[1-9][0-9]|100)([\\s+?]([1-9]|10)){6}[\\s+?]([1-9][0-9]|100)$";
 
    public static boolean checkArguments(String[] args) {
        return Pattern.compile(sintaksa)
                .matcher(args[0]+" "+args[1]+" "+args[2]+" "+args[3]+" "+args[4]+" "+args[5]+" "+args[6]+" "+args[7]+" "+args[8]+" "+args[9])
                .matches();
    }
}
