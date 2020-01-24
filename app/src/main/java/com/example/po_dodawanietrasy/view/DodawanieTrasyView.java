package com.example.po_dodawanietrasy.view;

public interface DodawanieTrasyView {
    /**
     * Metoda getPointA pobiera tekst z konstrolki Textview dotyczącej punktu A i go zwraca.
     * @return tekst pobrany z kontrolki
     */
    public String getPointA();
    /**
     * Metoda getPointB pobiera tekst z konstrolki Textview dotyczącej Bpunktu  i go zwraca.
     * @return tekst pobrany z kontrolki
     */
    public String getPointB();
    /**
     * Metoda getDistance pobiera tekst z konstrolki Textview dotyczącej odległości i go zwraca.
     * @return tekst pobrany z kontrolki
     */
    public String getDistance();

    /**
     * Metoda getSumOfDifferences pobiera tekst z konstrolki Textview dotyczącej sumy roznic poziomow i go zwraca.
     * @return tekst pobrany z kontrolki
     */
    public String getSumOfDifferences();

    /**
     * Metoda showPopup wyświetla na ekranie podaną wiadomość.
     * @param message wiadomośc do wyświetlenia
     */
    public void showPopup(String message);

}
