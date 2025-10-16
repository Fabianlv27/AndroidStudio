package com.example.e3;

import android.os.Bundle;
import android.view.View;
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
    }

    public void general(EditText t,int a){
        double n=Double.valueOf(t.getText().toString())+a;
        t.setText(String.valueOf(n));

        if (t==jtgc) {
            jtgf.setText(String.valueOf((n * 9) / 5 + 32));
            jtgk.setText(String.valueOf(n + 273.15));
        } else if (t==jtgf) {
            jtgc.setText(String.valueOf((5 * (n - 32)) / 9));
            jtgk.setText(String.valueOf((5 * (n - 32)) / 9) + 273.15);
        } else if (t==jtgk) {
            jtgc.setText(String.valueOf(n - 273.15));
            jtgf.setText(String.valueOf((n - 273.15) * 9 / 5 + 32));
        }
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