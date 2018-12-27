package com.example.updateupgrade.dc_stress;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.PublicKey;

public class Rep_musica extends AppCompatActivity {

    MediaPlayer mp;
    int pause;
    int aux;
    private Button nextsong;

    // ASIGNANDO MUSICAS
    int canciones[]={R.raw.mnaturaleza,R.raw.angel_de_agua,R.raw.mprofundo,R.raw.mrelajarse,R.raw.horizonte,R.raw.mistico};
    int index=0;


    //FIN ASIGNANDO MUSICAS


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_musica);

        nextsong = (Button)findViewById(R.id.nexstong);
    }

    public void play (View view){
        if (mp == null) {

            mp = MediaPlayer.create(getApplication(), canciones[index] ); // R.raw.mnaturaleza R.raw.angel_de_agua
            mp.start();
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }else if(mp != null){
           // mp.seekTo(pause);
            mp.start();
            Toast.makeText(this, "Reanudando", Toast.LENGTH_SHORT).show();
        }
    }

    public void pausa (View view){
        if (mp !=null) {
            mp.pause();
            //pause = mp.getCurrentPosition();
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop (View view){
        mp.stop();
        mp = null;
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
    }

    public void nextsong (View view){
        nextsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if (index>5)index=0;
                mp.stop();
                mp = MediaPlayer.create(getApplication(), canciones[index]);
                mp.start();

            }
        });


        Toast.makeText(this, "Siguiente Pista", Toast.LENGTH_SHORT).show();
    }

}

