package com.example.reto3.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import com.example.reto3.Modelo.Adaptador_favoritos;
import com.example.reto3.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto3.Modelo.Entidad;
import com.example.reto3.R;
import java.util.ArrayList;

public class fragment_favoritos extends Fragment {

    GridView listFav;
    View v;
    Cursor cursor;
    ArrayList<Entidad>listaItems = new ArrayList<>();

    public ArrayList<Entidad> getListaItems() {
        return listaItems;
    }

    public void setListaItems(ArrayList<Entidad> listaItems) {
        this.listaItems = listaItems;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_favoritos, container, false);
        //*********************************
        listFav= (GridView) v.findViewById(R.id.lista_favoritos);
        Adaptador_favoritos adapter = new Adaptador_favoritos(getListaItems_conSQL(), getContext());

        listFav.setAdapter(adapter);

        //*********************************
        return v;
    }

    public ArrayList<Entidad> getListaItems_conSQL() {
        MotorBaseDatosSQLite conectar = new MotorBaseDatosSQLite(getContext(), "TiendaDecal12", null, 1);

        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        cursor = db_leer.rawQuery("SELECT * FROM favoritos", null);

        while(cursor.moveToNext()){
            listaItems.add(new Entidad(Uri.parse(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }
        conectar.onUpgrade(db_leer, 1, 2);
        return listaItems;
    }
}