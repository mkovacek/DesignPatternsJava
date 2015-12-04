/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.photo;

/**
 *
 * @author Matija
 */
public class Photo {
    private String[] apertureRange={"1.4","2.0","2.8","4","5.6","8","11","16","22"}; 
    private String aperture;
    private String[] exposureRange={"-4","-3","-2","-1","0","1","2","3",
                                       "4","5","6","7","8","9","10","11","12",
                                       "13","14","15","16" };
    private String exposure;
    
    public Photo() {}

    public Photo(String aperture, String exposure) {
        this.aperture = aperture;
        this.exposure = exposure;
    }
    
    public String getAperture() { return aperture; }

    public void setAperture(String aperture) { this.aperture = aperture; }

    public String getExposure() { return exposure; }

    public void setExposure(String exposure) { this.exposure = exposure; }

    public String[] getApertureRange() { return apertureRange; }

    public void setApertureRange(String[] apertureRange) { this.apertureRange = apertureRange; }

    public String[] getExposureRange() { return exposureRange; }

    public void setExposureRange(String[] exposureRange) { this.exposureRange = exposureRange; }
     
}
