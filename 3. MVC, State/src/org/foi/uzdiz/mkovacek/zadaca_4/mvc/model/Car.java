/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.mvc.model;

import org.foi.uzdiz.mkovacek.zadaca_4.util.Format;
import org.foi.uzdiz.mkovacek.zadaca_4.util.NumberGenerator;

/**
 *
 * @author Matija
 */
public class Car {

    private final int id;
    private int zone; 
    private boolean parked; 
    private int numOfExtendedTicket;
    private int parkingCounter;
    private final CarOwner owner;
    private long parkingTime;

    public Car(int id,CarOwner owner) {
        this.id = id;
        this.owner=owner;    
        parkingCounter=0;
        numOfExtendedTicket=0;
        parked=false;
    }

    public int getId() {
        return id;
    }

    public CarOwner getOwner() {
        return owner;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }
    
    public float getGenNumber1() {
        return Format.floatFormat(NumberGenerator.getRandomNumber());
    }

    public float getGenNumber2() {
        return Format.floatFormat(NumberGenerator.getRandomNumber());
    }


    public float getGenNumber3() {
        return Format.floatFormat(NumberGenerator.getRandomNumber());
    }

    public boolean isParked() {
        return parked;
    }

    public void setParked(boolean parked) {
        this.parked = parked;
    }

    public int getNumOfExtendedTicket() {
        return numOfExtendedTicket;
    }

    public void setNumOfExtendedTicket(int numOfExtendedTicket) {
        this.numOfExtendedTicket = numOfExtendedTicket;
    }
    
    public void increaseNumOfExtendedTicek(){
        this.numOfExtendedTicket++;
    }

    public int getParkingCounter() {
        return parkingCounter;
    }

    public void increaseParkingCounter() {
        this.parkingCounter++;
    }

    public long getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(long parkingTime) {
        this.parkingTime = parkingTime;
    }
    
    
    
}
