package com.example.w2020skerdjan.spectrumtrack.Retrofit.TripRelatedCalls;

import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.tripsOfDriverResponse;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Activities.AllActivities;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.EquipmentResponseModel;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Stops.AllStops;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.VehicleEquipment;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by W2020 Android on 12/11/2017.
 */

public interface TripDetailsAPI {
    @Headers({"Content-Type:application/json", "Origin:192.168.0.192:8081"})
    @GET("vehicleEquipmentModule/equipmentsOfVehicle/1")
    Call<EquipmentResponseModel> getEquipments(@HeaderMap Map<String,String> map);

    @Headers({"Content-Type:application/json", "Origin:192.168.0.192:8081"})
    @GET("tripModule/tripsOfDriver/{idDriver}")
    Call<tripsOfDriverResponse> getAllTripsOfDriver(@Path("idDriver") String id, @HeaderMap Map<String,String> map);

    @Headers({"Content-Type:application/json", "Origin:192.168.0.192:8081"})
    @GET("tripModule/activity")
    Call<AllActivities> getAllActivities(@HeaderMap Map<String,String> map);



    @Headers({"Content-Type:application/json", "Origin:192.168.0.192:8081"})
    @GET("tripModule/stop")
    Call<AllStops> getAllStops(@HeaderMap Map<String, String> authMap);
}
