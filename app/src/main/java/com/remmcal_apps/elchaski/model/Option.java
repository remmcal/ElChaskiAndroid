package com.remmcal_apps.elchaski.model;

import java.io.Serializable;

/**
 * Creado por Ángel Quino Chipana  en 22/noviembre/2018
 * dangerouslapaz@gmail.com
 * +591 78812425 - +591 68092193
 * La Paz, Bolivia
 */
public class Option implements Serializable {
    String name,photo;
    boolean state;
    public Option(){

    }
    public Option(String name, String photo, boolean state) {
        this.name = name;
        this.photo = photo;
        this.state = state;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
