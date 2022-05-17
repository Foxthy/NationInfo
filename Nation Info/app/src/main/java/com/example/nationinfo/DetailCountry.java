package com.example.nationinfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailCountry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_country);
       Intent intent = getIntent();
      Country country = (Country) intent.getSerializableExtra("data");
        Log.d("bc","name: "+country.getCountryName());



        TextView countryname = (TextView) findViewById(R.id.setname);
        ImageView logo = (ImageView) findViewById(R.id.imglogo);
        ImageView map = (ImageView) findViewById(R.id.setmap);
        TextView population = (TextView) findViewById(R.id.setpopulation);
        TextView area = (TextView) findViewById(R.id.setarea);


        countryname.setText(country.getCountryName());
        logo.setImageBitmap(country.getLogobitmap());
        map.setImageBitmap(country.getMapbitmap());
        population.setText(country.getPopulation());
        area.setText(country.getAreaInSqKm());
    }
}
