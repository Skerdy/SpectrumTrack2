package com.example.w2020skerdjan.spectrumtrack.Models;

import com.squareup.timessquare.CalendarPickerView;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by W2020 Android on 12/7/2017.
 */

public class FragmentCalendarState implements Serializable {
    private Date calendarStartingDate;
    private Calendar calendarJavaObject;
    private CalendarPickerView cal;
    private List<Date> highlighteddates;

    public FragmentCalendarState(Date dt, Calendar cl){
        calendarJavaObject=cl;
        calendarStartingDate=dt;
    }

    public Date getCalendarStartingDate(){
        return calendarStartingDate;
    }
    public Calendar getCalendarJavaObject(){
        return  calendarJavaObject;
    }

    public void initCalendarInFragment(CalendarPickerView cal){
        this.cal=cal;
        cal.init(calendarStartingDate, calendarJavaObject.getTime())
                .inMode(CalendarPickerView.SelectionMode.SINGLE);
    }

}
