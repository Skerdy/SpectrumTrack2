package com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated;

/**
 * Created by W2020 Android on 12/21/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonalAreaData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("fine")
    @Expose
    private Integer fine;
    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("week")
    @Expose
    private Integer week;
    @SerializedName("nextStop")
    @Expose
    private Integer nextStop;
    @SerializedName("user")
    @Expose
    private Integer user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getNextStop() {
        return nextStop;
    }

    public void setNextStop(Integer nextStop) {
        this.nextStop = nextStop;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}
