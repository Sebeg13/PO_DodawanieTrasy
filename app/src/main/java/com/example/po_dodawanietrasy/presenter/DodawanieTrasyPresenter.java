package com.example.po_dodawanietrasy.presenter;

import com.example.po_dodawanietrasy.model.DodawanieTrasyManager;
import com.example.po_dodawanietrasy.view.DodawanieTrasyView;

public class DodawanieTrasyPresenter {
    DodawanieTrasyManager model;
    DodawanieTrasyView view;

    public DodawanieTrasyPresenter(DodawanieTrasyView view){
        this.view = view;
        model = new DodawanieTrasyManager();
    }

    public void updateDataToDataBase(){
        String punktA = view.getPunktA();
        String punktB = view.getPunktB();
        String odlegloscStr = view.getOdleglosc();
        String sumaRoznicStr = view.getSumaRoznic();

        if (validateData(odlegloscStr, sumaRoznicStr)){
            double odleglosc = Double.valueOf(odlegloscStr);
            double sumaRoznic = Double.valueOf(sumaRoznicStr);

            if(model.updateData(punktA, punktB, odleglosc, sumaRoznic))
                view.displayDodanoTrase();
            else
                view.displayBrakDostepuDoBazy();
        }else{
            view.displayNiepoprawneDane();
        }

    }

    private boolean validateData(String odleglosc, String sumaRoznic) {
        return odleglosc.matches("^[+]?\\d+([.]\\d+)?$") && sumaRoznic.matches("^[+]?\\d+([.]\\d+)?$");
    }

}
