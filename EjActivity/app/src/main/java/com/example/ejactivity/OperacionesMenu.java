package com.example.ejactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OperacionesMenu extends AppCompatActivity {
TextView numeros_titulo,suma,resta,multi,divi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operaciones_menu);
        numeros_titulo=findViewById(R.id.numeros_titulo);
        suma=findViewById(R.id.suma);
        resta=findViewById(R.id.resta);
        multi=findViewById(R.id.multi);
        divi=findViewById(R.id.divi);

        Bundle b=getIntent().getExtras();
        Float n1= b.getFloat("n1") ;
        Float n2= b.getFloat("n2");

        suma.setText("Suma: "+String.valueOf(n1+n2));
        resta.setText("Resta: "+String.valueOf(n1-n2));
        multi.setText("Multiplicacion: "+String.valueOf(n1*n2));
        if (n2!=0){
            divi.setText("Divicion: "+ String.valueOf((n1/n2)) );
        }else{
            divi.setText("Divicion: Syntaxis Error");
        }
    }

    public void salir(View v) {
      finish();
    }
}