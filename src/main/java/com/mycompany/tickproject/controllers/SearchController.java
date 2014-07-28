package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.models.Price;

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
import java.util.List;

/**
 * Created by apple on 27.07.14.
 */
@Controller
public class SearchController {
    @Autowired
    private FacadeService facadeService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPage(HttpServletRequest request, HttpServletResponse response,Model map) {
        String msg = "";
        String typemsg = "";
        String q = request.getParameter("q");
        if(q!=null) {
            String[] nameAndLastName = q.split(" ");
            if(nameAndLastName.length>1) {
                if(nameAndLastName[0]!=null && nameAndLastName[1]!=null) {
                    if(nameAndLastName[0].length()>2 && nameAndLastName[1].length()>1) {
                    List<Customer> customerList=facadeService.getCustomerService().findCustomerByNameLastName(nameAndLastName[0],nameAndLastName[1]);
                        if(customerList.size()!=0) {
                            map.addAttribute("customerList",customerList);
                            msg = "Результат найден! Смотрите ниже!";
                            typemsg = "success";
                        } else {
                            msg = "Ничего не найдено!";
                            typemsg = "error";
                        }
                    } else {
                        msg = "Ничего не найдено!";
                        typemsg = "error";
                    }

                } else {
                    msg = "Ничего не найдено!";
                    typemsg = "error";
                }
            } else {
                msg = "Ничего не найдено!";
                typemsg = "error";
            }
            //facadeService.getCustomerService().
            //facadeService.getTicketService().
            //map.addAttribute("result",)
        } /*else {
            msg = "Пусто! Введите фамилию и имя";
            typemsg = "info";
        }*/
        map.addAttribute("msg",msg);
        map.addAttribute("typemsg",typemsg);

        return "searchp";
    }
}
