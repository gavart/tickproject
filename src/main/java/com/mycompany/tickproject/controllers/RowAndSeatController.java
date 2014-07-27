package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.helper.Generation;
import com.mycompany.tickproject.models.*;
import com.mycompany.tickproject.helper.WorkWithTxtFile;
import com.mycompany.tickproject.service.FacadeService;
import com.sun.corba.se.spi.activation._ServerManagerImplBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 09.07.14.
 */
@Controller
public class RowAndSeatController {

    @Autowired
    private FacadeService facadeService;

    @RequestMapping(value = "/upload_file_form", method = RequestMethod.GET)
    public String displayFileUploadForm(Model map) {
        List<SectionOfStadium> sectionOfStadiumList = facadeService.getSectionOfStadiumService().getSectionsOfStadium(1);
        map.addAttribute("sectionOfStadiumList",sectionOfStadiumList);
        return "file_upload_form";
    }

    @RequestMapping(value = "/upload_files", method = RequestMethod.POST)
    public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
            Model map) throws IOException {
        String pathToFilesDirectory = "/Users/apple/IdeaProjects/tickproject/src/main/webapp/textfiles/";
        List<MultipartFile> files = uploadForm.getFiles();
        List<String> sectionsId = uploadForm.getSectionsId();
        List<List<RowAndSeat>> listWithListsOfRowsAndSeatsBySection = new ArrayList<>();
        WorkWithTxtFile workWithTxtFile = new WorkWithTxtFile();
        Generation generation = new Generation();
        List<SectionAndNameFileWithSeats> listWithSectionIdAndFileName = new ArrayList<>();
        boolean isNotEmptyAllFiles = false;
        int index = 0;
        for(MultipartFile file :files)
        {
            if(file.getOriginalFilename()!="")
            {
                isNotEmptyAllFiles = true;
                SectionAndNameFileWithSeats sectionAndNameFileWithSeats = new SectionAndNameFileWithSeats();
                sectionAndNameFileWithSeats.setFileName(file.getOriginalFilename());
                sectionAndNameFileWithSeats.setSectionId(sectionsId.get(index));
                listWithSectionIdAndFileName.add(sectionAndNameFileWithSeats);
            }
            index++;
        }
        if(isNotEmptyAllFiles == true)
        {
            workWithTxtFile.uploadFileOnTheServer(files);

            int currentPosition = 0;
            for(SectionAndNameFileWithSeats sectionAndNameFileWithSeats :listWithSectionIdAndFileName) {
                SectionOfStadium sectionOfStadium = facadeService.getSectionOfStadiumService().getSectionOfStadium(Integer.parseInt(sectionAndNameFileWithSeats.getSectionId()));
                listWithListsOfRowsAndSeatsBySection.add(workWithTxtFile.getRowsAndSeatsFromFile(pathToFilesDirectory + sectionAndNameFileWithSeats.getFileName(), sectionOfStadium));
            }

     ///////
            /*for(List<RowAndSeat> list : listWithListsOfRowsAndSeatsBySection) {
                 facadeService.getRowAndSeatService().addRowsAndSeatsFromFile(list);
            }*/

            map.addAttribute("rowsAndSeats", generation.generateRowsAndSeatsFromRowsAndSeatsList(workWithTxtFile.getRowsAndSeatsFromFile(pathToFilesDirectory + workWithTxtFile.getFileNames().get(0), facadeService.getSectionOfStadiumService().getSectionOfStadium(Integer.parseInt(sectionsId.get(1)))))); // + workWithTxtFile.getFileNames().get(0)
            return "file_upload_success";
        }
        else {
            return "file_upload_failed";
        }
    }
