package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Customer;

import java.util.List;

/** This interface provide methods that are used to work with the entity {@link com.mycompany.tickproject.models.Customer}
 * @author jenias
 * @version 1.0, 08/07/14
 */
public interface CustomerDAO {
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
    /** This method gets an object from the database by name,lastName and returns an object of {@link com.mycompany.tickproject.models.Customer}
     *
     * @param name field an object of {@link com.mycompany.tickproject.models.Customer#firstName}
     * @param lastName field an object of {@link com.mycompany.tickproject.models.Customer#lastName}
     * @return an object of {@link com.mycompany.tickproject.models.Customer}
     */
    public Customer getCustomerByNameLastName(String name, String lastName);


    /** This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Customer}
     *
     * @param customer an object of {@link com.mycompany.tickproject.models.Customer}
     */
    public void editCustomer(Customer customer);


    public List<Customer> findCustomerByNameLastName(String firstName,String lastName);
}
