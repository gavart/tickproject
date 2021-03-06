package com.mycompany.tickproject.service;

import com.mycompany.tickproject.models.Ticket;

import java.util.List;

/**
 * Created by apple on 12.07.14.
 */
public interface TicketService {
    public Ticket getTicket(int actionID, int rowAndSeatID);


    public List<Ticket> getTickets(int actionID, int sectionID);

    /** This method sells a ticket by id an object of {@link com.mycompany.tickproject.models.Ticket}. Change {@link com.mycompany.tickproject.models.Ticket#status} to id=3 and status SELLED
     *
     * @param ticket an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    public void sellTicket(Ticket ticket);

    /** This method sells a ticket through update exist item in database an object of {@link com.mycompany.tickproject.models.Ticket}. Change {@link com.mycompany.tickproject.models.Ticket#status} to id=3 and status SELLED
     *
     * @param ticket an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    public void sellTicketThroughUpdate(Ticket ticket);

    /** This method reserves a ticket
     *
     * @param ticket an object of {@link com.mycompany.tickproject.models.Ticket}
     */
    public void reserveTicket(Ticket ticket);

    /** This method unreserve and return in sale
     *
     * @param actionID id an object of {@link com.mycompany.tickproject.models.Action}
     * @param rowAndSeatIDs array with ids an object of {@link com.mycompany.tickproject.models.RowAndSeat}
     */
    public boolean unreserveAndReturnInSale(int actionID, int[] rowAndSeatIDs);
}
