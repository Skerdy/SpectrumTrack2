package com.example.w2020skerdjan.spectrumtrack.Retrofit.CalendarRelatedCalls;

import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.CalendarResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;

/**
 * Created by W2020 Android on 12/19/2017.
 */

public interface CalendarCalls {
    @GET("calendar/")
    Call<CalendarResponse> getCalendarEvents(@HeaderMap Map<String, String> authMap);
}
