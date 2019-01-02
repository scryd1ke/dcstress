package com.dcstress.updateupgrade.dc_stress;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class Ejercicios extends AppCompatActivity {
    // CREACION DE INSTANCIA DE FIREBASE
    FirebaseStorage storage = FirebaseStorage.getInstance();

    // Create a storage reference from our app
    StorageReference storageRef = storage.getReference();


    // BOTONES DE CONTROL
    private VideoView videoView;
    //private ImageView playBtn;
    private TextView currentTimer;
    private TextView durationTimer;
    private ProgressBar currentProgress;
    private ProgressBar bufferProgress;

    //private Uri videoUri;

    private boolean isPlaying =false;
    private int current = 0;
    private int duration = 0;

    //FIN BOTONES DE CONTROL

    // CREACION DE LISTAS DE VIDEOS


    private ListView listView;
    private TextView tv1;

    private String[] VIDEOS = { "Ejercicio 1 - Activar miembros inferiores.", "Ejercicio 2 - Estiramiento de cadera y espalda.", "Ejercicio 3 - Calentamiento de hombros.", "Ejercicio 4 - Calentamiento articular. ", "Ejercicio 5- Estiramiento de manos."};

    private String[] URISS = {  "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio1.mp4?alt=media&token=3d323a34-611b-4a9f-8262-e77bef2fc070",
            "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio2.mp4?alt=media&token=a9100de1-56cd-4734-9c10-daa57f8e2077",
            "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio3.mp4?alt=media&token=6fabe806-3c4a-4340-b024-837bd2d38590",
            "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio4.mp4?alt=media&token=a06fd9b8-6044-4719-b832-e37fe410be33",
            "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio5.mp4?alt=media&token=44e64243-f265-4250-bfcb-c693cceb4d9e"};


    // FIN CREACION DE LISTAS DE VIDEO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);



        isPlaying = false;

        videoView = (VideoView)findViewById(R.id.video_view);
       // playBtn = (ImageView)findViewById(R.id.playBtn2);
        //currentTimer= (TextView)findViewById(R.id.currenTimer2);
        //durationTimer = (TextView)findViewById(R.id.durationTimer2);
        //currentProgress = (ProgressBar)findViewById(R.id.videoProgress2);
        //currentProgress.setMax(100);
        bufferProgress = (ProgressBar) findViewById(R.id.bufferProgress2);
        bufferProgress.setVisibility(View.INVISIBLE);

        // VINCULACION DEL LISTVIEW CON EL ADAPTADOR MAS UN AUXILIAR PARA RESCATAR LA DIRECCION HTTP
        tv1=(TextView)findViewById(R.id.tv1);
        listView =(ListView)findViewById(R.id.listview);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, VIDEOS);
        listView.setAdapter(adapter); //LLENA O POBLA LA LISTA

        //NUEVO CONTROL DE VIDEO
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        //FIN NUEVO CONTROL DE VIDEO

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //METODO QUE ESTABLECE UNA VEZ PRESIONADO UN ITEM DE LA LISTA SE EJECUTE UN VIDEO
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                bufferProgress.setVisibility(View.VISIBLE);
                isPlaying = false;

                tv1.setText(URISS[posicion]);
                Uri uri = Uri.parse((String) tv1.getText());

                videoView.setVideoURI(uri);
                videoView.requestFocus();

                // MANEJADOR DE LA BARRA DE PROGRESO DE CARGA EN  MEDIO DEL VIDEO



                videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
                        if (i == mediaPlayer.MEDIA_INFO_BUFFERING_START){
                            bufferProgress.setVisibility(View.VISIBLE);

                        }else if (i == mediaPlayer.MEDIA_INFO_BUFFERING_END){
                            bufferProgress.setVisibility(View.INVISIBLE);
                        }

                        return false;
                    }
                });


                //FIN MANEJADOR DE CARGA

                // SETEO DE LA DURACION DEL VIDEO

                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaplayer) {
                        duration = mediaplayer.getDuration()/1000;
                        String durationString = String.format("%02d:%02d", duration / 60, duration % 60);
                        //durationTimer.setText(durationString);
                    }
                });


                //FIN SETEO DURACION VIDEO

                videoView.start();
/*
                isPlaying = true; //AUXILIAR PARA ENTRAR Y SALIR DEL CICLO IF PARA CAMBIAR EL ESTADO DEL BOTON  PLAY_PAUSA
                playBtn.setImageResource(R.drawable.img_pause);
                new videoProgress2().execute();

                playBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isPlaying){
                            videoView.pause();
                            isPlaying = false;
                            playBtn.setImageResource(R.drawable.img_play);
                        }else {

                            videoView.start();
                            isPlaying = true;
                            playBtn.setImageResource(R.drawable.img_pause);
                        }
                    }
                });*/
            }



        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        isPlaying = false;
        videoView.stopPlayback();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isPlaying = false;
        videoView.stopPlayback();
    }
/*
    // SACANDO LA BARRA DE PROGRESO MANUAL
    public class videoProgress2 extends AsyncTask<Void, Integer, Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            do {

                if (isPlaying) {
                    current = videoView.getCurrentPosition() / 1000;
                    publishProgress(current);// ESTO FUE LO ULTIMO QUE CAMBIE POR SI FALLA
                    try {

                        int currentPercent = current * 100 / duration;
                        publishProgress(currentPercent);

                    } catch (Exception e) {
                    }
                }
            }while(currentProgress.getProgress() <= 100);

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // currentProgress.setProgress(values[0]);
            try {

                int currentPercent = values[0] * 100/duration;
                currentProgress.setProgress(currentPercent);

                String currentString = String.format("%02d:%02d", values[0] / 60, values[0] % 60);

                currentTimer.setText(currentString);



            }catch (Exception e){


            }


        }
    }*/

}
