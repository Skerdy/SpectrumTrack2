package com.example.w2020skerdjan.spectrumtrack.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarEntity;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.FragmentCalendarState;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.CalendarResponse;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.CalendarLegendAdapter;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.SectionedLegendAdapter;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.CalendarRelatedCalls.CalendarCalls;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Utils.CalendarUtils;
import com.example.w2020skerdjan.spectrumtrack.Utils.CalendarUtilsResponse;
import com.example.w2020skerdjan.spectrumtrack.Utils.RetrofitHeaderManager;
import com.squareup.timessquare.CalendarPickerView;

import java.util.ArrayList;
import java.util.Calendar;
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
        private LinearLayout monthCanvasView;
        private FragmentCalendarState fragmentCalendarState;
        private CalendarPickerView calendarPickerView;
        private ArrayList<Date> highlightedDates=null;
        private int monthParam, yearParam;
        private Retrofit retrofit;
        private RetrofitClient retrofitClient;
        private CalendarCalls calendarCalls;
        private CalendarResponse calendarResponse;
        private int _yDelta;
        private  RelativeLayout rootLayout;
        boolean openOnce=false;
        boolean sliderUP= true;
        private int offset;
        private int calendarHeight;
        private float fixedViewYPosition ;
        private ViewGroup.LayoutParams finalMonthParams;
        private RecyclerView recyclerView;
        private SectionedLegendAdapter adapter;
        private boolean hideEmpty = true;
        private boolean showFooters = true;
        private GridLayoutManager gridLayoutManager;


        public MonthFragment() {

        }


        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            fragmentCalendarState = (FragmentCalendarState) getArguments().getSerializable(ARGUMENTS);
            monthParam =fragmentCalendarState.getCalendarStartingDate().getMonth()+1;
            yearParam = CalendarEntity.getYearFromDate(fragmentCalendarState.getCalendarStartingDate());
            retrofitClient = new RetrofitClient();
            gridLayoutManager  = new GridLayoutManager(getActivity(),2);
            retrofit = retrofitClient.krijoRetrofit();
            calendarCalls = retrofit.create(CalendarCalls.class);
            Log.d("CalendarStateFragment", " getCurrentMonth = " + monthParam + " ||| getCurrentYear = " + yearParam);


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
            final View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
            calendarPickerView = (CalendarPickerView) rootView.findViewById(R.id.calendar_view);
            rootLayout = (RelativeLayout) rootView.findViewById(R.id.canvasMonth);
            monthCanvasView = (LinearLayout) rootView.findViewById(R.id.monthCanvas1);
            recyclerView = (RecyclerView) rootView.findViewById(R.id.legendRecyclerView);
            recyclerView.setLayoutManager(gridLayoutManager);
            //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            //rootView.findViewById(R.id.separator).setOnTouchListener(this);
            calendarCalls.getCalendarEvents(RetrofitHeaderManager.getCalendarMap(getActivity(),monthParam,yearParam)).enqueue(finalCalendarCallback);


            rootView.post(new Runnable() {
                          @Override
                          public void run() {
                              View separatorView = (View) rootView.findViewById(R.id.separator);
                              Log.d("Calculations", "Vlera e y = " + separatorView.getY());
                              Log.d("Calculations", "Vlera e pivot = " + calendarPickerView.getPivotY()/2);
                              Log.d("Calculations", "Vlera e Y e Calendar = "+ calendarPickerView.getY());
                              moveLayoutWithOffset(separatorView, (int) calendarPickerView.getPivotY()/2);
                              Log.d("Calculations", "Vlera e y Pas = " + separatorView.getY());
                              fixedViewYPosition = separatorView.getY();
                              Log.d("Calculations", "Vlera e pivot Pas = " + calendarPickerView.getPivotY()/2);
                              Log.d("Calculations", "Vlera e Y e Calendar Pas = "+ calendarPickerView.getY());
                              finalMonthParams = monthCanvasView.getLayoutParams();
                          }
                      }
            );




            rootView.findViewById(R.id.separator).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Calculations", "Vlera e y = " + v.getY());
                    Log.d("Calculations", "Vlera e height Calendar = " + calendarPickerView.getPivotY());
                    Log.d("Calculations", "Vlera e Y e Calendar = "+ calendarPickerView.getY());

                    if(!sliderUP){
                        offset = -(int ) calendarPickerView.getPivotY()-calendarPickerView.getHeight()/5;
                        resizeMonth(monthCanvasView, sliderUP);
                        sliderUP=true;
                    }
                    else
                    {
                        offset = (int) calendarPickerView.getPivotY();
                        resizeMonth(monthCanvasView, sliderUP);
                        sliderUP=false;
                    }
                    //moveLayoutWithOffset(v, offset);
                    //moveLayoutFixed(v, offset);

                }
            });


            if(!openOnce) {
                initCalendarData(fragmentCalendarState);
                openOnce=true;
            }
            return rootView;
        }

        public void initCalendarData(FragmentCalendarState fr){
            calendarPickerView.init(fr.getCalendarStartingDate(), fr.getCalendarJavaObject().getTime())
                    .inMode(CalendarPickerView.SelectionMode.SINGLE);
            if(fr.getHighlighteddates().size()!=0){
                 // calendarPickerView.highlightDates(fr.getHighlighteddates());
                    calendarPickerView.highLightOrganizedDates(fr.getOrganizedHighLightedDates());

            }
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            calendarHeight = calendarPickerView.getHeight();
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
                        /*
                        CalendarUtilsResponse calendarUtilsResponse = new CalendarUtilsResponse(calendarResponse);
                        if (calendarUtilsResponse.getResultHighlight().size() != 0) {
                            Log.d("Kalendar", "HighlightedDates te llogaritura jane OK");
                            fragmentCalendarState.setHighlighteddates(calendarUtilsResponse.getResultHighlight());
                            fragmentCalendarState.setOrganizedHighLightedDates(calendarUtilsResponse.getOrganizedHighlight());

                            initCalendarData(fragmentCalendarState);

                            CalendarLegendAdapter calendarLegendAdapter = new CalendarLegendAdapter(getActivity(), calendarUtilsResponse,
                                    MonthFragment.this ,fragmentCalendarState);

                            calendarLegendAdapter.setClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    int pos = recyclerView.indexOfChild(v);
                                    Toast toast = Toast.makeText(getActivity(), "Skerdi + " + pos, Toast.LENGTH_LONG);                                }
                            });

                            recyclerView.setAdapter(calendarLegendAdapter);
                        }
                        else {
                            Log.d("Kalendar", "HighlightedDates te llogaritura jane Bosh");
                        }
                    */

                            CalendarUtils calendarUtils = new CalendarUtils(calendarResponse);
                        if (calendarUtils.getCalendarTrips().size() != 0) {
                            SectionedLegendAdapter sectionedLegendAdapter = new SectionedLegendAdapter(getActivity(), calendarUtils.getCalendarTrips());
                            sectionedLegendAdapter.setLayoutManager(gridLayoutManager);
                            sectionedLegendAdapter.shouldShowHeadersForEmptySections(hideEmpty);
                            recyclerView.setAdapter(sectionedLegendAdapter);
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
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                _yDelta = Y - lParams.bottomMargin;
                Log.d("Skerdi", "Y value = " + Y);
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                layoutParams.bottomMargin = (Y - _yDelta);
                layoutParams.topMargin = -layoutParams.bottomMargin;
                    Log.d("Skerdi", "Action Move = " + layoutParams.topMargin);
                    v.setLayoutParams(layoutParams);
                    v.animate().translationY(Y - _yDelta).setDuration(0);

                break;
        }
        rootLayout.invalidate();
        rootLayout.requestLayout();
        return true;
    }




    private void moveLayoutFixed(View v, int val){
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
        layoutParams.bottomMargin = (-val);
        layoutParams.topMargin = -layoutParams.bottomMargin;
        Log.d("Skerdi", "Action Move = " + layoutParams.topMargin);
        v.setLayoutParams(layoutParams);
        v.animate().translationY(-val).setDuration(0);
        rootLayout.invalidate();
        rootLayout.requestLayout();
    }
    */

    private void moveLayoutWithOffset(View v , int offset){
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
        layoutParams.bottomMargin = (offset);
        layoutParams.topMargin = -layoutParams.bottomMargin;
        Log.d("Skerdi", "Action Move = " + layoutParams.topMargin);
        v.setLayoutParams(layoutParams);
        v.animate().translationY(offset).setDuration(0);
        v.setY(fixedViewYPosition);
        rootLayout.invalidate();
        rootLayout.requestLayout();
    }

    public void resizeMonth(LinearLayout linearLayout, boolean up){
        if(up){
            final float scale = getContext().getResources().getDisplayMetrics().density;
            int pixels = (int) (150 * scale + 0.5f);
            RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, pixels);
            // newParams.addRule(LinearLayout.VERTICAL);
            linearLayout.setLayoutParams(newParams);
        }
        else {
            linearLayout.setLayoutParams(finalMonthParams);
        }

    }
}
