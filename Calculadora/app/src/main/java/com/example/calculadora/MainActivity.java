package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private enum  Entrada{NINGUNA,DIGITO,OPERADOR,CE}


    private Entrada ultimaEntrada;

    private BigDecimal operando1;
    private BigDecimal operando2;

    private char operador;

    private  byte numOperandos;
    private Boolean puntoDecimal;

    private TextView Pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Pantalla=(TextView)findViewById(R.id.pantalla);
        operando1=new BigDecimal(0);
        operando2=new BigDecimal(0);
        numOperandos=0;
        operador=0;
        puntoDecimal=false;
        ultimaEntrada=Entrada.NINGUNA;
    }

    public void Iniciar(View v){
        Pantalla.setText("0.");
        operando1=new BigDecimal(0);
        operando2=new BigDecimal(0);
        numOperandos=0;
        operador=0;
        puntoDecimal=false;
        ultimaEntrada=Entrada.NINGUNA;
    }
public void PuntoDec(View v){
        if (ultimaEntrada !=Entrada.DIGITO){
            Pantalla.setText("0.");
            ultimaEntrada=Entrada.DIGITO;
        }else if(!puntoDecimal){
            Pantalla.setText(Pantalla.getText().toString()+".");
        }
}
    public void BorrarEntrada(View v){
        String t=Pantalla.getText().toString();
        if (t.length()>0){
            Pantalla.setText(t.substring(0,t.length()-1));
            puntoDecimal=false;
            ultimaEntrada=Entrada.CE;
        }

    }
    public void pulsarDigito(View v){
        String t=((Button)v).getText().toString();
        //Para la primera vez , despues el reset y cuando se pone un operador
        if (ultimaEntrada!=Entrada.DIGITO){
            if (t.compareTo("0")==0)return;
            Pantalla.setText("");
            ultimaEntrada=Entrada.DIGITO;
            puntoDecimal=false;

        }
        Pantalla.setText(Pantalla.getText().toString()+t);
    }
    public void TantoPorciento(View v){

        BigDecimal resultado;
        //Para la primera vez o despuesd el reset
        if (ultimaEntrada==Entrada.DIGITO){
            resultado=BigDecimal.valueOf(Double.valueOf(Pantalla.getText().toString())).divide(new BigDecimal(100));
            resultado=operando1.multiply(resultado);
            Pantalla.setText(resultado.toString());
            operando1=resultado;
            numOperandos=1;
            ultimaEntrada=Entrada.NINGUNA;
        }
    }
    public void Operacion(View v){
        String t=((Button)v).getText().toString();
        if (numOperandos==0&& t.equals("-")) ultimaEntrada=Entrada.DIGITO;
        if (ultimaEntrada==Entrada.DIGITO)numOperandos++;
        if(numOperandos==1){
            operando1=BigDecimal.valueOf(Double.valueOf(Pantalla.getText().toString()) );
        }else if(numOperandos==2){
            operando2=BigDecimal.valueOf(Double.valueOf(Pantalla.getText().toString()));
            switch (operador){
                case '+':
                    operando1=operando1.add(operando2);
                    break;
                case '-':
                    operando1=operando1.subtract(operando2);
                    break;
                    case 'x':
                    operando1=operando1.multiply(operando2);
                    break;
                case '÷':
                    double a=Double.valueOf(operando1.toString())/Double.valueOf(operando2.toString());
                    //operando1=operando1.divide(operando2,4, RoundingMode.HALF_EVEN);
                    operando1=new BigDecimal(a);
                    break;
                case '=':
                    operando1=operando2;
                    break;
            }
            Pantalla.setText((operando1.toString()));
            numOperandos=1;

        }
        operador=t.charAt(0);
        ultimaEntrada=Entrada.OPERADOR;
        //op1=0
        //op2=0
        //op=-
    }
}