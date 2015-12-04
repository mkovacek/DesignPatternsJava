/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.competition;

/**
 *
 * @author Matija
 */
public class CompetitonFacade {

    private final Competition competition;
    private final int seed;
    private final int maxNumOfSubjects;
    private final int maxNumOfSubjectsPerCompetitor;
    private final int maxNumOfCategories;
    private final int maxNumOfCompetitors;
    private final int numOfJury;
    private final String className;
    private final String fileName;
    
    public CompetitonFacade(String [] args) {
        seed=Integer.parseInt(args[0]);
        maxNumOfSubjects=Integer.parseInt(args[1]);
        maxNumOfSubjectsPerCompetitor=Integer.parseInt(args[2]);
        maxNumOfCategories=Integer.parseInt(args[3]);
        maxNumOfCompetitors=Integer.parseInt(args[4]);
        numOfJury=Integer.parseInt(args[5]);
        className=args[6];
        fileName=args[7];
        competition=Competition.getInstance();
    }
      
    public void startCompetition(){
        Competition.init(seed,maxNumOfSubjects,maxNumOfCompetitors);
        Competition.registration(maxNumOfSubjectsPerCompetitor,maxNumOfCategories);
        Competition.scoring(numOfJury,className);
        Competition.results(fileName);
    }
}
