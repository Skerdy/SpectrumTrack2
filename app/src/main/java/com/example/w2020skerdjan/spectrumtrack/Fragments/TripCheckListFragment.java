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

import com.example.w2020skerdjan.spectrumtrack.Activities.TripDetails;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.EquipmentResponseModel;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.VehicleEquipment;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.TripCheckListAdapter;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.TripRelatedCalls.TripDetailsAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by W2020 Android on 12/11/2017.
 */

public class TripCheckListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<VehicleEquipment> vehicleEquipments = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    private RetrofitClient retrofitClient;
    private Retrofit retrofit;
    private TripDetailsAPI tripDetailsAPI;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i =0; i<20 ;i++){
            VehicleEquipment vh = new VehicleEquipment();
            vh.setEquipment("Equipment");
            vh.setMinimalAmount(10);
            vh.setQuantity(12);
            vehicleEquipments.add(vh);
        }

        retrofitClient = new RetrofitClient();
        retrofit = retrofitClient.krijoRetrofit();
        tripDetailsAPI = retrofit.create(TripDetailsAPI.class);
        tripDetailsAPI.getEquipments().enqueue(callbackEquipments);

    }

    Callback<EquipmentResponseModel> callbackEquipments = new Callback<EquipmentResponseModel>(){
        @Override
        public void onResponse(Call<EquipmentResponseModel> call, Response<EquipmentResponseModel> response) {
            if(response.isSuccessful()){
                Log.d("Skerdi", "response Sukses");
                EquipmentResponseModel responseModel = response.body();
                TripCheckListAdapter adapter =  new TripCheckListAdapter(getActivity(), responseModel.getData());
                recyclerView.setAdapter(adapter);
            }
            else{
                //Log.d("Skerdi", response.body().toString());
                Log.d("Skerdi", "response vjen por eshte gabim ");
            }
        }

        @Override
        public void onFailure(Call<EquipmentResponseModel> call, Throwable t) {
            Log.d("Skerdi", "Fail ");
            Log.d("Skerdi", t.getMessage());
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.check_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLayoutManager= new LinearLayoutManager(getActivity());
        recyclerView= (RecyclerView) view.findViewById(R.id.check_list_recycler_view);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setAdapter(new TripCheckListAdapter(getActivity(), vehicleEquipments));
    }
}