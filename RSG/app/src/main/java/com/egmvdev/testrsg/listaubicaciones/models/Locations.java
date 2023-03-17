package com.egmvdev.testrsg.listaubicaciones.models;

import java.io.Serializable;

public class Locations implements Serializable {
    private String name;
    private String type;
    private int estado;

    public Locations(String name, String type) {
        this.name = name;
        this.type = type;
        estado = 0;
    }

    public String imprimirValores() {
        return "Nombre: " + name + "Type: " + type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
