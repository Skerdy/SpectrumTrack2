package com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.ResponseModel;

/**
 * Created by W2020 Android on 12/19/2017.
 */

import com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated.Driver;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.DeliveryPointAddress;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Disposition;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.LoadingPointAddress;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CalendarEvent {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("driver")
    @Expose
    private Driver driver;
    @SerializedName("instructions")
    @Expose
    private String instructions;
    @SerializedName("disposition")
    @Expose
    private Disposition disposition;
    @SerializedName("loadUnloads")
    @Expose
    private Object loadUnloads;
    @SerializedName("createdAt")
    @Expose
    private Long createdAt;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Disposition getDisposition() {
        return disposition;
    }

    public void setDisposition(Disposition disposition) {
        this.disposition = disposition;
    }

    public Object getLoadUnloads() {
        return loadUnloads;
    }

    public void setLoadUnloads(Object loadUnloads) {
        this.loadUnloads = loadUnloads;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
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