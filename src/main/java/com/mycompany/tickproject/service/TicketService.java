package com.mycompany.tickproject.service;

import com.mycompany.tickproject.models.Ticket;

import java.util.List;

/**
 * Created by apple on 12.07.14.
 */
public interface TicketService {
    public List<Ticket> getTickets(int actionID, int sectionID);
}
