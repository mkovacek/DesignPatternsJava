/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.savedStates;


/**
 *
 * @author Matija
 */
public class ElementMemento {

    private String state;

    public ElementMemento(String state) {
        this.state = state;
    }

    public String getSavedElement() {
        return state;
    }

}
