package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.w2020skerdjan.spectrumtrack.Fragments.PersonalAreaFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripCheckListFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripDetailFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripsFragment;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;

import java.util.ArrayList;
import java.util.List;

public class TripDetails extends BaseActivity {
    private ActionBar actionBar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private List<Fragment> fragments = new ArrayList<>();
    private int tripPosition ;
  //  private FragmentPagerAdapter fragmentPagerAdapter;
    private BoomMenuButton bmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);
        bmb = (BoomMenuButton) findViewById(R.id.bmb) ;
        Intent intent = getIntent();
        tripPosition=intent.getIntExtra("TripPosition", 0);
        fragmentManager = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

      //  ((ViewGroup)scrollChildLayout.getParent()).removeView(scrollChildLayout);
        initTripDetailsFragment();

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            SimpleCircleButton.Builder builder = new SimpleCircleButton.Builder()
                    .normalImageRes(R.drawable.profile);
            bmb.addBuilder(builder);
        }

        bmb.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {
                if(index==0){
                    initCheckListFragment();
                }
                else if(index==1){
                   initNewMenu();
                }
            }

            @Override
            public void onBackgroundClick() {

            }

            @Override
            public void onBoomWillHide() {

            }

            @Override
            public void onBoomDidHide() {

            }

            @Override
            public void onBoomWillShow() {

            }

            @Override
            public void onBoomDidShow() {

            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return true;
    }


    private void initTripDetailsFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        TripDetailFragment fragment1 = TripDetailFragment.newInstance(tripPosition);
        fragmentTransaction.replace(R.id.tripDetailsFragment, fragment1);
        fragmentTransaction.commit();
    }

    private void initCheckListFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        TripCheckListFragment fragment2 = new TripCheckListFragment();
        fragmentTransaction.replace(R.id.tripDetailsFragment, fragment2);
        fragmentTransaction.commit();
    }

    private void initNewMenu(){
        Intent intent = new Intent(TripDetails.this, TripCommands.class);
        startActivity(intent);
    }
}
