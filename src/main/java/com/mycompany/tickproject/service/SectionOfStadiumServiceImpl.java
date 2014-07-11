package com.mycompany.tickproject.service;

import com.mycompany.tickproject.dao.FacadeDAO;
import com.mycompany.tickproject.models.SectionOfStadium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** This class implement methods that are used to work with the entity {@link com.mycompany.tickproject.models.SectionOfStadium} and with {@link com.mycompany.tickproject.dao.FacadeDAO} we gets necessary objects.
 * @author jenias
 * @version 1.0, 09/07/14
 */
@Service
public class SectionOfStadiumServiceImpl implements SectionOfStadiumService {

    @Autowired
    private FacadeDAO facadeDAO;
    /**
     * This method adds a new {@link com.mycompany.tickproject.models.SectionOfStadium} to the database
     *
     * @param sectionOfStadium an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Transactional
    @Override
    public void addSectionOfStadium(SectionOfStadium sectionOfStadium) {
        facadeDAO.getSectionOfStadiumDAO().addSectionOfStadium(sectionOfStadium);
    }

    /**
     * This method add list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium} to the database
     *
     * @param listWithSectionsOfStadium list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Transactional
    @Override
    public void addSectionsOfStadium(List<SectionOfStadium> listWithSectionsOfStadium) {
        //facadeDAO.getSectionOfStadiumDAO().addSectionsOfStadium(listWithSectionsOfStadium);
    }

    /**
     * This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.SectionOfStadium}
     *
     * @param sectionOfStadium an object of {@link com.mycompany.tickproject.models.SectionOfStadium} with updated information
     */
    @Transactional
    @Override
    public void editSectionOfStadium(SectionOfStadium sectionOfStadium) {
        facadeDAO.getSectionOfStadiumDAO().editSectionOfStadium(sectionOfStadium);
    }

    /**
     * This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @return an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Transactional
    @Override
    public SectionOfStadium getSectionOfStadium(int sectionId) {
        return facadeDAO.getSectionOfStadiumDAO().getSectionOfStadium(sectionId);
    }

    /**
     * This method get sections of stadium from the database by id and return list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium}
     *
     * @param stadiumID id an object of {@link com.mycompany.tickproject.models.Stadium}
     * @return list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Transactional
    @Override
    public List<SectionOfStadium> getSectionsOfStadium(int stadiumID) {
        return facadeDAO.getSectionOfStadiumDAO().getSectionsOfStadium(stadiumID);
    }

    /**
     * This method removes an object of {@link com.mycompany.tickproject.models.SectionOfStadium} from the database
     *
     * @param sectionOfStadium an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    @Transactional
    @Override
    public void removeSectionOfStadium(SectionOfStadium sectionOfStadium) {
        facadeDAO.getSectionOfStadiumDAO().removeSectionOfStadium(sectionOfStadium);
    }
}
