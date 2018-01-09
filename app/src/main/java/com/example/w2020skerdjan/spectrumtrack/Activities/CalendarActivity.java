package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import com.example.w2020skerdjan.spectrumtrack.Adapters.CalendarFragmentAdapter;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarEntity;
import com.example.w2020skerdjan.spectrumtrack.R;

public class CalendarActivity extends AppCompatActivity {

    private CalendarEntity calendarEntity;
        /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    private ViewPager mViewPager;
    private ImageButton prev, next;
    private CalendarFragmentAdapter calendarFragmentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initCalendarViews();
        new initCalendarActivity().execute(this);
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

    private class initCalendarActivity extends AsyncTask<Context,Integer,Void>{

        @Override
        protected Void doInBackground(Context... contexts) {
            calendarFragmentAdapter = new CalendarFragmentAdapter(getSupportFragmentManager(),2,contexts[0] );
            mViewPager.setAdapter(calendarFragmentAdapter);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }

    private void initCalendarViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        prev = (ImageButton) findViewById(R.id.buton_prev);
        next = (ImageButton) findViewById(R.id.buton_next);
        mViewPager = (ViewPager) findViewById(R.id.container);
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

}
