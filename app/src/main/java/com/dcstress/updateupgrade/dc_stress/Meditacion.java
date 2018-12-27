package com.dcstress.updateupgrade.dc_stress;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class Meditacion extends AppCompatActivity {

    private boolean isplayingmed = false;
    ListView listaDatos; // CREAMOS LA VISTA DE LISTA EN EL LAYOUT
    ArrayList<datoslist> Lista; // CREAMOS LA LISTA PARA AGREGAR ITEMS
    String URISS; //CREAMOS EL CONTENEDOR DE URLs


    MediaPlayer mediaPlayer = new MediaPlayer(); // CREAMOS EL MEDIAPLAYER mediaplayer


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditacion);


        isplayingmed = false; //auziliar para el boton play_pause

        // ASIGNAMOS EL BOTON PLAY PAUSE
        final Button play_pause = (Button) findViewById(R.id.play_pause); // CREAMOS DE BOTON PLAY PLUSE
        listaDatos = (ListView) findViewById(R.id.lstDatos);

        Lista = new ArrayList<datoslist>();

        Lista.add(new datoslist(1, "Meditacion de 5 Minutos para mejorar tu salud","https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/meditacion%2Fmeditacion5min.mp4?alt=media&token=f27a0dc8-92de-4d46-b13d-48164db13a18", R.drawable.m3 ));
        Lista.add(new datoslist(2, "Meditacion para quitar tensiones","https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/meditacion%2Fmeditacion5minmp3.mp3?alt=media&token=9926a319-aed2-4c64-8bef-0b0719f876fb", R.drawable.m1 ));
        Lista.add(new datoslist(3, "Meditacion de 3 Minutos para Relajarse","https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/meditacion%2FRelajacion3min.mp3?alt=media&token=bde4aba2-a758-45f1-9dda-a98046e21e56", R.drawable.m2 ));

        Adaptadorlist miadaptador = new Adaptadorlist(getApplicationContext(),Lista);
        listaDatos.setAdapter(miadaptador);


        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // COLOCAR AQUI CODIGO PARA REPRODUCTR EL ARCHIVO DE AUDIO STREAMING DESDE FIREBASE
                //SEGUN LA POSICION DE LA LISTA

               final String detalle = (String) Lista.get(position).getDetalle();

                TextView muestra;
                muestra = (TextView) findViewById(R.id.mostrar);

                muestra.setText(detalle);

                try {
                   // MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(detalle);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    isplayingmed=true;
                    play_pause.setBackgroundResource(R.drawable.img_pause);
                    Toast.makeText(Meditacion.this, "Play", Toast.LENGTH_SHORT).show();

                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }




            }
        });

// BOTONES DE CONTROL PARA EL MEDIA PLAYER
        //play_pause = (Button) findViewById(R.id.play_pause);
        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isplayingmed){
                    mediaPlayer.pause();
                    play_pause.setBackgroundResource(R.drawable.img_play);
                    Toast.makeText(Meditacion.this, "Pausa", Toast.LENGTH_SHORT).show();
                    isplayingmed = false;
                }
                else {
                    mediaPlayer.start();
                    play_pause.setBackgroundResource(R.drawable.img_pause);
                    Toast.makeText(Meditacion.this, "Play", Toast.LENGTH_SHORT).show();
                    isplayingmed=true;
                }
            }
        });

    }
}