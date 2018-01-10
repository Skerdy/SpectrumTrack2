package com.squareup.timessquare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by W2020 Android on 1/5/2018.
 */


//With this class i can keep track of different highlightes dates in monthView at the Calendar Activity

public class LegendHighLight implements Serializable {

    private ArrayList<Date> eventHighlightedDates;
    private String eventName;
    private int eventCellsHighlightColor;


    public LegendHighLight( ArrayList<Date> eventHighlightedDates, int eventCellsHighlightColor){
       // this.eventName = eventName;
        this.eventHighlightedDates = eventHighlightedDates;
        this.eventCellsHighlightColor = eventCellsHighlightColor;
    }

    public ArrayList<Date> getEventHighlightedDates() {
        return eventHighlightedDates;
    }

    public void setEventHighlightedDates(ArrayList<Date> eventHighlightedDates) {
        this.eventHighlightedDates = eventHighlightedDates;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getEventCellsHighlightColor() {
        return eventCellsHighlightColor;
    }

    public void setEventCellsHighlightColor(int eventCellsHighlightColor) {
        this.eventCellsHighlightColor = eventCellsHighlightColor;
    }


}
