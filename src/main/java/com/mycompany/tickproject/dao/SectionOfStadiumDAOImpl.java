package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.SectionOfStadium;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/** This class implement methods that are used to work with the entity {@link com.mycompany.tickproject.models.SectionOfStadium}
 * @author jenias
 * @version 1.0, 09/07/14
 */
@Repository
public class SectionOfStadiumDAOImpl implements SectionOfStadiumDAO {

    @Autowired
    public SessionFactory sessionFactory;

    /**
     * This method adds a new {@link com.mycompany.tickproject.models.SectionOfStadium} to the database
     *
     * @param sectionOfStadium an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Override
    public void addSectionOfStadium(SectionOfStadium sectionOfStadium) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.save(sectionOfStadium);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method add list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium} to the database
     *
     * @param listWithSectionsOfStadium list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Override
    public void addSectionsOfStadium(List<SectionOfStadium> listWithSectionsOfStadium) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            for(SectionOfStadium sectionOfStadium : listWithSectionsOfStadium) {
                session.save(sectionOfStadium);
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.SectionOfStadium}
     *
     * @param sectionOfStadium an object of {@link com.mycompany.tickproject.models.SectionOfStadium} with updated information
     */
    @Override
    public void editSectionOfStadium(SectionOfStadium sectionOfStadium) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.update(sectionOfStadium);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @return an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Override
    public SectionOfStadium getSectionOfStadium(int sectionId) {
        Session session = sessionFactory.getCurrentSession();
        SectionOfStadium sectionOfStadium = (SectionOfStadium) session.get(SectionOfStadium.class,sectionId);
        return sectionOfStadium;
    }

    /**
     * This method get sections of stadium from the database by id and return list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium}
     *
     * @param stadiumID id an object of {@link com.mycompany.tickproject.models.Stadium}
     * @return list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Override
    public List<SectionOfStadium> getSectionsOfStadium(int stadiumID) {
        Session session = sessionFactory.getCurrentSession();
        List<SectionOfStadium> sectionOfStadiumList = (List<SectionOfStadium>) session.createSQLQuery("SELECT * FROM Sections_of_stadium WHERE stadium_id =" +stadiumID).addEntity(SectionOfStadium.class).list();
        return sectionOfStadiumList;
    }

    /**
     * This method removes an object of {@link com.mycompany.tickproject.models.SectionOfStadium} from the database
     *
     * @param sectionOfStadium an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Override
    public void removeSectionOfStadium(SectionOfStadium sectionOfStadium) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(sectionOfStadium);
    }
}
