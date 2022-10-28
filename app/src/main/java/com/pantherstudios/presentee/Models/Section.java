package com.pantherstudios.presentee.Models;

public class Section {

    public String name;

    public Section(String name) {
        this.name = name;
    }

    public String toString() {
        String toString = "";
        toString = "Name: " + name;
        return toString;
    }

}
