package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Fragments.PersonalAreaFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripActivitiesFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripDefaultFragment;
import com.example.w2020skerdjan.spectrumtrack.Fragments.TripStopsFragment;
import com.example.w2020skerdjan.spectrumtrack.MapsActivity;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.yalantis.guillotine.animation.GuillotineAnimation;
import com.yalantis.guillotine.interfaces.GuillotineListener;

public class TripCommands extends AppCompatActivity implements View.OnClickListener {
    private static final long RIPPLE_DURATION = 250;
    private Toolbar toolbar;
    private FrameLayout root;
    private View contentHamburger;
    private View guillotineMenu;
    private LinearLayout map, activities, stops, back_menu;
    private TextView mapTxt, activitiesTxt, stopsTxt, back_menuTxt;
    private GuillotineAnimation guillotineAnimation;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private TextView Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_commands);
        fragmentManager = getSupportFragmentManager();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        root = (FrameLayout) findViewById(R.id.root);
        contentHamburger = (View) findViewById(R.id.content_hamburger);
        guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);

        Title = (TextView) findViewById(R.id.TripCommandsTitle);
        root.addView(guillotineMenu);
        initGuillotineMenu();


        guillotineAnimation = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
        initDefaultTripFragment();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.map_guillotine:
                guillotineAnimation.close();
                initMapActivity();
                break;
            case R.id.activities_guillotine:
                guillotineAnimation.close();
                initActivitiesFragment();
                break;
            case R.id.stops_guillotine:
                guillotineAnimation.close();
                initStopsFragment();
                break;
            case R.id.main_menu_guillotine:
                guillotineAnimation.close();
                initBackToHome();
                break;
        }
    }


    private void initGuillotineMenu(){
        //kapja e elementeve te menuse custom
        map = (LinearLayout) guillotineMenu.findViewById(R.id.map_guillotine);
        activities = (LinearLayout) guillotineMenu.findViewById(R.id.activities_guillotine);
        stops = (LinearLayout) guillotineMenu.findViewById(R.id.stops_guillotine);
        back_menu = (LinearLayout) guillotineMenu.findViewById(R.id.main_menu_guillotine);

        //kapja e textview sepse style nuk vendoset programatikisht
        mapTxt= (TextView) guillotineMenu.findViewById(R.id.mapTxt);
        activitiesTxt= (TextView) guillotineMenu.findViewById(R.id.activitiesTxt);
        stopsTxt= (TextView) guillotineMenu.findViewById(R.id.StopsTxt);
        back_menuTxt= (TextView) guillotineMenu.findViewById(R.id.mainMenuTxt);

        map.setClickable(true); activities.setClickable(true); stops.setClickable(true); back_menu.setClickable(true);
        map.setOnClickListener(this); activities.setOnClickListener(this); stops.setOnClickListener(this); back_menu.setOnClickListener(this);
    }

    private void initBackToHome(){
        Intent intent = new Intent(TripCommands.this, MainMenu.class);
        startActivity(intent);
    }

    private void initMapActivity(){
        Intent intent = new Intent(TripCommands.this, MapsActivity.class);
        startActivity(intent);
    }

    private void initActivitiesFragment(){
        fragmentTransaction=fragmentManager.beginTransaction();
        Title.setText("Activities");
        fragmentTransaction.addToBackStack("activityFragments");
        TripActivitiesFragment tripActivitiesFragment = new TripActivitiesFragment();
        fragmentTransaction.replace(R.id.TripCommandsContainer, tripActivitiesFragment);
        fragmentTransaction.commit();
    }

    private void initStopsFragment(){
        fragmentTransaction=fragmentManager.beginTransaction();
        Title.setText("Stops");
        fragmentTransaction.addToBackStack("stopsFragments");
        TripStopsFragment tripStopsFragment = new TripStopsFragment();
        fragmentTransaction.replace(R.id.TripCommandsContainer, tripStopsFragment);
        fragmentTransaction.commit();
    }

    private void initDefaultTripFragment(){
        fragmentTransaction=fragmentManager.beginTransaction();
        Title.setText("Trip Commands");
        fragmentTransaction.addToBackStack("defaultTrip");
        TripDefaultFragment tripDefaultFragment = new TripDefaultFragment();
        fragmentTransaction.add(R.id.DefaultTripContainer, tripDefaultFragment);
        fragmentTransaction.commit();
    }
}
