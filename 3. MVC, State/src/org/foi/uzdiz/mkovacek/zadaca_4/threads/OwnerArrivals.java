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
import org.foi.uzdiz.mkovacek.zadaca_4.mvc.model.Zone;
import org.foi.uzdiz.mkovacek.zadaca_4.settings.Settings;

/**
 *
 * @author Matija
 */
public class OwnerArrivals implements Runnable {

    private List<Zone> zones;
    private List<Car> cars;

    public OwnerArrivals(List<Zone> zones, List<Car> cars) {
        this.zones = zones;
        this.cars = cars;
    }

    @Override
    public void run() {
        while (true) {
            new ArrayList<>(cars).forEach(car -> {
                long start = System.currentTimeMillis();
                if (car.isParked()) {                   
                    int action = getActionNumber();
                    Zone zone = zones.get(car.getZone() - 1);
                    if (action == 1) {
                        System.out.println(car.getOwner().getName() + " izlazi s svojim automobilom_" + car.getId() + " iz parkiralista, zone " + zone.getId());
                        zones.get(car.getZone() - 1).getCars().remove(car);
                        car.setParked(false);
                        car.setNumOfExtendedTicket(0);
                    }
                    if (action == 2) {
                        if (car.getNumOfExtendedTicket() <= zone.getMaxNumOfTicketExtending()) {
                            System.out.println(car.getOwner().getName() + " produljuje parking svom automobilu_" + car.getId() + " u parkiralistu, zone " + zone.getId());
                            zone.payTicket();
                            car.increaseParkingCounter();
                            car.increaseNumOfExtendedTicek();
                            car.setParkingTime(System.currentTimeMillis());
                        } else {
                            System.out.println(car.getOwner().getName() + " je htio produljiti parking svom automobilu_" + car.getId() + " u parkiralistu, zone " + zone.getId() + " ali nemoze jer je iskoristio max br parkiranja");
                        }
                    }
                }
                try {
                    long sleep = 1000 * Math.round((Settings.getTimeUnit() / Settings.getDepartureInterval()) * car.getGenNumber3()) - (System.currentTimeMillis() - start);
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

    private int getActionNumber() {
        double d = Math.random() * 100;
        if (d < 50) {
            return 1;
        } else if (d < 75) {
            return 0;
        } else {
            return 2;
        }
    }

}
