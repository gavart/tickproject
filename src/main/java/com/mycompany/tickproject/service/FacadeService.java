package com.mycompany.tickproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by apple on 09.07.14.
 */
@Service
public class FacadeService {

    private StadiumService stadiumService;
    private SectionOfStadiumService sectionOfStadiumService;
    private RowAndSeatService rowAndSeatService;

    @Autowired
    public void setStadiumService(StadiumService stadiumService){

        this.stadiumService = stadiumService;
    }
    public StadiumService getStadiumService() { return this.stadiumService; }

    @Autowired
    public void setSectionOfStadiumService(SectionOfStadiumService sectionOfStadiumService){
        this.sectionOfStadiumService = sectionOfStadiumService;
    }
    public SectionOfStadiumService getSectionOfStadiumService() {
        return this.sectionOfStadiumService;
    }

    @Autowired
    public void setRowAndSeatService(RowAndSeatService rowAndSeatService){
        this.rowAndSeatService = rowAndSeatService;
    }
    public RowAndSeatService getRowAndSeatService() {
        return this.rowAndSeatService;
    }

}
