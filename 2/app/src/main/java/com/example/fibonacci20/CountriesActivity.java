package com.example.fibonacci20;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CountriesActivity extends AppCompatActivity {

    ArrayList<Countries> countries;
    String[] arreglo;
    Countries countrie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        countries = new ArrayList<>();

        try {

            JSONObject json = new JSONObject(loadJSONFromAsset());
            JSONArray paisesJsonArray = json.getJSONArray("paises");

            for (int i = 0; i < paisesJsonArray.length(); i++) {
                JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
                String capital = jsonObject.getString("capital");
                String name = jsonObject.getString("nombre_pais");
                String nameInt = jsonObject.getString("nombre_pais_int");
                String sigla = jsonObject.getString("sigla");

                countrie = new Countries(capital, name, nameInt, sigla);
                countries.add(countrie);

            }
        }
         catch (JSONException e) {
            e.printStackTrace();
        }


        initArray();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arreglo);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(adapterView.getContext(),DetailActivity.class);
                intent.putExtra("nombre",countries.get(i).getName());
                intent.putExtra("nombre_int",countries.get(i).getInternationalName());
                intent.putExtra("capital",countries.get(i).getCapital());
                intent.putExtra("sigla",countries.get(i).getSigla());
                startActivity(intent);
            }
        });
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void initArray() {

        arreglo = new String[25];

        for (int i = 0; i < countries.size(); i++) {
            arreglo[i] = countries.get(i).getName();
        }
    }

}
