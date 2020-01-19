package com.example.po_dodawanietrasy.model;

import com.example.po_dodawanietrasy.model.Wycieczki.PunktPosredni;
import com.example.po_dodawanietrasy.model.Wycieczki.Trasa;

public class DodawanieTrasyManager {

    public boolean updateData(String punktA, String punktB, double odleglosc, double sumaRoznic){
        //update to database;

        PunktPosredni punktAObj = new PunktPosredni(1, punktA, 0);
        PunktPosredni punktBObj = new PunktPosredni(2,punktB,0);
        Trasa trasa = new Trasa(1, "Nazwa", odleglosc, sumaRoznic, punktAObj, punktBObj, null,null,0);

        return true;
    }

}
