package com.egmvdev.testrsg.listaubicaciones.models;

import java.io.Serializable;

public class Products implements Serializable {
    private String name;
    private int weight;
    private int volume;
    private double ss;

    public Products(String name, int weight, int volume) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        ss = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getSs() {
        return ss;
    }

    public void setSs(double ss) {
        this.ss = ss;
    }
}
