package com.example.reto3.Modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reto3.R;

import java.util.ArrayList;

/**
 * Adaptar los datos manejados en entidad para ser mostrados en cada item de la lista
 */
public class Adaptador_compras extends BaseAdapter {

    ArrayList<Entidad> itemLista;
    Context context;

    public Adaptador_compras(ArrayList<Entidad> itemLista, Context context) {
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

        v = LayoutInflater.from(context).inflate(R.layout.item_catalogo, null);
        //**************************************

        ImageView imagen = (ImageView) v.findViewById(R.id.imagen1_item_catalogo);
        TextView nombre = (TextView) v.findViewById(R.id.nombre_item_catalogo);
        TextView precio = (TextView) v.findViewById(R.id.precio_item_item_catalogo);
        TextView referencia = (TextView) v.findViewById(R.id.ref_item_catalogo);


        imagen.setImageURI(datosItem.getImagen());
        nombre.setText(datosItem.getNombre());
        referencia.setText(datosItem.getReferencia());
        precio.setText(datosItem.getPrecio());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "item: " + nombre.getText(), Toast.LENGTH_LONG).show();
            }
        });

    //***************************************
        return v;
    }

}
