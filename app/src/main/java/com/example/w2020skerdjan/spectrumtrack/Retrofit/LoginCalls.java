package com.example.w2020skerdjan.spectrumtrack.Retrofit;

import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by W2020 Android on 12/12/2017.
 */

public interface LoginCalls {
    @Headers({"Content-Type:application/json", "Origin:192.168.0.192:8081"})
    @GET("login?")
    Call<LoginResponse> Login(@Query("email") String email,
                              @Query("password") String password);


    /*
    @Headers({"Content-Type:application/json", "Origin:192.168.0.192:8081"})
    @GET("login/?email=d.b@gmail.com&password=test1234")
    Call<LoginResponse> Login();
    */
}
