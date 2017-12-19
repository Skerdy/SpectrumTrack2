package com.example.w2020skerdjan.spectrumtrack.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.w2020skerdjan.spectrumtrack.Fragments.MonthFragment;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarEntity;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.CalendarResponse;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.CalendarRelatedCalls.CalendarCalls;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Utils.RetrofitHeaderManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


 /** A {@link FragmentPagerAdapter} that returns a fragment corresponding to
        * one of the sections/tabs/pages.
        */

public class CalendarFragmentAdapter extends FragmentStatePagerAdapter {

        private int numberOfMonths;
        private CalendarEntity calendarEntity;
        private Retrofit retrofit;
        private RetrofitClient retrofitClient;
        private CalendarCalls calendarCalls;
        private CalendarResponse calendarResponse;
        private Context ctx;
        private List<MonthFragment> months;
        private int monthIterator;


        public CalendarFragmentAdapter(FragmentManager fm, int numberOfMonths, Context ctx){
            super(fm);
            calendarEntity=new CalendarEntity();
            months =new ArrayList<>();
            this.ctx=ctx;
            this.numberOfMonths = numberOfMonths;
            retrofitClient = new RetrofitClient();
            retrofit = retrofitClient.krijoRetrofit();
            calendarCalls= retrofit.create(CalendarCalls.class);
            fetchAllMonths();
            monthIterator=1;
        }



        @Override
        public Fragment getItem(int position) {
            /*
            if(position==0){
                makeCalendarCall();
                return MonthFragment.newInstance(calendarEntity.getFragmentCalendarState());


            }
            else {
                calendarEntity.showActualMonth();
                makeCalendarCall();
                return MonthFragment.newInstance(calendarEntity.getFragmentCalendarState());
            }
            */
            return months.get(position);

        }

        @Override
        public int getCount() {
            return numberOfMonths;
        }



        public void makeCalendarCall(){
            calendarCalls.getCalendarEvents(RetrofitHeaderManager.getCalendarMap(ctx,calendarEntity.getCurrentMonth(),calendarEntity.getCurrentYear())).enqueue(calendarCallback);
        }

       Callback<CalendarResponse> calendarCallback = new Callback<CalendarResponse>() {
           @Override
           public void onResponse(Call<CalendarResponse> call, Response<CalendarResponse> response) {
               if(response.isSuccessful()) {
                   Log.d("Kalendar", "Success" );
                   calendarResponse = response.body();

                   if( calendarResponse != null)
                   if(calendarResponse.getData().size()!=0) {

                       if(monthIterator!=1)
                       calendarEntity.showActualMonth();

                       Log.d("Kalendar", calendarResponse.getData().toString() );
                       MonthFragment actualMonth = MonthFragment.newInstance(calendarEntity.getFragmentCalendarState());
                       months.add(actualMonth);
                   }
               }
               else {
                   Log.d("Kalendar", "noSucces" );
               }
           }


           @Override
           public void onFailure(Call<CalendarResponse> call, Throwable t) {
               Log.d("Kalendar", "Failure Calendar FetchData" + t.getMessage());
           }
       };


        public void fetchAllMonths(){
            for(int i =0; i<numberOfMonths;i++){
                if(i==0){
                    makeCalendarCall();
                }
                else{
                    makeCalendarCall();
                }
                monthIterator++;
            }
        }

    }

