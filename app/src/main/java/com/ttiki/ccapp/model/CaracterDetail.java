package com.ttiki.ccapp.model;

import java.util.ArrayList;

public class CaracterDetail {
    int id;
    String name;
    boolean status;
    String species;
    String gender;
    String origin;
    String image;
    //ArrayList<Episode> eps;

    public CaracterDetail(int id, String name, boolean status, String species, String gender, String origin, String image) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.origin = origin;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive()
    {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public ArrayList<Episode> getEps() {
//        return eps;
//    }
//
//    public void setEps(ArrayList<Episode> eps) {
//        this.eps = eps;
//    }
}
