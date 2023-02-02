package com.example.listaprzepisow3pgr1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listaViewKategorie);
        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intencja = new Intent(MainActivity.this,
                        ListaPrzepisowActivity.class);
                intencja.putExtra("Kategoria",i);
                startActivity(intencja);
                String kategoria = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, kategoria, Toast.LENGTH_SHORT).show();
            }
        };
        listView.setOnItemClickListener(clickListener);

        ArrayList<String> slowa = new ArrayList<>();
        slowa.add("podlać kwiaty");
        slowa.add("wyprowadzić psa");
        slowa.add("wyczesać psa");
        slowa.add("schować do zmywarki");


        ArrayAdapter<String> slowaAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                slowa
        );
        ListView listView2 = findViewById(R.id.listViewDynamicznie);
        listView2.setAdapter(slowaAdapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText editText = findViewById(R.id.editText);
                        String wpisanyTekst = editText.getText().toString();
                        slowa.add(wpisanyTekst);
                        slowaAdapter.notifyDataSetChanged();
                    }
                }
        );
        AdapterView.OnItemClickListener kliknieteSlowo = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, slowa.get(i), Toast.LENGTH_SHORT).show();
                slowa.remove(i);
                slowaAdapter.notifyDataSetChanged();
            }
        };
        listView2.setOnItemClickListener(kliknieteSlowo);

    }
}