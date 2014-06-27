package com.mycompany.tickproject.models;

import javax.persistence.*;

/**
 * Created by apple on 27.06.14.
 */
@Entity
@Table(name = "Sections_of_stadium")
public class SectionOfStadium {

    //properties
    private int id;
    private String name;
    private String description;
    private Stadium stadium;



    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    @ManyToOne
    @JoinColumn(name="stadium_id")
    public Stadium getStadium() {
        return stadium;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
