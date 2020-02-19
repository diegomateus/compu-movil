package com.example.fibonacci20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    Spinner spinner;
    Button button;
    Button buttonCountries;
    TextView textView;
    TextView textViewFactorial;
    TextView textViewFibonacci;
    int contFibonacci = 0;
    int contFactorial = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);
        button = findViewById(R.id.button);
        buttonCountries = findViewById(R.id.buttonCountries);
        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.numbers);
        textViewFactorial = findViewById(R.id.textViewOfFactorial);
        textViewFibonacci = findViewById(R.id.textViewOfFibonacci);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Main2Activity.class);
                startActivity(intent);
                contFibonacci++;

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = (String)spinner.getSelectedItem();
                int num = Integer.parseInt(number);
                int result = 1;

                for (int i = 1; i <= num; i++){
                    result = result * i;
                }

                textView.setText(String.valueOf(result));
                contFactorial++;
                textViewFactorial.setText(String.valueOf(contFactorial));
            }
        });

        buttonCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),CountriesActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        textViewFactorial = findViewById(R.id.textViewOfFactorial);
        textViewFibonacci = findViewById(R.id.textViewOfFibonacci);
        textViewFibonacci.setText(String.valueOf(contFibonacci));
        textViewFactorial.setText(String.valueOf(contFactorial));
    }
}
