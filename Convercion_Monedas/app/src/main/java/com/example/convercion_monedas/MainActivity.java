package com.example.convercion_monedas;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    double[] cambios={1,0.86,153.53,0.76};
    boolean updating = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       findViewById(R.id.eq_0_0).setEnabled(false);
    for(int i=1;i<4;i++){
        int resId=getResources().getIdentifier("eq_0"+"_"+i,"id",getPackageName()) ;
        EditText e=findViewById(resId);
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!updating){
                    ActualizarValores(e);
                    Rellenar();
                }

            }
        });
    }
Rellenar();
    }
public void Rellenar(){
        updating=true;
        for (int i=0;i<4;i++){
            for (int j = 0; j < 4; j++) {
                int resId=getResources().getIdentifier("eq_"+i+"_"+j,"id",getPackageName()) ;
                EditText e=findViewById(resId);
                if (e==null) continue;
                if (i!=0){
                    double valor=cambios[j]/cambios[i];
                    e.setText(String.valueOf(valor) );
                }

               if (i==j){
                   e.setEnabled(false);
                   e.setBackgroundColor(Color.LTGRAY);
               }
               if(i!=0){
                   e.setEnabled(false);
               }
            }
        }

        updating=false;
}
public void ActualizarValores(EditText e){
    String nombre = getResources().getResourceEntryName(e.getId());
        cambios[Integer.valueOf(nombre.split("_")[2])]= Double.parseDouble(e.getText().toString());
}
}