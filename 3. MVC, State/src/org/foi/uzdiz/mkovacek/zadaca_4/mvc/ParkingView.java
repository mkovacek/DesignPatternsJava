/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.mvc;

import java.util.Comparator;
import org.foi.uzdiz.mkovacek.zadaca_4.mvc.model.Car;
import org.foi.uzdiz.mkovacek.zadaca_4.mvc.model.Parking;

/**
 *
 * @author Matija
 */
public class ParkingView {
    
     public void printParkingSalaryByZones() {
        Parking.getZones().forEach(zone -> {
            System.out.println("Zone " + zone.getId() + ", ticket salary " + zone.getTicketSalary());
        });
    }

    public void printPenaltySalaryByZones() {
        Parking.getZones().forEach(zone -> {
            System.out.println("Zone " + zone.getId() + ", penalty salary " + zone.getPenaltySalary());
        });
    }

    public void printNotParkedCarsByZones() {
        Parking.getNotParkedCars().entrySet().forEach(entry -> {
            System.out.println("U zoni " + entry.getKey() + " ,automobili se nisu mogli " + entry.getValue().size() + " puta parkirati.");
            System.out.print("(");
            entry.getValue().forEach(car -> {
                System.out.print(" auto_" + car.getId() + " ");
            });
            System.out.println(")");
        });
    }

    public void printDumpCarsByZones() {
        Parking.getDumpCars().entrySet().forEach(entry -> {
            System.out.println("Iz zone " + entry.getKey() + " ,pauk je odveo " + entry.getValue().size() + " puta automobil.");
            System.out.print("(");
            entry.getValue().forEach(car -> {
                System.out.print(" auto_" + car.getId() + " ");
            });
            System.out.println(")");
        });
    }

    public void printTopFiveCarsWithMaxNumOfParking() {
        Parking.getCars().stream().sorted(Comparator.comparing(Car::getParkingCounter).reversed()).limit(5).forEach(car -> {
            System.out.println("Automobil_" + car.getId() + " ,se parkirao " + car.getParkingCounter() + " puta.");
        });
    }

    public void printParkingOccupancyByZone() {
        Parking.getZones().forEach(zone -> {
            System.out.println("Trenutna popunjenost zone " + zone.getId() + " iznosi " + zone.getOccupancy() + " %");

        });
    }
    
}
