package com.example.w2020skerdjan.spectrumtrack.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Trip;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.TripsAdapter;

import java.util.ArrayList;

/**
 * Created by W2020 Android on 12/2/2017.
 */

public class TripsFragment extends Fragment {
    private RecyclerView rc;
    private RecyclerView.LayoutManager mLayoutManager;
    private TripsAdapter tripsAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trips_fragment, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLayoutManager= new LinearLayoutManager(getActivity());
        tripsAdapter=new TripsAdapter(getActivity(), generateDummyTrips());
        rc = (RecyclerView)view.findViewById(R.id.trips_recycler_view);
        rc.setLayoutManager(mLayoutManager);
        rc.setAdapter(tripsAdapter);
    }


    public ArrayList<Trip> generateDummyTrips(){
         ArrayList<Trip> dummyTrips = new ArrayList<>();
         dummyTrips.add(new Trip("12/4/2017", "Tiranë", "Scania" , "Elbasan", "dummyTrailer"));
        dummyTrips.add(new Trip("12/12/2017", "Rome", "MAN" , "Milano", "dummyTrailer"));
        dummyTrips.add(new Trip("1/10/2018", "Berlin", "Mercedes" , "Dortmund", "dummyTrailer"));
        dummyTrips.add(new Trip("2/19/2017", "Shkoder", "Scania" , "Sarande", "dummyTrailer"));
        dummyTrips.add(new Trip("2/23/2017", "Bot", "Teleport" , "Top", "dummyPlayer"));
        dummyTrips.add(new Trip("3/1/2017", "getLocation", "Dollap" , "Narnia", "dummyMovie"));
        return dummyTrips;
    }


}
