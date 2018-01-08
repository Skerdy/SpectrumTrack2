package com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated;

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Disposition;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.LoadUnload;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by W2020 Android on 1/8/2018.
 */

public class CalendarTrip {
    private Integer id;
    private String name;
    private String instructions;
    private Disposition disposition;
    private Long createdAt;
    private ArrayList<CustomCalendarEvent> calendarCustomEvents;

    public CalendarTrip(Integer id, String name){
        this.id=id;
        this.name=name;
    }

    public CalendarTrip(Integer id, String name, Disposition disposition ){
        this.id=id;
        this.name=name;
        this.disposition=disposition;
    }

    public CalendarTrip(Integer id, String name, String instructions, Disposition disposition, Long createdAt){
        this.id=id;
        this.name=name;
        this.instructions = instructions;
        this.disposition=disposition;
        this.createdAt=createdAt;
    }

    public CalendarTrip(Integer id, String name, Disposition disposition, ArrayList<CustomCalendarEvent> calendarCustomEvents){
        this.id=id;
        this.name=name;
        this.disposition=disposition;
        this.createdAt=createdAt;
        this.calendarCustomEvents=calendarCustomEvents;
    }

    public void addCustomCalendarEvent ( CustomCalendarEvent customCalendarEvent){
        calendarCustomEvents.add(customCalendarEvent);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Disposition getDisposition() {
        return disposition;
    }

    public void setDisposition(Disposition disposition) {
        this.disposition = disposition;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<CustomCalendarEvent> getCalendarCustomEvents() {
        return calendarCustomEvents;
    }

    public void setCalendarCustomEvents(ArrayList<CustomCalendarEvent> calendarCustomEvents) {
        this.calendarCustomEvents = calendarCustomEvents;
    }

}
