package com.remmcal_apps.elchaski.model;

import java.io.Serializable;

/**
 * Creado por Ángel Quino Chipana  en 02/enero/2019
 * dangerouslapaz@gmail.com
 * +591 78812425 - +591 68092193
 * La Paz, Bolivia
 */
public class Pedido implements Serializable {
    String id, nombreRestaurant, nombre, detalle;
    double precio;
    double precioEnvio;

    public Pedido(String id, String nombreRestaurant, String nombre, String detalle, double precio, int precioEnvio) {
        this.id = id;
        this.nombreRestaurant = nombreRestaurant;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.precioEnvio = precioEnvio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreRestaurant() {
        return nombreRestaurant;
    }

    public void setNombreRestaurant(String nombreRestaurant) {
        this.nombreRestaurant = nombreRestaurant;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }


}