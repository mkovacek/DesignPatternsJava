/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.mvc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.foi.uzdiz.mkovacek.zadaca_4.settings.Settings;
import org.foi.uzdiz.mkovacek.zadaca_4.state.ClosedParking;
import org.foi.uzdiz.mkovacek.zadaca_4.state.OpenedParking;
import org.foi.uzdiz.mkovacek.zadaca_4.state.ParkingState;
import org.foi.uzdiz.mkovacek.zadaca_4.threads.CarArrivals;
import org.foi.uzdiz.mkovacek.zadaca_4.threads.OwnerArrivals;
import org.foi.uzdiz.mkovacek.zadaca_4.threads.ControllerArrivals;

/**
 *
 * @author Matija
 */
public class Parking {

    private static List<Zone> zones;
    private static List<Car> cars;
    private static HashMap<Integer, List<Car>> dumpCars;
    private static HashMap<Integer, List<Car>> notParkedCars;
    private Thread carArrivalsT;
    private Thread ownerArrivalsT;
    private Thread controllerArrivalsT;
    private CarArrivals carArrivals;
    private OwnerArrivals ownerArrivals;
    private ControllerArrivals parkingController;
    private ParkingState parkingState;
    private OpenedParking openedParking;
    private ClosedParking closedParking;

    public Parking() {
        zones = new ArrayList<>();
        dumpCars = new HashMap<>();
        notParkedCars = new HashMap<>();
        cars = new ArrayList<>();
        closedParking = new ClosedParking();
        openedParking = new OpenedParking();
    }

    public void init() {
        for (int i = 1; i <= Settings.getNumOfZones(); i++) {
            Zone zone = new Zone(i);
            zones.add(zone);
        }

        for (int i = 1; i <= Settings.getNumOfCars(); i++) {
            CarOwner owner = new CarOwner("Vlasnik_" + i);
            Car car = new Car(i, owner);
            cars.add(car);
        }

        carArrivals = new CarArrivals(zones, cars);
        carArrivalsT = new Thread(carArrivals);
        carArrivalsT.start();

        ownerArrivals = new OwnerArrivals(zones, cars);
        ownerArrivalsT = new Thread(ownerArrivals);
        ownerArrivalsT.start();

        parkingController = new ControllerArrivals(zones, cars);
        controllerArrivalsT = new Thread(parkingController);
        controllerArrivalsT.start();

    }

    public void closeParking() {
        closedParking.doAction(this);
        this.getParkingState().parkingAction(carArrivals);
    }

    public void openParking() {
        openedParking.doAction(this);
        this.getParkingState().parkingAction(carArrivals);
    }

    public void killThreads() {
        if (carArrivalsT != null & carArrivalsT.isAlive()) {
            carArrivalsT.interrupt();
        }
        if (ownerArrivalsT != null & ownerArrivalsT.isAlive()) {
            ownerArrivalsT.interrupt();
        }
        if (controllerArrivalsT != null & controllerArrivalsT.isAlive()) {
            controllerArrivalsT.interrupt();
        }
    }

    public static List<Zone> getZones() {
        return zones;
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static HashMap<Integer, List<Car>> getDumpCars() {
        return dumpCars;
    }

    public static HashMap<Integer, List<Car>> getNotParkedCars() {
        return notParkedCars;
    }

    public ParkingState getParkingState() {
        return parkingState;
    }

    public void setParkingState(ParkingState parkingState) {
        this.parkingState = parkingState;
    }

}
