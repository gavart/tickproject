/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tickproject.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.tickproject.helper.Generation;
import com.mycompany.tickproject.models.Action;
import com.mycompany.tickproject.service.FacadeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *
 * @author apple
 */
@Controller
public class IndexController {

    @Autowired
    private FacadeService facadeService;
    //private final static Logger LOGGER = Logger.getLogger(IndexController.class);
    public IndexController() {
        
    }
    
    @RequestMapping(value="/index",method = RequestMethod.GET)  
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //LOGGER.debug("Index Controller page open.");
        Generation generation = new Generation();

        String contextPath = request.getContextPath();
        List<Action> actionList = facadeService.getActionService().getActions();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("actionListString", generation.generateActions(actionList,contextPath));
        //LOGGER.debug("Index Controller page close.");
        return modelAndView;
    }

}
