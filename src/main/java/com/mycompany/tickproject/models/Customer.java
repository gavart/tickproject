package com.mycompany.tickproject.models;

import javax.persistence.*;

/**
 * Created by apple on 27.06.14.
 */
@Entity
@Table(name = "Customers")
public class Customer {
    //properties
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    //getters
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //
}
