/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.uzdiz.mkovacek.zadaca_1.categories;

import java.util.ArrayList;
import org.foi.uzdiz.mkovacek.zadaca_1.camera.Mirrorless;
import org.foi.uzdiz.mkovacek.zadaca_1.camera.Camera;
import org.foi.uzdiz.mkovacek.zadaca_1.camera.Dslr;
import org.foi.uzdiz.mkovacek.zadaca_1.camera.Compact;

/**
 *
 * @author Matija
 */
public class Categories {

    public enum Types { DSLR, BEZZRCALNI, KOMPAKTNI };

    public Categories() {
    }

    public ArrayList<Camera> initDslr() {
        ArrayList<Camera> cameraList = new ArrayList<>();
        Camera camera = new Dslr();
        camera.setNaziv("Canon EOS 600D");
        camera.setObjektiv("Canon EF-S 18-55mm f/3.5-5.6 IS STM");
        camera.setFaktorPovecanja("0,36x");
        camera.setIntegriraniRukohvat("Ne");
        camera.setStabilizacijaSlike("Ne");
        cameraList.add(camera);
        
        Camera camera2 = new Dslr();
        camera2.setNaziv("Nikon D5200");
        camera2.setObjektiv("AF-S DX NIKKOR 18-55mm f/3.5-5.6G VR");
        camera2.setFaktorPovecanja("0.31x");
        camera2.setIntegriraniRukohvat("Da");
        camera2.setStabilizacijaSlike("Ne");
        cameraList.add(camera2);
        
        Camera camera3 = new Dslr();
        camera3.setNaziv("Olympus OM-D E-M5");
        camera3.setObjektiv("M.ZUIKO DIGITAL ED 14‑150mm 1:4.0‑5.6 II");
        camera3.setFaktorPovecanja("10.7x");
        camera3.setIntegriraniRukohvat("Ne");
        camera3.setStabilizacijaSlike("Da");
        cameraList.add(camera3);
                
        return cameraList;
    }

    public ArrayList<Camera> initMirrorless() {
        ArrayList<Camera> cameraList = new ArrayList<>();
        Camera camera = new Mirrorless();
        camera.setNaziv("Olympus PEN E-PL6");
        camera.setObjektiv("M.ZUIKO DIGITAL 17mm F1.8");
        camera.setFaktorPovecanja("0.16x");
        camera.setDodatniRukohvat("Ne");
        cameraList.add(camera);
        
        Camera camera2 = new Mirrorless();
        camera2.setNaziv("Sony A6000");
        camera2.setObjektiv("Vario-Tessar T* E 16-70 mm F4 ZA OSS");
        camera2.setFaktorPovecanja("4x");
        camera2.setDodatniRukohvat("Da");
        cameraList.add(camera2);
        
        Camera camera3 = new Mirrorless();
        camera3.setNaziv("Fuji X-M1");
        camera3.setObjektiv("FUJINON XC16-50mmF3.5-5.6 OIS");
        camera3.setFaktorPovecanja("3.1x");
        camera3.setDodatniRukohvat("Ne");
        cameraList.add(camera3);
        
        return cameraList;
    }

    public ArrayList<Camera> initCompact() {
        ArrayList<Camera> cameraList = new ArrayList<>();
        Camera camera = new Compact();
        camera.setNaziv("Panasonic LX100");
        camera.setObjektiv("LEICA DC VARIO-SUMMILUX F1.7-2.8 24-75mm");
        camera.setOkular("Da");
        cameraList.add(camera);
        
        Camera camera2 = new Compact();
        camera2.setNaziv("Canon PowerShot S120");
        camera2.setObjektiv("F1.8 24-120mm");
        camera2.setOkular("Ne");
        cameraList.add(camera2);
        
        Camera aparat3 = new Compact();
        aparat3.setNaziv("Sony Cyber-shot RX100 III");
        aparat3.setObjektiv("Zeiss F1.8-2.8 24-70mm");
        aparat3.setOkular("Ne");
        cameraList.add(aparat3);
        
        return cameraList;
    }
}
