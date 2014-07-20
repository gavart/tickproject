package com.mycompany.tickproject.service;

import com.mycompany.tickproject.models.Price;

import java.util.List;

/**
 * Created by apple on 19.07.14.
 */
public interface PriceService {
    /** This method adds a new {@link com.mycompany.tickproject.models.Price} for certain section and action to the database
     *
     * @param price an object of {@link com.mycompany.tickproject.models.Price}
     */
    public void addPrice(Price price);

    /** This method gets an object from the database by id and edit information about {@link com.mycompany.tickproject.models.Price}
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @param actionId id an object of {@link com.mycompany.tickproject.models.Action}
     */
    public void editPrice(int sectionId,int actionId);

    /** This method gets an object of {@link com.mycompany.tickproject.models.Price} from the database by sectionId and actionId
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @param actionId id an object of {@link com.mycompany.tickproject.models.Action}
     */
    public Price getActualPrice(int sectionId,int actionId);

    /** This method get objects of {@link com.mycompany.tickproject.models.Price} from the database by id an object of {@link com.mycompany.tickproject.models.Action} and return list with objects of {@link com.mycompany.tickproject.models.Price}
     *
     * @param actionId id an object of {@link com.mycompany.tickproject.models.Action}
     */
    public List<Price> getPrices(int actionId);
}
