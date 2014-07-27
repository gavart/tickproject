package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Price;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by apple on 19.07.14.
 */
@Repository
public class PriceDAOImpl implements PriceDAO {

    @Autowired
    public SessionFactory sessionFactory;
    /**
     * This method adds a new {@link com.mycompany.tickproject.models.Price} for certain section and action to the database
     *
     * @param price an object of {@link com.mycompany.tickproject.models.Price}
     */
    @Override
    public void addPrice(Price price) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.createSQLQuery("INSERT INTO Prices (price, section_of_stadium_id, action_id, date_price) VALUES ("+ price.getPrice() +", "+price.getSectionOfStadium().getId()+", "+price.getAction().getId()+", CURRENT_TIMESTAMP)").executeUpdate();
            //session.save(price);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method adds a new {@link com.mycompany.tickproject.models.Price} for certain section and action to the database
     *
     * @param prices list with objects of {@link com.mycompany.tickproject.models.Price}
     */
    @Override
    public void addPrices(List<Price> prices) {

    }

    /**
     * This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Price}
     *
     * @param price an object of {@link com.mycompany.tickproject.models.Price}
     */
    @Override
    public void editPrice(Price price) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.update(price);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }


    /**
     * This method get list with objects from the database by action id and edit information about {@link com.mycompany.tickproject.models.Price}
     *
     * @param actionId id an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Override
    public void editPrices(int actionId) {

    }

    /**
     * This method gets an object of {@link com.mycompany.tickproject.models.Price} from the database by sectionId and actionId
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @param actionId  id an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Override
    public Price getActualPrice(int sectionId, int actionId) {
        Session session = sessionFactory.getCurrentSession();
        Price price = (Price) session.createSQLQuery("SELECT * From Prices Where section_of_stadium_id = " + sectionId + " AND action_id = " + actionId + " AND (date_price <= NOW()) ORDER BY date_price DESC LIMIT 1").addEntity(Price.class).uniqueResult();
        return price;
    }

    /**
     * This method get objects of {@link com.mycompany.tickproject.models.Price} from the database by id an object of {@link com.mycompany.tickproject.models.Action} and return list with objects of {@link com.mycompany.tickproject.models.Price}
     *
     * @param actionId id an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Override
    public List<Price> getPrices(int actionId) {
        Session session = sessionFactory.getCurrentSession();
        List<Price> prices = session.createSQLQuery("SELECT  * FROM Prices WHERE action_id="+ actionId +" AND (date_price <= NOW()) GROUP BY section_of_stadium_id ").addEntity(Price.class).list();
        return prices;
    }
}
