package com.example.w2020skerdjan.spectrumtrack.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.w2020skerdjan.spectrumtrack.Activities.MainMenu;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.Utils.MySharedPref;


/**
 * Created by W2020 Android on 12/6/2017.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
    private CardView active_trip, calendar, chat, personal_area, trips;
    private MySharedPref mySharedPref;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySharedPref = new MySharedPref(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }



    public void initViews(View view){
        active_trip = (CardView) view.findViewById(R.id.card_active_trip);
        calendar = (CardView) view.findViewById(R.id.card_calendar);
        chat = (CardView) view.findViewById(R.id.card_chat);
        personal_area = (CardView) view.findViewById(R.id.card_personal_area);
        trips = (CardView) view.findViewById(R.id.card_trips);

        /*
        active_trip.setClickable(true);
        calendar.setClickable(true);
        chat.setClickable(true);
        personal_area.setClickable(true);
        trips.setClickable(true);
*/
        active_trip.setOnClickListener(this);
        calendar.setOnClickListener(this);
        chat.setOnClickListener(this);
        personal_area.setOnClickListener(this);
        trips.setOnClickListener(this);
        initActiveTrip();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_calendar:
                ((MainMenu)getActivity()).initCalendar();
                break;
            case R.id.card_trips:
                ((MainMenu)getActivity()).initTripsFragment();
                break;
            case R.id.card_chat:
                ((MainMenu)getActivity()).initChatActivity();
                break;
            case R.id.card_personal_area:
                ((MainMenu)getActivity()).initPersonalAreaFragment();
                break;
            case R.id.card_active_trip:
                Toast.makeText(getActivity(),"Do implementohet me vone", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void initActiveTrip(){
      String auth = mySharedPref.getSavedObjectFromPreference("Auth", String.class);
      if (auth==null){
          active_trip.removeAllViews();
          TextView message = new TextView(getActivity());
          message.setText("You don't have any active Trips Yet...");
          Button go_toTrips = new Button(getActivity());
          go_toTrips.setText("Go to trips");
          active_trip.addView(message);
          active_trip.addView(go_toTrips);
      }
      else {

      }
    }
}
