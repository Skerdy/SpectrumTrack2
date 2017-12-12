package com.example.w2020skerdjan.spectrumtrack.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.w2020skerdjan.spectrumtrack.Fragments.PlaceholderFragment;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarEntity;

import java.util.ArrayList;

/**
 * Created by W2020 Android on 12/7/2017.
 */

 /** A {@link FragmentPagerAdapter} that returns a fragment corresponding to
        * one of the sections/tabs/pages.
        */

public class CalendarFragmentAdapter extends FragmentPagerAdapter {
        private int lastPosition;
        private int numberOfMonths;
        private ArrayList<PlaceholderFragment> allMonths;
        private CalendarEntity calendarEntity;

        public CalendarFragmentAdapter(FragmentManager fm){
            super(fm);
            allMonths=new ArrayList<>();
            calendarEntity=new CalendarEntity();
            generateAllMonths(10);
        }

        public void generateAllMonths(int numberOfMonths){
            PlaceholderFragment placeholderFragment;
            for(int i =0 ; i<numberOfMonths; i++){
                if(i==0)
                placeholderFragment = PlaceholderFragment.newInstance(calendarEntity.getFragmentCalendarState());

                else{
                    calendarEntity.showActualMonth();
                    placeholderFragment=PlaceholderFragment.newInstance(calendarEntity.getFragmentCalendarState());
                }
                allMonths.add(placeholderFragment);
            }
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return allMonths.get(position);
        }

        @Override
        public int getCount() {
            return allMonths.size();
        }
    }

