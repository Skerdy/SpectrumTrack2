package com.example.w2020skerdjan.spectrumtrack.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by W2020 Android on 11/3/2017.
 */

public class RetrofitClient {
    private String MAIN_URL="http://192.168.0.194:8081/SpectrumTrack/";
    Retrofit retrofit;


    public Retrofit krijoRetrofit() {
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
