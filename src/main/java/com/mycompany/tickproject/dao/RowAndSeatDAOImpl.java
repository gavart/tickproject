package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.RowAndSeat;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/** This class implement methods that are used to work with the entity {@link com.mycompany.tickproject.models.RowAndSeat}
 * @author jenias
 * @version 1.0, 09/07/14
 */
@Repository
public class RowAndSeatDAOImpl implements RowAndSeatDAO {

    @Autowired
    public SessionFactory sessionFactory;

    /**
     * This method adds a new {@link com.mycompany.tickproject.models.RowAndSeat} to the database
     *
     * @param rowAndSeat an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    @Override
    public void addRowAndSeat(RowAndSeat rowAndSeat) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.save(rowAndSeat);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /** This method add list with objects of {@link com.mycompany.tickproject.models.RowAndSeat} from file to the database
     *
     * @param listWithRowsAndSeats list with objects of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    @Override
    public void addRowsAndSeatsFromFile(List<RowAndSeat> listWithRowsAndSeats) {
        Session session = null;
        try {

            for(RowAndSeat rowAndSeat : listWithRowsAndSeats) {
                session = sessionFactory.getCurrentSession();
                session.save(rowAndSeat);
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method get objects of {@link com.mycompany.tickproject.models.RowAndSeat} from the database by id an object of {@link com.mycompany.tickproject.models.SectionOfStadium} and return list with objects of {@link com.mycompany.tickproject.models.RowAndSeat}
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Override
    public List<RowAndSeat> getRowsAndSeats(int sectionId) {
        Session session = sessionFactory.getCurrentSession();
        List<RowAndSeat> rowAndSeatList = (List<RowAndSeat>) session.createSQLQuery("SELECT * FROM Rows_and_seats WHERE section_of_stadium_id=" +sectionId).addEntity(RowAndSeat.class).list();
        return rowAndSeatList;
    }
}
