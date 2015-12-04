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
public class ElementOriginator {

    private String state;

    public void set(String state) {
        this.state = state;
    }

    public ElementMemento storeInMemento() {
        return new ElementMemento(state);
    }

    public String restoreFromMemento(ElementMemento memento) {
        state = memento.getSavedElement();
        return state;
    }
}