///sellseat?idsection=27&idaction=2&idstadium=1&idseat=76202
    @RequestMapping(value = "/sellseats", method = RequestMethod.POST)
    public @ResponseBody String sellSeat(HttpServletRequest request, HttpServletResponse response,Model map) {
        int actionID = Integer.parseInt(request.getParameter("actionID"));
        String[] rowandseatIDs = request.getParameterValues("rowandseatsID[]");
        //String pricesID = request.getParameter("priceID");

            for(int i=0; i < rowandseatIDs.length; i++) {
                RowAndSeat rowAndSeat = facadeService.getRowAndSeatService().getRowAndSeat(Integer.parseInt(rowandseatIDs[i]));
                Action action = facadeService.getActionService().getAction(actionID);
                Status status = new Status();
                status.setId(3);// 3 = sold
                Price price = facadeService.getPriceService().getActualPrice(rowAndSeat.getSectionOfStadium().getId(),actionID);
                Customer customer = new Customer();
                customer.setId(1);//1 = default customer
                Ticket ticket = new Ticket();
                ticket.setSectionOfStadium(rowAndSeat.getSectionOfStadium());
                ticket.setStadium(action.getStadium());
                ticket.setRowAndSeat(rowAndSeat);
                ticket.setAction(action);
                ticket.setStatus(status);
                ticket.setCustomer(customer);
                ticket.setPrice(price);
                facadeService.getTicketService().sellTicket(ticket);
            }

        /*
        int sectionID =Integer.parseInt(request.getParameter("idsection"));

        int stadiumID = Integer.parseInt(request.getParameter("idstadium"));
        int seatID = Integer.parseInt(request.getParameter("idseat"));

        Ticket ticket = new Ticket();
        RowAndSeat rowAndSeat = new RowAndSeat();
        rowAndSeat.setId(seatID);
        Action action = new Action();
        action.setId(actionID);
        Status status = new Status();
        status.setId(3);// 3 = sold
        Stadium stadium = new Stadium();
        stadium.setId(stadiumID);
        Customer customer = new Customer();
        customer.setId(1);//1 = default customer
        SectionOfStadium sectionOfStadium = new SectionOfStadium();
        sectionOfStadium.setId(sectionID);
        ticket.setSectionOfStadium(sectionOfStadium);
        ticket.setStadium(stadium);
        ticket.setRowAndSeat(rowAndSeat);
        ticket.setAction(action);
        ticket.setStatus(status);
        ticket.setCustomer(customer);
        ticket.setPrice(facadeService.getPriceService().getActualPrice(sectionID,actionID));
        facadeService.getTicketService().sellTicket(ticket);*/
        return "OK";
    }
    /*
    @RequestMapping(value = "/reserveseats", method = RequestMethod.POST)
    public @ResponseBody String reserveSeat(HttpServletRequest request, HttpServletResponse response,Model map) {
        int actionID = Integer.parseInt(request.getParameter("actionID"));
        String[] rowandseatIDs = request.getParameterValues("rowandseatsID[]");
        String customerName = "";
        String customerLastName = "";

        Customer customer = new Customer();
        customer.setFirstName(customerName);
        customer.setLastName(customerLastName);
        customer.setPhoneNumber("0");
        facadeService.getCustomerService().addCustomer(customer);
        customer = facadeService.getCustomerService().getCustomerByNameLastName(customerName,customerLastName);
        for(int i=0; i < rowandseatIDs.length; i++) {
            RowAndSeat rowAndSeat = facadeService.getRowAndSeatService().getRowAndSeat(Integer.parseInt(rowandseatIDs[i]));
            Action action = facadeService.getActionService().getAction(actionID);
            Status status = new Status();
            status.setId(2);// 2 = booked
            Price price = facadeService.getPriceService().getActualPrice(rowAndSeat.getSectionOfStadium().getId(),actionID);

            Ticket ticket = new Ticket();
            ticket.setSectionOfStadium(rowAndSeat.getSectionOfStadium());
            ticket.setStadium(action.getStadium());
            ticket.setRowAndSeat(rowAndSeat);
            ticket.setAction(action);
            ticket.setStatus(status);
            ticket.setCustomer(customer);
            ticket.setPrice(price);
            facadeService.getTicketService().reserveTicket(ticket);
        }

        return "OK";
    }
    */

    @RequestMapping(value = "/showseats", method = RequestMethod.GET)
    public String showRowsAndSeats(HttpServletRequest request, HttpServletResponse response,Model map) {
        int sectionID =Integer.parseInt(request.getParameter("idsection"));
        int actionID = Integer.parseInt(request.getParameter("idaction"));
        Generation generation = new Generation();
        List<Ticket> receivedTicketList = facadeService.getTicketService().getTickets(actionID, sectionID);
        Price price = facadeService.getPriceService().getActualPrice(sectionID,actionID);
        List<RowAndSeat> rowAndSeatList = facadeService.getRowAndSeatService().getRowsAndSeats(sectionID);
        List<Ticket> newTicketList = new ArrayList<>();
        for(int i=0;i<rowAndSeatList.size();i++) {
            Ticket t = new Ticket();
            t.setRowAndSeat(rowAndSeatList.get(i));
            t.setPrice(price);
            newTicketList.add(t);
        }
        for(Ticket ticket :receivedTicketList) {
            //if(ticket!=null) {
                int index = 0;
                for(Ticket ticket1 : newTicketList) {
                    if(ticket.getRowAndSeat().getId()==ticket1.getRowAndSeat().getId()) {
                        newTicketList.set(index, ticket);
                    }
                    index++;
                }
            //} else {
            //    break;
            //}
        }


        //generateRowsAndSeatsFromTicketsList
        map.addAttribute("rowsAndSeats", generation.generateRowsAndSeatsFromTicketsList(newTicketList));//generation.generateRowsAndSeatsFromRowsAndSeatsList(facadeService.getRowAndSeatService().getRowsAndSeats(sectionID)));
        return "showseats";
        /*int sectionID =Integer.parseInt(request.getParameter("idsection"));
        int actionID = Integer.parseInt(request.getParameter("idaction"));
        Generation generation = new Generation();
        List<Ticket> ticketList = facadeService.getTicketService().getTickets(actionID, sectionID);
        List<RowAndSeat> rowAndSeatList = facadeService.getRowAndSeatService().getRowsAndSeats(sectionID);
        List<Ticket> ticketList1 = new ArrayList<>();
        for(int i=0;i<rowAndSeatList.size();i++) {
                Ticket t = new Ticket();
                t.setRowAndSeat(rowAndSeatList.get(i));
            ticketList1.add(t);
        }
        for(Ticket ticket :ticketList) {
            if(ticket!=null) {
                int index = 0;
                for(Ticket ticket1 : ticketList1) {
                    if(ticket.getRowAndSeat().getId()==ticket1.getRowAndSeat().getId()) {
                        ticketList1.set(index,ticket);
                    }
                    index++;
                }
            } else {
                break;
            }
        }


        //generateRowsAndSeatsFromTicketsList
        map.addAttribute("rowsAndSeats", generation.generateRowsAndSeatsFromTicketsList(ticketList1));//generation.generateRowsAndSeatsFromRowsAndSeatsList(facadeService.getRowAndSeatService().getRowsAndSeats(sectionID)));
        return "showseats";*/
    }

}
