package com.example.editoractionlistenej1;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText editor;
TextView letra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editor=findViewById(R.id.buscarletra);
        letra=findViewById(R.id.letra);
        editor.setOnEditorActionListener((new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean procesado=false;
                if (actionId== EditorInfo.IME_ACTION_SEARCH){
                    letra.setText(biblioteca.dninie(editor.getText().toString()));
                    //Ocultar el teclado virtual
                    InputMethodManager em=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    em.hideSoftInputFromWindow(v.getWindowToken(),0);
                    procesado=true;
                }

                return procesado;
            }
        }));

    }
}