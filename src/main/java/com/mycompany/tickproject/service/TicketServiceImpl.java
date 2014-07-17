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
    public List<Ticket> getTickets(int actionID, int sectionID) {
        return facadeDAO.getTicketDAO().getTickets(actionID,sectionID);
    }
}