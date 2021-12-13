package com.example.reto3.Vista;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.reto3.Modelo.Adaptador_catalogo;
import com.example.reto3.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto3.Modelo.Entidad;
import com.example.reto3.R;

import java.util.ArrayList;

public class fragment_productos extends Fragment {

    GridView listaProductos;
    View v;
    Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_productos, container, false);
        //***************************************************

        listaProductos = (GridView) v.findViewById(R.id.lista_catalogo);
        Adaptador_catalogo adapter = new Adaptador_catalogo(getListaItems_conSQL(), getContext());

        listaProductos.setAdapter(adapter);

        //***************************************************

        return v;
    }

    private ArrayList<Entidad> getListaItems_conSQL() {
        MotorBaseDatosSQLite conectar = new MotorBaseDatosSQLite(getContext(), "TiendaDecal12", null, 1);
        ArrayList<Entidad>listaItems = new ArrayList<>();
        SQLiteDatabase db_leer = conectar.getReadableDatabase();

        conectar.onUpgrade(db_leer, 1, 2);
        cursor = db_leer.rawQuery("SELECT * FROM productos", null);

        while(cursor.moveToNext()){
            listaItems.add(new Entidad(Uri.parse(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }

        return listaItems;
    }


}