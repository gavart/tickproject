package com.mycompany.tickproject.models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by apple on 27.06.14.
 */
@Entity
@Table(name = "Actions_history")
public class ActionHistory {

    //properties
    private int id;
    private Action action;
    private int amountOfTicketsSold;
    private BigDecimal earnings;

    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }
    @ManyToOne
    @JoinColumn(name = "action_id")
    public Action getAction() {
        return action;
    }
    @Column(name = "amount_of_tickets_sold")
    public int getAmountOfTicketsSold() {
        return amountOfTicketsSold;
    }
    @Column(name = "earnings")
    public BigDecimal getEarnings() {
        return earnings;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setAmountOfTicketsSold(int amountOfTicketsSold) {
        this.amountOfTicketsSold = amountOfTicketsSold;
    }

    public void setEarnings(BigDecimal earnings) {
        this.earnings = earnings;
    }
}
