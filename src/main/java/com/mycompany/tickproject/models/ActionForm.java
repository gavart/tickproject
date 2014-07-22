package com.mycompany.tickproject.models;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by apple on 21.07.14.
 */
public class ActionForm {
    private List<Integer> sectionsId;
    private List<Integer> actionsId;
    private List<BigDecimal> prices;

    public List<Integer> getSectionsId() {
        return sectionsId;
    }

    public void setSectionsId(List<Integer> sectionsId) {
        this.sectionsId = sectionsId;
    }

    public List<Integer> getActionsId() {
        return actionsId;
    }

    public void setActionsId(List<Integer> actionsId) {
        this.actionsId = actionsId;
    }

    public List<BigDecimal> getPrices() {
        return prices;
    }

    public void setPrices(List<BigDecimal> prices) {
        this.prices = prices;
    }
}
