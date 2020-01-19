package com.example.po_dodawanietrasy.model.Odznaki;



import com.example.po_dodawanietrasy.model.Uzytkownicy.Uzytkownik;

import java.util.Date;

public class GOT {
    private int id;
    private Date dataZdobycia;
    private int punktyZdobyte;
    private TypGOT typGOT;
    private Uzytkownik idZdobywajacego;
    private Uzytkownik idPrzodownika;

    public GOT(int id, int punktyZdobyte, TypGOT typGOT, Uzytkownik idZdobywajacego) {
        this.id = id;
        this.punktyZdobyte = punktyZdobyte;
        this.typGOT = typGOT;
        this.idZdobywajacego = idZdobywajacego;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataZdobycia() {
        return dataZdobycia;
    }

    public void setDataZdobycia(Date dataZdobycia) {
        this.dataZdobycia = dataZdobycia;
    }

    public int getPunktyZdobyte() {
        return punktyZdobyte;
    }

    public void setPunktyZdobyte(int punktyZdobyte) {
        this.punktyZdobyte = punktyZdobyte;
    }

    public TypGOT getTypGOT() {
        return typGOT;
    }

    public void setTypGOT(TypGOT typGOT) {
        this.typGOT = typGOT;
    }

    public Uzytkownik getIdZdobywajacego() {
        return idZdobywajacego;
    }

    public void setIdZdobywajacego(Uzytkownik idZdobywajacego) {
        this.idZdobywajacego = idZdobywajacego;
    }

    public Uzytkownik getIdPrzodownika() {
        return idPrzodownika;
    }

    public void setIdPrzodownika(Uzytkownik idPrzodownika) {
        this.idPrzodownika = idPrzodownika;
    }
}
