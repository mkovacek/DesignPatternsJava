/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.iterator;

import org.foi.uzdiz.mkovacek.zadaca_2.elements.Element;

/**
 *
 * @author Matija
 */
public interface Iterator {
    boolean hasNext();
    Element next();
}
