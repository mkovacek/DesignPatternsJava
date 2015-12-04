/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.registration;

import java.util.ArrayList;
import org.foi.uzdiz.mkovacek.zadaca_1.camera.Camera;
import org.foi.uzdiz.mkovacek.zadaca_1.competitors.Competitor;
import org.foi.uzdiz.mkovacek.zadaca_1.photo.Photo;

/**
 *
 * @author Matija
 */
public class Registration{
    private Competitor competitor;
    private Camera photoaparat;
    private Photo photo;
    private int correctScore;
    private int score;
    private boolean disqualified;
    private String subject;
    private String categorie;
    private ArrayList<Integer> marks;
            
    public Registration() {
    }

    public Competitor getCompetitor() { return competitor; }

    public void setCompetitor(Competitor competitor) { this.competitor = competitor; }

    public Camera getPhotoaparat() { return photoaparat; }

    public void setPhotoaparat(Camera photoaparat) { this.photoaparat = photoaparat; }

    public Photo getPhoto() { return photo; }

    public void setPhoto(Photo photo) { this.photo = photo; }

    public int getCorrectScore() { return correctScore;}

    public void setCorrectScore(int correctScore) { this.correctScore = correctScore; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public boolean isDisqualified() { return disqualified; }

    public void setDisqualified(boolean disqualified) { this.disqualified = disqualified; }

    public ArrayList<Integer> getMarks() { return marks; }

    public void setMarks(ArrayList<Integer> marks) { this.marks = marks; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public String getCategorie() { return categorie; }

    public void setCategorie(String categorie) { this.categorie = categorie; }    
}
