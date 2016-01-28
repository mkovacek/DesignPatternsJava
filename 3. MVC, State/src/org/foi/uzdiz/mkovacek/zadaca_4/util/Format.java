/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Format {

    public static String dateFormat(long timestamp) {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(timestamp));
    }

    public static float floatFormat(float number) {
        return Float.valueOf(String.format(Locale.ENGLISH, "%.4f", number));
    }
}
