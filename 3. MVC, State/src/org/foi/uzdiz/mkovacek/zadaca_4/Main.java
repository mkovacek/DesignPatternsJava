package org.foi.uzdiz.mkovacek.zadaca_4;

import org.foi.uzdiz.mkovacek.zadaca_4.mvc.ParkingController;
import org.foi.uzdiz.mkovacek.zadaca_4.mvc.ParkingView;
import org.foi.uzdiz.mkovacek.zadaca_4.mvc.model.Parking;
import org.foi.uzdiz.mkovacek.zadaca_4.util.ArgumentValidator;

/**
 *
 * @author Matija
 */
public class Main {

    public static void main(String[] args) {
        if (ArgumentValidator.checkArguments(args)) {
            Parking model=new Parking();
            ParkingView view=new ParkingView();
            ParkingController parkingCtrl=new ParkingController(model, view, args);
            parkingCtrl.start();
        } else {
            System.out.println("Invalid arguments");
            System.exit(0);
        }

    }
}
