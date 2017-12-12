package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.w2020skerdjan.spectrumtrack.R;
import com.yalantis.guillotine.animation.GuillotineAnimation;

public class TripCommands extends AppCompatActivity {
    private static final long RIPPLE_DURATION = 250;
    Toolbar toolbar;
    FrameLayout root;
    View contentHamburger;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_commands);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        root = (FrameLayout) findViewById(R.id.root);
        contentHamburger = (View) findViewById(R.id.content_hamburger);


        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }
}
