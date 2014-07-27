package com.mycompany.tickproject.service;

import com.mycompany.tickproject.dao.FacadeDAO;
import com.mycompany.tickproject.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by apple on 19.07.14.
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private FacadeDAO facadeDAO;
    /**
     * This method adds a new {@link com.mycompany.tickproject.models.Price} for certain section and action to the database
     *
     * @param price an object of {@link com.mycompany.tickproject.models.Price}
     */
    @Transactional
    @Override
    public void addPrice(Price price) {
        facadeDAO.getPriceDAO().addPrice(price);
    }

    /**
     * This method update an object information about {@link com.mycompany.tickproject.models.Price} in database
     *
     * @param price an object of {@link com.mycompany.tickproject.models.Price}
     */
    @Transactional
    @Override
    public void editPrice(Price price) {
        facadeDAO.getPriceDAO().editPrice(price);
    }

    /**
     * This method gets an object of {@link com.mycompany.tickproject.models.Price} from the database by sectionId and actionId
     *
     * @param sectionId id an object of {@link com.mycompany.tickproject.models.SectionOfStadium}
     * @param actionId  id an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Transactional
    @Override
    public Price getActualPrice(int sectionId, int actionId) {
        return facadeDAO.getPriceDAO().getActualPrice(sectionId,actionId);
    }

    /**
     * This method get objects of {@link com.mycompany.tickproject.models.Price} from the database by id an object of {@link com.mycompany.tickproject.models.Action} and return list with objects of {@link com.mycompany.tickproject.models.Price}
     *
     * @param actionId id an object of {@link com.mycompany.tickproject.models.Action}
     */
    @Transactional
    @Override
    public List<Price> getPrices(int actionId) {
        return facadeDAO.getPriceDAO().getPrices(actionId);
    }
}
