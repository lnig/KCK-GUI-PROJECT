package com.example.kckgui.Model.Class;

public class familyMember {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public familyMember(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
