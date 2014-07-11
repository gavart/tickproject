package com.mycompany.tickproject.helper;

import java.util.ArrayList;
import java.util.List;

/** This class provides method that are used to recalculate indexes of list
 * @author jenias
 * @version 1.0, 11/07/14
 */
public class RecalculationIndexes {

    public <T> List<T> recalculateListIndexes(List<T> list) {
        List<T> newList = new ArrayList<>();
        for(T item : list) {
            if(item!=null) {
                newList.add(item);
            }
        }
        return newList;
    }

}
