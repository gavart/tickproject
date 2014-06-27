package com.mycompany.tickproject.models;

import javax.persistence.*;

/**
 * Created by apple on 27.06.14.
 */

@Entity
@Table(name = "Statuses")
public class Status {

    //properties
    private int id;
    private String Status;

    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }
    @Column(name = "status")
    public String getStatus() {
        return Status;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
