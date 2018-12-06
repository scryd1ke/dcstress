package com.example.updateupgrade.dc_stress;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import static com.example.updateupgrade.dc_stress.R.layout.activity_musica_;

public class Musica_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_musica_);

        Button btn2 = (Button) findViewById(R.id.btnVolver);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent2, 0);
            }
        });
        // SOLO COMENTARIO PARA HACER EL COMMIT EN LA NUEVA RAMA PRESENTACION-2

    }
}