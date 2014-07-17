package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by apple on 12.07.14.
 */
@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    public SessionFactory sessionFactory;
    /**
     * This method adds a ticket by id action,section and rowAndSeat. When we create action, we also create tickets in database
     *
     * @param actionID     id an object of {@link com.mycompany.tickproject.models.Action}
     * @param sectionID    id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @param rowAndSeatID id an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    @Override
    public void addTicket(int actionID, int sectionID, int rowAndSeatID) {

    }

    /**
     * This method get tickets for sale from the database on a certain action and section and return list with objects of {@link com.mycompany.tickproject.models.Ticket}
     *
     * @param actionID  id an object of {@link com.mycompany.tickproject.models.Action}
     * @param sectionID id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @return list with objects of {@link com.mycompany.tickproject.models.Ticket}
     */
    @Override
    public List<Ticket> getTickets(int actionID, int sectionID) {

        //Select t.id, t.action_id, t.stadium_id, t.section_of_stadium_id, ras.row_and_seat_id, t.status_id,t.сustomer_id
        //From Tickets AS t
        //RIGHT OUTER JOIN
        //Rows_and_seats AS ras
        //ON t.row_and_seat_id = ras.id AND t.section_of_stadium_id = 4
        /*
        Session session = sessionFactory.getCurrentSession();
        List<Ticket> ticketList = (List<Ticket>) session.createSQLQuery("Select t.id, t.action_id, t.stadium_id, t.section_of_stadium_id, t.row_and_seat_id, t.status_id, t.customer_id"+
        " From Tickets AS t "+
        " RIGHT OUTER JOIN "+
        " Rows_and_seats AS ras "+
        " ON t.row_and_seat_id = ras.id AND t.action_id = " + actionID + " AND t.section_of_stadium_id = " +sectionID ).addEntity(Ticket.class).list();
        return ticketList;
        */

        Session session = sessionFactory.getCurrentSession();
        List<Ticket> ticketList = (List<Ticket>) session.createSQLQuery("Select t.id, t.action_id, t.stadium_id, t.section_of_stadium_id, t.row_and_seat_id, t.status_id, t.customer_id"+
                " From Tickets AS t "+
                " RIGHT OUTER JOIN "+
                " Rows_and_seats AS ras "+
                " ON t.row_and_seat_id = ras.id AND t.action_id = " + actionID + " AND t.section_of_stadium_id = " +sectionID ).addEntity(Ticket.class).list();
        return ticketList;
    }

    /**
     * This method gets reserved ticket on a certain customer from database and return an object of {@link com.mycompany.tickproject.models.Ticket}
     *
     * @param customerID id an object of {@link com.mycompany.tickproject.models.Customer}
     * @return an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    @Override
    public Ticket findTicketByCustomer(int customerID) {
        return null;
    }

    /**
     * This method sells a ticket by id an object of {@link com.mycompany.tickproject.models.Ticket}. Change {@link com.mycompany.tickproject.models.Ticket#status} to id=3 and status SELLED
     *
     * @param ticketID id an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    @Override
    public void sellTicket(int ticketID) {

    }

    /**
     * This method reserves a ticket by {@link com.mycompany.tickproject.models.Customer#id} and {@link com.mycompany.tickproject.models.Ticket#id}
     *
     * @param ticketID   id an object of {@link com.mycompany.tickproject.models.Ticket}
     * @param customerID id an object of {@link com.mycompany.tickproject.models.Customer}
     */
    @Override
    public void reserveTicket(int ticketID, int customerID) {

    }
}
