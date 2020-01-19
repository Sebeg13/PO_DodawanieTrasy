package com.example.po_dodawanietrasy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.po_dodawanietrasy.R;
import com.example.po_dodawanietrasy.presenter.DodawanieTrasyPresenter;
import com.example.po_dodawanietrasy.view.DodawanieTrasyView;

public class MainActivity extends AppCompatActivity implements DodawanieTrasyView {
    private DodawanieTrasyPresenter presenter;
    private EditText punktAEditText;
    private EditText punktBEditText;
    private EditText odlegloscEditText;
    private EditText sumaRoznicEditText;
    private Button dodajButton;

    private TextWatcher textWatcher;

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new DodawanieTrasyPresenter(this);

        punktAEditText = findViewById(R.id.punktAEditText);
        punktBEditText = findViewById(R.id.punktBEditText);
        odlegloscEditText = findViewById(R.id.odlegloscEditText);
        sumaRoznicEditText = findViewById(R.id.sumaRoznicEditText);
        dodajButton = findViewById(R.id.dodajButton);

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkFieldForEmptyValues();
            }
        };

        punktAEditText.addTextChangedListener(textWatcher);
        punktBEditText.addTextChangedListener(textWatcher);
        odlegloscEditText.addTextChangedListener(textWatcher);
        sumaRoznicEditText.addTextChangedListener(textWatcher);

        dodajButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dodajTrase();
            }
        });
    }

    @Override
    public void dodajTrase() {
        presenter.updateDataToDataBase();
    }

    @Override
    public String getPunktA() {
        return punktAEditText.getText().toString();
    }

    @Override
    public String getPunktB() {
        return punktBEditText.getText().toString();
    }

    @Override
    public String getOdleglosc() {
        return odlegloscEditText.getText().toString();
    }

    @Override
    public String getSumaRoznic() {
        return sumaRoznicEditText.getText().toString();
    }

    @Override
    public void displayDodanoTrase() {
        showPopup("Dodano trasę");

//        Toast.makeText(getApplicationContext(),"Dodano trasę", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayBrakDostepuDoBazy() {
        showPopup("Brak dostępu do bazy danych");
//        Toast.makeText(getApplicationContext(),"Brak dostępu do bazy danych", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayNiepoprawneDane() {
        showPopup("Niepoprawne dane");
//        Toast.makeText(getApplicationContext(),"Niepoprawne dane", Toast.LENGTH_SHORT).show();
    }


    public void checkFieldForEmptyValues(){
        String s1, s2, s3, s4;
        s1 = odlegloscEditText.getText().toString();
        s2 = sumaRoznicEditText.getText().toString();
        s3 = punktAEditText.getText().toString();
        s4 = punktBEditText.getText().toString();

        if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals(""))
            dodajButton.setEnabled(false);
        else
            dodajButton.setEnabled(true);

    }

    private void showPopup(String message){
        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context. LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_window,null);

        popupWindow = new PopupWindow(this);
        popupWindow.setContentView(layout);
        popupWindow.setWidth(800);
        popupWindow.setHeight(600);
        popupWindow.setFocusable(true);


        // prevent clickable background
        popupWindow.setBackgroundDrawable(null);

        popupWindow.showAtLocation(layout, Gravity.CENTER, 1, 1);

        TextView txtMessage = (TextView) layout.findViewById(R.id.messageTextView);
        txtMessage.setText(message);

        Button okButton = (Button) layout.findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }

}
