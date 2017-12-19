package com.example.w2020skerdjan.spectrumtrack.Activities;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        calendarFragmentAdapter = new CalendarFragmentAdapter(getSupportFragmentManager(),3, this);
        prev = (ImageButton) findViewById(R.id.buton_prev);
        next = (ImageButton) findViewById(R.id.buton_next);


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(calendarFragmentAdapter);

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

}
