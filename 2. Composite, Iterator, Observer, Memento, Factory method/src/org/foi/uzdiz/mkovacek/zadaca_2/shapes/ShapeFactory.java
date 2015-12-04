/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.shapes;

/**
 *
 * @author Matija
 */
public class ShapeFactory {
    public static IShape initShape(int numOfCordinates){       
        if(numOfCordinates==3){
            return new CircleShape();
        }else if(numOfCordinates==4){
            return new RectangleShape();
        }else{
            return new PolygonShape();
        }
    }
}
