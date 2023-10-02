package com.example.actividad25092023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button activity2, mapa, calendario, google,alarma,llamada;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity2 = findViewById(R.id.activity2);
        mapa = findViewById(R.id.mapa);
        calendario = findViewById(R.id.calendario);
        google = findViewById(R.id.google);
        alarma = findViewById(R.id.alarma);
        llamada = findViewById(R.id.llamar);




        mapa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showMap(Uri.parse("https://www.google.com/maps/place/Instituci%C3%B3n+Universitaria+Pascual+Bravo/@6.2733494,-75.5883927,17z/data=!3m1!4b1!4m6!3m5!1s0x8e44293b5709163d:0x2744a3a12c601259!8m2!3d6.2733441!4d-75.5858178!16s%2Fg%2F120rs03z?entry=ttu"));

            }

            public void showMap(Uri geoLocation) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(String.valueOf(geoLocation)));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }

        });

        calendario.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                addEvent("", "",5,10);


            }

            public void addEvent(String title, String location, long begin, long end) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.Events.TITLE, title)
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }


        });

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