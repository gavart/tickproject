package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Action;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/** This class implement methods that are used to work with the entity {@link com.mycompany.tickproject.models.Action}
 * @author jenias
 * @version 1.0, 16/07/14
 */
@Repository
public class ActionDAOImpl implements ActionDAO {

    @Autowired
    public SessionFactory sessionFactory;
    /**
     * This method adds a new {@link com.mycompany.tickproject.models.Action} to the database
     *
     * @param action an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Override
    public void addAction(Action action) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.save(action);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method gets an object from the database by id and edits an information about {@link com.mycompany.tickproject.models.Action}
     *
     * @param action an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Override
    public void editAction(Action action) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.update(action);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Action}
     *
     * @param id id an object of {@link com.mycompany.tickproject.models.Action}
     * @return an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Override
    public Action getAction(int id) {
        Session session = sessionFactory.getCurrentSession();
        Action action = (Action) session.get(Action.class,id);
        return action;
    }

    /**
     * This method gets last added an object from the database and returns an object of {@link com.mycompany.tickproject.models.Action}
     *
     * @return an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Override
    public Action getLastAddedAction() {
        Session session = sessionFactory.getCurrentSession();
        Action action = (Action) session.createSQLQuery("SELECT * FROM Actions ORDER BY id DESC LIMIT 1").addEntity(Action.class).uniqueResult();
        return action;
    }

    /**
     * This method get actions from the database and return list with objects of {@link com.mycompany.tickproject.models.Action}
     *
     * @return list with objects of {@link com.mycompany.tickproject.models.Action}
     */
    @Override
    public List<Action> getActions() {
        Session session = sessionFactory.getCurrentSession();
        List<Action> actionList = (List<Action>) session.createSQLQuery("SELECT * FROM Actions WHERE isActive=true ORDER BY date_time_action").addEntity(Action.class).list();
        return actionList;
    }
}
