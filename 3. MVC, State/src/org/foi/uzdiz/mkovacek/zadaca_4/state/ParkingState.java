/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.state;

import org.foi.uzdiz.mkovacek.zadaca_4.mvc.model.Parking;
import org.foi.uzdiz.mkovacek.zadaca_4.threads.CarArrivals;

/**
 *
 * @author Matija
 */
public interface ParkingState {
    public void doAction(Parking parking);
    public void parkingAction(CarArrivals carArrivals);
}
