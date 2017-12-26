package com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated;

/**
 * Created by W2020 Android on 12/26/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserExpiration {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("expiration")
    @Expose
    private String expiration;
    @SerializedName("expirationDescription")
    @Expose
    private String expirationDescription;
    @SerializedName("authority")
    @Expose
    private String authority;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("expirationsDate")
    @Expose
    private Long expirationsDate;
    @SerializedName("releaseDate")
    @Expose
    private Long releaseDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getExpirationDescription() {
        return expirationDescription;
    }

    public void setExpirationDescription(String expirationDescription) {
        this.expirationDescription = expirationDescription;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getExpirationsDate() {
        return expirationsDate;
    }

    public void setExpirationsDate(Long expirationsDate) {
        this.expirationsDate = expirationsDate;
    }

    public Long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Long releaseDate) {
        this.releaseDate = releaseDate;
    }

}