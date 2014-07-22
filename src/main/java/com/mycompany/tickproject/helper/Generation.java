package com.mycompany.tickproject.helper;

import com.mycompany.tickproject.models.Action;
import com.mycompany.tickproject.models.RowAndSeat;
import com.mycompany.tickproject.models.SectionOfStadium;
import com.mycompany.tickproject.models.Ticket;

import javax.validation.constraints.Null;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** This class provides method that are used to generate in the correct order rows and seats
 * @author jenias
 * @version 1.0, 11/07/14
 */
public class Generation {

    public String generateOneAction(Action action, String contextPath) {
        StringBuilder paintedAction = new StringBuilder("");

        SimpleDateFormat ftDate = new SimpleDateFormat ("yyyy-MM-dd");
        SimpleDateFormat ftTime = new SimpleDateFormat ("HH:mm");
        paintedAction.append("<div id=\"oneAction\"><span class=\"dateAction\">"+ftDate.format(action.getDateTimeAction()) +"</span> в <span class=\"timeAction\">"+ftTime.format(action.getDateTimeAction())+"</span> Стадион:<span class=\"placeAction\">"+action.getStadium().getName()+"</span><div class=\"nameAction\">"+action.getNameAction()+"</div></div>");
        return paintedAction.toString();
    }

    public String generateActions(List<Action> actionList, String contextPath) {
        StringBuilder paintedActions = new StringBuilder("");

        SimpleDateFormat ftDate = new SimpleDateFormat ("yyyy-MM-dd");
        SimpleDateFormat ftTime = new SimpleDateFormat ("HH:mm");

        for(Action action:actionList) {
            paintedActions.append("<li class=\"action\"><a href=\""+contextPath+"/getsections?idaction="+action.getId()+"&idstadium="+action.getStadium().getId()+"\" ><span class=\"dateAction\">"+ftDate.format(action.getDateTimeAction()) +"</span> в <span class=\"timeAction\">"+ftTime.format(action.getDateTimeAction())+"</span> Стадион:<span class=\"placeAction\">"+action.getStadium().getName()+"</span><div class=\"nameAction\">"+action.getNameAction()+"</div></a></li>");
        }
        return paintedActions.toString();
    }

    public String generateSections(List<SectionOfStadium> list, String contextPath,int actionId) {
        StringBuilder sections = new StringBuilder();
        sections.append("<ul class=\"sector-number\">\n");
        int count = 1;
        for(SectionOfStadium sectionOfStadium : list) {
            sections.append("<li style=\"background-color:"+ sectionOfStadium.getColor() +";\" data-idsection=\""+sectionOfStadium.getId()+"\"><a href=\""+ contextPath +"/showseats?idaction="+actionId+"&idsection="+sectionOfStadium.getId()+"\">" + sectionOfStadium.getName() + "</a></li>");
        }
        sections.append("</ul>");
        return sections.toString();
    }

    /** This method gets list, generate in the correct order rows and seats and returns generated string
     *
     * @param list list with objects
     * @return string
     */
    public String generateRowsAndSeatsFromRowsAndSeatsList(List<RowAndSeat> list) {
        StringBuilder paintedRowsAndSeats = new StringBuilder("");
        int row1 = 0;
        int row2 = 0;
        for(RowAndSeat ras: (List<RowAndSeat>)list) {
            row2 = ras.getRow();
            String seat="";

            if(ras.getSeat()==0) {
                seat = "<td class=\"row-title\"></td>";
            }
            else {
                seat = "<td class=\"active\" id=\"1\" rowText=\""+ras.getRow()+"\" seatText=\""+String.format("%d",ras.getSeat())+"\" >"+ String.format("%d",ras.getSeat())+"</td>";//String.format("%d",ticket.getSeat());
            }
            if(row1==0) {
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
///////////////////////////
    public String generateRowsAndSeatsFromTicketsList(List<Ticket> list) {
        StringBuilder paintedRowsAndSeats = new StringBuilder("");
        int row1 = 0;
        int row2 = 0;
        for(Ticket ticket : list) {
            row2 = ticket.getRowAndSeat().getRow();
            String seat="";

            if(ticket.getRowAndSeat().getSeat()==0) {
                seat = "<td class=\"row_title\"></td>";
            }
            else {
                if(ticket.getStatus()== null) {
                    seat = "<td title =\""+"ряд: "+ticket.getRowAndSeat().getRow()+"\"class=\"active\" id=\""+ticket.getRowAndSeat().getId()+"\" rowText=\""+ ticket.getRowAndSeat().getRow()+"\" seatText=\""+String.format("%d", ticket.getRowAndSeat().getSeat())+"\" priceSeat=\""+ticket.getPrice().getPrice()+"\" >"+ String.format("%d", ticket.getRowAndSeat().getSeat())+"</td>";//String.format("%d",ticket.getSeat());
                } else {
                    seat = "<td class=\"" + ticket.getStatus().getStatus() + "\" id=\""+ticket.getRowAndSeat().getId()+"\" rowText=\""+ ticket.getRowAndSeat().getRow()+"\" seatText=\""+String.format("%d", ticket.getRowAndSeat().getSeat())+"\" priceSeat=\""+ticket.getPrice().getPrice()+"\" >"+ String.format("%d", ticket.getRowAndSeat().getSeat())+"</td>";//String.format("%d",ticket.getSeat());
                }
            }
            if(row1==0) {
                row1 = ticket.getRowAndSeat().getRow();
                paintedRowsAndSeats.append("<tr>" + "\n");
                paintedRowsAndSeats.append("<td class=\"row_title\">"+row1+"</td>" + "\n");
                paintedRowsAndSeats.append(seat + "\n");
            }
            else if(row1 == row2) {
                paintedRowsAndSeats.append(seat + "\n");
            }
            else {
                row1 = ticket.getRowAndSeat().getRow();
                paintedRowsAndSeats.append("</tr>" + "\n");
                paintedRowsAndSeats.append("<tr>" + "\n");
                paintedRowsAndSeats.append("<td class=\"row_title\">"+row1+"</td>" + "\n");
                paintedRowsAndSeats.append(seat + "\n");
            }
        }
        paintedRowsAndSeats.append("</tr>" + "\n");
        return paintedRowsAndSeats.toString();
    }
}
