package com.example.updateupgrade.dc_stress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Meditacion extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<datoslist> Lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditacion);

        listaDatos = (ListView) findViewById(R.id.lstDatos);

        Lista = new ArrayList<datoslist>();

        Lista.add(new datoslist(1, "Meditacion de 5 Minutos","Meditacion rapida para mejorar tu salud", R.drawable.m3 ));
        Lista.add(new datoslist(2, "Meditacion para quitar tensiones","Meditacion mas produnda para eliminar tensiones laborales", R.drawable.m1 ));
        Lista.add(new datoslist(3, "Meditacion para relajarse","Meditacion para proporcionar un relajo adicional en tu jornada", R.drawable.m2 ));

        Adaptadorlist miadaptador = new Adaptadorlist(getApplicationContext(),Lista);
        listaDatos.setAdapter(miadaptador);

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                datoslist obj = (datoslist) parent.getItemAtPosition(position);

                Intent paso = new Intent(getApplicationContext(), reproduccion_med1.class);
                paso.putExtra("objeto", (Serializable) obj);
                startActivity(paso);

            }
        });



    }
}