package com.example.updateupgrade.dc_stress;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
 //FD - REFENCIA A FIREBASE STORAGE
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();


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

        ImageButton btn4 = (ImageButton) findViewById(R.id.btnCreditos);//
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), creditos.class); //creditos.class
                startActivityForResult(intent, 0);
            }
        });
//FD -  DESCARGANDO ARCHIVOS DESDE FIREBASE CON EL ASSISTENTE

        //Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
        StorageReference riversRef = storageReference.child("images/rivers.jpg");

        File localFile = null;
        try {
            localFile = File.createTempFile("images", "jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        riversRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
            }
        });



    }
// LANZA NOTIFICACIONES AL SISTEMA ANDROID

    public void notificar(View view){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "my_channel_01")
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle("Titulo de la notificacion")
                .setContentText("Texto de la notificacion")
                .setTicker("Alerta!!")
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+1111111"));
        PendingIntent dialPendinIntent = PendingIntent.getActivity(this,0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(dialPendinIntent);

        NotificationManagerCompat mNotificationManager = NotificationManagerCompat.from(this);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String name ="My Channel";
            String description = "Channle Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("my_channel_01", name, importance);
            channel.setDescription(description);

            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
        mNotificationManager.notify(1, mBuilder.build());


    }

    //GENERA NOTIFICACIONES SEGUN TIEMPO ESTABLECIDO Y LLAMA A LA FUNCION NOTIFICAR

}
