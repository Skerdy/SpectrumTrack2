package com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated;

import com.squareup.timessquare.LegendHighLight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by W2020 Android on 12/7/2017.
 */

public class FragmentCalendarState implements Serializable {
    private Date calendarStartingDate;
    private Calendar calendarJavaObject;
    private ArrayList<Date> highlighteddates;
    private ArrayList<LegendHighLight> organizedHighLightedDates;

    public FragmentCalendarState(Date dt, Calendar cl){
        calendarJavaObject=cl;
        calendarStartingDate=dt;
        highlighteddates = new ArrayList<>();
        organizedHighLightedDates = new ArrayList<>();
    }


    public void addOneOrganizedDate(LegendHighLight legendHighLight){
        this.organizedHighLightedDates.add(legendHighLight);
    }


    public ArrayList<Date> getHighlighteddates() {
        return highlighteddates;
    }
    public Date getCalendarStartingDate(){
        return calendarStartingDate;
    }
    public Calendar getCalendarJavaObject(){
        return  calendarJavaObject;
    }


    public void setHighlighteddates(ArrayList<Date> dates){
        this.highlighteddates=dates;
    }

    public void clearHighLightedDates (){
        this.highlighteddates.clear();
    }
    public void clearOrganizedDates(){
        this.organizedHighLightedDates.clear();
    }


    public ArrayList<LegendHighLight> getOrganizedHighLightedDates() {
        return organizedHighLightedDates;
    }

    public void setOrganizedHighLightedDates(ArrayList<LegendHighLight> organizedHighLightedDates) {
        this.organizedHighLightedDates = organizedHighLightedDates;
    }

}
