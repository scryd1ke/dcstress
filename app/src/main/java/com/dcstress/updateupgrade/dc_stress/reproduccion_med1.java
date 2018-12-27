package com.dcstress.updateupgrade.dc_stress;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;


public class reproduccion_med1 extends AppCompatActivity {

    private VideoView mainVideoView;
    private ImageView playBtn;
    private TextView currentTimer;
    private TextView durationTimer;
    private ProgressBar currentProgress;
    private ProgressBar bufferProgress;

    private Uri videoUri;

    private boolean isPlaying;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduccion_med1);
        /*

        isPlaying = false;

        mainVideoView = (VideoView)findViewById(R.id.mainVideoView);
        playBtn = (ImageView)findViewById(R.id.playBtn);
        currentTimer= (TextView)findViewById(R.id.currenTimer);
        durationTimer = (TextView)findViewById(R.id.durationTimer);
        currentProgress = (ProgressBar)findViewById(R.id.videoProgress);
        bufferProgress = (ProgressBar) findViewById(R.id.bufferProgress);

        videoUri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/dcstress-899ef.appspot.com/o/ejercicios%2Fejercicio1.mp4?alt=media&token=3d323a34-611b-4a9f-8262-e77bef2fc070");


        mainVideoView.setVideoURI(videoUri);
        mainVideoView.requestFocus();
        mainVideoView.start();
        isPlaying = true;
        playBtn.setImageResource(R.drawable.img_pause);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying){
                    mainVideoView.pause();
                    isPlaying = false;
                    playBtn.setImageResource(R.drawable.img_play);
                }else {

                    mainVideoView.start();
                    isPlaying = true;
                    playBtn.setImageResource(R.drawable.img_pause);
                }
            }
        });*/

    }// FIN OnCreate


}
