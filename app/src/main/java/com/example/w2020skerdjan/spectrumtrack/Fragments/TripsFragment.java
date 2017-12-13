package com.example.w2020skerdjan.spectrumtrack.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.tripsOfDriverResponse;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.EquipmentResponseModel;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.OldTrip;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.TripCheckListAdapter;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.TripsAdapter;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.TripRelatedCalls.TripDetailsAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by W2020 Android on 12/2/2017.
 */

public class TripsFragment extends Fragment {
    private RecyclerView rc;
    private RecyclerView.LayoutManager mLayoutManager;
    private TripsAdapter tripsAdapter;
    private Retrofit retrofit;
    private TripDetailsAPI tripDetailsAPI;
    private RetrofitClient retrofitClient;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trips_fragment, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLayoutManager= new LinearLayoutManager(getActivity());
        //tripsAdapter=new TripsAdapter(getActivity(), generateDummyTrips());
        rc = (RecyclerView)view.findViewById(R.id.trips_recycler_view);
        rc.setLayoutManager(mLayoutManager);
        retrofitClient = new RetrofitClient();

        retrofit = retrofitClient.krijoRetrofit();
        tripDetailsAPI = retrofit.create(TripDetailsAPI.class);
        tripDetailsAPI.getAllTripsOfDriver("1").enqueue(callbackAllTrips);
        rc.setAdapter(tripsAdapter);
    }




    public ArrayList<OldTrip> generateDummyTrips(){
         ArrayList<OldTrip> dummyTrips = new ArrayList<>();
         dummyTrips.add(new OldTrip("12/4/2017", "Tiranë", "Scania" , "Elbasan", "dummyTrailer"));
        dummyTrips.add(new OldTrip("12/12/2017", "Rome", "MAN" , "Milano", "dummyTrailer"));
        dummyTrips.add(new OldTrip("1/10/2018", "Berlin", "Mercedes" , "Dortmund", "dummyTrailer"));
        dummyTrips.add(new OldTrip("2/19/2017", "Shkoder", "Scania" , "Sarande", "dummyTrailer"));
        dummyTrips.add(new OldTrip("2/23/2017", "Bot", "Teleport" , "Top", "dummyPlayer"));
        dummyTrips.add(new OldTrip("3/1/2017", "getLocation", "Dollap" , "Narnia", "dummyMovie"));
        return dummyTrips;
    }

    Callback<tripsOfDriverResponse> callbackAllTrips = new Callback<tripsOfDriverResponse>() {
        @Override
        public void onResponse(Call<tripsOfDriverResponse> call, Response<tripsOfDriverResponse> response) {
            if(response.isSuccessful()){
                Log.d("Skerdi", "response Sukses");
                 tripsOfDriverResponse tripsResponse = response.body();
                 tripsAdapter =  new TripsAdapter(getActivity(), tripsResponse.getData());
                rc.setAdapter(tripsAdapter);
            }
            else {
                Log.d("Skerdi", "response vjen por eshte gabim ");
            }
        }

        @Override
        public void onFailure(Call<tripsOfDriverResponse> call, Throwable t) {
            Log.d("Skerdi", "Fail ");
            Log.d("Skerdi", t.getMessage());
        }
    };


}
