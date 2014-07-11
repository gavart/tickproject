package com.mycompany.tickproject.service;

import com.mycompany.tickproject.dao.FacadeDAO;
import com.mycompany.tickproject.models.RowAndSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** This class implement methods that are used to work with the entity {@link com.mycompany.tickproject.models.RowAndSeat} and with {@link com.mycompany.tickproject.dao.FacadeDAO} we gets necessary objects.
 * @author jenias
 * @version 1.0, 09/07/14
 */
@Service
public class RowAndSeatServiceImpl implements RowAndSeatService {

    @Autowired
    private FacadeDAO facadeDAO;
    /**
     * This method adds a new {@link com.mycompany.tickproject.models.RowAndSeat} to the database
     *
     * @param rowAndSeat an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    @Transactional
    @Override
    public void addRowAndSeat(RowAndSeat rowAndSeat) {
        facadeDAO.getRowAndSeatDAO().addRowAndSeat(rowAndSeat);
    }

    /** This method add list with objects of {@link com.mycompany.tickproject.models.RowAndSeat} from file to the database
     *
     * @param listWithRowsAndSeats list with objects of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    @Transactional
    @Override
    public void addRowsAndSeatsFromFile(List<RowAndSeat> listWithRowsAndSeats) {

        //facadeDAO.getRowAndSeatDAO().addRowsAndSeatsFromFile(listWithRowsAndSeats);
    }

    /**
     * This method get objects of {@link com.mycompany.tickproject.models.RowAndSeat} from the database by id an object of {@link com.mycompany.tickproject.models.SectionOfStadium} and return list with objects of {@link com.mycompany.tickproject.models.RowAndSeat}
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Transactional
    @Override
    public List<RowAndSeat> getRowsAndSeats(int sectionId) {
        return facadeDAO.getRowAndSeatDAO().getRowsAndSeats(sectionId);
    }
}
