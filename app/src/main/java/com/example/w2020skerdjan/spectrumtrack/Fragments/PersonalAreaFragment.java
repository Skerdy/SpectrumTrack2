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
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated.PersonalAreaData;
import com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated.UserExpiration;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.LoginResponse;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.PersonalAreaResponse;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.UserExpirationsResponse;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.RecyclerViews.ExpirationsAdapter;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.DriverRelatedCalls.DriverCallAPI;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Utils.RetrofitHeaderManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by W2020 Android on 12/2/2017.
 */

public class PersonalAreaFragment extends Fragment {

    private Retrofit retrofit;
    private RetrofitClient retrofitClient;
    private DriverCallAPI driverCallAPI;
    private TextView day , week, nextStop, infrigements;
    private PersonalAreaData personalAreaData;
    private List<UserExpiration> expirations;
    private RecyclerView recyclerView;
    private ExpirationsAdapter expirationsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofitClient= new RetrofitClient();
        retrofit = retrofitClient.krijoRetrofit();
        driverCallAPI = retrofit.create(DriverCallAPI.class);
        personalAreaData = null;
        layoutManager= new LinearLayoutManager(getActivity());


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.personal_area_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        day = (TextView) view.findViewById(R.id.day_PA);
        week = (TextView) view.findViewById(R.id.week_PA);
        nextStop = (TextView) view.findViewById(R.id.next_stop_PA);
        infrigements = (TextView) view.findViewById(R.id.infrigements);
        recyclerView = (RecyclerView)view.findViewById(R.id.expiration_RecyclerView);
        recyclerView.setLayoutManager(layoutManager);

        driverCallAPI.getPersonalAreaData(RetrofitHeaderManager.getAuthMap(getActivity())).enqueue(personalAreaCallBack);
        driverCallAPI.getUserExpirations(RetrofitHeaderManager.getAuthMap(getActivity())).enqueue(userExpirationsCallBack);




        //nese personal area data nuk ka ardhur ende bej nej thirrje te dyte
        //else if (personalAreaData==null)
    }

    Callback<PersonalAreaResponse> personalAreaCallBack =  new Callback<PersonalAreaResponse>() {
        @Override
        public void onResponse(Call<PersonalAreaResponse> call, Response<PersonalAreaResponse> response) {
            if (response.isSuccessful()){
                Log.d("ResponsePersonalArea", " Response is successful");
                PersonalAreaResponse personalAreaResponse = response.body();
                personalAreaData=personalAreaResponse.getData();
                    setDataIntoViews(personalAreaData);

            }
            else {
                Log.d("ResponsePersonalArea", " Response not successful");
            }
        }

        @Override
        public void onFailure(Call<PersonalAreaResponse> call, Throwable t) {
            Log.d("ResponsePersonalArea", " Response Failed : " + t.getMessage());
        }
    };


    Callback<UserExpirationsResponse> userExpirationsCallBack = new Callback<UserExpirationsResponse>() {
        @Override
        public void onResponse(Call<UserExpirationsResponse> call, Response<UserExpirationsResponse> response) {
            if (response.isSuccessful()){
                Log.d("ResponsePersonalArea", " Response is successful");
                UserExpirationsResponse expirationsResponse = response.body();
                expirations=expirationsResponse.getData();
                expirationsAdapter = new ExpirationsAdapter(getActivity(), expirations);
                recyclerView.setAdapter(expirationsAdapter);
            }
            else {
                Log.d("ResponsePersonalArea", " Response not successful");
            }
        }

        @Override
        public void onFailure(Call<UserExpirationsResponse> call, Throwable t) {

        }
    };



    public boolean validateViewsCreated (){
        boolean flag = true;
        if(day==null){
            flag=false;
        }
        if(week==null){
            flag=false;
        }
        if(nextStop==null){
            flag=false;
        }
        Log.d("ResponsePersonalArea", " flag : " + flag);
        return flag;
    }

    public void setDataIntoViews (PersonalAreaData data){
        day.setText(data.getDay().toString());
        week.setText(data.getWeek().toString());
        nextStop.setText(data.getNextStop().toString());
        StringBuilder infrigements_string = new StringBuilder();
        infrigements_string.append("INFRIGEMENTS (").append(data.getFine()).append(")");
        infrigements.setText(infrigements_string.toString());
        Log.d("ResponsePersonalArea", " textviews associated wuith data");
    }
}
