/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.camera;

/**
 *
 * @author Matija
 */
public class Compact implements Camera{
    private String naziv;
    private String objektiv;
    private String okular;

    public Compact() {
    }

    @Override
    public String getNaziv() { return naziv; }

    @Override
    public void setNaziv(String naziv) {this.naziv = naziv;}

    @Override
    public String getObjektiv() {return objektiv;}

    @Override
    public void setObjektiv(String objektiv) {this.objektiv = objektiv;}
    
    @Override
    public String getOkular() { return okular;}

    @Override
    public void setOkular(String okular) { this.okular = okular; }

    @Override
    public String getFaktorPovecanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFaktorPovecanja(String faktorPovecanja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIntegriraniRukohvat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIntegriraniRukohvat(String integriraniRukohvat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIntegriraniBlic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIntegriraniBlic(String integriraniBlic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStabilizacijaSlike() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStabilizacijaSlike(String stabilizacijaSlike) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDodatniRukohvat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDodatniRukohvat(String dodatniRukohvat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
