/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.settings;

/**
 *
 * @author Matija
 */
public class Settings {

    private static int numOfCars;
    private static int numOfZones;
    private static int zoneCapacity;
    private static int maxParking;
    private static int timeUnit;
    private static int arrivalInterval;
    private static int departureInterval;
    private static int priceUnit;
    private static int controlInterval;
    private static int parkingPenalty;
        
    
    public static void setSettings(String[] args){
        setNumOfCars(Integer.valueOf(args[0]));
        setNumOfZones(Integer.valueOf(args[1]));
        setZoneCapacity(Integer.valueOf(args[2]));
        setMaxParking(Integer.valueOf(args[3]));
        setTimeUnit(Integer.valueOf(args[4]));
        setArrivalInterval(Integer.valueOf(args[5]));
        setDepartureInterval(Integer.valueOf(args[6]));
        setPriceUnit(Integer.valueOf(args[7]));
        setControlInterval(Integer.valueOf(args[8]));
        setParkingPenalty(Integer.valueOf(args[9]));
    }
    
    public static int getNumOfCars() {
        return numOfCars;
    }

    private static void setNumOfCars(int numOfCars) {
        Settings.numOfCars = numOfCars;
    }

    public static int getNumOfZones() {
        return numOfZones;
    }

    private static void setNumOfZones(Integer numOfZones) {
        Settings.numOfZones = numOfZones;
    }

    public static int getZoneCapacity() {
        return zoneCapacity;
    }

    private static void setZoneCapacity(Integer zoneCapacity) {
        Settings.zoneCapacity = zoneCapacity;
    }

    public static int getMaxParking() {
        return maxParking;
    }

    private static void setMaxParking(Integer maxParking) {
        Settings.maxParking = maxParking;
    }

    public static int getTimeUnit() {
        return timeUnit;
    }

    private static void setTimeUnit(Integer timeUnit) {
        Settings.timeUnit = timeUnit;
    }

    public static int getArrivalInterval() {
        return arrivalInterval;
    }

    private static void setArrivalInterval(Integer arrivalInterval) {
        Settings.arrivalInterval = arrivalInterval;
    }

    public static int getDepartureInterval() {
        return departureInterval;
    }

    private static void setDepartureInterval(Integer departureInterval) {
        Settings.departureInterval = departureInterval;
    }

    public static int getPriceUnit() {
        return priceUnit;
    }

    private static void setPriceUnit(Integer priceUnit) {
        Settings.priceUnit = priceUnit;
    }

    public static int getControlInterval() {
        return controlInterval;
    }

    private static void setControlInterval(Integer controlInterval) {
        Settings.controlInterval = controlInterval;
    }

    public static int getParkingPenalty() {
        return parkingPenalty;
    }

    private static void setParkingPenalty(Integer parkingPenalty) {
        Settings.parkingPenalty = parkingPenalty;
    }    
}
