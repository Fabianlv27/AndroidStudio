package com.example.memoria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TableLayout tabla;
    TextView contador;
    int numero_cartas;
    String[] matriz;

    String number;

    ImageView img1;

    ConstraintLayout body;
    int imagen3;
    public static int alea(int li,int ls) {
        return (int)(Math.random()*(ls-li+1))+li;
    }

    public void mostrarImagenPantallaCompleta(Activity activity, int drawableId) {
        // Crear un ImageView
        ImageView img = new ImageView(activity);
        img.setImageResource(drawableId);

        // Configurar para que ocupe toda la pantalla
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        // Asignar un id para poder borrarlo luego
        imagen3=View.generateViewId();
        img.setId(imagen3);

        // Añadirlo al layout raíz
        ViewGroup root = (ViewGroup) activity.findViewById(android.R.id.content);
        root.addView(img);
    }

    public void borrarImagenPantallaCompleta(Activity activity, int imageViewId) {
        ViewGroup root = (ViewGroup) activity.findViewById(android.R.id.content);
        View img = root.findViewById(imageViewId);

        if (img != null) {
            root.removeView(img);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        body=findViewById(R.id.main);
        tabla=findViewById(R.id.tabla);
        contador=findViewById(R.id.contador);
        numero_cartas=16;
        inicio(null);

    }

    public void inicio(View v){
        number="x";
        contador.setText("0");
        matriz=new String[numero_cartas];
        Arrays.fill(matriz,"x");
        LLenar_matriz_aleatorio();
        asignar_evento_imagen();
    }


    public void LLenar_matriz_aleatorio(){
        boolean keep;
        int n;
        for (int i = 1; i <= (numero_cartas/2); i++) {
            for (int j = 0; j < 2; j++) {
                keep=true;
                while (keep){
                    n=alea(0,(numero_cartas-1));
                    if (Objects.equals(matriz[n], "x")){
                        matriz[n]=String.valueOf(i);
                        keep=false;
                    }
                }
            }

        }

    }

    public void Cambiar_color_fondo(boolean right){
        if (right){
            mostrarImagenPantallaCompleta(this, R.drawable.albert);

            body.setBackgroundResource(R.drawable.right);
        }else{
            body.setBackgroundResource(R.drawable.wrong);
            mostrarImagenPantallaCompleta(this, R.drawable.gato);
        }

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                body.setBackgroundResource(R.drawable.fondo_degradado);
                borrarImagenPantallaCompleta(MainActivity.this, imagen3);

            }
        },500);
    }

    public void Comprobar(String number2,ImageView img2){

        if (number.equals(number2)){
            contador.setText(String.valueOf(Integer.parseInt(String.valueOf(contador.getText())) + 1 )  );
           img1.setOnClickListener(null) ;
           img2.setOnClickListener(null) ;
           Cambiar_color_fondo(true);

        }else{
            img1.setImageResource(R.drawable.logo);
            img2.setImageResource(R.drawable.logo);
            img1.setClickable(true);
            img2.setClickable(true);
            Cambiar_color_fondo(false);
        }
        number="x";
    }

    public void Image_Click(ImageView img){
        // Obtener el nombre del recurso a partir del id
        String nombre = getResources().getResourceEntryName(img.getId());
        String[] partes = nombre.split("_");
        int pos = Integer.parseInt(partes[1]);


        img.setImageResource(getResources().getIdentifier(("n"+matriz[pos]),"drawable",getPackageName()));
        img.setClickable(false);

        if (Objects.equals(number, "x")){
            number=matriz[pos];
            img1=img;
        }else{
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Comprobar(matriz[pos],img);
                }
            },500);

        }


    }

    public void asignar_evento_imagen(){
        for (int i = 0; i < tabla.getChildCount(); i++) {
            View e=tabla.getChildAt(i);
            if(e instanceof TableRow){
                TableRow fila=(TableRow) e;
                for (int j = 0; j < fila.getChildCount(); j++) {
                    View hijo=fila.getChildAt(j);
                    if (hijo instanceof ImageView){
                        ImageView imagen=(ImageView) hijo;
                        imagen.setImageResource(R.drawable.logo);
                        imagen.setClickable(true);
                        imagen.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Image_Click(imagen);
                            }
                        });
                    }
                }

            }
        }
    }
}