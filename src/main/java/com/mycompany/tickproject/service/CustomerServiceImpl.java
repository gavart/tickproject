package com.mycompany.tickproject.service;

import com.mycompany.tickproject.dao.FacadeDAO;
import com.mycompany.tickproject.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by apple on 26.07.14.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private FacadeDAO facadeDAO;
    /**
     * This method adds a new {@link com.mycompany.tickproject.models.Customer} to the database
     *
     * @param customer an object of {@link com.mycompany.tickproject.models.Customer}
     */
    @Transactional
    @Override
    public void addCustomer(Customer customer) {
        facadeDAO.getCustomerDAO().addCustomer(customer);
    }

    /**
     * This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Customer}
     *
     * @param id id by which to get the object of {@link com.mycompany.tickproject.models.Customer}
     * @return an object of {@link com.mycompany.tickproject.models.Customer}
     */
    @Transactional
    @Override
    public Customer getCustomer(int id) {
        return facadeDAO.getCustomerDAO().getCustomer(id);
    }

    /**
     * This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Customer}
     *
     * @param customer an object of {@link com.mycompany.tickproject.models.Customer}
     */
    @Transactional
    @Override
    public void editCustomer(Customer customer) {
        facadeDAO.getCustomerDAO().editCustomer(customer);
    }
}
