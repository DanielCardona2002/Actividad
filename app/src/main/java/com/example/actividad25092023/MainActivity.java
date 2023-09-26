package com.example.actividad25092023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button activity2, google,alarma,llamada;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity2 = findViewById(R.id.activity2);
        google = findViewById(R.id.google);
        alarma = findViewById(R.id.alarma);
        llamada = findViewById(R.id.llamar);


        google.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent irAGoogle = new Intent(Intent.ACTION_VIEW);
                irAGoogle.setData(Uri.parse("http://www.google.com"));
                startActivity(irAGoogle);

            }

        });

        alarma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                crearAlarma();


            }
            private void crearAlarma() {
                Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarma.putExtra(AlarmClock.EXTRA_MESSAGE,"Trabajar");
                alarma.putExtra(AlarmClock.EXTRA_HOUR,4);
                alarma.putExtra(AlarmClock.EXTRA_MINUTES,30);
                if (alarma.resolveActivity(getPackageManager())!=null){
                    startActivity(alarma);
                }
            }

        });

        llamada.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialPhoneNumber("3054605113");


            }

            public void dialPhoneNumber(String phoneNumber) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }

        });
    }




}