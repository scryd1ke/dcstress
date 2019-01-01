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
import java.sql.BatchUpdateException;
import java.util.ArrayList;

public class Meditacion extends AppCompatActivity {

    int isplayingmed = 3; //0 = false; 1 = true; 3 = loquesea;
    ListView listaDatos; // CREAMOS LA VISTA DE LISTA EN EL LAYOUT
    ArrayList<datoslist> Lista; // CREAMOS LA LISTA PARA AGREGAR ITEMS
    String URISS; //CREAMOS EL CONTENEDOR DE URLs


    MediaPlayer mediaPlayer = new MediaPlayer(); // CREAMOS EL MEDIAPLAYER mediaplayer
    String detalle;
    Button play_pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditacion);

        play_pause = (Button) findViewById(R.id.play_pause); // ASIGNAMOS EL BOTON PLAY PAUSE


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

                detalle = (String) Lista.get(position).getDetalle();
                isplayingmed=1;

                iniciaReproduccion(detalle);


            }
        });

    }

    private void iniciaReproduccion(String detalle) {
        if (isplayingmed==1){


            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    mp.reset();
                    return false;
                }
            });

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

            try {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.setDataSource(detalle);
                this.mediaPlayer.prepareAsync();
                isplayingmed=1;
                play_pause.setBackgroundResource(R.drawable.img_pause);
                Toast.makeText(Meditacion.this, "Play", Toast.LENGTH_SHORT).show();
                // mediaPlayer.start();
            } catch (IllegalArgumentException e) {
            } catch (IllegalStateException e) {
            } catch (IOException e) {
            }
        }
    }


    //METODO PARA REPRODUCIR CANCIONES CUANDO SE PRESIONE UN ELEMENTO DE LA LISTA
    public void play_pause (View view){

        if (isplayingmed==1){

            play_pause.setBackgroundResource(R.drawable.img_play);
            Toast.makeText(Meditacion.this, "Pausa", Toast.LENGTH_SHORT).show();
            isplayingmed = 0;
            mediaPlayer.pause();

        }else if (isplayingmed==0){
            mediaPlayer.start();
            play_pause.setBackgroundResource(R.drawable.img_pause);
            Toast.makeText(Meditacion.this, "Play", Toast.LENGTH_SHORT).show();
            isplayingmed=1;
        }else{}

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isplayingmed = 0;
        mediaPlayer.stop();
        mediaPlayer.release();
    }

}