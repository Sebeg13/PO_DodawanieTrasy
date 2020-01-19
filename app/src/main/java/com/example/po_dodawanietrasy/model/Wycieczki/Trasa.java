package com.example.po_dodawanietrasy.model.Wycieczki;

import androidx.annotation.NonNull;

import com.example.po_dodawanietrasy.model.Obszary.GrupaGorska;
import com.example.po_dodawanietrasy.model.Obszary.TerenGorski;


public class Trasa {
    private int id;
    private String nazwa;
    private double odleglosc;
    private double sumaRoznicPoziomow;
    private PunktPosredni punktA;
    private PunktPosredni punktB;
    private GrupaGorska grupaGorska;
    private TerenGorski terenGorski;
    private int punkty;

    public Trasa(int id, String nazwa, double odleglosc, double sumaRoznicPoziomow, PunktPosredni punktA, PunktPosredni punktB, GrupaGorska grupaGorska, TerenGorski terenGorski, int punkty) {
        this.id = id;
        this.nazwa = nazwa;
        this.odleglosc = odleglosc;
        this.sumaRoznicPoziomow = sumaRoznicPoziomow;
        this.punktA = punktA;
        this.punktB = punktB;
        this.grupaGorska = grupaGorska;
        this.terenGorski = terenGorski;
        this.punkty = punkty;
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

    public double getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(double odleglosc) {
        this.odleglosc = odleglosc;
    }

    public double getSumaRoznicPoziomow() {
        return sumaRoznicPoziomow;
    }

    public void setSumaRoznicPoziomow(double sumaRoznicPoziomow) {
        this.sumaRoznicPoziomow = sumaRoznicPoziomow;
    }

    public PunktPosredni getPunktA() {
        return punktA;
    }

    public void setPunktA(PunktPosredni punktA) {
        this.punktA = punktA;
    }

    public PunktPosredni getPunktB() {
        return punktB;
    }

    public void setPunktB(PunktPosredni punktB) {
        this.punktB = punktB;
    }

    public GrupaGorska getGrupaGorska() {
        return grupaGorska;
    }

    public void setGrupaGorska(GrupaGorska grupaGorska) {
        this.grupaGorska = grupaGorska;
    }

    public TerenGorski getTerenGorski() {
        return terenGorski;
    }

    public void setTerenGorski(TerenGorski terenGorski) {
        this.terenGorski = terenGorski;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }


    @NonNull
    @Override
    public String toString() {
        return "          " + nazwa + "                                                                " + punkty;
    }


}
