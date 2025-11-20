package com.example.e3;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText jtgc;EditText jtgf;EditText jtgk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        jtgc=findViewById(R.id.tgc);
        jtgf=findViewById(R.id.tgf);
        jtgk=findViewById(R.id.tgk);

        jtgc.setOnEditorActionListener((new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                general(jtgc,0);
                return true;
            }
        }));
        jtgf.setOnEditorActionListener((new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                general(jtgf,0);
                return true;
            }
        }));
        jtgk.setOnEditorActionListener((new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                general(jtgk,0);
                return true;
            }
        }));
    }

    public void general(EditText t,int a){
        double n=Double.valueOf(t.getText().toString())+a;
        t.setText(String.valueOf(n));

        if (t==jtgc) {
            jtgf.setText(String.valueOf(redondear((n * 9) / 5 + 32,2)));
            jtgk.setText(String.valueOf(redondear(n + 273.15,2)));
        } else if (t==jtgf) {
            jtgc.setText(String.format("%.2f",(5 * (n - 32)) / 9));
            jtgk.setText(String.format("%.2f",((5 * (n - 32)) / 9)+ 273.15)) ;
        } else if (t==jtgk) {
            jtgc.setText(String.valueOf( redondear(n - 273.15,2)));
            jtgf.setText(String.valueOf(redondear((n - 273.15) * 9 / 5 + 32,2)));
        }
    }

    public double redondear(double n, int d){
        double ex=Math.pow(10,d);
        return Math.round(n*ex)/ex;
    }
    public void incrementarCentigrados(View vista){
        general(jtgc,1);
    }
    public void decrementarCentigrados(View vista){
        general(jtgc,-1);
    }


    public void incrementarFar(View vista){
        general(jtgf,1);
    }
    public void decrementarFar(View vista){
        general(jtgf,-1);
    }

    public void incrementarKelvin(View vista){
        general(jtgk,1);
    }
    public void decrementarKelvin(View vista){
        general(jtgk,-1);
    }

}