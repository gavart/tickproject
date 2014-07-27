package com.mycompany.tickproject.models;



import javax.persistence.*;
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
    private Timestamp startDateTimeAction;
    private Timestamp endDateTimeAction;
    private Timestamp timeLimitBooking;
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

    @Column(name = "start_date_time_action")
    public Timestamp getStartDateTimeAction() {
        return this.startDateTimeAction;
    }

    @Column(name = "end_date_time_action")
    public Timestamp getEndDateTimeAction() {
        return endDateTimeAction;
    }

    @Column(name = "time_limit_booking")
    public Timestamp getTimeLimitBooking() {
        return timeLimitBooking;
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

    public void setStartDateTimeAction(Timestamp dateTimeAction) {
        this.startDateTimeAction = dateTimeAction;
    }

    public void setEndDateTimeAction(Timestamp endDateTimeAction) {
        this.endDateTimeAction = endDateTimeAction;
    }

    public void setTimeLimitBooking(Timestamp timeLimitBooking) {
        this.timeLimitBooking = timeLimitBooking;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
