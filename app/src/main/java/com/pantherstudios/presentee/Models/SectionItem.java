package com.pantherstudios.presentee.Models;

public class SectionItem {
    public String name;
    public Section section;

    public SectionItem(String name, Section section) {
        this.name = name;
        this.section = section;
    }

    public String toString() {
        String toString = "";
        toString = "Name: " + name + " Product: " + section;
        return toString;
    }
}
