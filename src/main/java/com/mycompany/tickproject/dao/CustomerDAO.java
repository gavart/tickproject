package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Customer;

/** This interface provides methods that are used to work with the entity {@link com.mycompany.tickproject.models.Customer}
 * @author jenias
 * @version 1.0, 08/07/14
 */
public interface CustomerDAO {
    /** This method add new {@link com.mycompany.tickproject.models.Customer} to the database
     *
     * @param customer an object of {@link com.mycompany.tickproject.models.Customer}
     */
    public void addCustomer(Customer customer);

    /** This method get an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Customer}
     *
     * @param id id by which to get the object of {@link com.mycompany.tickproject.models.Customer}
     * @return an object of {@link com.mycompany.tickproject.models.Customer}
     */
    public Customer getCustomer(int id);

    /** This method get an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Customer}
     *
     * @param id id by which to get the object of {@link com.mycompany.tickproject.models.Customer}
     */
    public void editCustomer(int id);
}
