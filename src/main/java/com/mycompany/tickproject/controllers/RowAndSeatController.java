package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.helper.GenerationRowsAndSeats;
import com.mycompany.tickproject.models.FileUploadForm;
import com.mycompany.tickproject.helper.WorkWithTxtFile;
import com.mycompany.tickproject.models.RowAndSeat;
import com.mycompany.tickproject.models.SectionOfStadium;
import com.mycompany.tickproject.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
        GenerationRowsAndSeats generationRowsAndSeats = new GenerationRowsAndSeats();

        boolean isNotEmptyAllFiles = false;
        for(MultipartFile file :files)
        {
            if(file.getOriginalFilename()!="")
            {
                isNotEmptyAllFiles = true;
            }
        }
        if(isNotEmptyAllFiles == true)
        {
            workWithTxtFile.uploadFileOnTheServer(files);

            int currentPosition = 0;
            for(String fileName : workWithTxtFile.getFileNames()) {
                if(fileName!="") {
                SectionOfStadium sectionOfStadium = facadeService.getSectionOfStadiumService().getSectionOfStadium(Integer.parseInt(sectionsId.get(currentPosition)));
                listWithListsOfRowsAndSeatsBySection.add(workWithTxtFile.getRowsAndSeatsFromFile(pathToFilesDirectory + fileName, sectionOfStadium));
                }
                currentPosition++;
            }

            for(List<RowAndSeat> list : listWithListsOfRowsAndSeatsBySection) {
                 facadeService.getRowAndSeatService().addRowsAndSeatsFromFile(list);
            }

            map.addAttribute("rowsAndSeats", generationRowsAndSeats.generateRowsAndSeats(workWithTxtFile.getRowsAndSeatsFromFile(pathToFilesDirectory+ workWithTxtFile.getFileNames().get(0),facadeService.getSectionOfStadiumService().getSectionOfStadium(Integer.parseInt(sectionsId.get(1)))))); // + workWithTxtFile.getFileNames().get(0)
            return "file_upload_success";
        }
        else {
            return "file_upload_failed";
        }

    }

}
