package com.example.reto3.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import androidx.annotation.Nullable;

import com.example.reto3.Modelo.Adaptador_compras;
import com.example.reto3.Modelo.Entidad;
import com.example.reto3.Vista.fragment_compras;
import com.example.reto3.Vista.fragment_favoritos;


public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE productos (image TEXT, titulo TEXT, descripcion TEXT, precio TEXT)");
        db.execSQL("INSERT INTO productos VALUES ('android.resource://com.example.reto3/2131230817', 'chaqueta cuero 1', 'estoy aprendiendo sqlite jaja', '$ 45000 COP')");
        db.execSQL("INSERT INTO productos VALUES ('android.resource://com.example.reto3/2131230818', 'chaqueta cuero 2', 'estoy aprendiendo sqlite jeje', '$ 85000 COP')");
        db.execSQL("INSERT INTO productos VALUES ('android.resource://com.example.reto3/2131230819', 'chaqueta cuero 3', 'estoy aprendiendo sqlite jiji', '$ 30000 COP')");
        db.execSQL("INSERT INTO productos VALUES ('android.resource://com.example.reto3/2131230820', 'chaqueta cuero 4', 'estoy aprendiendo sqlite jojo', '$ 10000 COP')");

        db.execSQL("CREATE TABLE comprar (image TEXT, titulo TEXT, descripcion TEXT, precio TEXT)");
        fragment_compras fc =new fragment_compras();
        for(Entidad lista: fc.getListaItems() ){
            db.execSQL("INSERT INTO compras VALUES('"+lista.getImagen()+"', '"+lista.getNombre()+"', '"+lista.getReferencia()+"','"+lista.getPrecio()+"')");
        }

        db.execSQL("CREATE TABLE favoritos (image TEXT, titulo TEXT, descripcion TEXT, precio TEXT)");
        fragment_favoritos fg =new fragment_favoritos();
        for(Entidad lista:fg.getListaItems() ){
            db.execSQL("INSERT INTO favoritos VALUES('"+lista.getImagen()+"', '"+lista.getNombre()+"', '"+lista.getReferencia()+"','"+lista.getPrecio()+"')");
        }

        db.execSQL("CREATE TABLE sucursales (image TEXT, descripcion TEXT)");
        db.execSQL("INSERT INTO sucursales VALUES ('android.resource://com.example.reto3/2131230827', 'Av. Boyacá #17a-65, Bogotá  Horas:  lunes - martes - miércoles - jueves - viernes de 10:00a19:00, sábado -domingos 11:00a16:30')");
        db.execSQL("INSERT INTO sucursales VALUES ('android.resource://com.example.reto3/2131230828', 'Dirección: Cra. 7 #21-73, Bogotá   Horas:  lunes - martes - miércoles - jueves - viernes de 10:00a19:00, sábado -domingos 11:00a16:30')");
        db.execSQL("INSERT INTO sucursales VALUES ('android.resource://com.example.reto3/2131230829', '01, Av. Boyacá ##19, Bogotá   Horas:  lunes - martes - miércoles - jueves - viernes de 10:00a19:00, sábado -domingos 11:00a16:30')");
        db.execSQL("INSERT INTO sucursales VALUES ('android.resource://com.example.reto3/2131230830', 'Cra. 65 #11-50, Bogotá       Horas:  lunes - martes - miércoles - jueves - viernes de 10:00a19:00, sábado -domingos 11:00a16:30')");

        db.execSQL("CREATE TABLE servicios (image TEXT, titulo TEXT, descripcion TETX)");
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://com.example.reto3/2131230831', 'Domicilios','Domicilios de puerta a puerta, no tendrás la necesidad de desplazarte a nuestro establecimineto y además no tendrá un costo adicional.')");
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://com.example.reto3/2131230826', 'Devoluciones', 'Sabemos que a veces podemos tener dificultades con nuestros productos, por esta razón ofrecemos la posibilidad de de darte la devolución del producto que hayas comprado, además sin cargos adicionales.')");
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://com.example.reto3/2131230832', 'Entregas rapidas', 'Las compras que pidas por nuestro servicio de domicilio será entregado dentro de las primeras 24 horas desde que lo pidas, si tu domicilio no llega en ese rango de tiempo, te devolvemos tú dinero!')");
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://com.example.reto3/2131230808', 'Bonos', 'Sabemos que eres un cliente fiel a nuestros productos, por esta misma razón, si haces compras por un cierto período de tiempo,  te daremos bonos de fidelidad a la marca.')");

        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE productos");
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE comprar");
        db.execSQL("DROP TABLE sucursales");
        db.execSQL("DROP TABLE servicios");
        onCreate(db);
    }

    public void agregarProducto(SQLiteDatabase db, String imagen, String nombre, String ref, String precio){
        db.execSQL("INSERT INTO comprar VALUES('"+imagen+"', '"+nombre+"', '"+ref+"','"+precio+"')");
    }
    public void eliminar(SQLiteDatabase db, String nombre){
        db.execSQL("DELETE FROM favoritos WHERE titulo= '"+nombre+"'");
    }
}
