package com.mycompany.tickproject.models;

import javax.persistence.*;

/**
 * Created by apple on 27.06.14.
 */
@Entity
@Table(name = "Rows_and_seats")
public class RowAndSeat {
    //properties
    private int id;
    private SectionOfStadium sectionOfStadium;
    private int row;
    private int seat;

    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }
    @ManyToOne
    @JoinColumn(name="section_of_stadium_id")
    public SectionOfStadium getSectionOfStadium() {
        return sectionOfStadium;
    }
    @Column(name = "row")
    public int getRow() {
        return row;
    }
    @Column(name = "seat")
    public int getSeat() {
        return seat;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setSectionOfStadium(SectionOfStadium sectionOfStadium) {
        this.sectionOfStadium = sectionOfStadium;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
