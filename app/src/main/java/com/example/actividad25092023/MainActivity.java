package com.example.actividad25092023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button activity2,camara,  contacto, musica, google,alarma,llamada;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity2 = findViewById(R.id.activity2);
        camara = findViewById(R.id.camara);
        contacto = findViewById(R.id.contacto);
        musica = findViewById(R.id.musica);
        google = findViewById(R.id.google);
        alarma = findViewById(R.id.alarma);
        llamada = findViewById(R.id.llamar);





        camara.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                capturePhoto();

            }

            public void capturePhoto() {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    int REQUEST_IMAGE_CAPTURE = 0;
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                }
            }

        });

        contacto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                insertContact("Tareas","......");

            }

            public void insertContact(String name, String email) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
                intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }

        });

        musica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                playSearchArtist("");

            }

            public void playSearchArtist(String artist) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                        MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
                intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, artist);
                intent.putExtra(SearchManager.QUERY, artist);
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