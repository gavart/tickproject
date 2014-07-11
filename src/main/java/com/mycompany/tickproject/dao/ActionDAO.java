package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Action;

import java.util.List;

/** This interface provide methods that are used to work with the entity {@link com.mycompany.tickproject.models.Action}
 * @author jenias
 * @version 1.0, 04/07/14
 */

public interface ActionDAO {
    /** This method adds a new {@link com.mycompany.tickproject.models.Action} to the database
     *
     * @param action an object of {@link com.mycompany.tickproject.models.Action}
     */
    public void addAction(Action action);

    /** This method gets an object from the database by id and edits an information about {@link com.mycompany.tickproject.models.Action}
     *
     * @param id id an object of {@link com.mycompany.tickproject.models.Action}
     */
    public void editAction(int id);

    /** This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Action}
     *
     * @param id id an object of {@link com.mycompany.tickproject.models.Action}
     * @return an object of {@link com.mycompany.tickproject.models.Action}
     */
    public Action getAction(int id);

    /** This method get actions from the database and return list with objects of {@link com.mycompany.tickproject.models.Action}
     *
     * @return list with objects of {@link com.mycompany.tickproject.models.Action}
     */
    public List<Action> getActions();

}


