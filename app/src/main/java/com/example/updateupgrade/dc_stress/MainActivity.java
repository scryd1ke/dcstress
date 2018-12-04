package com.example.updateupgrade.dc_stress;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn1 = (ImageButton) findViewById(R.id.btnMusica);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Musica_Activity.class);
                startActivityForResult(intent, 0);
            }
        });

        ImageButton btn2 = (ImageButton) findViewById(R.id.btnEjercicios);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Ejercicios.class);
                startActivityForResult(intent, 0);
            }
        });

        ImageButton btn3 = (ImageButton) findViewById(R.id.btnMeditacion);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Meditacion.class);
                startActivityForResult(intent, 0);
            }
        });

        ImageButton btn4 = (ImageButton) findViewById(R.id.btnCreditos);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), creditos.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
