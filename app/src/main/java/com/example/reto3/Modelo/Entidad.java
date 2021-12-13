package com.example.reto3.Modelo;

import android.net.Uri;

/**
 * Administrar los datos de las listas
 */
public class Entidad {

    Uri imagen;
    String nombre;
    String referencia;
    String precio;

    public Entidad(Uri imagen, String nombre, String referencia, String precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.referencia = referencia;
        this.precio = precio;
    }

    public Entidad(Uri imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public Entidad(Uri imagen, String nombre, String referencia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.referencia = referencia;
    }

    public Uri getImagen() {
        return imagen;
    }

    public void setImagen(Uri imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
