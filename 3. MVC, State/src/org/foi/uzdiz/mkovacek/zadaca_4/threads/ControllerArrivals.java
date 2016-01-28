/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.foi.uzdiz.mkovacek.zadaca_4.mvc.model.Car;
import org.foi.uzdiz.mkovacek.zadaca_4.mvc.model.Parking;
import org.foi.uzdiz.mkovacek.zadaca_4.mvc.model.Zone;
import org.foi.uzdiz.mkovacek.zadaca_4.settings.Settings;

/**
 *
 * @author Matija
 */
public class ControllerArrivals implements Runnable {

    private List<Zone> zones;
    private List<Car> cars;

    public ControllerArrivals(List<Zone> zones, List<Car> cars) {
        this.zones = zones;
        this.cars = cars;
    }

    @Override
    public void run() {
        while (true) {
            new ArrayList<>(zones).forEach(zone -> {
                long start = System.currentTimeMillis();
                new ArrayList<>(zone.getCars()).forEach(car -> {
                    if (((System.currentTimeMillis() - car.getParkingTime()) / 1000) > zone.getParkingTime()) {
                        System.out.println("Automobilu_" + car.getId()+" je isteklo parkiranje. Kazna, auto se odvozi na deponij.");
                        zone.payPenalty();
                        zone.removeCar(car);
                        Parking.getCars().remove(car);
                        int zoneId = zone.getId();
                        if (Parking.getDumpCars().containsKey(zoneId)) {
                            List<Car> listOfDumpCars = Parking.getDumpCars().get(zoneId);
                            listOfDumpCars.add(car);
                            Parking.getDumpCars().replace(zoneId, listOfDumpCars);
                        } else {
                            List<Car> listOfDumpCars = new ArrayList<>();
                            listOfDumpCars.add(car);
                            Parking.getDumpCars().put(zoneId, listOfDumpCars);
                        }
                    }
                });
                try {
                    long sleep = 1000 * (Settings.getTimeUnit() / Settings.getControlInterval()) - (System.currentTimeMillis() - start);
                    if (sleep < 0) {
                        sleep = 0;
                    }
                    Thread.sleep(sleep);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CarArrivals.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }

}
