package com.mycompany.tickproject.service;

import com.mycompany.tickproject.models.SectionOfStadium;

import java.util.List;

/** This interface provide methods that are used to work with the entity {@link com.mycompany.tickproject.models.SectionOfStadium} and with {@link com.mycompany.tickproject.dao.FacadeDAO} we gets necessary objects.
 * @author jenias
 * @version 1.0, 09/07/14
 */
public interface SectionOfStadiumService {
    /** This method adds a new {@link com.mycompany.tickproject.models.SectionOfStadium} to the database
     *
     * @param sectionOfStadium an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    public void addSectionOfStadium(SectionOfStadium sectionOfStadium);

    /** This method add list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium} to the database
     *
     * @param listWithSectionsOfStadium list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    public void addSectionsOfStadium(List<SectionOfStadium> listWithSectionsOfStadium);

    /** This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.SectionOfStadium}
     *
     * @param sectionOfStadium an object of {@link com.mycompany.tickproject.models.SectionOfStadium} with updated information
     */
    public void editSectionOfStadium(SectionOfStadium sectionOfStadium);

    /** This method gets an object from the database by id and returns an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @return an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    public SectionOfStadium getSectionOfStadium(int sectionId);

    /** This method get sections of stadium from the database by id and return list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium}
     *
     * @param stadiumID id an object of {@link com.mycompany.tickproject.models.Stadium}
     * @return list with objects of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    public List<SectionOfStadium> getSectionsOfStadium(int stadiumID);

    /** This method removes an object of {@link com.mycompany.tickproject.models.SectionOfStadium} from the database
     *
     * @param sectionOfStadium an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     */
    public void removeSectionOfStadium(SectionOfStadium sectionOfStadium);
}
