package com.example.fibonacci20;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);
        textView3 = findViewById(R.id.textView4);
        textView4 = findViewById(R.id.textView5);

        textView1.setText("Nombre: " + getIntent().getStringExtra("nombre"));
        textView2.setText("Nombre internacional: " + getIntent().getStringExtra("nombre_int"));
        textView3.setText("Capital: " + getIntent().getStringExtra("capital"));
        textView4.setText("Sigla: " + getIntent().getStringExtra("sigla"));
    }
}
