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
public interface Camera {  
    public void setNaziv(String naziv);
    public String getNaziv();
    public void setObjektiv(String objektiv);
    public String getObjektiv();
    public String getFaktorPovecanja();
    public void setFaktorPovecanja(String faktorPovecanja);
    public String getIntegriraniRukohvat();
    public void setIntegriraniRukohvat(String integriraniRukohvat);
    public String getIntegriraniBlic();
    public void setIntegriraniBlic(String integriraniBlic);
    public String getStabilizacijaSlike();
    public void setStabilizacijaSlike(String stabilizacijaSlike);
    public String getDodatniRukohvat();
    public void setDodatniRukohvat(String dodatniRukohvat);
    public String getOkular();
    public void setOkular(String okular);
}
