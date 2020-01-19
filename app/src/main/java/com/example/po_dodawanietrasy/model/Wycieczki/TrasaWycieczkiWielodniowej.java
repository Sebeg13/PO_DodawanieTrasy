package com.example.po_dodawanietrasy.model.Wycieczki;

import java.util.Date;

public class TrasaWycieczkiWielodniowej {

    private int id;
    private Trasa trasa;
    private Date dataTWJ;

    public Date getDataTWJ() {
        return dataTWJ;
    }

    public void setDataTWJ(Date dataTWJ) {
        this.dataTWJ = dataTWJ;
    }

    public Trasa getTrasa() {
        return trasa;
    }

    public void setTrasa(Trasa trasa) {
        this.trasa = trasa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
