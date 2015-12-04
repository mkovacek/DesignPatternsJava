/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.shapes;

import java.awt.Shape;
import java.util.List;

/**
 *
 * @author Matija
 */
public interface IShape {
    public Shape createShape(List<Integer> cordinates);
    public Double calculateArea(List<Integer> cordinates);
    public List<Integer> getRelativeCords(int xParent, int yParent, List<Integer> cordinates);
}
