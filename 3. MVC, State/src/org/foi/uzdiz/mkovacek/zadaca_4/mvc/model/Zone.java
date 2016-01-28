/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.mvc.model;

import java.util.ArrayList;
import java.util.List;
import org.foi.uzdiz.mkovacek.zadaca_4.settings.Settings;

/**
 *
 * @author Matija
 */
public class Zone {

    private int id;
    private int capacity;
    private int parkingTime;
    private int ticketPrice;
    private int penaltyPrice;
    private int maxNumOfTicketExtending;
    private int ticketSalary;
    private int penaltySalary;
    private List<Car> cars;


    public Zone(int id) {
        this.id = id;
        cars = new ArrayList<>();
        setCapacity();
        setParkingTime();
        setTicketPrice();
        setPenaltyPrice();
        setMaxNumOfTicketExtending();
        ticketSalary = 0;
        penaltySalary = 0;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity() {
        capacity = id * Settings.getZoneCapacity();
    }

    public int getParkingTime() {
        return parkingTime;
    }

    private void setParkingTime() {
        parkingTime = id * Settings.getMaxParking() * Settings.getTimeUnit();
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    private void setTicketPrice() {
        this.ticketPrice = (Settings.getNumOfZones() + 1 - id) * Settings.getPriceUnit();
    }

    public int getPenaltyPrice() {
        return penaltyPrice;
    }

    public void setPenaltyPrice() {
        this.penaltyPrice = Settings.getParkingPenalty() * Settings.getPriceUnit() * (Settings.getNumOfZones() + 1 - id);
    }

    public int getMaxNumOfTicketExtending() {
        return maxNumOfTicketExtending;
    }

    private void setMaxNumOfTicketExtending() {
        this.maxNumOfTicketExtending = id - 1;
    }

    public int getTicketSalary() {
        return ticketSalary;
    }

    public void payTicket() {
        this.ticketSalary += getTicketPrice();
    }

    public int getPenaltySalary() {
        return penaltySalary;
    }

    public void payPenalty() {
        this.penaltySalary += getPenaltyPrice();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public float getOccupancy() {
        return (100*((float)cars.size()/(float)capacity));
    }

}
