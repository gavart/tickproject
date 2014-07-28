package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.models.Price;
import com.mycompany.tickproject.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tverd.alex on 24.07.2014.
 */
@Controller
public class SearchController {

    @Autowired
    private FacadeService facadeService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response, Model map) {
        ModelAndView modelAndView = new ModelAndView("search");



        return modelAndView;
    }

}
