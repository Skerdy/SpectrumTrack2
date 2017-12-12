package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by W2020 Android on 12/11/2017.
 */

public class VehicleEquipment {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("equipment")
    @Expose
    private String equipment;
    @SerializedName("vehicle")
    @Expose
    private String vehicle;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("minimalAmount")
    @Expose
    private Integer minimalAmount;
    @SerializedName("createdAt")
    @Expose
    private Long createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMinimalAmount() {
        return minimalAmount;
    }

    public void setMinimalAmount(Integer minimalAmount) {
        this.minimalAmount = minimalAmount;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}

