package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.models.*;
import com.mycompany.tickproject.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
        Action defaultAction = facadeService.getActionService().getAction(1);
        map.addAttribute("defaultAction",defaultAction);
        return "add_action_form";
    }
    @RequestMapping(value = "/addaction", method = RequestMethod.GET)
    public String addAction(@ModelAttribute("addActionForm") ActionForm actionForm, HttpServletRequest request, HttpServletResponse response,Model map, RedirectAttributes redirectAttributes) {
        String name = request.getParameter("nameaction");//"Черноморец - Олимпик";//
        String startDateTimeAction = request.getParameter("startdatetimeaction").replace("T"," ")+":00";//"2014-07-26 19:00:00";//Timestamp startDateTimeAction;
        String endDateTimeAction = request.getParameter("enddatetimeaction").replace("T"," ")+":00";
        String timelimitbooking = "2014-07-26 "+request.getParameter("timelimitbooking")+":00";
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
        action.setStartDateTimeAction(Timestamp.valueOf(startDateTimeAction));
        action.setEndDateTimeAction(Timestamp.valueOf(endDateTimeAction));
        action.setTimeLimitBooking(Timestamp.valueOf(timelimitbooking));

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
            redirectAttributes.addFlashAttribute("msg", "Мероприятие " + action.getNameAction() + " успешно создано!");
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
            redirectAttributes.addFlashAttribute("msg", "Мероприятие " + action.getNameAction() + " успешно создано!");
        }
        return "redirect:index";
        /*
        try {

            response.sendRedirect(request.getContextPath()+"/index");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    //edit_action_form
    @RequestMapping(value = "/edit_action_form", method = RequestMethod.GET)
    public String editActionForm(HttpServletRequest request, HttpServletResponse response,Model map) {
        String idAction = request.getParameter("id_action");
        Action action = facadeService.getActionService().getAction(Integer.parseInt(idAction));
        map.addAttribute("action",action);
        request.setAttribute("action",action);
        List<Price> defaultPrices = facadeService.getPriceService().getPrices(Integer.parseInt(idAction));//1 default action, get default prices
        map.addAttribute("defaultPrices",defaultPrices);
        return "edit_action_form";
    }

    @RequestMapping(value = "/edit_action", method = RequestMethod.GET)
    public String editAction(@ModelAttribute("editActionForm") ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, Model map, RedirectAttributes redirectAttributes) {
        String idAction = request.getParameter("idAction");
        String name = request.getParameter("nameaction");//"Черноморец - Олимпик";//
        String startDateTimeAction = request.getParameter("startdatetimeaction").replace("T"," ")+":00";//"2014-07-26 19:00:00";//Timestamp startDateTimeAction;
        String endDateTimeAction = request.getParameter("enddatetimeaction").replace("T"," ")+":00";
        String timelimitbooking = "2014-07-26 "+request.getParameter("timelimitbooking")+":00";
        Boolean isNewPrices = Boolean.valueOf(request.getParameter("isNewPrices"));
        List<BigDecimal> prices = actionForm.getPrices();
        Action action1 = facadeService.getActionService().getAction(Integer.parseInt(idAction));
        action1.setNameAction(name);
        action1.setStartDateTimeAction(Timestamp.valueOf(startDateTimeAction));
        action1.setEndDateTimeAction(Timestamp.valueOf(endDateTimeAction));
        action1.setTimeLimitBooking(Timestamp.valueOf(timelimitbooking));

        facadeService.getActionService().editAction(action1);
        if(isNewPrices==true) {
            List<Price> defaultPrices = facadeService.getPriceService().getPrices(action1.getId());//default actionID = 1
            if(defaultPrices.size()==prices.size()) {
                for(int i=0; i < prices.size(); i++ ) {
                    defaultPrices.get(i).setPrice(prices.get(i));
                    facadeService.getPriceService().editPrice(defaultPrices.get(i));
                }
            }
        }

        redirectAttributes.addFlashAttribute("msg", "Мероприятие " + action1.getNameAction() + " успешно отредактировано!");

        return "redirect:index";
    }

    @RequestMapping(value = "/remove_action", method = RequestMethod.GET)
    public String removeAction(HttpServletRequest request, HttpServletResponse response,Model map,RedirectAttributes redirectAttributes) {
        String idAction = request.getParameter("id_action");
        facadeService.getActionService().makeNotActiveAction(Integer.parseInt(idAction));
        Action action1 = facadeService.getActionService().getAction(Integer.parseInt(idAction));
        redirectAttributes.addFlashAttribute("msg", "Мероприятие " + action1.getNameAction() + " успешно добавлено в архив!");
        return "redirect:index";
    }
}
