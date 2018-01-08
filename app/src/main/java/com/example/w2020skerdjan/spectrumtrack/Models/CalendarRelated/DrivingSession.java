package com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated;

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Trip;

import java.util.Date;

/**
 * Created by W2020 Android on 1/8/2018.
 */

public class DrivingSession {
    public final static String LOAD = "load";
    public final static String UNLOAD = "unload";

    private String type;
    private Date date;
    private DrivingSessionAddress drivingSessionAddress;


    public DrivingSession (String type, Date date, DrivingSessionAddress drivingSessionAddress){
        this.type = type;
        this.date = date;
        this.drivingSessionAddress = drivingSessionAddress;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DrivingSessionAddress getDrivingSessionAddress() {
        return drivingSessionAddress;
    }

    public void setDrivingSessionAddress(DrivingSessionAddress drivingSessionAddress) {
        this.drivingSessionAddress = drivingSessionAddress;
    }

}
