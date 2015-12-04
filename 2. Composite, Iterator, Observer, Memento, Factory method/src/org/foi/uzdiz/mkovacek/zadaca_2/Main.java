/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.foi.uzdiz.mkovacek.zadaca_2.elements.ElementHandler;

/**
 *
 * @author Matija
 */
public class Main {

  private static boolean exit = false;
  private static ElementHandler elementHandler;

  public static void main(String[] args) {

    if (args.length != 1) {
      System.err.println("Invalid arguments!");
      System.exit(0);
    }
    Path path = Paths.get(args[0]);
    elementHandler = new ElementHandler();
    elementHandler.fillStructure(path);

    while (!exit) {
      switch (menu()) {
        case "0":
          exit = true;
          break;
        case "1":
          elementHandler.checkState();
          break;
        case "2":
          elementHandler.checkOverlaping();
          break;
        case "3":
          elementHandler.changeStatus(consoleReader().split(" "));
          break;
        case "4":
          elementHandler.getArea();
          break;
        case "5":
          elementHandler.readFile(Paths.get(consoleReader()));
          break;
        case "6":
          elementHandler.getStates();
          break;
        default:
          System.out.println("Krivi unos!");
      }
    }
  }

  public static String menu() {
    System.out.println("\n#####################");
    System.out.println("Odabir:");
    System.out.println("1.Pregled stanja");
    System.out.println("2.Pregled jednostavnih elemenata u presjeku");
    System.out.println("3.Promjena status elementa");
    System.out.println("4.Ukupne površine boja");
    System.out.println("5.Učitavanje dodatne datoteke");
    System.out.println("6.Vlastita funkcionalnost - ispis stanja, vraćanje na stanje x");
    System.out.println("0.Izlaz iz programa");
    return consoleReader();
  }

  public static String consoleReader() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    try {
      input = br.readLine();
    } catch (IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    return input;
  }

}
