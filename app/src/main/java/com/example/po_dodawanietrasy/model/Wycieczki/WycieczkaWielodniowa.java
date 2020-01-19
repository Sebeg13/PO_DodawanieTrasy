package com.example.po_dodawanietrasy.model.Wycieczki;


import com.example.po_dodawanietrasy.model.Obszary.GrupaGorska;
import com.example.po_dodawanietrasy.model.Odznaki.GOT;
import com.example.po_dodawanietrasy.model.Uzytkownicy.Uzytkownik;

import java.util.ArrayList;
import java.util.Date;

public class WycieczkaWielodniowa {
    private int id;
    private String nazwa;
    private ArrayList<Date> dataWycieczki;
    private GrupaGorska grupaGorska;
    private boolean zatwierdzona;
    private boolean odbyta;
    private ArrayList<TrasaWycieczkiWielodniowej> trasy;
    private GOT got;
    private Uzytkownik zdobywajacy;
    private Uzytkownik przodownik;

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

    public ArrayList<Date> getDataWycieczki() {
        return dataWycieczki;
    }

    public void setDataWycieczki(ArrayList<Date> dataWycieczki) {
        this.dataWycieczki = dataWycieczki;
    }

    public GrupaGorska getGrupaGorska() {
        return grupaGorska;
    }

    public void setGrupaGorska(GrupaGorska grupaGorska) {
        this.grupaGorska = grupaGorska;
    }

    public boolean isZatwierdzona() {
        return zatwierdzona;
    }

    public void setZatwierdzona(boolean zatwierdzona) {
        this.zatwierdzona = zatwierdzona;
    }

    public boolean isOdbyta() {
        return odbyta;
    }

    public void setOdbyta(boolean odbyta) {
        this.odbyta = odbyta;
    }

    public ArrayList<TrasaWycieczkiWielodniowej> getTrasy() {
        return trasy;
    }

    public void setTrasy(ArrayList<TrasaWycieczkiWielodniowej> trasy) {
        this.trasy = trasy;
    }

    public GOT getGot() {
        return got;
    }

    public void setGot(GOT got) {
        this.got = got;
    }

    public Uzytkownik getZdobywajacy() {
        return zdobywajacy;
    }

    public void setZdobywajacy(Uzytkownik zdobywajacy) {
        this.zdobywajacy = zdobywajacy;
    }

    public Uzytkownik getPrzodownik() {
        return przodownik;
    }

    public void setPrzodownik(Uzytkownik przodownik) {
        this.przodownik = przodownik;
    }
}
