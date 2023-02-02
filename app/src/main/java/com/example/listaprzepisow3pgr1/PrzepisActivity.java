package com.example.listaprzepisow3pgr1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PrzepisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przepis);
        int kat = getIntent().getExtras().getInt("kategoria");
        int indeks = getIntent().getExtras().getInt("idprzepisu");
        Przepis przepis = RepozytoriumPrzepisow.wybierzPrzepisy(kat).get(indeks);

    }
}