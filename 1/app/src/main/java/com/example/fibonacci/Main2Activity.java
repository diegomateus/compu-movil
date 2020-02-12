package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList <Integer>fibonacci;
    LinearLayout linearLayout;
    ScrollView scrollView;

    int num;
    int dato1;
    int dato2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fibonacci = new ArrayList<>();
        linearLayout = findViewById(R.id.linear);
        scrollView = findViewById(R.id.scrollView);
        num = getIntent().getIntExtra("value",0);
        fibonacci.add(0);
        fibonacci.add(1);

        int resp;

        for(int i = 0; i < num; i++) {
            if (i >= 2) {
                dato1 = fibonacci.get(fibonacci.size() - 1);
                dato2 = fibonacci.get(fibonacci.size() - 2);
                resp = dato1 + dato2;
                fibonacci.add(resp);
                TextView textView = new TextView(this);
                String pasar = String.valueOf(resp);
                textView.setText(pasar);
                linearLayout.addView(textView);
            }
            else{
                TextView textView = new TextView(this);
                String pasar = String.valueOf(fibonacci.get(i));
                textView.setText(pasar);
                linearLayout.addView(textView);
            }
        }
    }
}
