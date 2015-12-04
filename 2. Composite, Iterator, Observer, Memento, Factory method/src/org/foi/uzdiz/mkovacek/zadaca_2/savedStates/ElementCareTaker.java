/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.savedStates;

import java.util.ArrayList;

/**
 *
 * @author Matija
 */
public class ElementCareTaker {

    private  ArrayList<ElementMemento> mementos=new ArrayList<>();;

    public void addMemento(ElementMemento m) {     
        mementos.add(m);
    }

    public ElementMemento getMemento(int index) {
        return mementos.get(index);
    }

    public ArrayList<ElementMemento> getAllMementos() {
        return mementos;
    }
}
