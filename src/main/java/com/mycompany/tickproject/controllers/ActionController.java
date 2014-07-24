package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.models.*;
import com.mycompany.tickproject.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 19.07.14.
 */
@Controller
public class ActionController {

    @Autowired
    private FacadeService facadeService;

    @RequestMapping(value = "/add_action_form", method = RequestMethod.GET)
    public String addActionForm(HttpServletRequest request, HttpServletResponse response,Model map) {
        List<Price> defaultPrices = facadeService.getPriceService().getPrices(1);//1 default action, get default prices
        map.addAttribute("defaultPrices",defaultPrices);
        return "add_action_form";
    }
    @RequestMapping(value = "/addaction", method = RequestMethod.GET)
    public void addAction(@ModelAttribute("sectionForm") ActionForm actionForm,HttpServletRequest request, HttpServletResponse response,Model map) {
        String name = request.getParameter("nameaction");//"Черноморец - Олимпик";//
        String dateAction = request.getParameter("datetimeaction").replace("T"," ")+":00";//"2014-07-26 19:00:00";//Timestamp dateAction;
        Boolean isNewPrices = Boolean.valueOf(request.getParameter("isNewPrices"));
        boolean a = Boolean.parseBoolean(request.getParameter("isNewPrices"));
        String a2 = request.getParameter("isNewPrices");
        List<Integer> sectionsId = actionForm.getSectionsId();
        List<Integer> actionsId = actionForm.getActionsId();
        List<BigDecimal> prices = actionForm.getPrices();



        Action action = new Action();
        Stadium stadium = new Stadium();
        stadium.setId(1); //Chernomorets = 1
        action.setNameAction(name);
        action.setStadium(stadium);
        action.setIsActive(true);
        action.setDateTimeAction(Timestamp.valueOf(dateAction));

        facadeService.getActionService().addAction(action);
        Action lastAddedAction = facadeService.getActionService().getLastAddedAction();
        if(isNewPrices==false) {
            List<Price> defaultPrices = facadeService.getPriceService().getPrices(1);//default actionID = 1
            for(Price price : defaultPrices) {
                Price newPrice = new Price();
                newPrice.setSectionOfStadium(price.getSectionOfStadium());
                newPrice.setAction(lastAddedAction);
                newPrice.setPrice(price.getPrice());
                facadeService.getPriceService().addPrice(newPrice);
            }
        } else {
            for(int i=0; i < prices.size(); i++ ) {
                Price newPrice = new Price();
                SectionOfStadium sectionOfStadium = new SectionOfStadium();
                sectionOfStadium.setId(sectionsId.get(i));
                newPrice.setSectionOfStadium(sectionOfStadium);
                newPrice.setAction(lastAddedAction);
                newPrice.setPrice(prices.get(i));
                facadeService.getPriceService().addPrice(newPrice);
            }

        }
        try {
            response.sendRedirect(request.getContextPath()+"/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return
    }
}
