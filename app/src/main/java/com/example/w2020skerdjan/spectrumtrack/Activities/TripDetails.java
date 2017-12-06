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
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripDetailFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripsFragment;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

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
        fragmentTransaction = fragmentManager.beginTransaction();
      //  ((ViewGroup)scrollChildLayout.getParent()).removeView(scrollChildLayout);
        TripDetailFragment fragment1 = TripDetailFragment.newInstance(tripPosition);
        fragmentTransaction.replace(R.id.tripDetailsFragment, fragment1);
        fragmentTransaction.commit();

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            SimpleCircleButton.Builder builder = new SimpleCircleButton.Builder()
                    .normalImageRes(R.drawable.profile);
            bmb.addBuilder(builder);
        }
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
        TripDetailFragment fragment1 = TripDetailFragment.newInstance(1);
        fragmentTransaction.add(R.id.tripDetailsFragment, fragment1);
        fragmentTransaction.commit();
    }
}
