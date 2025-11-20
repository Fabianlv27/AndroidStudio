package com.example.listas;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private TextView t1;


String[] paises={"España","Francia","Portugal"};

String[] poblacion={"40000000000","5000000000","60000000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
      t1=findViewById(R.id.pais);
      l1=findViewById(R.id.lista);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paises);

        l1.setAdapter(adaptador);

        l1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                t1.setText("La Poblacion de "+L1.getItemAtPosition(position)+" es "+poblacion[position]);
            }
        });
    };
}