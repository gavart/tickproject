package com.mycompany.tickproject.models;

import javax.persistence.*;

/**
 * Created by apple on 27.06.14.
 */
@Entity
@Table(name = "Tickets")
public class Ticket {
    //properties
    private int id;
    private Action action;
    private Stadium stadium;
    private SectionOfStadium sectionOfStadium;
    private RowAndSeat rowAndSeat;
    private Status status;
    private Customer customer;

    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }
    @ManyToOne
    @JoinColumn(name="action_id")
    public Action getAction() {
        return action;
    }
    @ManyToOne
    @JoinColumn(name="stadium_id")
    public Stadium getStadium() {
        return stadium;
    }
    @ManyToOne
    @JoinColumn(name="section_of_stadium_id")
    public SectionOfStadium getSectionOfStadium() {
        return sectionOfStadium;
    }
    @ManyToOne
    @JoinColumn(name="row_and_seat_id")
    public RowAndSeat getRowAndSeat() {
        return rowAndSeat;
    }
    @ManyToOne
    @JoinColumn(name="status_id")
    public Status getStatus() {
        return status;
    }
    @ManyToOne
    @JoinColumn(name="customer_id")
    public Customer getCustomer() {
        return customer;
    }
    //setters


    public void setId(int id) {
        this.id = id;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public void setSectionOfStadium(SectionOfStadium sectionOfStadium) {
        this.sectionOfStadium = sectionOfStadium;
    }

    public void setRowAndSeat(RowAndSeat rowAndSeat) {
        this.rowAndSeat = rowAndSeat;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
