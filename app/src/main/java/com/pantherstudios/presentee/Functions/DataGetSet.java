package com.pantherstudios.presentee.Functions;

import android.app.Activity;

import com.pantherstudios.presentee.MainActivity;
import com.pantherstudios.presentee.Models.Section;
import com.pantherstudios.presentee.Models.SectionItem;

import java.util.ArrayList;

public class DataGetSet {

    // variables

    private static ArrayList<Section> arrayOfSections = new ArrayList<>();
    private static ArrayList<SectionItem> arrayOfSectionItems = new ArrayList<>();
    private static Section selectedSection;
    //static TinyDB tinyDB = new TinyDB(ApplContext.getAppContext());


    // methods

    public static ArrayList<SectionItem> getArrayOfSectionItems() {
        return arrayOfSectionItems;
    }

    public static void setArrayOfSectionItems(ArrayList<SectionItem> arrayOfSectionItems) {
        DataGetSet.arrayOfSectionItems = arrayOfSectionItems;
        ArrayList<Object> sectionItemObjects = new ArrayList<>();

        for(SectionItem p : arrayOfSectionItems) {
            sectionItemObjects.add((Object)p);
        }
        //tinyDB.putListObject("sectionItemList", sectionItemObjects);
    }

    public static void addSectionItem(SectionItem sectionItem) {
        arrayOfSectionItems.add(sectionItem);
        ArrayList<Object> sectionItemObjects = new ArrayList<>();

        for(SectionItem p : arrayOfSectionItems) {
            sectionItemObjects.add((Object)p);
        }
        //tinyDB.putListObject("sectionItemList", sectionItemObjects);
    }

    public ArrayList<Section> getArrayOfSections() {
        return arrayOfSections;
    }

    public void setArrayOfSections(ArrayList<Section> arrayOfSections) {
        this.arrayOfSections = arrayOfSections;
    }

    public static void addSection(Section section) {
        arrayOfSections.add(section);
        ArrayList<Object> sectionObjects = new ArrayList<>();

        for(Section p : arrayOfSections){
            sectionObjects.add((Object)p); // casting to raw objects
        }
        //tinyDB.putListObject("sectionList", sectionObjects);
    }

    public static void removeSection(Section section) {
        arrayOfSections.remove(section);

        ArrayList<Object> sectionObjects = new ArrayList<>();

        for(Section p : arrayOfSections){
            if(!p.equals(section)) {
                sectionObjects.add((Object) p); // casting to raw objects
            }
        }
        //tinyDB.putListObject("sectionList", sectionObjects);
    }

    public Section getSelectedSection() {
        return selectedSection;
    }

    public void setSelectedSection(Section selectedSection) {
        this.selectedSection = selectedSection;
    }



}
