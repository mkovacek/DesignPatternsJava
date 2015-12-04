/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.elements;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import org.foi.uzdiz.mkovacek.zadaca_2.shapes.ShapeHelper;
import org.foi.uzdiz.mkovacek.zadaca_2.iterator.Iterator;

/**
 *
 * @author Matija
 */
public class Child extends Element {

    public Child(int type, String code, String parentCode, String color, boolean visible) {
        this.type = type;
        this.code = code;
        this.parentCode = parentCode;
        this.color = color;
        this.visible = true;
        status = "active";
        overlapCords = "";
    }

    @Override
    public void checkOverlaping(Shape parent) {
        ShapeHelper id = new ShapeHelper();
        String cords = id.checkOverlaping(parent, shape);
        if (visible) {
            if (cords != null) {
                overlap = true;
                overlapCords = cords;
            }
            System.out.println(type + "\t" + code + "\t" + parentCode + "\t" + relativeCoordinates.toString() + "\t" + color + "\t Status " + status + "\t Vidljiv " + visible + "\t Prijestup " + overlapCords);
        }

    }

    @Override
    public void getColorAreaInfo(Shape parent) {
        if (visible) {
            ShapeHelper id = new ShapeHelper();
            boolean isInside = id.isInside(parent, shape);
            if (isInside) {
                area = iShape.calculateArea(relativeCoordinates);
                System.out.println(type + "\t" + code + "\t" + parentCode + "\t" + color + "\t Status " + status + "\t Vidljiv " + visible + "\t Prijestup " + overlapCords + "\t Površina " + area.toString());
            }
        }

    }

    @Override
    public List<Element> getColorArea(Shape parent) {
        List<Element> element = new ArrayList<>();
        if (visible) {
            ShapeHelper id = new ShapeHelper();
            boolean isInside = id.isInside(parent, shape);
            if (isInside) {
                area = iShape.calculateArea(relativeCoordinates);
                element.add(this);
                return element;
            }
        }
        return element;

    }

    @Override
    public void checkIntersection() {
    }

    @Override
    public void changeStatus(String code, String status) {
        if (this.code.equals(code)) {
            this.status = status;
            visible = !status.equals("sakriveni");
        } else {
            if (parentCode.equals(code)) {
                visible = !status.equals("sakriveni");
            }
        }
    }

    @Override
    public void print() {
        System.out.println(type + "\t" + code + "\t" + parentCode + "\t" + coordinates.toString() + "\t" + color + "\t Status " + status + "\t Vidljiv " + visible);
    }

    @Override
    public String printStates(String clear) {
        return type + "\t" + code + "\t" + parentCode + "\t Status " + status + "\t Vidljiv " + visible + "\n";
    }

    @Override
    public void changeVisibility(boolean visible) {
        this.setVisible(visible);
    }

    @Override
    public void add(Element element) {
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator createIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Element getChild(int i) {
        return null;
    }

}
