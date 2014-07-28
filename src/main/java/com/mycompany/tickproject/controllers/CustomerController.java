package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.models.Customer;
import com.mycompany.tickproject.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by apple on 28.07.14.
 */
@Controller
public class CustomerController {

    @Autowired
    private FacadeService facadeService;

    @RequestMapping(value="/getcustomer",method = RequestMethod.POST, produces ="text/html;charset=UTF-8")
    public @ResponseBody String getCustomer(HttpServletRequest request, HttpServletResponse response) {
        String custimerID = request.getParameter("customerid");
        //if(custimerID!=null) {
            Customer customer = facadeService.getCustomerService().getCustomer(Integer.parseInt(custimerID));
        //}
        response.setCharacterEncoding("UTF-8");
        return customer.getLastName() + "," +customer.getFirstName();
    }

}
