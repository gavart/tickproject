package com.mycompany.tickproject.service;

import com.mycompany.tickproject.dao.ActionDAO;
import com.mycompany.tickproject.dao.FacadeDAO;
import com.mycompany.tickproject.models.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** This class implement methods that are used to work with the entity {@link com.mycompany.tickproject.models.Action} and with {@link com.mycompany.tickproject.dao.FacadeDAO} we gets necessary objects.
 * @author jenias
 * @version 1.0, 16/07/14
 */
@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private FacadeDAO facadeDAO;
    /**
     * This method adds a new {@link com.mycompany.tickproject.models.Action} to the database
     *
     * @param action an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Transactional
    @Override
    public void addAction(Action action) {
        facadeDAO.getActionDAO().addAction(action);
    }

    /**
     * This method gets an object from the database by id and edits an information about {@link com.mycompany.tickproject.models.Action}
     *
     * @param action an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Transactional
    @Override
    public void editAction(Action action) {
        facadeDAO.getActionDAO().editAction(action);
    }

    /**
     * This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Action}
     *
     * @param id id an object of {@link com.mycompany.tickproject.models.Action}
     * @return an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Transactional
    @Override
    public Action getAction(int id) {
        return facadeDAO.getActionDAO().getAction(id);
    }

    /**
     * This method gets last added an object from the database and returns an object of {@link com.mycompany.tickproject.models.Action}
     *
     * @return an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Transactional
    @Override
    public Action getLastAddedAction() {
        return facadeDAO.getActionDAO().getLastAddedAction();
    }

    /**
     * This method get actions from the database and return list with objects of {@link com.mycompany.tickproject.models.Action}
     *
     * @return list with objects of {@link com.mycompany.tickproject.models.Action}
     */
    @Transactional
    @Override
    public List<Action> getActions() {
        return facadeDAO.getActionDAO().getActions();
    }
}
