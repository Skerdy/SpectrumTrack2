package com.example.w2020skerdjan.spectrumtrack.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.FragmentCalendarState;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.squareup.timessquare.CalendarPickerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by W2020 Android on 12/7/2017.
 */

    public  class PlaceholderFragment extends Fragment {
        private static final String ARGUMENTS = "arg";
        private static final String DATES = "dates";
        private FragmentCalendarState fragmentCalendarState;
        private CalendarPickerView calendarPickerView;
        private ArrayList<Date> highlightedDates=null;

        public PlaceholderFragment() {
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }


        public static PlaceholderFragment newInstance(FragmentCalendarState calendarState) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putSerializable(ARGUMENTS,calendarState);
            //args.putSerializable(DATES, dates);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
            calendarPickerView = (CalendarPickerView) rootView.findViewById(R.id.calendar_view);
            fragmentCalendarState = (FragmentCalendarState) getArguments().getSerializable(ARGUMENTS);
            fragmentCalendarState.initCalendarInFragment(calendarPickerView);
            if(highlightedDates!=null)
            fragmentCalendarState.setHighlighteddates((highlightedDates));
            return rootView;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        }
}
