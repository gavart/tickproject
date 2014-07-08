package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Stadium;

/** This interface provides methods that are used to work with the entity {@link com.mycompany.tickproject.models.Stadium}
 * @author jenias
 * @version 1.0, 08/07/14
 */
public interface StadiumDAO {
    /** This method add new {@link com.mycompany.tickproject.models.Stadium} to the database
     *
     * @param stadium an object of {@link com.mycompany.tickproject.models.Stadium}
     */
    public void addStadium(Stadium stadium);

    /** This method get an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Stadium}
     *
     * @param id id by which to get the object of {@link com.mycompany.tickproject.models.Stadium}
     */
    public void editStadium(int id);

    /** This method get an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Stadium}
     *
     * @param id id by which to get the object of {@link com.mycompany.tickproject.models.Stadium}
     * @return an object of {@link com.mycompany.tickproject.models.Stadium}
     */
    public Stadium getStadium(int id);
}
