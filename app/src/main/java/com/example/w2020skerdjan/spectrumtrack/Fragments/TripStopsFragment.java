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

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Activities.AllActivities;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Stops.AllStops;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.ActivityAdapter;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.StopsAdapter;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.TripRelatedCalls.TripDetailsAPI;
import com.example.w2020skerdjan.spectrumtrack.Utils.RetrofitHeaderManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by W2020 Android on 12/18/2017.
 */

public class TripStopsFragment extends Fragment {
    private RecyclerView rc;
    private RecyclerView.LayoutManager mLayoutManager;
    private StopsAdapter stopsAdapter;
    private Retrofit retrofit;
    private TripDetailsAPI tripDetailsAPI;
    private RetrofitClient retrofitClient;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trip_stops_fragment, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLayoutManager= new LinearLayoutManager(getActivity());
        rc = (RecyclerView)view.findViewById(R.id.recyclerViewStops);
        rc.setLayoutManager(mLayoutManager);
        retrofitClient = new RetrofitClient();
        retrofit = retrofitClient.krijoRetrofit();
        tripDetailsAPI = retrofit.create(TripDetailsAPI.class);
        tripDetailsAPI.getAllStops(RetrofitHeaderManager.getAuthMap(getActivity())).enqueue(callbackAllStops);
    }

    Callback<AllStops> callbackAllStops = new Callback<AllStops>() {
        @Override
        public void onResponse(Call<AllStops> call, Response<AllStops> response) {
            if(response.isSuccessful()){
                Log.d("Skerdi", "response Sukses");
                AllStops allStops = response.body();
                stopsAdapter =  new StopsAdapter(getActivity(), allStops.getData());
                rc.setAdapter(stopsAdapter);
            }
            else {
                Log.d("Skerdi", "response vjen por eshte gabim ");
            }
        }

        @Override
        public void onFailure(Call<AllStops> call, Throwable t) {
            Log.d("Skerdi", "Fail ");
            Log.d("Skerdi", t.getMessage());
        }
    };
}
