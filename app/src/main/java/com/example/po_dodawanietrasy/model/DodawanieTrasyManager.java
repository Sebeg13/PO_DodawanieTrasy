package com.example.po_dodawanietrasy.model;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.po_dodawanietrasy.model.Wycieczki.PunktPosredni;
import com.example.po_dodawanietrasy.model.Wycieczki.Trasa;
import com.example.po_dodawanietrasy.presenter.DodawanieTrasyPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasa DodawanieTrasyManager reprezentuję warstwę modelu we wzorcu MVP. Jest odpowiedzialna za komunikację z bazą danych.
 */
public class DodawanieTrasyManager {

    private Context context;
    private final String URL_ROUTES = "http://192.168.0.103/po/dodajtrase.php";
    private DodawanieTrasyPresenter presenter;

    /**
     * Konstruktor klasy DodawanieTrasyManager.
     * @param presenter referencja do obiektu presentera
     * @param context referencja do kontekstu aplikacji
     */
    public DodawanieTrasyManager(DodawanieTrasyPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    /**
     * Klasa updateData aktualizuje danę nowej trasy do bazy danych.
     * @param pointA nazwa punktu A
     * @param pointB nazwa Punkty B
     * @param distance odległość między punktami
     * @param sumOfDifferences suma różnic poziomów między punktami
     */
    public void updateData(final String pointA, final String pointB, final double distance, final double sumOfDifferences) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_ROUTES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")) {
                                presenter.displayMessage("Dodano trasę do bazy danych");
                            } else {
                                presenter.displayMessage("Dodawanie trasy nie powiodło się!");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            presenter.displayMessage("Dodawanie trasy nie powiodło się!");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        presenter.displayMessage("Brak dostępu do bazy danych");
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nazwaP1", pointA);
                params.put("wysokoscP1", "0");
                params.put("nazwaP2", pointB);
                params.put("wysokoscP2", "0");
                params.put("odleglosc", String.valueOf(distance));
                params.put("sumaroznic", String.valueOf(sumOfDifferences));
                params.put("nazwaT", "Trasa1");
                params.put("idLG", "3");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
