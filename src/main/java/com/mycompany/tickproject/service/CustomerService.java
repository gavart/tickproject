package com.mycompany.tickproject.service;

import com.mycompany.tickproject.models.Customer;

/**
 * Created by apple on 26.07.14.
 */
public interface CustomerService {
    /** This method adds a new {@link com.mycompany.tickproject.models.Customer} to the database
     *
     * @param customer an object of {@link com.mycompany.tickproject.models.Customer}
     */
    public void addCustomer(Customer customer);

    /** This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Customer}
     *
     * @param id id by which to get the object of {@link com.mycompany.tickproject.models.Customer}
     * @return an object of {@link com.mycompany.tickproject.models.Customer}
     */
    public Customer getCustomer(int id);

    /** This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Customer}
     *
     * @param customer an object of {@link com.mycompany.tickproject.models.Customer}
     */
    public void editCustomer(Customer customer);
}
