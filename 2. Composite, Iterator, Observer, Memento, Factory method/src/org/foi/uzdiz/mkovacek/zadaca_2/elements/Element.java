/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.elements;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import org.foi.uzdiz.mkovacek.zadaca_2.iterator.Iterator;
import org.foi.uzdiz.mkovacek.zadaca_2.shapes.IShape;
import org.foi.uzdiz.mkovacek.zadaca_2.shapes.ShapeFactory;

/**
 *
 * @author Matija
 */
public abstract class Element implements ElementObserver {

    protected int type;
    protected String code;
    protected String parentCode;
    protected List<Integer> coordinates;
    protected List<Integer> relativeCoordinates;
    protected String color;
    protected boolean overlap;
    protected String overlapCords;
    protected boolean visible;
    protected String status;
    public ArrayList<Element> childElements = new ArrayList<>();
    protected Shape shape;
    protected IShape iShape;
    protected Double area;

    abstract void checkOverlaping(Shape shape);

    abstract void getColorAreaInfo(Shape shape);

    abstract List<Element> getColorArea(Shape shape);

    abstract void checkIntersection();

    public abstract void print();

    public abstract String printStates(String clear);

    abstract void changeStatus(String code, String status);

    abstract Iterator createIterator();

    abstract void add(Element element);

    abstract void remove(Element element);

    abstract Element getChild(int i);

    @Override
    public abstract void changeVisibility(boolean visible);

    public void notifyObservers() {
        for (Element observers : childElements) {
            observers.changeVisibility(visible);
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        notifyObservers();
    }

    public void setRelCords(int xParent, int yParent) {
        iShape = ShapeFactory.initShape(coordinates.size());
        setRelativeCoordinates(iShape.getRelativeCords(xParent, yParent, coordinates));
        setShape();
    }

    public void setShape() {
        shape = iShape.createShape(relativeCoordinates);
    }

    public void setRelativeCoordinates(List<Integer> relativeCoordinates) {
        this.relativeCoordinates = relativeCoordinates;
    }

    public int getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public List<Integer> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Integer> getRelativeCoordinates() {
        return relativeCoordinates;
    }

    public String getColor() {
        return color;
    }

    public boolean isOverlap() {
        return overlap;
    }

    public String getOverlapCords() {
        return overlapCords;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Element> getChildElements() {
        return childElements;
    }

    public Shape getShape() {
        return shape;
    }

    public IShape getiShape() {
        return iShape;
    }

    public Double getArea() {
        return area;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOverlap(boolean overlap) {
        this.overlap = overlap;
    }

    public void setOverlapCords(String overlapCords) {
        this.overlapCords = overlapCords;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setChildElements(ArrayList<Element> childElements) {
        this.childElements = childElements;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setiShape(IShape iShape) {
        this.iShape = iShape;
    }

    public void setArea(Double area) {
        this.area = area;
    }

}
