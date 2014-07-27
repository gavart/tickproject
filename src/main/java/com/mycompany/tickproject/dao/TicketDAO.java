package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Ticket;

import java.util.List;

/**
 * This interface provides methods that are used to work with the entity {@link com.mycompany.tickproject.models.Ticket}
 * @author jenias
 * @version 1.0, 04/07/14
 */
public interface TicketDAO {
    /** This method adds a ticket by id action,section and rowAndSeat. When we create action, we also create tickets in database
     *
     * @param actionID id an object of {@link com.mycompany.tickproject.models.Action}
     * @param sectionID id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @param rowAndSeatID id an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    public void addTicket(int actionID, int sectionID, int rowAndSeatID);

    /** This method get tickets for sale from the database on a certain action and section and return list with objects of {@link com.mycompany.tickproject.models.Ticket}
     *
     * @param actionID id an object of {@link com.mycompany.tickproject.models.Action}
     * @param sectionID id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @return list with objects of {@link com.mycompany.tickproject.models.Ticket}
     */
    public List<Ticket> getTickets(int actionID, int sectionID);
    public List<Object[]> getTicketsInListObjects(int actionID, int sectionID);
    //public Ticket getTicket(int actionID, int sectionID, int rowAndSeatID);

    /** This method gets reserved ticket on a certain customer from database and return an object of {@link com.mycompany.tickproject.models.Ticket}
     *
     * @param customerID id an object of {@link com.mycompany.tickproject.models.Customer}
     * @return an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    public Ticket findTicketByCustomer(int customerID);

    /** This method sells a ticket by id an object of {@link com.mycompany.tickproject.models.Ticket}. Change {@link com.mycompany.tickproject.models.Ticket#status} to id=3 and status SELLED
     *
     * @param ticket an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    public void sellTicket(Ticket ticket);

    /** This method reserves a ticket
     *
     * @param ticket an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    public void reserveTicket(Ticket ticket);


}

