package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

/**
 * Created by W2020 Android on 12/13/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Disposition implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("workType")
    @Expose
    private String workType;
    @SerializedName("vehicle")
    @Expose
    private String vehicle;
    @SerializedName("trailer")
    @Expose
    private String trailer;
    @SerializedName("vehiclePlate")
    @Expose
    private String vehiclePlate;
    @SerializedName("trailerPlate")
    @Expose
    private String trailerPlate;
    @SerializedName("driver")
    @Expose
    private String driver;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("customer")
    @Expose
    private Object customer;
    @SerializedName("subContractor")
    @Expose
    private Object subContractor;
    @SerializedName("order")
    @Expose
    private String order;
    @SerializedName("subContractorPrice")
    @Expose
    private Integer subContractorPrice;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("createdDate")
    @Expose
    private Long createdDate;
    @SerializedName("transportType")
    @Expose
    private Object transportType;
    @SerializedName("carrier")
    @Expose
    private Object carrier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getTrailerPlate() {
        return trailerPlate;
    }

    public void setTrailerPlate(String trailerPlate) {
        this.trailerPlate = trailerPlate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Object getCustomer() {
        return customer;
    }

    public void setCustomer(Object customer) {
        this.customer = customer;
    }

    public Object getSubContractor() {
        return subContractor;
    }

    public void setSubContractor(Object subContractor) {
        this.subContractor = subContractor;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getSubContractorPrice() {
        return subContractorPrice;
    }

    public void setSubContractorPrice(Integer subContractorPrice) {
        this.subContractorPrice = subContractorPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Object getTransportType() {
        return transportType;
    }

    public void setTransportType(Object transportType) {
        this.transportType = transportType;
    }

    public Object getCarrier() {
        return carrier;
    }

    public void setCarrier(Object carrier) {
        this.carrier = carrier;
    }

}

