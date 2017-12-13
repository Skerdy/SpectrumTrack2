package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

/**
 * Created by W2020 Android on 12/13/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Parking implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parkingNumber")
    @Expose
    private String parkingNumber;
    @SerializedName("addresses")
    @Expose
    private ParkingAddress addresses;
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("validity")
    @Expose
    private Integer validity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(String parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public ParkingAddress getAddresses() {
        return addresses;
    }

    public void setAddresses(ParkingAddress addresses) {
        this.addresses = addresses;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

}
