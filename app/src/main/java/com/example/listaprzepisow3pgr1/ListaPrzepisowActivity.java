package com.example.listaprzepisow3pgr1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaPrzepisowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_przepisow);
        int kat = getIntent().getExtras().getInt("Kategoria");
        //Toast.makeText(this, Integer.toString(kat), Toast.LENGTH_SHORT).show();
        ArrayList<Przepis> przepisy = RepozytoriumPrzepisow.wybierzPrzepisy(kat);

        ArrayAdapter<Przepis> adapterPrzepisow = new ArrayAdapter<>(
                ListaPrzepisowActivity.this,
                android.R.layout.simple_list_item_1,
                przepisy
        );

        ListView listViewPrzepisy = findViewById(R.id.listViewPrzepisy);
        listViewPrzepisy.setAdapter(adapterPrzepisow);

        AdapterView.OnItemClickListener wybranyPrzepis = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intencja = new Intent(ListaPrzepisowActivity.this,
                        PrzepisActivity.class);
                //do intencji dodać kliknięty przepis
                intencja.putExtra("kategoria",kat);
                intencja.putExtra("idprzepisu",i);
                Toast.makeText(ListaPrzepisowActivity.this,
                        przepisy.get(i).getNazwa(),
                        Toast.LENGTH_SHORT).show();
                startActivity(intencja);
            }
        };
        listViewPrzepisy.setOnItemClickListener(wybranyPrzepis);
    }
}