package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    String peticion;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.edit_text);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                editText = findViewById(R.id.edit_text);
                peticion = editText.getText().toString();
                count = Integer.parseInt(peticion);
                Intent intent = new Intent(view.getContext(),Main2Activity.class);
                intent.putExtra("value",count);
                startActivity(intent);

            }
        });
    }
}
