package com.mycompany.tickproject.controllers;

import com.mycompany.tickproject.helper.Generation;
import com.mycompany.tickproject.helper.RecalculationIndexes;
import com.mycompany.tickproject.models.Action;
import com.mycompany.tickproject.models.SectionForm;
import com.mycompany.tickproject.models.SectionOfStadium;
import com.mycompany.tickproject.models.Stadium;
import com.mycompany.tickproject.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 09.07.14.
 */
@Controller
public class SectionOfStadiumController {

    @Autowired
    private FacadeService facadeService;

    @RequestMapping(value = "/addsectionpage", method = RequestMethod.GET)
    public String addSectionPage(HttpServletRequest request, HttpServletResponse response,Model map) throws Exception {
        int id =Integer.parseInt(request.getParameter("idstadium"));
        //Stadium stadium = facadeService.getStadiumService().getStadium(id);

        List<Stadium> listWithStadiums = new ArrayList<>();//facadeService.getStadiumService().getStadiums();
        listWithStadiums.add(facadeService.getStadiumService().getStadium(1));
        map.addAttribute("listWithStadiums",listWithStadiums);
        //map.addAttribute("stadium",stadium);
        return "addsectionpage";
    }

    @RequestMapping(value = "/addsection", method = RequestMethod.POST)
    public String addSection(@ModelAttribute("sectionForm") SectionForm sectionForm,
                       Model map) {

        ArrayList<String> sectionNames =sectionForm.getNames();
        ArrayList<String> sectionDescriptions = sectionForm.getDescriptions();
        ArrayList<String> stadiumsId = sectionForm.getStadiums();
        List<String> sectionNamesUpdated = new ArrayList<>();
        List<String> sectionDescriptionsUpdated = new ArrayList<>();
        List<String> stadiumsIdUpdated = new ArrayList<>();

        ArrayList<SectionOfStadium> listWithSections = new ArrayList<>();

        //if(sectionNames.size()==sectionDescriptions.size() && stadiumsId.size()==sectionNames.size() && sectionDescriptions.size() == stadiumsId.size())
        //{
            //re-calculation indexes in lists
            RecalculationIndexes recalculationIndexes = new RecalculationIndexes();
            sectionNamesUpdated = recalculationIndexes.recalculateListIndexes(sectionNames);
            sectionDescriptionsUpdated = recalculationIndexes.recalculateListIndexes(sectionDescriptions);
            stadiumsIdUpdated = recalculationIndexes.recalculateListIndexes(stadiumsId);

            for(int i=0; i < sectionNamesUpdated.size(); i++) {
                SectionOfStadium sectionOfStadium = new SectionOfStadium();
                sectionOfStadium.setName(sectionNamesUpdated.get(i));
                sectionOfStadium.setDescription(sectionDescriptionsUpdated.get(i));
                sectionOfStadium.setStadium(facadeService.getStadiumService().getStadium(Integer.parseInt(stadiumsIdUpdated.get(0))));//(facadeService.getStadiumService().getStadium(Integer.parseInt(stadiumsIdUpdated.get(i))));
                listWithSections.add(sectionOfStadium);
                sectionOfStadium = null;
            }
            if(listWithSections.size()!=0) {
                facadeService.getSectionOfStadiumService().addSectionsOfStadium(listWithSections);
            }
        //}

        map.addAttribute("listWithSections",listWithSections);

        return "addsections_success";
    }

    @RequestMapping(value = "/getsections", method = RequestMethod.GET)
    public String getSections(HttpServletRequest request, HttpServletResponse response,Model map) throws Exception {
        int idstadium =Integer.parseInt(request.getParameter("idstadium"));
        int actionId = Integer.parseInt(request.getParameter("idaction"));
        Generation generation = new Generation();

        String contextPath = request.getContextPath();
        Action action = facadeService.getActionService().getAction(actionId);
        map.addAttribute("actionString", generation.generateOneAction(action,contextPath));
        map.addAttribute("listSections", generation.generateSections(facadeService.getSectionOfStadiumService().getSectionsOfStadium(idstadium),contextPath,actionId)); //facadeService.getSectionOfStadiumService().getSectionsOfStadium(idstadium));//generation.generateSections(facadeService.getSectionOfStadiumService().getSectionsOfStadium(idstadium)));
        return "showsections";
    }

}
