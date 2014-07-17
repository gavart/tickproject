package com.mycompany.tickproject.models;



import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by apple on 27.06.14.
 */
@Entity
@Table(name = "Actions")
public class Action {

    //properties
    private int id;
    private String nameAction;
    private Timestamp dateTimeAction;
    private Stadium stadium;
    private boolean isActive;

    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return this.id;
    }

    @Column(name = "name_action")
    public String getNameAction() {
        return this.nameAction;
    }

    @Column(name = "date_time_action")
    public Timestamp getDateTimeAction() {
        return this.dateTimeAction;
    }

    @ManyToOne
    @JoinColumn(name="stadium_id")
    public Stadium getStadium() {
        return this.stadium;
    }

    @Column(name = "isActive")
    public boolean getIsActive() {
        return this.isActive;
    }



    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNameAction(String nameAction) {
        this.nameAction = nameAction;
    }

    public void setDateTimeAction(Timestamp dateTimeAction) {
        this.dateTimeAction = dateTimeAction;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
