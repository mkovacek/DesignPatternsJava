/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.shapes;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class CircleShape implements IShape {

  @Override
  public Shape createShape(List<Integer> cordinates) {
    return new Ellipse2D.Double((cordinates.get(0) - cordinates.get(2)), (cordinates.get(1) - cordinates.get(2)), (cordinates.get(2) * 2), (cordinates.get(2) * 2));
  }

  @Override
  public Double calculateArea(List<Integer> cordinates) {
    return Math.PI * (cordinates.get(2) * cordinates.get(2));
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
