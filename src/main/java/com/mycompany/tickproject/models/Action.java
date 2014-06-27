package com.mycompany.tickproject.models;



import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

/**
 * Created by apple on 27.06.14.
 */
@Entity
@Table(name = "Actions")
public class Action {

    //properties
    private int id;
    private String nameAction;
    private Date dateAction;
    private Time timeAction;
    private Stadium stadium;
    private boolean isActive;

    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getActionID() {
        return this.id;
    }

    @Column(name = "name_action")
    public String getNameAction() {
        return this.nameAction;
    }

    @Column(name = "date_action")
    public Date getDateAction() {
        return this.dateAction;
    }

    @Column(name = "time_action")
    public Time getTimeAction() {
        return this.timeAction;
    }

    @ManyToOne
    @JoinColumn(name="stadium_id")
    public Stadium getStadiumID() {
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

    public void setDateAction(Date dateAction) {
        this.dateAction = dateAction;
    }

    public void setTimeAction(Time timeAction) {
        this.timeAction = timeAction;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
