package com.example.po_dodawanietrasy.model.Wycieczki;


public class TrasaWycieczkiJednodniowej {

    private int id;
    private Trasa trasa;

    public TrasaWycieczkiJednodniowej(int id, Trasa trasa) {
        this.id = id;
        this.trasa = trasa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Trasa getTrasa() {
        return trasa;
    }

    public void setTrasa(Trasa trasa) {
        this.trasa = trasa;
    }
}
