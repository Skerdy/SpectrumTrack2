package com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated;

import com.example.w2020skerdjan.spectrumtrack.Utils.CalendarUtilsResponse;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by W2020 Android on 1/8/2018.
 */

public class CustomCalendarEvent {

    public static final String FULL_EVENT = "full_event";
    public static final String HALF_EVENT = "half_event";

    private String type;
    private Integer tripID;
    private DrivingSession startDrivingSession;
    private DrivingSession finishDrivingSession;
    private ArrayList<Date> inBetweenDates;
    private int color;

    public CustomCalendarEvent(String type, DrivingSession startDrivingSession, DrivingSession finishDrivingSession){
        this.startDrivingSession = startDrivingSession;
        this.finishDrivingSession = finishDrivingSession;
        this.type = type;
        if(type.equals(FULL_EVENT))
        inBetweenDates = new ArrayList<>();
    }

    public boolean isFullEvent(){
        if(type==FULL_EVENT){
            return true;
        }
        else return false;
    }


   //getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DrivingSession getStartDrivingSession() {
        return startDrivingSession;
    }

    public void setStartDrivingSession(DrivingSession startDrivingSession) {
        this.startDrivingSession = startDrivingSession;
    }

    public DrivingSession getFinishDrivingSession() {
        return finishDrivingSession;
    }

    public void setFinishDrivingSession(DrivingSession finishDrivingSession) {
        this.finishDrivingSession = finishDrivingSession;
    }

    public ArrayList<Date> getInBetweenDates() {
        return inBetweenDates;
    }

    public void setInBetweenDates(ArrayList<Date> inBetweenDates) {
        this.inBetweenDates = inBetweenDates;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    public Integer getTripID() {
        return tripID;
    }

    public void setTripID(Integer tripID) {
        this.tripID = tripID;
    }

}
