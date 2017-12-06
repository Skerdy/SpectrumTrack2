package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.R;
import com.squareup.timessquare.CalendarPickerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {




    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private ImageButton prev, next;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        prev = (ImageButton) findViewById(R.id.buton_prev);
        next = (ImageButton) findViewById(R.id.buton_next);


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            float sumPositionplusPositionOffset;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position+positionOffset>sumPositionplusPositionOffset){
                    //swipe right ->left
                }
                else{
                    //swipe left ->right
                }
                sumPositionplusPositionOffset=position+positionOffset;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(moveViewPagerWithButton(-1), true);
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {mViewPager.setCurrentItem(moveViewPagerWithButton(1), true);
            }
        });


    }

    private int moveViewPagerWithButton(int i) {
        return mViewPager.getCurrentItem() + i;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        else if (id==android.R.id.home){
        super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private int CurrentMonth, todayMonth, CurrentYear, todayYear;
        private Calendar kalendar_android;
        private Date today;
        private Date lastGeneratedDate;
        private List<Date> dates;
        public final int ROLL_CALENDAR_UP=1;
        public final int ROLL_CALENDAR_DOWN=2;
        private CalendarPickerView calendar;



        private static final String ARG_MOVE_CALENDAR = "move_calendar";

        public PlaceholderFragment() {
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            dates = new ArrayList<Date>();
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */

        public static PlaceholderFragment newInstance(int move_cal_param) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_MOVE_CALENDAR, move_cal_param);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
            calendar = (CalendarPickerView) rootView.findViewById(R.id.calendar_view);
           /* switch (getArguments().getInt(ARG_MOVE_CALENDAR)){
                case 1 :
                    rollCalendar(ROLL_CALENDAR_DOWN, lastGeneratedDate);
                    break;

                case 2:
                     rollCalendar(ROLL_CALENDAR_UP,lastGeneratedDate);
                break;
                case 3:
                    initCalendarToday();
                 break;
                }
                */
           initCalendarToday();
            return rootView;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        }

        private void rollCalendar(int parameterRollCalendar, Date lastGeneratedDate){
            Calendar cal = Calendar.getInstance();

            cal.setTime(lastGeneratedDate);
            int year = cal.get(Calendar.YEAR);
            CurrentYear = year;
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            if(parameterRollCalendar==ROLL_CALENDAR_UP){
                // kalendar_android = Calendar.getInstance()
                if(CurrentMonth+1!=todayMonth){
                    simulateMoveMonth(parameterRollCalendar);
                }
                else{
                    if( CurrentYear != todayYear){
                        simulateMoveMonth(parameterRollCalendar);
                    }
                    else {
                        initCalendarToday();
                    }

                }
            }
            else{
                if(CurrentMonth-1!=todayMonth){
                    simulateMoveMonth(parameterRollCalendar);
                }
                else{
                    if(CurrentYear != todayYear){
                        simulateMoveMonth(parameterRollCalendar);
                    }
                    else{
                        initCalendarToday();
                    }
                }


            }
        }

        private void initCalendarToday(){
            today = new Date();
            lastGeneratedDate=today;
            todayMonth = getMonthFromDate(today);
            CurrentMonth=todayMonth;
            todayYear = getYearFromDate(today);
            Log.d("Current Month ", " "+CurrentMonth);
            kalendar_android = fetchCalendarDates(today);
            displayCurrentMonth(today, kalendar_android);
        }

        private int getMonthFromDate(Date date){
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            return month;
        }

        private int getYearFromDate(Date date) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            return year;
        }
        private void displayCurrentMonth(Date startingDate, Calendar month_time){
            calendar.init(startingDate, month_time.getTime())
                    .inMode(CalendarPickerView.SelectionMode.SINGLE);
            calendar.highlightDates(dates);
        }

        private Calendar fetchCalendarDates(Date startingDay){
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

        private void simulateMoveMonth(int param){
            Calendar workingCal;
            if(param==1) {
                if (CurrentMonth == 11) {
                    ++CurrentYear;
                    CurrentMonth = -1;
                }
                Date nextMonthFirstDate = krijoDate(CurrentYear, CurrentMonth + 1, 1);
                lastGeneratedDate = nextMonthFirstDate;
                Log.d("Data e muajit tjeter", nextMonthFirstDate.toString());
                workingCal = fetchCalendarDates(nextMonthFirstDate);
                displayCurrentMonth(nextMonthFirstDate, workingCal);
                CurrentMonth++;
            }
            else {
                if(CurrentMonth==0){
                    --CurrentYear;
                    CurrentMonth=12;
                }
                Date nextMonthFirstDate = krijoDate(CurrentYear,CurrentMonth-1,1);
                lastGeneratedDate= nextMonthFirstDate;
                Log.d("Data e muajit tjeter" , nextMonthFirstDate.toString());
                workingCal = fetchCalendarDates(nextMonthFirstDate);
                displayCurrentMonth(nextMonthFirstDate,workingCal);
                CurrentMonth--;

            }
        }

        private Date krijoDate (int Viti, int muaji, int dita){
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Viti);
            calendar.set(Calendar.MONTH, muaji);
            calendar.set(Calendar.DATE, dita);
            Date date = calendar.getTime();
            return date;

        }
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private int lastPosition = 1 ;

        //highlighted dates
        private List<Date> dates;
        private List<Fragment> fragments = new ArrayList<>();
        private int actual_position=0, scrollPosition=0;
        private ImageButton prev, next;
        private FrameLayout frameLayout;
        public final int ROLL_CALENDAR_UP=1;
        public final int ROLL_CALENDAR_DOWN=2;
        public final int INIT_CALENDARTODAY=3;
        private int chosentype=INIT_CALENDARTODAY;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position==1){
                chosentype=INIT_CALENDARTODAY;
            }
            else if(position>lastPosition){
                chosentype=ROLL_CALENDAR_UP;
            }
            else chosentype = ROLL_CALENDAR_DOWN;
            lastPosition = position;

            return PlaceholderFragment.newInstance(chosentype);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
