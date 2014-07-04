/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tickproject.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author apple
 */
@Controller
public class IndexController {
    //private final static Logger LOGGER = Logger.getLogger(IndexController.class);
    public IndexController() {
        
    }
    
    @RequestMapping(value="/index",method = RequestMethod.GET)  
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        //LOGGER.debug("Index Controller page open.");
        ModelAndView modelAndView = new ModelAndView("index");
        //LOGGER.debug("Index Controller page close.");
        return modelAndView;
    }
}
