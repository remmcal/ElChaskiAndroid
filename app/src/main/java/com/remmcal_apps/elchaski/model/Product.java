package com.remmcal_apps.elchaski.model;

import java.io.Serializable;

/**
 * Creado por Ángel Quino Chipana  en 15/noviembre/2018
 * dangerouslapaz@gmail.com
 * +591 78812425 - +591 68092193
 * La Paz, Bolivia
 */
public class Product implements Serializable{
    String id,name,photo,details;
    Double price;
    int quantity;
    boolean state;
    public Product(){

    }

    public Product(String id, String name, String photo, String details,Double price, int quantity, boolean state) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.details = details;
        this.price=price;
        this.quantity =quantity;
        this.state=state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
