/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.shapes;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.List;
import org.foi.uzdiz.mkovacek.zadaca_2.elements.Element;

/**
 *
 * @author Matija
 */
public class ShapeHelper {

  public String checkOverlaping(Shape parent, Shape child) {
    String cords = "";
    Rectangle2D boundingBox = child.getBounds2D();
    boolean isInside = parent.contains(boundingBox);

    if (!isInside) {
      boolean isIntersecting = parent.intersects(boundingBox);
      if (isIntersecting) {
        Point a = new Point((int) boundingBox.getMinX(), (int) boundingBox.getMinY());
        Point b = new Point((int) boundingBox.getMaxX(), (int) boundingBox.getMinY());
        Point c = new Point((int) boundingBox.getMinX(), (int) boundingBox.getMaxY());
        Point d = new Point((int) boundingBox.getMaxX(), (int) boundingBox.getMaxY());

        if (!parent.contains(a) && !parent.contains(b)) {
          cords += " Y ";
        }
        if (!parent.contains(a) && !parent.contains(c)) {
          cords += " X ";
        }
        if (!parent.contains(c) && !parent.contains(d)) {
          cords += " Y ";
        }
        if (!parent.contains(b) && !parent.contains(d)) {
          cords += " X ";
        }
        return cords;
      } else {
        if (boundingBox.getHeight() == 0 && boundingBox.getWidth() == 0) {
          cords += " Nema ";
        } else {
          cords += " Izvan roditelja ";
        }
        return cords;
      }
    }
    return "Nema";
  }

  public void checkIntersection(Shape parent, List<Element> childs) {
    for (int i = 0; i < childs.size(); i++) {
      Rectangle2D childI = childs.get(i).getShape().getBounds2D();
      for (int j = i + 1; j < childs.size(); j++) {
        Rectangle2D childJ = childs.get(j).getShape().getBounds2D();
        boolean isInside = parent.contains(childJ);
        if (isInside) {
          boolean isIntersecting = childJ.intersects(childI);
          if (isIntersecting) {
            System.out.print("\t(" + childs.get(i).getCode() + "," + childs.get(j).getCode() + ")");
          }
        }

      }
    }
    System.out.println("");
  }

  public boolean isInside(Shape parent, Shape child) {
    Rectangle2D boundingBox = child.getBounds2D();
    boolean isInside = parent.contains(boundingBox);
    return isInside;
  }

}
