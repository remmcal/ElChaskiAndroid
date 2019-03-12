package com.remmcal_apps.elchaski.model;

/**
 * Creado por Ángel Quino Chipana  en 24/noviembre/2018
 * dangerouslapaz@gmail.com
 * +591 78812425 - +591 68092193
 * La Paz, Bolivia
 */
public class SelectableItem {
    private String name;
    private String photo;
    private boolean isSelected = false;
    private boolean cabecera=false;
    public SelectableItem(){

    }
    public SelectableItem(String name, String photo) {
        this.name = name;
        this.photo = photo;
        this.isSelected = false;
    }
    public SelectableItem(String name, String photo, boolean isSelected) {
        this.name = name;
        this.photo = photo;
        this.isSelected = isSelected;
    }

    public SelectableItem(String name, String photo, boolean isSelected, boolean cabecera) {
        this.name = name;
        this.photo = photo;
        this.isSelected = isSelected;
        this.cabecera = cabecera;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        SelectableItem itemCompare = (SelectableItem) obj;
        if(itemCompare.getName().equals(this.getName()))
            return true;

        return false;
    }

    public boolean isCabecera() {
        return cabecera;
    }

    public void setCabecera(boolean cabecera) {
        this.cabecera = cabecera;
    }
}