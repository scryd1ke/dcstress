package com.example.updateupgrade.dc_stress;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
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
    VideoView videoView;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
        //mStorageRef = FirebaseStorage.getInstance().getReference();


        Button btn2 = (Button) findViewById(R.id.btnVolver);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent2, 0);
            }
        });
        /*   VIDEO DE PRUEBA AUTOMATICO

        videoView = (VideoView) findViewById(R.id.video_view);

        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        //Uri uri = Uri.parse("http://algun video de youtube");
        videoView.setMediaController((new MediaController(this)));
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
       */

        listView=(ListView) findViewById(R.id.listview);
        ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add("Video 1");
        arrayList.add("Video 2");
        arrayList.add("Video 3");
        arrayList.add("Video 4");
        arrayList.add("Video 5");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

    }


}
