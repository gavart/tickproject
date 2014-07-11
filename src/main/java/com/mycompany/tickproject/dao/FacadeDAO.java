package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.SectionOfStadium;
import com.mycompany.tickproject.models.Stadium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** This interface provide properties that are used in services
 * @author jenias
 * @version 1.0, 09/07/14
 */
@Repository
public class FacadeDAO {
    private RowAndSeatDAO rowAndSeatDAO;
    private SectionOfStadiumDAO sectionOfStadiumDAO;
    private StadiumDAO stadiumDAO;

    @Autowired
    public void setRowAndSeatDAO(RowAndSeatDAO rowAndSeatDAO) {
        this.rowAndSeatDAO = rowAndSeatDAO;
    }
    public RowAndSeatDAO getRowAndSeatDAO() {
        return rowAndSeatDAO;
    }

    @Autowired
    public void setSectionOfStadiumDAO(SectionOfStadiumDAO sectionOfStadiumDAO) {
        this.sectionOfStadiumDAO = sectionOfStadiumDAO;
    }
    public SectionOfStadiumDAO getSectionOfStadiumDAO() {
        return sectionOfStadiumDAO;
    }

    @Autowired
    public void setStadiumDAO(StadiumDAO stadiumDAO) {
        this.stadiumDAO = stadiumDAO;
    }
    public StadiumDAO getStadiumDAO() {
        return stadiumDAO;
    }
}
