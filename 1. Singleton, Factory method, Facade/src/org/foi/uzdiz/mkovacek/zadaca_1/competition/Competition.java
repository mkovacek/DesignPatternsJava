/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.competition;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.foi.uzdiz.mkovacek.zadaca_1.camera.Camera;
import org.foi.uzdiz.mkovacek.zadaca_1.categories.Categories;
import org.foi.uzdiz.mkovacek.zadaca_1.categories.Categories.Types;
import org.foi.uzdiz.mkovacek.zadaca_1.competitors.Competitor;
import org.foi.uzdiz.mkovacek.zadaca_1.helper.RandomGenerator;
import org.foi.uzdiz.mkovacek.zadaca_1.helper.Writer;
import org.foi.uzdiz.mkovacek.zadaca_1.photo.Photo;
import org.foi.uzdiz.mkovacek.zadaca_1.subject.Subject;
import org.foi.uzdiz.mkovacek.zadaca_1.registration.Registration;
import org.foi.uzdiz.mkovacek.zadaca_1.scoring.Scoring;
import org.foi.uzdiz.mkovacek.zadaca_1.scoring.ScoringFactory;

/**
 *
 * @author Matija
 */
public class Competition {

    private static volatile Competition INSTANCE;
    public static ArrayList<String> activePhotoSubjects;
    public static ArrayList<String> activeCategories;
    public static ArrayList<Competitor> activeCompetitor;
    public static RandomGenerator rand;
    public static Subject[] subjectValues = Subject.values();
    public static Types[] categorieValues = Categories.Types.values();
    public static int finalNumOfCategories;
    public static int finalNumOfSubject;
    public static HashMap<String, ArrayList<Camera>> listOfCamera;
    public static HashMap<String, HashMap<String, ArrayList<Registration>>> listOfRegistrations;

    private Competition() {
    }

