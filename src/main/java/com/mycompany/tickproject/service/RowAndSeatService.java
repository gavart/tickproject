package com.mycompany.tickproject.service;

import com.mycompany.tickproject.models.RowAndSeat;

import java.util.List;

/** This interface provide methods that are used to work with the entity {@link com.mycompany.tickproject.models.RowAndSeat} and with {@link com.mycompany.tickproject.dao.FacadeDAO} we gets necessary objects.
 * @author jenias
 * @version 1.0, 09/07/14
 */
public interface RowAndSeatService {

    /** This method adds a new {@link com.mycompany.tickproject.models.RowAndSeat} to the database
     *
     * @param rowAndSeat an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    public void addRowAndSeat(RowAndSeat rowAndSeat);

    /** This method add list with objects of {@link com.mycompany.tickproject.models.RowAndSeat} from file to the database
     *
     * @param listWithRowsAndSeats list with objects of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    public void addRowsAndSeatsFromFile(List<RowAndSeat> listWithRowsAndSeats);

    /** This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     *
     * @param id id an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     * @return an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    public RowAndSeat getRowAndSeat(int id);

    /** This method get objects of {@link com.mycompany.tickproject.models.RowAndSeat} from the database by id an object of {@link com.mycompany.tickproject.models.SectionOfStadium} and return list with objects of {@link com.mycompany.tickproject.models.RowAndSeat}
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    public List<RowAndSeat> getRowsAndSeats(int sectionId);
}
