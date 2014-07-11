package com.mycompany.tickproject.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 10.07.14.
 */
public class SectionForm {

    private ArrayList<String> names;
    private ArrayList<String> descriptions;
    private ArrayList<String> stadiums;

    //Getter and setter methods
    public ArrayList<String> getNames(){
        return this.names;
    }

    public void setNames(ArrayList<String> sectionNames) {
        this.names = sectionNames;
    }

    //Getter and setter methods
    public ArrayList<String> getDescriptions() {
        return this.descriptions;
    }

    public void setDescriptions(ArrayList<String> descriptions) {
        this.descriptions = descriptions;
    }

    //Getter and setter methods
    public ArrayList<String> getStadiums() {
        return this.stadiums;
    }

    public void setStadiums(ArrayList<String> stadiums) {
        this.stadiums = stadiums;
    }
}
