package com.example.dinero;

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
 EditText Conversor;
    EditText IND;
    EditText INE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Conversor=findViewById(R.id.INC);
        IND= (EditText) findViewById(R.id.IND);
        INE= (EditText) findViewById(R.id.INE);
    }

    //TextView.OnEditorActionListener()
    public void general(EditText t,int x){
        double n= Double.parseDouble(t.getText().toString())+x;
        t.setText(String.valueOf(n));
        if (t==IND){
            INE.setText(String.valueOf(n*Double.parseDouble(Conversor.getText().toString()))  );
        }else{
            IND.setText(String.valueOf(n*Double.parseDouble(Conversor.getText().toString()))  );
        }
    }
    public void AumentarDollar(View v){
        general(IND,1);
    }
    public void DecrementarDollar(View v){
        general(IND,-1);
    }

    public void AumentarEuro(View v){
        general(IND,1);
    }
    public void DecrementarEuro(View v){
        general(IND,-1);
    }
}