package com.remmcal_apps.elchaski.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Creado por Ángel Quino Chipana  en 16/noviembre/2018
 * dangerouslapaz@gmail.com
 * +591 78812425 - +591 68092193
 * La Paz, Bolivia
 */
public class Restaurant implements Serializable {
    String id,name,photo,horary,type;
    boolean state;
    ArrayList<Plato> platillos=new ArrayList<>();
    public Restaurant(){

    }
    public Restaurant(String id, String name, String photo, String horary, String type, boolean state) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.horary = horary;
        this.type = type;
        this.state=state;
    }

    public Restaurant(String id, String name, String photo, String horary, String type, boolean state, ArrayList<Plato> platillos) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.horary = horary;
        this.type = type;
        this.state = state;
        this.platillos = platillos;
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

    public String getHorary() {
        return horary;
    }

    public void setHorary(String horary) {
        this.horary = horary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ArrayList<Plato> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(ArrayList<Plato> platillos) {
        this.platillos = platillos;
    }
}
