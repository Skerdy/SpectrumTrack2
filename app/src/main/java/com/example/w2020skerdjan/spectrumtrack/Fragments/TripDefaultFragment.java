package com.example.w2020skerdjan.spectrumtrack.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.w2020skerdjan.spectrumtrack.R;

/**
 * Created by W2020 Android on 12/18/2017.
 */

public class TripDefaultFragment extends Fragment {
    private View circleIndicator;
    private CardView cardView;
    private Button button;
    private boolean status= false;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.default_fragment_trip_commands,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        circleIndicator = (View) view.findViewById(R.id.circleIndicator);
        cardView = (CardView) view.findViewById(R.id.Default_trip_CardView);
        button = (Button) view.findViewById(R.id.startTripButton);

        if(status == false){
            circleIndicator.setBackgroundResource(R.drawable.trip_status_circle_red);
        }
        else {
            circleIndicator.setBackgroundResource(R.drawable.trip_status_circle_green);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!status){
                    status=true;
                    circleIndicator.setBackgroundResource(R.drawable.trip_status_circle_green);
                    button.setText("Finish!");
                }
                else {
                    status=false;
                    circleIndicator.setBackgroundResource(R.drawable.trip_status_circle_red);
                    button.setText("Start");
                }
            }
        });
    }
}
