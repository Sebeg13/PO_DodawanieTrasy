package com.example.po_dodawanietrasy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.po_dodawanietrasy.R;
import com.example.po_dodawanietrasy.presenter.DodawanieTrasyPresenter;

/**
 * Klasa MainActivity to klasa głównej aktywności
 */
public class MainActivity extends AppCompatActivity implements DodawanieTrasyView {
    private DodawanieTrasyPresenter presenter;
    private EditText pointAEditText;
    private EditText pointBEditText;
    private EditText distanceEditText;
    private EditText sumaOfDifferencesEditText;
    private Button addButton;

    private TextWatcher textWatcher;

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.activity_main_toolbar));

        presenter = new DodawanieTrasyPresenter(this, getApplicationContext());

        pointAEditText = findViewById(R.id.punktAEditText);
        pointBEditText = findViewById(R.id.punktBEditText);
        distanceEditText = findViewById(R.id.odlegloscEditText);
        sumaOfDifferencesEditText = findViewById(R.id.sumaRoznicEditText);
        addButton = findViewById(R.id.dodajButton);

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

        pointAEditText.addTextChangedListener(textWatcher);
        pointBEditText.addTextChangedListener(textWatcher);
        distanceEditText.addTextChangedListener(textWatcher);
        sumaOfDifferencesEditText.addTextChangedListener(textWatcher);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateDataToDataBase();
            }
        });
    }


    @Override
    public String getPointA() {
        return pointAEditText.getText().toString();
    }

    @Override
    public String getPointB() {
        return pointBEditText.getText().toString();
    }

    @Override
    public String getDistance() {
        return distanceEditText.getText().toString();
    }

    @Override
    public String getSumOfDifferences() {
        return sumaOfDifferencesEditText.getText().toString();
    }



    public void checkFieldForEmptyValues(){
        String s1, s2, s3, s4;
        s1 = distanceEditText.getText().toString();
        s2 = sumaOfDifferencesEditText.getText().toString();
        s3 = pointAEditText.getText().toString();
        s4 = pointBEditText.getText().toString();

        if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals(""))
            addButton.setEnabled(false);
        else
            addButton.setEnabled(true);

    }

    @Override
    public void showPopup(String message){
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
