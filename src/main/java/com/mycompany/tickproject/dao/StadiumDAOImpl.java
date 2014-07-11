package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Stadium;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/** This class implement methods that are used to work with the entity {@link com.mycompany.tickproject.models.Stadium}
 * @author jenias
 * @version 1.0, 09/07/14
 */
@Repository
public class StadiumDAOImpl implements StadiumDAO {

    @Autowired
    public SessionFactory sessionFactory;

    /**
     * This method adds a new {@link com.mycompany.tickproject.models.Stadium} to the database
     *
     * @param stadium an object of {@link com.mycompany.tickproject.models.Stadium}
     */
    @Override
    public void addStadium(Stadium stadium) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.save(stadium);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Stadium}
     *
     * @param stadium an object of {@link com.mycompany.tickproject.models.Stadium} with updated information
     */
    @Override
    public void editStadium(Stadium stadium) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.update(stadium);
            //String query = "UPDATE nStadium SET ame='" + stadium.getName() + "', description='" + stadium.getDescription() + "', amountOfSeats=" + stadium.getAmountOfSeats() + " WHERE id=" + stadium.getId();
            //session.createQuery(query);
            //session.update(stadium);

        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Stadium}
     *
     * @param id id by which to get the object of {@link com.mycompany.tickproject.models.Stadium}
     * @return an object of {@link com.mycompany.tickproject.models.Stadium}
     */
    @Override
    public Stadium getStadium(int id) {
        Session session = sessionFactory.getCurrentSession();
        Stadium stadium = (Stadium) session.get(Stadium.class,id);
        return stadium;
    }

    /**
     * This method get objects of {@link com.mycompany.tickproject.models.Stadium} from the database and return list with objects of {@link com.mycompany.tickproject.models.Stadium}
     *
     * @return list with objects of {@link com.mycompany.tickproject.models.Stadium}
     */
    @Override
    public List<Stadium> getStadiums() {
        Session session = sessionFactory.getCurrentSession();
        List<Stadium> sectionOfStadiumList = (List<Stadium>) session.createSQLQuery("SELECT * FROM Stadiums").addEntity(Stadium.class).list();
        return sectionOfStadiumList;
    }

}
