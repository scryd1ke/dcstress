package com.example.updateupgrade.dc_stress;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;


public class Ejercicios extends AppCompatActivity {
    // CREACION DE INSTANCIA DE FIREBASE
    FirebaseStorage storage = FirebaseStorage.getInstance();
    //private StorageReference mStorageRef;
    // Create a storage reference from our app
    StorageReference storageRef = storage.getReference();
    private  VideoView videoView;

    private ListView listView;
    private TextView tv1;

    private String[] VIDEOS = { "Video 1", "Video 2", "Video 3", "Video 4 ", "Video 5"};

    private String[] URISS = {  "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio1.mp4?alt=media&token=3d323a34-611b-4a9f-8262-e77bef2fc070",
            "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio2.mp4?alt=media&token=a9100de1-56cd-4734-9c10-daa57f8e2077",
            "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio3.mp4?alt=media&token=6fabe806-3c4a-4340-b024-837bd2d38590",
            "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio4.mp4?alt=media&token=a06fd9b8-6044-4719-b832-e37fe410be33",
            "https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio5.mp4?alt=media&token=44e64243-f265-4250-bfcb-c693cceb4d9e"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);


        // LISTVIEW AUTOMATICO MODIFICADO
       // videoView.setMediaController((new MediaController(this)));
        videoView=(VideoView) findViewById(R.id.video_view);
        tv1=(TextView)findViewById(R.id.tv1);
        listView =(ListView)findViewById(R.id.listview);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, VIDEOS);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {

                tv1.setText(URISS[posicion]);
                Uri uri = Uri.parse((String) tv1.getText());

                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
            }
        });
    }


// FIN EXPORTACION LISTVIEW AUTOMATICO




        //mStorageRef = FirebaseStorage.getInstance().getReference();

  /*   VIDEO DE PRUEBA AUTOMATICO

        videoView = (VideoView) findViewById(R.id.video_view);

        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        //Uri uri = Uri.parse("http://algun video de youtube");
        videoView.setMediaController((new MediaController(this)));
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
       */


/* BOTON DE PRUEBA VOLVER

        Button btn2 = (Button) findViewById(R.id.btnVolver);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent2, 0);
            }
        });

    }
    */ // FIN BOTON DE PRUEBA VOLVER


}
