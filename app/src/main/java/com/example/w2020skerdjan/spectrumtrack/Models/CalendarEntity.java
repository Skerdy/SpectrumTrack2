package com.example.w2020skerdjan.spectrumtrack.Models;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by W2020 Android on 12/6/2017.
 */

public class CalendarEntity {
    //kalendar stuff
    private int CurrentMonth, todayMonth, CurrentYear, todayYear;
    private Calendar kalendar_android;
    private Date today;
    private Date lastGeneratedDate;
    private List<Date> dates;
    public final int ROLL_CALENDAR_UP=1;
    public final int ROLL_CALENDAR_DOWN=2;

    public CalendarEntity (){
        today=new Date();
    }



}
