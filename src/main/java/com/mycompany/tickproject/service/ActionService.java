package com.mycompany.tickproject.service;

import com.mycompany.tickproject.models.Action;

import java.util.List;

/** This interface provide methods that are used to work with the entity {@link com.mycompany.tickproject.models.Action} and with {@link com.mycompany.tickproject.dao.FacadeDAO} we gets necessary objects.
 * @author jenias
 * @version 1.0, 16/07/14
 */
public interface ActionService {
    /** This method adds a new {@link com.mycompany.tickproject.models.Action} to the database
     *
     * @param action an object of {@link com.mycompany.tickproject.models.Action}
     */
    public void addAction(Action action);

    /** This method gets an object from the database by id and edits an information about {@link com.mycompany.tickproject.models.Action}
     *
     * @param action an object of {@link com.mycompany.tickproject.models.Action}
     */
    public void editAction(Action action);

    /** This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Action}
     *
     * @param id id an object of {@link com.mycompany.tickproject.models.Action}
     * @return an object of {@link com.mycompany.tickproject.models.Action}
     */
    public Action getAction(int id);

    /** This method gets last added an object from the database and returns an object of {@link com.mycompany.tickproject.models.Action}
     *
     * @return an object of {@link com.mycompany.tickproject.models.Action}
     */
    public Action getLastAddedAction();

    /** This method get actions from the database and return list with objects of {@link com.mycompany.tickproject.models.Action}
     *
     * @return list with objects of {@link com.mycompany.tickproject.models.Action}
     */
    public List<Action> getActions();

    /** This method gets an object from the database by id and make it action not active
     *
     * @param id id an object of {@link com.mycompany.tickproject.models.Action}
     */
    public void makeNotActiveAction(int id);
}
