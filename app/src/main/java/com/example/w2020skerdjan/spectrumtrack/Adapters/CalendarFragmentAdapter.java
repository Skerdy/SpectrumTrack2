package com.example.w2020skerdjan.spectrumtrack.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.w2020skerdjan.spectrumtrack.Activities.CalendarActivity;
import com.example.w2020skerdjan.spectrumtrack.Activities.MainMenu;
import com.example.w2020skerdjan.spectrumtrack.Fragments.MonthFragment;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarEntity;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.CalendarResponse;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.CalendarRelatedCalls.CalendarCalls;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Utils.CalendarUtilsResponse;
import com.example.w2020skerdjan.spectrumtrack.Utils.RetrofitHeaderManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


 /** A {@link FragmentPagerAdapter} that returns a fragment corresponding to
        * one of the sections/tabs/pages.
        */

public class CalendarFragmentAdapter extends FragmentPagerAdapter {

        private int numberOfMonths;
        private CalendarEntity calendarEntity;
        private Retrofit retrofit;
        private RetrofitClient retrofitClient;
        private CalendarCalls calendarCalls;
        private CalendarResponse calendarResponse;
        private Context ctx;
        private List<MonthFragment> months;
        private int monthIterator;
        private boolean doNotifyDataSetChangedOnce = false;
        private ArrayList<Date> highlightedDates;
        private CalendarEntity cl;

        private int monthParam, yearParam;

        public CalendarFragmentAdapter(FragmentManager fm, int numberOfMonths, Context ctx){
            super(fm);
            calendarEntity=new CalendarEntity();
            monthParam = calendarEntity.getCurrentMonth()+1;
            yearParam = calendarEntity.getCurrentYear();
            months =new ArrayList<>();
            highlightedDates = new ArrayList<>();
            this.ctx=ctx;
            this.numberOfMonths = numberOfMonths;

            retrofitClient = new RetrofitClient();
            retrofit = retrofitClient.krijoRetrofit();
            calendarCalls= retrofit.create(CalendarCalls.class);
           // monthIterator=1;
            //fetchAllMonths();
        }


        @Override
        public Fragment getItem(int position) {
                        //kontrollo nese jemi ne fundin e nje viti
            if(monthParam==13){
                monthParam=1;
                yearParam++;
            }

             cl = new CalendarEntity();
            //nese nuk eshte muaji i sotem instatiate nga starting date = 1 ;
            if(position != 0) {
                cl.initWithDate(CalendarEntity.krijoDate(yearParam, monthParam-1));
            }

            MonthFragment monthFragment = MonthFragment.newInstance(cl.getFragmentCalendarState());
            monthParam++;

            if (doNotifyDataSetChangedOnce) {
                doNotifyDataSetChangedOnce = false;
                notifyDataSetChanged();
            };

            Log.d("Kalendar", "Return Fragment time");
            return monthFragment;
        }

        @Override
        public int getCount() {
            if (doNotifyDataSetChangedOnce) {
                doNotifyDataSetChangedOnce = false;
                notifyDataSetChanged();
            }
            return numberOfMonths;
        }

        /*
        public void makeCalendarCall(){

            if(monthParam==13){
                monthParam=1;
                yearParam++;
            }
            Log.d("CalendarState", " getCurrentMonth = " + monthParam + " ||| getCurrentYear = " + yearParam);
            calendarCalls.getCalendarEvents(RetrofitHeaderManager.getCalendarMap(ctx,monthParam,yearParam)).enqueue(calendarCallback);
            monthParam++;
        }



       Callback<CalendarResponse> calendarCallback = new Callback<CalendarResponse>() {
           @Override
           public void onResponse(Call<CalendarResponse> call, Response<CalendarResponse> response) {
               if (response.isSuccessful()) {
                   doNotifyDataSetChangedOnce = true;
                   Log.d("Kalendar", "Success");
                   calendarResponse = response.body();

                   if (calendarResponse != null) {
                       if (calendarResponse.getData().size() != 0) {
                          monthFragment = mapResponseWithUtils();
                       }
                       else {
                           //logjika kur calendar response size eshte 0
                           Log.d("Kalendar", "Response size eshte 0");
                       }
                   }
                   else Log.d("Kalendar", "Response eshte null");
               }
               else {
                   Log.d("Kalendar", "noSucces");
               }
           }


           @Override
           public void onFailure (Call < CalendarResponse > call, Throwable t){
               Log.d("Kalendar", "Failure Calendar FetchData" + t.getMessage());
           }
       };


       */


           public MonthFragment mapResponseWithUtils(){
               if (monthIterator != 1) {
                   Log.d("Kalendar", "monthIterator is " +monthIterator);
                   calendarEntity.showActualMonth();

               } else {
                   Log.d("Kalendar", "monthIterator is "+monthIterator);
               }

               CalendarUtilsResponse calendarUtilsResponse = new CalendarUtilsResponse(calendarResponse);
               if (calendarUtilsResponse.getResultHighlight().size() != 0) {
                   Log.d("Kalendar", "HighlightedDates te llogaritura jane OK");
                   calendarEntity.getFragmentCalendarState().setHighlighteddates(calendarUtilsResponse.getResultHighlight());
               }
               else {
                   Log.d("Kalendar", "HighlightedDates te llogaritura jane Bosh");
               }
               MonthFragment actualMonth = MonthFragment.newInstance(calendarEntity.getFragmentCalendarState());
               months.add(actualMonth);
               notifyDataSetChanged();
               monthIterator++;
               //calendarEntity.getFragmentCalendarState().clearHighLightedDates();
              // calendarUtilsResponse.clearHighlightedResult();
               return actualMonth;
           }




        Callback<CalendarResponse> finalCalendarCallback = new Callback<CalendarResponse>() {
            @Override
            public void onResponse(Call<CalendarResponse> call, Response<CalendarResponse> response) {
                if (response.isSuccessful()) {
                    doNotifyDataSetChangedOnce = true;
                    Log.d("Kalendar", "Success");
                    calendarResponse = response.body();

                    if (calendarResponse != null) {
                        if (calendarResponse.getData().size() != 0) {

                            CalendarUtilsResponse calendarUtilsResponse = new CalendarUtilsResponse(calendarResponse);
                            if (calendarUtilsResponse.getResultHighlight().size() != 0) {
                                Log.d("Kalendar", "HighlightedDates te llogaritura jane OK");
                                cl.getFragmentCalendarState().setHighlighteddates(calendarUtilsResponse.getResultHighlight());
                                notifyDataSetChanged();
                            }
                            else {
                                Log.d("Kalendar", "HighlightedDates te llogaritura jane Bosh");
                            }
                        }
                        else {
                            //logjika kur calendar response size eshte 0
                            Log.d("Kalendar", "Response size eshte 0");
                        }
                    }
                    else Log.d("Kalendar", "Response eshte null");
                }
                else {
                    Log.d("Kalendar", "noSucces");
                }
            }

            @Override
            public void onFailure(Call<CalendarResponse> call, Throwable t) {

            }
        };

/*
     public void fetchAllMonths(){
         for(int i =0; i<numberOfMonths;i++){
             makeCalendarCall();
             notifyDataSetChanged();
         }
     }

     */


    }

