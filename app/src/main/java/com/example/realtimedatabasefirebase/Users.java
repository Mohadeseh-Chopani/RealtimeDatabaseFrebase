package com.example.realtimedatabasefirebase;

public class Users {

    String name,family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Users(String name, String family) {
        this.name = name;
        this.family = family;
    }
}
