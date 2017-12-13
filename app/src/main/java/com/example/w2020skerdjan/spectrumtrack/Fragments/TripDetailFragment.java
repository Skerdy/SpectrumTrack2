package com.example.w2020skerdjan.spectrumtrack.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.w2020skerdjan.spectrumtrack.Adapters.TripDetailsAdapter;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.OldTrip;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Trip;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.TripDetailsItem;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W2020 Android on 12/4/2017.
 */

public class TripDetailFragment extends Fragment {
    private static final String ARG_TRIP_ID = "trip_id";
    private Trip trip;
    private List<TripDetailsItem> data;

public static TripDetailFragment newInstance(Trip trip){
    TripDetailFragment fragment = new TripDetailFragment();
    Bundle args = new Bundle();

    args.putSerializable(ARG_TRIP_ID, trip );
    fragment.setArguments(args);
    return fragment;
}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
    TripsFragment tf = new TripsFragment();
        super.onCreate(savedInstanceState);
       if (getArguments() != null) {
           if (getArguments().containsKey(ARG_TRIP_ID)) {
               trip = (Trip) getArguments().getSerializable(ARG_TRIP_ID);
           }
       }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View nsw = inflater.inflate(R.layout.trip_details_contents_fragment, container, false);
        ListView lv = nsw.findViewById(R.id.tripDetailsList);
        data = new ArrayList<>();
        data.add(new TripDetailsItem("Date", trip.getLoadUnloads().get(0).getLoadingPointAddress().getCity().toString()));
        data.add(new TripDetailsItem("From", trip.getLoadUnloads().get(0).getLoadingPointDate().toString()));
        data.add(new TripDetailsItem("To", trip.getLoadUnloads().get(trip.getLoadUnloads().size()-1).getDeliveryPointAddress().getCity()));
        data.add(new TripDetailsItem("Truck", trip.getDisposition().getVehicle().toString()));
        data.add(new TripDetailsItem("Trailer", trip.getDisposition().getTrailer().toString()));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        data.add(new TripDetailsItem("Dummy tag", "Dummy data"));
        TripDetailsAdapter tripDetailBaseAdapter = new TripDetailsAdapter(getContext(), data);
        lv.setAdapter(tripDetailBaseAdapter);
        return nsw;
    }
}
