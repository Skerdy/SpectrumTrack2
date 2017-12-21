package com.example.w2020skerdjan.spectrumtrack.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated.PersonalAreaData;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.LoginResponse;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.PersonalAreaResponse;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.DriverRelatedCalls.DriverCallAPI;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Utils.RetrofitHeaderManager;

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
    private TextView day , week, nextStop;
    private PersonalAreaData personalAreaData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofitClient= new RetrofitClient();
        retrofit = retrofitClient.krijoRetrofit();
        driverCallAPI = retrofit.create(DriverCallAPI.class);
        personalAreaData = null;
        driverCallAPI.getPersonalAreaData(RetrofitHeaderManager.getAuthMap(getActivity())).enqueue(personalAreaCallBack);
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
        if(personalAreaData!=null){
            setDataIntoViews(personalAreaData);
        }
        //nese personal area data nuk ka ardhur ende bej nej thirrje te dyte
        //else if (personalAreaData==null)
        driverCallAPI.getPersonalAreaData(RetrofitHeaderManager.getAuthMap(getActivity())).enqueue(personalAreaCallBack);
    }

    Callback<PersonalAreaResponse> personalAreaCallBack =  new Callback<PersonalAreaResponse>() {
        @Override
        public void onResponse(Call<PersonalAreaResponse> call, Response<PersonalAreaResponse> response) {
            if (response.isSuccessful()){
                PersonalAreaResponse personalAreaResponse = response.body();
                personalAreaData=personalAreaResponse.getData();
                if(validateViewsCreated()){
                    setDataIntoViews(personalAreaData);
                }
            }
            else {
                Log.d("Response PersonalArea", " Response not successful");
            }
        }

        @Override
        public void onFailure(Call<PersonalAreaResponse> call, Throwable t) {
            Log.d("Response PersonalArea", " Response Failed : " + t.getMessage());
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
        Log.d("Response PersonalArea", " flag : " + flag);

        return flag;
    }

    public void setDataIntoViews ( PersonalAreaData data){
        day.setText(data.getDay().toString());
        week.setText(data.getWeek().toString());
        nextStop.setText(data.getNextStop().toString());
        Log.d("Response PersonalArea", " textviews associated wuith data");

    }

}
