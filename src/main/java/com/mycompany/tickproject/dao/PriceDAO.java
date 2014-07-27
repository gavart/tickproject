package com.mycompany.tickproject.dao;

import com.mycompany.tickproject.models.Price;

import java.util.List;

/** This interface provide methods that are used to work with the entity {@link com.mycompany.tickproject.models.Price}
 * @author jenias
 * @version 1.0, 08/07/14
 */
public interface PriceDAO {
    /** This method adds a new {@link com.mycompany.tickproject.models.Price} for certain section and action to the database
     *
     * @param price an object of {@link com.mycompany.tickproject.models.Price}
     */
    public void addPrice(Price price);

    /** This method adds a new {@link com.mycompany.tickproject.models.Price} for certain section and action to the database
     *
     * @param prices list with objects of {@link com.mycompany.tickproject.models.Price}
     */
    public void addPrices(List<Price> prices);

    /** This method update an object information about {@link com.mycompany.tickproject.models.Price} in database
     *
     * @param price an object of {@link com.mycompany.tickproject.models.Price}
     */
    public void editPrice(Price price);

    /** This method get list with objects from the database by action id and edit information about {@link com.mycompany.tickproject.models.Price}
     *
     * @param actionId id an object of {@link com.mycompany.tickproject.models.Action}
     */
    public void editPrices(int actionId);

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
