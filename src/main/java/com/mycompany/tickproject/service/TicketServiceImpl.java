package com.mycompany.tickproject.service;

import com.mycompany.tickproject.dao.FacadeDAO;
import com.mycompany.tickproject.dao.TicketDAO;
import com.mycompany.tickproject.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by apple on 12.07.14.
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private FacadeDAO facadeDAO;

    @Transactional
    @Override
    public Ticket getTicket(int actionID, int rowAndSeatID) {
        return facadeDAO.getTicketDAO().getTicket(actionID,rowAndSeatID);
    }

    @Transactional
    @Override
    public List<Ticket> getTickets(int actionID, int sectionID) {
        return facadeDAO.getTicketDAO().getTickets(actionID,sectionID);
    }

    /**
     * This method sells a ticket by id an object of {@link com.mycompany.tickproject.models.Ticket}. Change {@link com.mycompany.tickproject.models.Ticket#status} to id=3 and status SELLED
     *
     * @param ticket an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    @Transactional
    @Override
    public void sellTicket(Ticket ticket) {
        facadeDAO.getTicketDAO().sellTicket(ticket);
    }

    /**
     * This method sells a ticket through update exist item in database an object of {@link com.mycompany.tickproject.models.Ticket}. Change {@link com.mycompany.tickproject.models.Ticket#status} to id=3 and status SELLED
     *
     * @param ticket an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    @Transactional
    @Override
    public void sellTicketThroughUpdate(Ticket ticket) {
        facadeDAO.getTicketDAO().sellTicketThroughUpdate(ticket);
    }

    /**
     * This method reserves a ticket
     *
     * @param ticket an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    @Transactional
    @Override
    public void reserveTicket(Ticket ticket) {
        facadeDAO.getTicketDAO().reserveTicket(ticket);
    }

    /** This method unreserve and return in sale
     *
     * @param actionID id an object of {@link com.mycompany.tickproject.models.Action}
     * @param rowAndSeatIDs array with ids an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    @Transactional
    @Override
    public boolean unreserveAndReturnInSale(int actionID, int[] rowAndSeatIDs) {
        return facadeDAO.getTicketDAO().unreserveAndReturnInSale(actionID,rowAndSeatIDs);
    }


}
