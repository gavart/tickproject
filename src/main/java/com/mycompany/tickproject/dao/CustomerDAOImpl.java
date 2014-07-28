package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by apple on 26.07.14.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    public SessionFactory sessionFactory;
    /**
     * This method adds a new {@link com.mycompany.tickproject.models.Customer} to the database
     *
     * @param customer an object of {@link com.mycompany.tickproject.models.Customer}
     */
    @Override
    public void addCustomer(Customer customer) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.save(customer);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Customer}
     *
     * @param id id by which to get the object of {@link com.mycompany.tickproject.models.Customer}
     * @return an object of {@link com.mycompany.tickproject.models.Customer}
     */
    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.get(Customer.class,id);
        return customer;
    }

    /**
     * This method gets an object from the database by name,lastName and returns an object of {@link com.mycompany.tickproject.models.Customer}
     *
     * @param name     field an object of {@link com.mycompany.tickproject.models.Customer#firstName}
     * @param lastName field an object of {@link com.mycompany.tickproject.models.Customer#lastName}
     * @return an object of {@link com.mycompany.tickproject.models.Customer}
     */
    @Override
    public Customer getCustomerByNameLastName(String name, String lastName) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.createSQLQuery("SELECT * FROM Customers WHERE first_name='"+name+"' AND last_name ='"+lastName+"' Limit 1").addEntity(Customer.class).uniqueResult();
        return customer;
    }


    /** This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Customer}
     *
     * @param customer an object of {@link com.mycompany.tickproject.models.Customer}
     */
    @Override
    public void editCustomer(Customer customer){
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.update(customer);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    @Override
    public List<Customer> findCustomerByNameLastName(String firstName, String lastName) {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customers = (List<Customer>) session.createSQLQuery("Select * FROM Customers Where first_name LIKE '%"+firstName+"%' AND last_name LIKE '%"+lastName+"%' LIMIT 10").addEntity(Customer.class).list();
        return customers;
    }
}
