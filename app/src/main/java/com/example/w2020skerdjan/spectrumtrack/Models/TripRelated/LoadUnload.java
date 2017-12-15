package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

/**
 * Created by W2020 Android on 12/13/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoadUnload implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("loadingPointDate")
    @Expose
    private Long loadingPointDate;
    @SerializedName("deliveryPointDate")
    @Expose
    private Long deliveryPointDate;
    @SerializedName("loadingPointAddress")
    @Expose
    private LoadingPointAddress loadingPointAddress;
    @SerializedName("deliveryPointAddress")
    @Expose
    private DeliveryPointAddress deliveryPointAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLoadingPointDate() {
        return loadingPointDate;
    }

    public void setLoadingPointDate(Long loadingPointDate) {
        this.loadingPointDate = loadingPointDate;
    }

    public Long getDeliveryPointDate() {
        return deliveryPointDate;
    }

    public void setDeliveryPointDate(Long deliveryPointDate) {
        this.deliveryPointDate = deliveryPointDate;
    }

    public LoadingPointAddress getLoadingPointAddress() {
        return loadingPointAddress;
    }

    public void setLoadingPointAddress(LoadingPointAddress loadingPointAddress) {
        this.loadingPointAddress = loadingPointAddress;
    }

    public DeliveryPointAddress getDeliveryPointAddress() {
        return deliveryPointAddress;
    }

    public void setDeliveryPointAddress(DeliveryPointAddress deliveryPointAddress) {
        this.deliveryPointAddress = deliveryPointAddress;
    }
}
