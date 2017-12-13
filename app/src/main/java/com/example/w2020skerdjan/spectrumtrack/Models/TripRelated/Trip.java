package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

/**
 * Created by W2020 Android on 12/13/2017.
 */

import java.io.Serializable;
import java.util.List;

import com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated.Driver;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trip implements Serializable {

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
    private List<LoadUnload> loadUnloads = null;
    @SerializedName("createdAt")
    @Expose
    private Long createdAt;

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

    public List<LoadUnload> getLoadUnloads() {
        return loadUnloads;
    }

    public void setLoadUnloads(List<LoadUnload> loadUnloads) {
        this.loadUnloads = loadUnloads;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

}
