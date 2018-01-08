package com.example.w2020skerdjan.spectrumtrack.Retrofit.DriverRelatedCalls;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.PersonalAreaResponse;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.UserExpirationsResponse;
import com.example.w2020skerdjan.spectrumtrack.Utils.EndpointUtil;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;

/**
 * Created by W2020 Android on 12/21/2017.
 */

public interface DriverCallAPI {

    String ORIGIN = EndpointUtil.BESNIK_PORT;
    @Headers({"Content-Type:application/json", "Origin:192.168.0.158:8080"})
    @GET("userPersonalAreaModule/userPersonalArea")
    Call<PersonalAreaResponse> getPersonalAreaData(@HeaderMap Map<String, String> headers);


    @Headers({"Content-Type:application/json", "Origin:192.168.0.158:8080"})
    @GET("usersModule/userExpirations")
    Call<UserExpirationsResponse> getUserExpirations(@HeaderMap Map<String, String> headers);



}
