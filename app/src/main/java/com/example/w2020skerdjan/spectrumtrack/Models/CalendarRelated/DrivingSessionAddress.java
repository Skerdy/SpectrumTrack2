package com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by W2020 Android on 1/8/2018.
 */

public class DrivingSessionAddress {

    private Integer id;
    private String street;
    private String zipCode;
    private String latitude;
    private String longitude;
    private String country;
    private String state;
    private String city;

    public DrivingSessionAddress(){

    }

    public DrivingSessionAddress(Integer id, String street, String zipCode, String latitude, String longitude, String country, String state ,String city){
        this.id =id;
        this.street = street;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
