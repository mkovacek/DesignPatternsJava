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
public class Dslr implements Camera{
    private String naziv;
    private String objektiv;
    private String faktorPovecanja;
    private String integriraniRukohvat;
    private String integriraniBlic;
    private String stabilizacijaSlike;

    public Dslr() {
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
    public String getFaktorPovecanja() { return faktorPovecanja;}

    @Override
    public void setFaktorPovecanja(String faktorPovecanja) { this.faktorPovecanja = faktorPovecanja;}

    @Override
    public String getIntegriraniRukohvat() { return integriraniRukohvat;}

    @Override
    public void setIntegriraniRukohvat(String integriraniRukohvat) { this.integriraniRukohvat = integriraniRukohvat; }

    @Override
    public String getIntegriraniBlic() { return integriraniBlic; }

    @Override
    public void setIntegriraniBlic(String integriraniBlic) { this.integriraniBlic = integriraniBlic; }

    @Override
    public String getStabilizacijaSlike() { return stabilizacijaSlike; }

    @Override
    public void setStabilizacijaSlike(String stabilizacijaSlike) {this.stabilizacijaSlike = stabilizacijaSlike;}

    @Override
    public String getDodatniRukohvat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDodatniRukohvat(String dodatniRukohvat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOkular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOkular(String okular) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}
