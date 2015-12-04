/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.shapes;

import java.awt.Polygon;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class PolygonShape implements IShape {

  int n;
  int x[];
  int y[];
  Double area;

  @Override
  public Shape createShape(List<Integer> cordinates) {
    n = cordinates.size() / 2;
    x = new int[n];
    y = new int[n];
    int xi = 0, yi = 0;
    for (int i = 0; i < cordinates.size(); i++) {
      if (i % 2 == 0) {
        x[xi] = cordinates.get(i);
        xi++;
      } else {
        y[yi] = cordinates.get(i);
        yi++;
      }
    }
    return new Polygon(x, y, n);
  }

  @Override
  public Double calculateArea(List<Integer> cordinates) {
    area = 0.0;
    for (int i = 0; i < n - 1; i++) {
      area += (x[i] * y[i + 1]) - (x[i + 1] * y[i]);
    }
    area = area / 2;
    return area;
  }

  @Override
  public List<Integer> getRelativeCords(int xParent, int yParent, List<Integer> cordinates) {
    List<Integer> relCords = new ArrayList<>();
      for (int j = 0; j < cordinates.size(); j++) {
        if (j % 2 == 0) {
          relCords.add(cordinates.get(j) + xParent);
        } else {
          relCords.add(cordinates.get(j) + yParent);
        }
      }
    return relCords;
  }

}
