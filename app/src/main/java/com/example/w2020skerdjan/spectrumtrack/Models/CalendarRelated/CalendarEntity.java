package com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated;

import android.util.Log;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by W2020 Android on 12/6/2017.
 */

public class CalendarEntity implements Serializable{
    //kalendar stuff
    private int CurrentMonth, todayMonth, CurrentYear, todayYear;
    private Date today;
    private Date lastGeneratedDate;
    private Calendar kalendar_android;
    private FragmentCalendarState fragmentCalendarState;


    public CalendarEntity (){
        today = new Date();
        lastGeneratedDate=today;
        todayMonth = getMonthFromDate(today);
        CurrentMonth=todayMonth;
        todayYear = getYearFromDate(today);
        CurrentYear=todayYear;
        Log.d("Current Month ", " "+CurrentMonth);
        kalendar_android = fetchCalendarDates(today);
        fragmentCalendarState= new FragmentCalendarState(today,kalendar_android);
    }

    public FragmentCalendarState getFragmentCalendarState(){
        return this.fragmentCalendarState;
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

    public Calendar fetchCalendarDates(Date startingDay){
        Calendar kalendar = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        kalendar.setTime(startingDay);
        cal.setTime(startingDay);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int deltaDate = kalendar.getActualMaximum(Calendar.DAY_OF_MONTH)-day + 1 ;
        Log.d("Data Sot", " "+ day +" "+ year + " delta Date = "+ deltaDate);
        kalendar.add(Calendar.DATE,deltaDate);
        return kalendar;
    }

    public void showActualMonth(){
        Calendar workingCal;
        if (CurrentMonth == 11) {
            ++CurrentYear;
            CurrentMonth = -1;
        }
        Date nextMonthFirstDate = krijoDate(CurrentYear, CurrentMonth + 1);
        lastGeneratedDate = nextMonthFirstDate;
        Log.d("Data e muajit tjeter", nextMonthFirstDate.toString());
        workingCal = fetchCalendarDates(nextMonthFirstDate);
        CurrentMonth++;
        fragmentCalendarState= new FragmentCalendarState(nextMonthFirstDate,workingCal);
    }

    public Date krijoDate (int Viti, int muaji){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Viti);
        calendar.set(Calendar.MONTH, muaji);
        calendar.set(Calendar.DATE, 1);
        Date date = calendar.getTime();
        return date;
    }

    public Date getToday(){
        return this.today;
    }

    public int getTodayMonth(){
        return todayMonth;
    }

    public int getTodayYear(){
        return todayYear;
    }

    public int getCurrentMonth(){
        return CurrentMonth;
    }

    public int getCurrentYear(){
        return CurrentYear;
    }

    public Date getLastGeneratedDate() {
        return lastGeneratedDate;
    }
}
