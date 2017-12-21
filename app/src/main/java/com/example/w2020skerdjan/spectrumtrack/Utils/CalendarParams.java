package com.example.w2020skerdjan.spectrumtrack.Utils;

/**
 * Created by W2020 Android on 12/21/2017.
 */

public class CalendarParams {
    private int[] monthParams;
    private int[] yearParams;
    private int year;
    private int month;

    public CalendarParams( int numberOfMonths, int year, int month){
        this.year = year;
        this.month = month;
        monthParams= new int[numberOfMonths];
        yearParams = new int[numberOfMonths];

        for(int i =0 ; i<numberOfMonths ; i++){
              if(month==13){
                  month=1;
                  year++;
              }
              monthParams[i] = month;
              yearParams[i] = year;
              month++;
        }
    }

    public  int[] getMonthParams(){
        return monthParams;
    }

    public  int[] getYearParams(){
        return yearParams;
    }
}
