package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    LinearLayout linearLayout;
    ArrayList<Long> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        linearLayout = findViewById(R.id.linearLayout);
        numbers = new ArrayList<>();
        numbers.add(Long.parseLong("0"));
        numbers.add(Long.parseLong("1"));

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                TextView newText;
                newText = new TextView(view.getContext());

                long numberOne = numbers.get(numbers.size() - 1);
                long numberTwo = numbers.get(numbers.size() - 2);
                long answer = numberOne + numberTwo;

                String respuesta = String.valueOf(answer);

                newText.setText(respuesta);
                linearLayout.addView(newText);

                numbers.add(answer);

            }
        });
    }
}
