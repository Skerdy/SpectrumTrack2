package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.R;
import com.yalantis.guillotine.animation.GuillotineAnimation;
import com.yalantis.guillotine.interfaces.GuillotineListener;

public class TripCommands extends AppCompatActivity implements View.OnClickListener {
    private static final long RIPPLE_DURATION = 250;
    Toolbar toolbar;
    FrameLayout root;
    View contentHamburger;
    View guillotineMenu;
    LinearLayout map, activities, stops, back_menu;
    TextView mapTxt, activitiesTxt, stopsTxt, back_menuTxt;
    GuillotineAnimation guillotineAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_commands);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        root = (FrameLayout) findViewById(R.id.root);
        contentHamburger = (View) findViewById(R.id.content_hamburger);
        guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);
        initGuillotineMenu();


        guillotineAnimation = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.map_guillotine:
                guillotineAnimation.close();
                break;
            case R.id.activities_guillotine:
                guillotineAnimation.close();
                break;
            case R.id.stops_guillotine:
                guillotineAnimation.close();
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
}
