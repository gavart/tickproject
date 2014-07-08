package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.RowAndSeat;

import java.util.List;

/** This interface provides methods that are used to work with the entity {@link com.mycompany.tickproject.models.RowAndSeat}
* @author jenias
* @version 1.0, 08/07/14
*/
public interface RowAndSeatDAO {
    /** This method adds a new {@link com.mycompany.tickproject.models.RowAndSeat} to the database
     *
     * @param rowAndSeat an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    public void addRowAndSeat(RowAndSeat rowAndSeat);

    /** This method get objects of {@link com.mycompany.tickproject.models.RowAndSeat} from the database by id an object of {@link com.mycompany.tickproject.models.SectionOfStadium} and return list with objects of {@link com.mycompany.tickproject.models.RowAndSeat}
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    public List<RowAndSeat> getRowsAndSeats(int sectionId);

}
