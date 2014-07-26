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
    private TicketDAO ticketDAO;
    private ActionDAO actionDAO;
    private PriceDAO priceDAO;



    private CustomerDAO customerDAO;

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

    @Autowired
    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }
    public TicketDAO getTicketDAO() {
        return ticketDAO;
    }

    @Autowired
    public void setActionDAO(ActionDAO actionDAO) {
        this.actionDAO = actionDAO;
    }
    public ActionDAO getActionDAO() {
        return actionDAO;
    }

    @Autowired
    public void setPriceDAO(PriceDAO priceDAO) {
        this.priceDAO = priceDAO;
    }
    public PriceDAO getPriceDAO() {
        return priceDAO;
    }

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    public CustomerDAO getCustomerDAO() {return this.customerDAO;}
}
