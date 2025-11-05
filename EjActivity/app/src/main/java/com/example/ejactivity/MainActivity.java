package com.example.ejactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);

    }
    public void enviar(View v){
Intent i=new Intent(this,OperacionesMenu.class);

i.putExtra("n1",Float.valueOf(n1.getText().toString()) );
i.putExtra("n2",Float.valueOf(n2.getText().toString()) );
        startActivity(i);
    }
}