package com.mycompany.tickproject.service;

import com.mycompany.tickproject.dao.FacadeDAO;
import com.mycompany.tickproject.dao.StadiumDAO;
import com.mycompany.tickproject.models.Stadium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** This class implement methods that are used to work with the entity {@link com.mycompany.tickproject.models.Stadium} and with {@link com.mycompany.tickproject.dao.FacadeDAO} we gets necessary objects.
 * @author jenias
 * @version 1.0, 09/07/14
 */
@Service
public class StadiumServiceImpl implements StadiumService {

    @Autowired
    //private StadiumDAO stadiumDAO;
    private FacadeDAO facadeDAO;

    /**
     * This method adds a new {@link com.mycompany.tickproject.models.Stadium} to the database
     *
     * @param stadium an object of {@link com.mycompany.tickproject.models.Stadium}
     */
    @Transactional
    @Override
    public void addStadium(Stadium stadium) {

        facadeDAO.getStadiumDAO().addStadium(stadium);
    }

    /**
     * This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Stadium}
     *
     * @param stadium an object of {@link com.mycompany.tickproject.models.Stadium} with updated information
     */
    @Transactional
    @Override
    public void editStadium(Stadium stadium) {
        facadeDAO.getStadiumDAO().editStadium(stadium);
    }

    /**
     * This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.Stadium}
     *
     * @param id id by which to get the object of {@link com.mycompany.tickproject.models.Stadium}
     * @return an object of {@link com.mycompany.tickproject.models.Stadium}
     */
    @Transactional
    @Override
    public Stadium getStadium(int id) {
        return  facadeDAO.getStadiumDAO().getStadium(id);
    }

    /**
     * This method get objects of {@link com.mycompany.tickproject.models.Stadium} from the database and return list with objects of {@link com.mycompany.tickproject.models.Stadium}
     *
     * @return list with objects of {@link com.mycompany.tickproject.models.Stadium}
     */
    @Transactional
    @Override
    public List<Stadium> getStadiums() {
        return facadeDAO.getStadiumDAO().getStadiums();
    }
}
