package com.example.reto3.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.reto3.Modelo.Adaptador_sucursales;
import com.example.reto3.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto3.Modelo.Entidad;
import com.example.reto3.R;

import java.util.ArrayList;

public class fragment_sucursales extends Fragment {

    ListView listaSucursales;
    View v;
    Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_sucursales, container, false);
        //***************************************************

        listaSucursales = (ListView) v.findViewById(R.id.lista_sucursales);
        Adaptador_sucursales adapter = new Adaptador_sucursales(getListaItems_conSQL(), getContext());

        listaSucursales.setAdapter(adapter);


        //***************************************************
        return v;
    }

    private ArrayList<Entidad> getListaItems_conSQL() {
        ArrayList<Entidad>listaItems = new ArrayList<>();
        MotorBaseDatosSQLite conectar = new MotorBaseDatosSQLite(getContext(), "TiendaDecal12", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        conectar.onUpgrade(db_leer, 1, 2);
        cursor = db_leer.rawQuery("SELECT * FROM sucursales", null);

        while(cursor.moveToNext()){
            listaItems.add(new Entidad(Uri.parse(cursor.getString(0)), cursor.getString(1)));
        }

        return listaItems;
    }
}