package com.example.permisosmapas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButtonCamara;
    ImageButton imageButtonContactos;
    ImageButton imageButtonMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonCamara = findViewById(R.id.imageButton);
        imageButtonContactos = findViewById(R.id.imageButton2);
        imageButtonMapa = findViewById(R.id.imageButton3);

        imageButtonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),CameraActivity.class));
            }
        });

        imageButtonContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), ContactsActivity.class));
            }
        });

        imageButtonMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),MapsActivity.class));
            }
        });
    }
}
