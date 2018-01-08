package com.example.w2020skerdjan.spectrumtrack.Retrofit;

import android.util.Log;

import com.example.w2020skerdjan.spectrumtrack.Utils.EndpointUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by W2020 Android on 11/3/2017.
 */

public class RetrofitClient {
    private StringBuilder URLBUILDER = new StringBuilder();
    private String MAIN_URL="http://192.168.0.194:8081/SpectrumTrack/";
    Retrofit retrofit;


    public Retrofit krijoRetrofit() {

        URLBUILDER.append("http://").append(EndpointUtil.BESNIK).append("/SpectrumTrack/");
        MAIN_URL = URLBUILDER.toString();

        Log.d("URLSkerdi", MAIN_URL);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
