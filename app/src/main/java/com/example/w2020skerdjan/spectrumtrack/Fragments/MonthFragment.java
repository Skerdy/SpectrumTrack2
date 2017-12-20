package com.example.w2020skerdjan.spectrumtrack.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarEntity;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.FragmentCalendarState;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.CalendarResponse;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.CalendarRelatedCalls.CalendarCalls;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Utils.CalendarUtilsResponse;
import com.example.w2020skerdjan.spectrumtrack.Utils.RetrofitHeaderManager;
import com.squareup.timessquare.CalendarPickerView;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by W2020 Android on 12/7/2017.
 */

    public  class MonthFragment extends Fragment {
        private static final String ARGUMENTS = "arg";
        private static final String DATES = "dates";
        private FragmentCalendarState fragmentCalendarState;
        private CalendarPickerView calendarPickerView;
        private ArrayList<Date> highlightedDates=null;


        private int monthParam, yearParam;
        private Retrofit retrofit;
        private RetrofitClient retrofitClient;
        private CalendarCalls calendarCalls;
        private CalendarResponse calendarResponse;

        public MonthFragment() {

        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            fragmentCalendarState = (FragmentCalendarState) getArguments().getSerializable(ARGUMENTS);
            monthParam =fragmentCalendarState.getCalendarStartingDate().getMonth()+1;
            yearParam = CalendarEntity.getYearFromDate(fragmentCalendarState.getCalendarStartingDate());
            retrofitClient = new RetrofitClient();
            retrofit = retrofitClient.krijoRetrofit();
            calendarCalls = retrofit.create(CalendarCalls.class);
            Log.d("CalendarStateFragment", " getCurrentMonth = " + monthParam + " ||| getCurrentYear = " + yearParam);
            calendarCalls.getCalendarEvents(RetrofitHeaderManager.getCalendarMap(getActivity(),monthParam,yearParam)).enqueue(finalCalendarCallback);

        }


        public static MonthFragment newInstance(FragmentCalendarState calendarState) {
            MonthFragment fragment = new MonthFragment();
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

            fragmentCalendarState.initCalendarInFragment(calendarPickerView);
            if(highlightedDates!=null)
            fragmentCalendarState.setHighlighteddates((highlightedDates));
            return rootView;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        }


    @Override
    public void onResume() {
        super.onResume();
    }

    Callback<CalendarResponse> finalCalendarCallback = new Callback<CalendarResponse>() {
        @Override
        public void onResponse(Call<CalendarResponse> call, Response<CalendarResponse> response) {
            if (response.isSuccessful()) {

                Log.d("Kalendar", "Success");
                calendarResponse = response.body();
                if (calendarResponse != null) {
                    if (calendarResponse.getData().size() != 0) {
                        CalendarUtilsResponse calendarUtilsResponse = new CalendarUtilsResponse(calendarResponse);
                        if (calendarUtilsResponse.getResultHighlight().size() != 0) {
                            Log.d("Kalendar", "HighlightedDates te llogaritura jane OK");
                            fragmentCalendarState.setHighlighteddates(calendarUtilsResponse.getResultHighlight());
                            fragmentCalendarState.initCalendarInFragment(calendarPickerView);
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
}