    public static Competition getInstance() {
        if (INSTANCE == null) {
            synchronized (Competition.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Competition();
                }
            }
        }
        return INSTANCE;
    }

    public static void init(int seed, int numOfSubjects, int numOfCompetitors) {

        rand = new RandomGenerator(seed);
        
        //subjects
        int randomNumOfSubjects = rand.random(numOfSubjects, 1);
        finalNumOfSubject = randomNumOfSubjects;
        activePhotoSubjects = new ArrayList<>();
        while (activePhotoSubjects.size() < randomNumOfSubjects) {
            int index = rand.random(subjectValues.length - 1, 0);
            String subject = subjectValues[index].toString();
            if (!activePhotoSubjects.contains(subject)) {
                activePhotoSubjects.add(subject);
            }
        }
    
        //categories
        int randomNumOfCategories = rand.random(categorieValues.length, 1);
        finalNumOfCategories = randomNumOfCategories;
        activeCategories = new ArrayList<>();
        listOfCamera = new HashMap<>();
        int ping = 1;
        
        while (activeCategories.size() < randomNumOfCategories) {
            int index = rand.random(categorieValues.length - 1, 0);
            String subject = categorieValues[index].toString();
            if (!activeCategories.contains(subject)) {
                activeCategories.add(subject);
                initCameras(subject);
            } else {
                if (ping == 2) {
                    String sub = categorieValues[index + 1].toString();
                    if (!activeCategories.contains(sub)) {
                        activeCategories.add(sub);
                        initCameras(sub);
                    }
                    ping = 1;
                }
                ping++;
            }
        }

        //competitors
        int randomNumOfCompetitors = rand.random(numOfCompetitors, 0);
        activeCompetitor = new ArrayList<>();

        for (int i = 1; i <= randomNumOfCompetitors; i++) {
            Competitor competitor = new Competitor("Competitor" + i);
            activeCompetitor.add(competitor);
        }


    }

    public static void registration(int numOfCompetitorSubject, int numOfCompetitorCategories) {
        listOfRegistrations = new HashMap<>();
        finalNumOfSubject = numOfCompetitorSubject >= finalNumOfSubject ? finalNumOfSubject : numOfCompetitorSubject;

        for (Competitor s : activeCompetitor) {
            int numOfSubject = rand.random(finalNumOfSubject, 1);
            ArrayList<String> subjects = new ArrayList<>();
            finalNumOfCategories = numOfCompetitorCategories >= finalNumOfCategories ? finalNumOfCategories : numOfCompetitorCategories;
            Photo photoData = new Photo();
            //subject
            while (subjects.size() < numOfSubject) {
                int subjectIndex = rand.random(activePhotoSubjects.size(), 0);
                String subjectName = activePhotoSubjects.get(subjectIndex);
                if (!subjects.contains(subjectName)) {
                    subjects.add(subjectName);
                    ArrayList<String> cat = new ArrayList<>();
                    HashMap<String, ArrayList<Registration>> categories = new HashMap<>();
                    int numOfCategories = rand.random(finalNumOfCategories, 1);
                    //categories
                    while (cat.size() < numOfCategories) {
                        ArrayList<Registration> registrations = new ArrayList<>();
                        int categorieIndex = rand.random(activeCategories.size(), 0);
                        String categoryName = activeCategories.get(categorieIndex);
                        if (!cat.contains(categoryName)) {
                            Registration registration = new Registration();
                            registration.setCompetitor(s);
                            registration.setCategorie(categoryName);
                            registration.setSubject(subjectName);
                            cat.add(categoryName);
                            //photo, camera
                            int apertureIndex = rand.random(photoData.getApertureRange().length - 1, 0);
                            int exposureIndex = rand.random(photoData.getExposureRange().length - 1, 0);
                            Photo photo = new Photo(photoData.getApertureRange()[apertureIndex], photoData.getExposureRange()[exposureIndex]);
                            registration.setPhoto(photo);
                            int cameraIndex = rand.random(listOfCamera.get(categoryName).size(), 0);
                            Camera camera = listOfCamera.get(categoryName).get(cameraIndex);
                            registration.setPhotoaparat(camera);

                            if (listOfRegistrations.get(subjectName) == null) {
                                registrations.add(registration);
                                categories.put(categoryName, registrations);
                                listOfRegistrations.put(subjectName, categories);
                            } else {
                                if (listOfRegistrations.get(subjectName).get(categoryName) == null) {
                                    registrations.add(registration);
                                    listOfRegistrations.get(subjectName).put(categoryName, registrations);
                                } else {
                                    listOfRegistrations.get(subjectName).get(categoryName).add(registration);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static void scoring(int numOfJury, String className) {
        int qualifiedRang = 2;
        for (Map.Entry<String, HashMap<String, ArrayList<Registration>>> subject : listOfRegistrations.entrySet()) {
            for (Map.Entry<String, ArrayList<Registration>> categorie : subject.getValue().entrySet()) {
                int index = 0;
                for (Registration registration : categorie.getValue()) {
                    registration.setSubject(subject.getKey());
                    registration.setCategorie(categorie.getKey());
                    int correctScore = rand.random(21, 0);
                    if (correctScore < qualifiedRang) {
                        registration.setCorrectScore(correctScore);
                        registration.setDisqualified(true);
                        registration.setScore(0);
                    } else {
                        registration.setCorrectScore(correctScore);
                        registration.setDisqualified(false);
                        ArrayList<Integer> markList = new ArrayList<>();
                        for (int i = 0; i < numOfJury; i++) {
                            int mark = rand.random(10, 0);
                            markList.add(mark);
                        }
                        registration.setMarks(markList);
                        Scoring score = ScoringFactory.initScoring(className);
                        registration.setScore(score.getScore(new ArrayList<>(markList))); //minMaxIgnore
                    }
                    listOfRegistrations.get(subject.getKey()).get(categorie.getKey()).set(index, registration);
                    index++;
                }
            }
        }
    }

    public static void results(String filename) {
        HashMap<String, ArrayList<Registration>> categorieScoreSheet = new HashMap<>();
        ArrayList<Registration> overallWinners = new ArrayList<>();
       
        System.out.println("---Proglašenje pobjednika po temama unutar kategorija:");
        for (Map.Entry<String, HashMap<String, ArrayList<Registration>>> subject : listOfRegistrations.entrySet()) {            
            System.out.println("\nTema: " + subject.getKey());
            
            for (Map.Entry<String, ArrayList<Registration>> categorie : subject.getValue().entrySet()) {
                ArrayList<Registration> topRegistrations = new ArrayList<>();
                System.out.println("\nKategorija: " + categorie.getKey());
                System.out.println("\tNatjecatelj\tBroj bodova");
                categorie.getValue().sort(Comparator.comparing(Registration::getScore).reversed());               
                List<Registration> regs=categorie.getValue().size()>3 ? categorie.getValue().subList(0, 3) : categorie.getValue();
                
                for (Registration registration : regs) {
                    if (!registration.isDisqualified())
                        System.out.println("\t" + registration.getCompetitor().getName() + "\t" + registration.getScore());

                    if (categorieScoreSheet.get(categorie.getKey()) == null) {
                        topRegistrations.add(registration);
                        categorieScoreSheet.put(categorie.getKey(), topRegistrations);
                    } else 
                        categorieScoreSheet.get(categorie.getKey()).add(registration);
                }
            }
        }
     
        System.out.println("\n---Ukupni pobjednici po kategorijama:");
        for (Map.Entry<String, ArrayList<Registration>> categorie : categorieScoreSheet.entrySet()) {
            categorie.getValue().sort(Comparator.comparing(Registration::getScore).reversed());
            System.out.println("\nKategorija: " + categorie.getKey());            
            List<Registration> cate=categorie.getValue().size()>3 ? categorie.getValue().subList(0, 3) : categorie.getValue();
            for (Registration reg : cate) {
                overallWinners.add(reg);
                System.out.println("\t" + reg.getCompetitor().getName() + "\t" + reg.getScore());
            }
        }
        
        System.out.println("\n---Ukupni pobjednici:");
        overallWinners.sort(Comparator.comparing(Registration::getScore).reversed());
        for (Registration reg : overallWinners.subList(0, 3)) {
            System.out.println("\t" + reg.getCompetitor().getName() + "\t" + reg.getScore());
        }
               
        resultsToFile(filename);
    }
    
    
    public static void resultsToFile(String filename) {
        HashMap<String, ArrayList<Registration>> categorieScoreSheet = new HashMap<>();
        ArrayList<Registration> allRegistrations=new ArrayList<>();
              
        for (Map.Entry<String, HashMap<String, ArrayList<Registration>>> subject : listOfRegistrations.entrySet()) {            
            String results="";
            String unqualifiedResults="";
            results+="\nTema:\n" + subject.getKey();
            results+="\tNatjecatelj\tKategorija\tOcjene sudaca\tKonacna ocjena";
            
            for (Map.Entry<String, ArrayList<Registration>> categorie : subject.getValue().entrySet()) {
                ArrayList<Registration> topRegistrations = new ArrayList<>();
                categorie.getValue().sort(Comparator.comparing(Registration::getScore).reversed());
                
                for (Registration registration : categorie.getValue()) {
                    allRegistrations.add(registration);
                    if (!registration.isDisqualified()) 
                        results+="\n\t"+registration.getCompetitor().getName()+"\t"+categorie.getKey()+"\t"+registration.getMarks().toString()+"\t"+registration.getScore();
                    else
                        unqualifiedResults+="\n\t"+ registration.getCompetitor().getName() + "\t" + categorie.getKey();
                    
                    if (categorieScoreSheet.get(categorie.getKey()) == null) {
                        topRegistrations.add(registration);
                        categorieScoreSheet.put(categorie.getKey(), topRegistrations);
                    } else 
                        categorieScoreSheet.get(categorie.getKey()).add(registration);
                }
            }            
            results+="\n\tDiskvalificirane prijave:\n";
            Writer.writeResultsToFile(filename, results);
            Writer.writeResultsToFile(filename, unqualifiedResults);
        }

        
        Map<Competitor,Map<String,List<Registration>>> registrationByCompetitor=allRegistrations.stream()
                .collect(Collectors.groupingBy(Registration::getCompetitor,Collectors.groupingBy(Registration::getCategorie)));

        String otherResults="\n-------";
        for (Map.Entry<Competitor,Map<String,List<Registration>>> competitor : registrationByCompetitor.entrySet()) {
            otherResults+="\n"+competitor.getKey().getName();
            System.out.println("\n"+competitor.getKey().getName());
            
            int allScores=0;
            for (Map.Entry<String,List<Registration>> categorie : competitor.getValue().entrySet()) {
                int scoreInCategorie=0;
                otherResults+="\n\t"+categorie.getKey();
                System.out.print("\n\t"+categorie.getKey());                
                for (Registration registration : categorie.getValue()) {
                    allScores+=registration.getScore();
                    scoreInCategorie+=registration.getScore();
                    otherResults+="\t"+registration.getSubject()+"\t"+registration.getScore();
                    System.out.print("\t"+registration.getSubject()+"\t"+registration.getScore());
                }
                otherResults+="\tZbroj:"+scoreInCategorie+"\n";
                System.out.println("\tZbroj:"+scoreInCategorie+"\n");
            }
            otherResults+="\tUkupno:"+allScores+"\n";
            System.out.println("\tUkupno:"+allScores+"\n");
        }
        otherResults+="Ovo oznacava kraj ispisa natjecaja! (U slucaju da nije bila obrisana datoteka)";
        otherResults+="\n==============================================================================";
        Writer.writeResultsToFile(filename, otherResults);
               
    }
    
    public static void initCameras(String subject) {
        Categories categorie = new Categories();
        if (subject.equals("DSLR")) {
            listOfCamera.put("DSLR", categorie.initDslr());
        }

        if (subject.equals("KOMPAKTNI")) {
            listOfCamera.put("KOMPAKTNI", categorie.initCompact());
        }

        if (subject.equals("BEZZRCALNI")) {
            listOfCamera.put("BEZZRCALNI", categorie.initMirrorless());
        }
    }

}
