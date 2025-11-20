package com.example.simulacro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
String[] operaciones={"+","-","/","*"};
    private ListView l1;
    String operador="+";
    TextView n1;
    TextView n2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        l1=findViewById(R.id.operacionesList1);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        result=findViewById(R.id.result);

        ArrayAdapter<String> adaptador=
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,operaciones);
        l1.setAdapter(adaptador);

        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               operador=operaciones[position];
               double valorn1=Double.parseDouble(n1.getText().toString());
               double valorn2=Double.parseDouble((n2.getText().toString()));
               double resultado=0;

               switch (operador){
                   case "+":
                       resultado=valorn1+valorn2;
                       break;
                   case "-":
                       resultado=valorn1-valorn2;
                       break;
                   case "/":
                       resultado=redondear(valorn1/valorn2,3) ;
                       break;
                   case "*":
                       resultado=valorn1*valorn2;
                       break;
               }

               result.setText(String.valueOf(resultado));
            }
        });
    }

    public double redondear(double n, int d){
        double ex=Math.pow(10,d);
        return Math.round(n*ex)/ex;
    }
}