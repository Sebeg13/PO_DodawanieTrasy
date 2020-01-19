package com.example.po_dodawanietrasy.view;

public interface DodawanieTrasyView {
    public void dodajTrase();
    public String getPunktA();
    public String getPunktB();
    public String getOdleglosc();
    public String getSumaRoznic();
    public void  displayDodanoTrase();
    public void displayBrakDostepuDoBazy();
    public void displayNiepoprawneDane();

}
