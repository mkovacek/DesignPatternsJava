/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.shapes;

import java.util.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

/**
 *
 * @author Matija
 */
public class RectangleShape implements IShape {

  @Override
  public Shape createShape(List<Integer> cordinates) {
    return new Rectangle(cordinates.get(0), cordinates.get(1), cordinates.get(2), cordinates.get(3));
  }

  @Override
  public Double calculateArea(List<Integer> cordinates) {
    return (double) (cordinates.get(2) * cordinates.get(3));
  }

  @Override
  public List<Integer> getRelativeCords(int xParent, int yParent, List<Integer> cordinates) {
    List<Integer> relCords = new ArrayList<>();
    for (int j = 0; j < cordinates.size(); j++) {
      if (j == 0) {
        relCords.add(cordinates.get(0) + xParent);
      } else if (j == 1) {
        relCords.add(cordinates.get(1) + yParent);
      } else {
        relCords.add(cordinates.get(j));
      }
    }
    return relCords;
  }

}
