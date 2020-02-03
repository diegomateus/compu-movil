package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    String serie;
    StringTokenizer token;
    int nDatos;
    int answer;
    int[] datos;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                textView = findViewById(R.id.textView);
                serie = textView.getText().toString();
                token = new StringTokenizer(serie, ",");
                nDatos = token.countTokens();
                datos = new int[1000];
                a = 0;

                for(int i = 0; token.hasMoreTokens(); i++){
                    String str = token.nextToken();
                    datos[i] = Integer.valueOf(str);
                    a = i;
                }

                answer = datos[a] + datos[a-1];

                textView.setText(serie + "," + answer);
            }
        });
    }
}
