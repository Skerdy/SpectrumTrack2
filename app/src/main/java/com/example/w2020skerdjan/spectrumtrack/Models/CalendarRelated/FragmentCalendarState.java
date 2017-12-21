package com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated;

import android.graphics.Color;

import com.squareup.timessquare.CalendarCellView;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.DayViewAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by W2020 Android on 12/7/2017.
 */

public class FragmentCalendarState implements Serializable {
    private Date calendarStartingDate;
    private Calendar calendarJavaObject;

    public ArrayList<Date> getHighlighteddates() {
        return highlighteddates;
    }

    private ArrayList<Date> highlighteddates;

    public FragmentCalendarState(Date dt, Calendar cl){
        calendarJavaObject=cl;
        calendarStartingDate=dt;
        highlighteddates = new ArrayList<>();
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

    public Date krijoDate (int Viti, int muaji, int dite){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Viti);
        calendar.set(Calendar.MONTH, muaji);
        calendar.set(Calendar.DATE, dite);
        Date date = calendar.getTime();
        return date;
    }

    private int getMonthFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return month;
    }

    private  int getYearFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return year;
    }

    private int getDayFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day;
    }

}
