package com.dcstress.updateupgrade.dc_stress;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Rep_musica extends AppCompatActivity {

    MediaPlayer mp;
    int pause;
    int aux;
    private Button nextsong;

    // ASIGNANDO MUSICAS
    int canciones[]={R.raw.mnaturaleza,R.raw.angel_de_agua,R.raw.mrelajarse,R.raw.horizonte,R.raw.mistico};
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
        if (mp !=null) {
            mp.stop();
            mp = MediaPlayer.create(getApplication(), canciones[index] );
           // mp.release();
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }

    }


    public void nextsong (View view){

        index++;
        if (index>4){
            index=0;
        }
        if (mp == null) {
            mp = MediaPlayer.create(getApplication(), canciones[index]);
            mp.start();
            Toast.makeText(this, "Siguiente Pista", Toast.LENGTH_SHORT).show();
        }else{
            mp.stop();
            mp = MediaPlayer.create(getApplication(), canciones[index]);
            mp.start();
            Toast.makeText(this, "Siguiente Pista", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try{
            mp.stop();
            mp.reset();
        }catch (Exception ex){

        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        try{
            mp.stop();
            mp.reset();
        }catch (Exception ex){

        }
    }
}

