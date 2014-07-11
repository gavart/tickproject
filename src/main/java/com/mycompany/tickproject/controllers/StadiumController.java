package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.models.Stadium;
import com.mycompany.tickproject.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by apple on 09.07.14.
 */
@Controller
public class StadiumController {

    @Autowired
    private FacadeService facadeService;

    @RequestMapping(value = "/addstadium", method = RequestMethod.GET)
    public void addStadium(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Stadium stadium = new Stadium();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String amountOfSeats = request.getParameter("seats");
        stadium.setName(name);
        stadium.setDescription(description);
        stadium.setAmountOfSeats(Integer.parseInt(amountOfSeats));
        facadeService.getStadiumService().addStadium(stadium);
    }
    @RequestMapping(value = "/editstadium", method = RequestMethod.GET)
    public void editStadium(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Stadium stadium = new Stadium();
        String id = request.getParameter("idstadium");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String amountOfSeats = request.getParameter("seats");
        stadium.setId(Integer.parseInt(id));
        stadium.setName(name);
        stadium.setDescription(description);
        stadium.setAmountOfSeats(Integer.parseInt(amountOfSeats));
        facadeService.getStadiumService().editStadium(stadium);
    }

}