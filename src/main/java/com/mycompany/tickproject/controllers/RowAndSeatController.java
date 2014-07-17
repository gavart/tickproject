package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.helper.Generation;
import com.mycompany.tickproject.models.*;
import com.mycompany.tickproject.helper.WorkWithTxtFile;
import com.mycompany.tickproject.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
        String pathToFilesDirectory = "/Users/apple/Desktop/Test Upload File/src/main/webapp/resources/files/";
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
            /*
            for(String fileName : workWithTxtFile.getFileNames()) {
                if(fileName!="") {

                SectionOfStadium sectionOfStadium = facadeService.getSectionOfStadiumService().getSectionOfStadium(Integer.parseInt(sectionsId.get(currentPosition)));
                listWithListsOfRowsAndSeatsBySection.add(workWithTxtFile.getRowsAndSeatsFromFile(pathToFilesDirectory + fileName, sectionOfStadium));
                }
                currentPosition++;
            }*/

            for(List<RowAndSeat> list : listWithListsOfRowsAndSeatsBySection) {
                 facadeService.getRowAndSeatService().addRowsAndSeatsFromFile(list);
            }

            map.addAttribute("rowsAndSeats", generation.generateRowsAndSeatsFromRowsAndSeatsList(workWithTxtFile.getRowsAndSeatsFromFile(pathToFilesDirectory + workWithTxtFile.getFileNames().get(0), facadeService.getSectionOfStadiumService().getSectionOfStadium(Integer.parseInt(sectionsId.get(1)))))); // + workWithTxtFile.getFileNames().get(0)
            return "file_upload_success";
        }
        else {
            return "file_upload_failed";
        }
    }
    @RequestMapping(value = "/showseats", method = RequestMethod.GET)
    public String showRowsAndSeats(HttpServletRequest request, HttpServletResponse response,Model map) {
        int sectionID =Integer.parseInt(request.getParameter("idsection"));
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
            }
        }


        //generateRowsAndSeatsFromTicketsList
        map.addAttribute("rowsAndSeats", generation.generateRowsAndSeatsFromTicketsList(ticketList1));//generation.generateRowsAndSeatsFromRowsAndSeatsList(facadeService.getRowAndSeatService().getRowsAndSeats(sectionID)));
        return "showseats";
    }

}
