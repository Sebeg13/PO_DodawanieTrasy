package com.example.po_dodawanietrasy.presenter;

import android.content.Context;

import com.example.po_dodawanietrasy.model.DodawanieTrasyManager;
import com.example.po_dodawanietrasy.view.DodawanieTrasyView;


/**
 *  Klasa DodanieTrasyPresenter reprezentuję warstwę prezentacji we wzorcu MVP.
 */
public class DodawanieTrasyPresenter {
    DodawanieTrasyManager model;
    DodawanieTrasyView view;

    /**
     * Kontruktor klasy DodawanieTrasyPresenter.
     * @param view referencja do obiektu widoku
     * @param context referencja do kontekstu aplikacji
     */
    public DodawanieTrasyPresenter(DodawanieTrasyView view, Context context) {
        this.view = view;
        model = new DodawanieTrasyManager(this, context);
    }


    /**
     * Metoda updateDataToDataBase rozpoczyna, poprzez model, aktualizowanie danych nowej trasy do bazy danych
     */
    public void updateDataToDataBase() {
        String pointA = view.getPointA();
        String pointB = view.getPointB();
        String distanceStr = view.getDistance();
        String sumOfDifferencesStr = view.getSumOfDifferences();

        if (validateData(distanceStr, sumOfDifferencesStr)) {
            double distance = Double.valueOf(distanceStr);
            double sumOfDifferences = Double.valueOf(sumOfDifferencesStr);

            model.updateData(pointA, pointB, distance, sumOfDifferences, countPointsForTrip(distance,sumOfDifferences));
        }
    }

    /**
     * Metoda displayMessage przekazuje widokowi wiadomość, którą ma wyświetlić.
     * @param message wiadomość do wyświetlenia
     */
    public void displayMessage(String message) {
        view.showPopup(message);
    }

    /**
     * Metoda validateDate sprawdza czy odległość i suma różnic, podane jakos ciąg znaków, są wartościami liczbowymi
     * @param distance odległość
     * @param sumOfDifferences suma różnic poziomów
     * @return wartość boolowska informująca o tym, czy odległość i suma różnić są wartościami liczbowymi
     */
    public static boolean validateData(String distance, String sumOfDifferences) {
        return distance.matches("^[+]?\\d+([.]\\d+)?$") && sumOfDifferences.matches("^[+]?\\d+([.]\\d+)?$");
    }

    public int countPointsForTrip(double distance, double sumOfDifferences){
        int points = 0;
        double pointsForDist = distance/1000;
        points += pointsForDist;
        points +=  (pointsForDist % 1) > 0.5 ? 1 : 0;

        double pointsForSumOfDiff = sumOfDifferences / 100;
        points += pointsForSumOfDiff;
        points += (pointsForSumOfDiff % 1) > 0.5 ? 1 : 0;

        return points;
    }

}
