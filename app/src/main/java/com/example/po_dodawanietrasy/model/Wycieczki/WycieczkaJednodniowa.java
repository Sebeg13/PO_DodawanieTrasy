package com.example.po_dodawanietrasy.model.Wycieczki;

import androidx.annotation.NonNull;


import com.example.po_dodawanietrasy.model.Odznaki.GOT;
import com.example.po_dodawanietrasy.model.Uzytkownicy.Uzytkownik;

import java.util.ArrayList;
import java.util.Date;

public class WycieczkaJednodniowa {
    private int id;
    private String nazwa;
    private Date dataWycieczki;
    private boolean zatwierdzona;
    private boolean odbyta;
    private ArrayList<TrasaWycieczkiJednodniowej> trasy;
    private GOT got;
    private Uzytkownik zdobywajacy;
    private Uzytkownik przodownik;

    private int liczbaPunktow = 0;


    public WycieczkaJednodniowa(int id, String nazwa, Date dataWycieczki, boolean zatwierdzona, boolean odbyta, ArrayList<TrasaWycieczkiJednodniowej> trasy, GOT got, Uzytkownik zdobywajacy, Uzytkownik przodownik) {
        this.id = id;
        this.nazwa = nazwa;
        this.dataWycieczki = dataWycieczki;
        this.zatwierdzona = zatwierdzona;
        this.odbyta = odbyta;
        this.trasy = trasy;
        this.got = got;
        this.zdobywajacy = zdobywajacy;
        this.przodownik = przodownik;
        updatePoints();
    }

    public void updatePoints() {
        for (TrasaWycieczkiJednodniowej trasa : trasy) {
            liczbaPunktow += trasa.getTrasa().getPunkty();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<TrasaWycieczkiJednodniowej> getTrasy() {
        return trasy;
    }

    public void setTrasy(ArrayList<TrasaWycieczkiJednodniowej> trasy) {
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

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getDataWycieczki() {
        return dataWycieczki;
    }

    public void setDataWycieczki(Date dataWycieczki) {
        this.dataWycieczki = dataWycieczki;
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

    public int getLiczbaPunktow() {
        return liczbaPunktow;
    }

    @NonNull
    @Override
    public String toString() {
        return "  " + nazwa + "                " + liczbaPunktow;
    }
}
