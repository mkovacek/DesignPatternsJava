/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_4.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.foi.uzdiz.mkovacek.zadaca_4.mvc.model.Parking;
import org.foi.uzdiz.mkovacek.zadaca_4.settings.Settings;

/**
 *
 * @author Matija
 */
public class ParkingController {

    private  Parking model;
    private  ParkingView view;


    public ParkingController(Parking model, ParkingView view, String[] args) {
        this.model = model;
        this.view = view;
        Settings.setSettings(args);
    }
        
    
    public void start(){
        model.init();
        while (true) {
                switch (menu()) {
                    case "Q":
                        model.killThreads();
                        System.exit(0);
                        break;
                    case "1":
                        model.closeParking();
                        break;
                    case "2":
                        model.openParking();
                        break;
                    case "3":
                        view.printParkingSalaryByZones();
                        break;
                    case "4":
                        view.printPenaltySalaryByZones();
                        break;
                    case "5":
                        view.printNotParkedCarsByZones();
                        break;
                    case "6":
                        view.printDumpCarsByZones();
                        break;
                    case "7":
                        view.printTopFiveCarsWithMaxNumOfParking();
                        break;
                    case "8":
                        view.printParkingOccupancyByZone();
                        break;
                    default:
                        System.out.println("Krivi unos!");
                }
            }
    }
    
    
    public static String menu() {
        System.out.println("\n#####################");
        System.out.println("Odabir:");
        System.out.println("1.Zatvaranje parkiralista");
        System.out.println("2.Otvaranje parkiralista");
        System.out.println("3.Zarada od parkiranja po zonama");
        System.out.println("4.Zarada od kazni po zonama");
        System.out.println("5.Broj automobila koji nisu mogli parkirati po zonama");
        System.out.println("6.Broj odvedenih automobila na deponij po zonama");
        System.out.println("7.Top 5 automobila s najviše parkiranja");
        System.out.println("8.Popunjenost parkirnih mjesta po zonama");
        System.out.println("Q.Izlaz iz programa");
        return consoleReader();
    }

    public static String consoleReader() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ParkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return input.toUpperCase();
    }
}
