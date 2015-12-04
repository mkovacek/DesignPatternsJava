/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_2.validator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Matija
 */
public class FileValidator {
    
    private ArrayList<String> listOfIds;
    private boolean rootElement=false;
    private final String sintaksa = "^(0|1)[\\t](\\d{5})[\\t](\\d{5})[\\t]([0-9]{1,4}(,[0-9]{1,4}){2,})[\\t](#[A-Fa-f0-9]{6})$";

    public FileValidator() {
        listOfIds=new ArrayList<>();
    }
  
    public Matcher checkSyntax(String record) {
        Pattern pattern = Pattern.compile(sintaksa);
        Matcher m = pattern.matcher(record);
        if (m.matches()) {              
            if(listOfIds.isEmpty()){
                listOfIds.add(m.group(2));
                System.out.println("\t => OK");
                if(m.group(2).equals(m.group(3))) rootElement=true;
            }else{
                if (listOfIds.contains(m.group(2))){ 
                    System.out.println("\t => Šifra nije jedinstvena!");
                    return null;
                }else if (!rootElement){
                    if(m.group(2).equals(m.group(3))) rootElement=true; 
                }else if(rootElement && m.group(2).equals(m.group(3))) {
                    System.out.println("\t => Samo jedan root elemenat mora postojati!");
                    return null;
                }else if(!listOfIds.contains(m.group(3))){
                    System.out.println("\t => Ne postoji roditelj s tom šifrom!"); 
                    return null;
                }else if(m.group(4).split(",").length>4 && m.group(4).split(",").length%2!=0){
                    System.out.println("\t => Kod poliedra mora biti paran broj kordinata"); 
                    return null;
                }else{
                    listOfIds.add(m.group(2));
                    System.out.println("\t => OK");    
                }              
            }
            
            return m;          
        } else {
            System.out.println("\t => Ne odgovara sintaksa zapisa!");
            return null;
        }
    }
    
}
