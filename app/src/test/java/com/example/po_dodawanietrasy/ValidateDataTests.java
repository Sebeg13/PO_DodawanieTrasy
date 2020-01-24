package com.example.po_dodawanietrasy;


import com.example.po_dodawanietrasy.presenter.DodawanieTrasyPresenter;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Klasa ValidateDataTests wykonuje testy jednostkowe dla metody validateData z klasy DodawanieTrasyPresenter.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ValidateDataTests {

    private String distance1 = "1234";
    private String distance3 = "123c";
    private String distance4 = "tysiac";

    private String sumOfDifferences1 = "100";
    private String sumOfDifferences3 = "100a";
    private String sumOfDifferences4 = "sto";

    /**
     * Test jednostkowy dla przypadku z obiema danymi poprawnymi.
     */
    @Test
    public void validateCorrectBothValues(){
        assertTrue(DodawanieTrasyPresenter.validateData(distance1,sumOfDifferences1));

        String distance2 = "0";
        String sumOfDifferences2 = "0";
        assertTrue(DodawanieTrasyPresenter.validateData(distance2, sumOfDifferences2));
    }

    /**
     * Test jednostkowy dla przypadku z jedną daną poprawną, a drugą niepoprawną. Dane są niepoprawne na różne sposoby.
     */
    @Test
    public void validateCorrectOneValue(){
        assertFalse(DodawanieTrasyPresenter.validateData(distance3,sumOfDifferences1));
        assertFalse(DodawanieTrasyPresenter.validateData(distance1,sumOfDifferences3));
        assertFalse(DodawanieTrasyPresenter.validateData(distance1,sumOfDifferences4));
        assertFalse(DodawanieTrasyPresenter.validateData(distance4,sumOfDifferences1));
    }

    /**
     * Test jednostkowy dla przypadku z obiema danymi niepoprawnymi. Dane są niepoprawne na różne sposoby.
     */
    @Test
    public void validateIncorrectValues(){
        assertFalse(DodawanieTrasyPresenter.validateData(distance3,sumOfDifferences3));
        assertFalse(DodawanieTrasyPresenter.validateData(distance4,sumOfDifferences4));

        String distance5 = "c123";
        String sumOfDifferences5 = "a100";
        assertFalse(DodawanieTrasyPresenter.validateData(distance5, sumOfDifferences5));

        String distance6 = "12c3";
        String sumOfDifferences6 = "1a00";
        assertFalse(DodawanieTrasyPresenter.validateData(distance6, sumOfDifferences6));
    }
}
