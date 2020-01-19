package com.example.po_dodawanietrasy.model.Wycieczki;

public class PunktPosredni {
    private int id;
    private String nazwa;
    private double wysokoscNPM;

    public PunktPosredni(int id, String nazwa, double wysokoscNPM) {
        this.id = id;
        this.nazwa = nazwa;
        this.wysokoscNPM = wysokoscNPM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getWysokoscNPM() {
        return wysokoscNPM;
    }

    public void setWysokoscNPM(double wysokoscNPM) {
        this.wysokoscNPM = wysokoscNPM;
    }
}
