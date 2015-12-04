/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1;


import org.foi.uzdiz.mkovacek.zadaca_1.competition.CompetitonFacade;

/**
 *
 * @author Matija
 */
public class App {
    private static final int NUM_OF_REQUIRED_ARGUMENTS = 8;
    private static CompetitonFacade competiton;
    
    public static void main(String [] args){
        if(args.length!=NUM_OF_REQUIRED_ARGUMENTS){
            System.err.println("Invalid arguments!");
            System.exit(0);
        }       
        competiton=new CompetitonFacade(args);
        competiton.startCompetition();       
    }    
}
