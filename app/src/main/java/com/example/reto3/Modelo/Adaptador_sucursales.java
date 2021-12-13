package com.example.reto3.Modelo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reto3.R;

import java.util.ArrayList;

/**
 * Adaptar los datos manejados en entidad para ser mostrados en cada item de la lista
 */
public class Adaptador_sucursales extends BaseAdapter {

    ArrayList<Entidad> itemLista;
    Context context;
    ImageButton button5;

    public Adaptador_sucursales(ArrayList<Entidad> itemLista, Context context) {
        this.itemLista = itemLista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemLista.size(); //Devuelve el nùmero de itmes de la lista
    }

    @Override
    public Object getItem(int position) {
        return itemLista.get(position); //Devuelve el item que se està trabajando
    }

    @Override
    public long getItemId(int position) {
        return 0; //No lo vamos a trabajr por ahora
    }

    /**
     * En este mètodo se van a poner los valore que corresponden a cada item, y lo configuramos
     * de manera similar a los frgaments
     * @param position
     * @param v
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        Entidad datosItem = (Entidad) getItem(position);

        v = LayoutInflater.from(context).inflate(R.layout.item_sucursales, null);
        //**************************************

        ImageView imagen= (ImageView) v.findViewById(R.id.imagen_item_suc);
        TextView descripcion = (TextView) v.findViewById(R.id.descripcion_item_suc);


        /**

         Button boton1 =(Button) v.findViewById(R.id.boton1_item);
         CheckBox checkBox1 = (CheckBox) v.findViewById(R.id.favoritos_item);
         CheckBox checkBox2 = (CheckBox) v.findViewById(R.id.clasificacion_item);
         */

        /**
         * Pongo los datos de cada item desde la clase entidad dentro de cada elemento xml
         */
        imagen.setImageURI(datosItem.getImagen());
        descripcion.setText(datosItem.getNombre());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "dirección: " + descripcion.getText(), Toast.LENGTH_LONG).show();
            }
        });

        button5 = (ImageButton) v.findViewById(R.id.imageButton_item_suc);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Se dirige a google maps", Toast.LENGTH_SHORT).show();
            }
        });
        //***************************************
        return v;
    }
}
