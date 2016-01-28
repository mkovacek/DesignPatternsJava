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
import org.foi.uzdiz.mkovacek.zadaca_4.util.Format;

/**
 *
 * @author Matija
 */
public class CarArrivals implements Runnable {

    private  List<Zone> zones;
    private  List<Car> cars;
    boolean pause = false;

    public CarArrivals(List<Zone> zones, List<Car> cars) {
        this.zones = zones;
        this.cars = cars;
    }

    @Override
    public void run() {
        while (true) {
            new ArrayList<>(cars).forEach(car -> {
                synchronized (this) {
                    while (pause) {  
                        try {
                            wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CarArrivals.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (!car.isParked()) {
                    long start = System.currentTimeMillis();
                    int num = Math.round(Settings.getNumOfZones() * car.getGenNumber2());
                    int zoneIndex = num > 0 ? num - 1 : num;
                    Zone zone = zones.get(zoneIndex);
                    if (zone.getCapacity() > zone.getCars().size()) {
                        long parkingTime = System.currentTimeMillis();
                        zone.payTicket();
                        zone.addCar(car);
                        car.increaseParkingCounter();
                        car.setParked(true);
                        car.setZone(zone.getId());
                        car.setParkingTime(parkingTime);
                        System.out.println("Automobil_" + car.getId() + " se parkirao u zoni " + zone.getId() + ". Cijena karte iznosi  " + zone.getTicketPrice()+" "+Format.dateFormat(parkingTime));
                    } else {
                        System.out.println("Automobil_" + car.getId() + " se nije parkirao u zoni " + zone.getId() + " zbog " + zone.getOccupancy() + " % popunjenosti kapacitea "+Format.dateFormat(System.currentTimeMillis()));
                        int zoneId = zone.getId();
                        if (Parking.getNotParkedCars().containsKey(zoneId)) {
                            List<Car> listOfNotParkedCars = Parking.getNotParkedCars().get(zoneId);
                            listOfNotParkedCars.add(car);
                            Parking.getNotParkedCars().replace(zoneId, listOfNotParkedCars);
                        } else {
                            List<Car> listOfNotParkedCars = new ArrayList<>();
                            listOfNotParkedCars.add(car);
                            Parking.getNotParkedCars().put(zoneId, listOfNotParkedCars);
                        }
                    }
                    try {
                        long sleep = 1000 * Math.round((Settings.getTimeUnit() / Settings.getArrivalInterval()) * car.getGenNumber1()) - (System.currentTimeMillis() - start);
                        if (sleep < 0) {
                            sleep = 0;
                        }
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CarArrivals.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
    }

    public void closeParking() {
        pause = true;
    }

    public synchronized void openParking() {
        pause = false;
        notify();
    }

}
