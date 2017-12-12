package com.example.w2020skerdjan.spectrumtrack.Retrofit.TripRelatedCalls;

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.EquipmentResponseModel;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.VehicleEquipment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by W2020 Android on 12/11/2017.
 */

public interface TripDetailsAPI {


    @Headers({"Content-Type:application/json", "Origin:192.168.0.192:8081"})
    @GET("vehicleEquipmentModule/equipmentsOfVehicle/1")
    Call<EquipmentResponseModel> getEquipments();
}
