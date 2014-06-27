package com.mycompany.tickproject.models;

import javax.persistence.*;

/**
 * Created by apple on 27.06.14.
 */
@Entity
@Table(name = "Stadiums")
public class Stadium {

    //properties
    private int id;
    private String name;
    private String description;
    private int amountOfSeats;

    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return this.id;
    }
    @Column(name = "name")
    public String getName() {
        return this.name;
    }
    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }
    @Column(name = "amount_of_seats")
    public int getAmountOfSeats() {
        return this.amountOfSeats;
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

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }
}
