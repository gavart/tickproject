package com.mycompany.tickproject.helper;

import com.mycompany.tickproject.models.RowAndSeat;

import java.util.ArrayList;
import java.util.List;

/** This class provides method that are used to generate in the correct order rows and seats
 * @author jenias
 * @version 1.0, 11/07/14
 */
public class GenerationRowsAndSeats {
    /** This method gets list, generate in the correct order rows and seats and returns generated string
     *
     * @param list list with objects
     * @return string
     */
    public <T> String generateRowsAndSeats(List<T> list) {
        StringBuilder paintedRowsAndSeats = new StringBuilder("");
        int row1 = 0;
        int row2 = 0;
        for(RowAndSeat ras: (List<RowAndSeat>)list) {
            row2 = ras.getRow();
            String seat="";

            if(ras.getSeat()==0)
            {
                seat = "<td class=\"row-title\"></td>";
            }
            else {
                seat = "<td class=\"active\" id=\"1\" rowText=\""+ras.getRow()+"\" seatText=\""+String.format("%d",ras.getSeat())+"\" >"+ String.format("%d",ras.getSeat())+"</td>";//String.format("%d",ras.getSeat());
            }
            if(row1==0)
            {
                row1 = ras.getRow();
                paintedRowsAndSeats.append("<tr>" + "\n");
                paintedRowsAndSeats.append("<td class=\"row-title\">"+row1+"</td>" + "\n");
                paintedRowsAndSeats.append(seat + "\n");
            }
            else if(row1 == row2) {
                paintedRowsAndSeats.append(seat + "\n");
            }
            else {
                row1 = ras.getRow();
                paintedRowsAndSeats.append("</tr>" + "\n");
                paintedRowsAndSeats.append("<tr>" + "\n");
                paintedRowsAndSeats.append("<td class=\"row-title\">"+row1+"</td>" + "\n");
                paintedRowsAndSeats.append(seat + "\n");
            }
        }
        paintedRowsAndSeats.append("</tr>" + "\n");
        return paintedRowsAndSeats.toString();
    }
}
