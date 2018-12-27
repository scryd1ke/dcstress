package com.dcstress.updateupgrade.dc_stress;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class creditos extends AppCompatActivity {

    Button b_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        b_send = (Button) findViewById(R.id.b_send);
        b_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dcstressapp@gmail.com"} );
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Para amigos de Dc-Stress");
                emailIntent.setData(Uri.parse("dcstressapp@gmail.com"));
                emailIntent.setType("Text/plain");
                startActivity(emailIntent);

            }
        });



    }
}
