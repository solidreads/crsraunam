package com.example.seader.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Anahi Salgado", "725896474", "jas@gmail.com"));
        contactos.add(new Contacto("Pedro Salgado", "568888822", "fd@gmail.com"));
        contactos.add(new Contacto("Daniel Rivas", "555896474", "reads@gmail.com"));
        contactos.add(new Contacto("Arnulfo Martinez", "725896474", "cas@gmail.com"));
        contactos.add(new Contacto("Juan Colin", "345896474", "tyu@gmail.com"));


        ArrayList<String> nombresContacto = new ArrayList<>();
        for(Contacto contacto: contactos){
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        //intent inplicito comunicar dos actividades
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
            }
        });
    }
}
