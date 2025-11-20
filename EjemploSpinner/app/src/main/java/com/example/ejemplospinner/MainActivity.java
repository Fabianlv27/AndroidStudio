package com.example.ejemplospinner;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText num1,num2,resultado;
Spinner sp;
String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
      num1=findViewById(R.id.numero1);
      num2=findViewById(R.id.numero2);
      resultado=findViewById(R.id.resultado);
      sp=findViewById(R.id.sp);

      String[] matriz_operaciones=getResources().getStringArray(R.array.operaciones);
      String[]ops={"+","-","*","/"};
      op="+";
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,matriz_operaciones);
        sp.setAdapter(adaptador);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                op=ops[position];
                cambio();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /*************************/
        num1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                cambio();
                return false;
            }
        });

        num2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                cambio();
                return false;
            }
        });
    }
    public void cambio(){
        double rs=0.0;
        double v1=Double.valueOf(num1.getText().toString());
        double v2=Double.valueOf(num2.getText().toString());
        rs=op.equals("+")?v1+v2:op.equals("-")?v1-v2:op.equals("*")?v1*v2:op.equals("/")?v1/v2:0.0;
        resultado.setText(String.format("%.2f",rs));
    }

}