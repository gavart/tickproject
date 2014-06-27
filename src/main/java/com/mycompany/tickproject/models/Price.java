package com.mycompany.tickproject.models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by apple on 27.06.14.
 */
@Entity
@Table(name = "Prices")
public class Price {
    //properties
    private int id;
    private BigDecimal price;
    private SectionOfStadium sectionOfStadium;
    private Action action;

    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }
    @ManyToOne
    @JoinColumn(name="section_of_stadium_id")
    public SectionOfStadium getSectionOfStadium() {
        return sectionOfStadium;
    }
    @ManyToOne
    @JoinColumn(name="action_id")
    public Action getAction() {
        return action;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSectionOfStadium(SectionOfStadium sectionOfStadium) {
        this.sectionOfStadium = sectionOfStadium;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
