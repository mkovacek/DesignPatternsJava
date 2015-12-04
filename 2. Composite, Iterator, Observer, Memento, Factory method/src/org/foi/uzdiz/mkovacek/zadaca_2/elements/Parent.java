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
public class Parent extends Element implements ElementObserver {

    private String ispis = "";

    public Parent(int type, String code, String parentCode, String color, boolean visible) {
        this.type = type;
        this.code = code;
        this.parentCode = parentCode;
        this.color = color;
        status = "active";
        this.visible = visible;
        overlapCords = "";
    }

    @Override
    public void add(Element element) {
        Iterator it = createIterator();
        if (code.equals(element.getParentCode())) {
            int xParent = relativeCoordinates.get(0);
            int yParent = relativeCoordinates.get(1);
            element.setRelCords(xParent, yParent);
            childElements.add(element);
        } else {
            while (it.hasNext()) {
                Element el = it.next();
                if (el.isVisible()) {
                    el.add(element);
                }
            }
        }
    }

    @Override
    public void checkOverlaping(Shape shape) {
        Iterator it = createIterator();
        if (it.hasNext()) {
            if (type == 0 && !code.equals(parentCode) && visible) {
                ShapeHelper id = new ShapeHelper();
                String cords = id.checkOverlaping(shape, this.shape);
                if (cords != null) {
                    overlap = true;
                    overlapCords = cords;
                }
                System.out.println(type + "\t" + code + "\t" + parentCode + "\t" + relativeCoordinates.toString() + "\t" + color + "\t Status " + status + "\t Vidljiv " + visible + "\t Prijestup " + overlapCords);
            }
            while (it.hasNext()) {
                it.next().checkOverlaping(this.shape);
            }
        }
    }

    @Override
    public void getColorAreaInfo(Shape shape) {
        Iterator it = createIterator();
        if (visible) {
            ShapeHelper id = new ShapeHelper();
            boolean inSide = id.isInside(shape, this.shape);
            if (inSide) {
                area = iShape.calculateArea(relativeCoordinates);
                System.out.println(type + "\t" + code + "\t" + parentCode + "\t" + color + "\t Status " + status + "\t Vidljiv " + visible + "\t Prijestup " + overlapCords + "\t Površina " + area.toString());
            }
            while (it.hasNext()) {
                it.next().getColorAreaInfo(this.shape);
            }
        }
    }

    @Override
    public List<Element> getColorArea(Shape shape) {
        List<Element> elementsAreaByColor = new ArrayList<>();
        Iterator it = createIterator();
        if (visible) {
            ShapeHelper id = new ShapeHelper();
            boolean inSide = id.isInside(shape, this.shape);
            if (inSide) {
                area = iShape.calculateArea(relativeCoordinates);
                elementsAreaByColor.add(this);
                while (it.hasNext()) {
                    Element elem = it.next();
                    List<Element> e = elem.getColorArea(this.shape);
                    if (!e.isEmpty()) {
                        e.forEach(child -> {
                            elementsAreaByColor.add(child);
                        });
                    }
                }
                return elementsAreaByColor;
            } else {
                while (it.hasNext()) {
                    Element elem = it.next();
                    List<Element> e = elem.getColorArea(this.shape);
                    if (!e.isEmpty()) {
                        e.forEach(child -> {
                            elementsAreaByColor.add(child);
                        });
                    }
                }
                return elementsAreaByColor;
            }
        }
        return elementsAreaByColor;
    }

    @Override
    public void checkIntersection() {
        Iterator it = createIterator();
        List<Element> childs = new ArrayList<>();
        if (isVisible()) {
            while (it.hasNext()) {
                Element el = it.next();
                if (el.isVisible()) {
                    childs.add(el);
                    el.checkIntersection();
                }
            }
            ShapeHelper id = new ShapeHelper();
            System.out.print("Roditelj: " + code + " => ");
            id.checkIntersection(shape, childs);
        }
    }

    @Override
    public void remove(Element element) {
        childElements.remove(element);
    }

    @Override
    public Element getChild(int i) {
        return childElements.get(i);
    }

    @Override
    public void print() {
        System.out.println(type + "\t" + code + "\t" + parentCode + "\t" + coordinates.toString() + "\t" + color + "\t Status " + status + "\t Vidljiv " + visible);
        Iterator it = createIterator();
        while (it.hasNext()) {
            it.next().print();
        }
    }

    @Override
    public String printStates(String clear) {
        ispis = clear;
        ispis += type + "\t" + code + "\t" + parentCode + "\t Status " + status + "\t Vidljiv " + visible + "\n";
        Iterator it = createIterator();
        while (it.hasNext()) {
            ispis += it.next().printStates(clear);
        }
        return ispis;
    }

    @Override
    public Iterator createIterator() {
        return new ElementIterator();
    }

    @Override
    public void changeStatus(String code, String status) {
        Iterator it = createIterator();
        if (this.code.equals(code)) {
            this.status = status;
            visible = !status.equals("sakriveni");
            notifyObservers();
        } else {
            if (this.parentCode.equals(code)) {
                visible = !status.equals("sakriveni");
                notifyObservers();
            } else { 
                while (it.hasNext()) {
                    it.next().changeStatus(code, status);
                }
            }
        }
    }

    @Override
    public void changeVisibility(boolean visible) {
        setVisible(visible);
    }

    public class ElementIterator implements Iterator {

        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < childElements.size();
        }

        @Override
        public Element next() {
            if (this.hasNext()) {
                int index = position;
                position++;
                return childElements.get(index);
            }
            return null;
        }

    }

}
