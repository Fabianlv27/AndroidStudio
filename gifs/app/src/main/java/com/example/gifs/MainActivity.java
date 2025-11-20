package com.example.gifs;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText DE,DY,DL ,ED,EY,EL,YD,YE,YL,LD,LE,LY;

double VDE=0.86,VDY=153.53,VDL=0.76;

ImageView img1,img2,img3,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        DE = findViewById(R.id.DE);
        DY = findViewById(R.id.DY);
        DL = findViewById(R.id.DL);

        ED = findViewById(R.id.ED);
        EY = findViewById(R.id.EY);
        EL = findViewById(R.id.EL);

        YD = findViewById(R.id.YD);
        YE = findViewById(R.id.YE);
        YL = findViewById(R.id.YL);

        LD = findViewById(R.id.LD);
        LE = findViewById(R.id.LE);
        LY = findViewById(R.id.LY);

        cambio();
    DE.setOnEditorActionListener((TextView v, int actionId, KeyEvent event)->{
                VDE=!DE.getText().toString().isEmpty()?Double.parseDouble(DE.getText().toString()):0.0;
                cambio();
                return false;
            });

    DY.setOnEditorActionListener((TextView v, int actionId, KeyEvent event)->{
                VDY=!DY.getText().toString().isEmpty()?Double.parseDouble(DY.getText().toString()):0.0;
                cambio();
                return false;
            });

    DL.setOnEditorActionListener((TextView v, int actionId, KeyEvent event)->{
            VDL=!DL.getText().toString().isEmpty()?Double.parseDouble(DL.getText().toString()):0.0;
            cambio();
            return false;
        });


    }
    public void cambio(){
        DE.setText(String.valueOf(VDE));
        DY.setText(String.valueOf(VDY));
        DL.setText(String.valueOf(VDL));

        ED.setText(String.format("%.6f",1/VDE));
        YD.setText(String.format("%.6f",1/VDY));
        LD.setText(String.format("%.6f",1/VDL));

        EY.setText(String.format("%.6f",VDY/VDE));
        EL.setText(String.format("%.6f",VDL/VDE));
        YL.setText(String.format("%.6f",VDL/VDY));

        YE.setText(String.format("%.6f",VDE/VDY));
        LE.setText(String.format("%.6f",VDE/VDL));
        LY.setText(String.format("%.6f",VDY/VDL));
    }
}