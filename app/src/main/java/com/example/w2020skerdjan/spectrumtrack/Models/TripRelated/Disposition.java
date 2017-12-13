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
    private Integer workType;
    @SerializedName("user")
    @Expose
    private Integer user;
    @SerializedName("vehicle")
    @Expose
    private Integer vehicle;
    @SerializedName("trailer")
    @Expose
    private Integer trailer;
    @SerializedName("vehiclePlate")
    @Expose
    private Object vehiclePlate;
    @SerializedName("trailerPlate")
    @Expose
    private Object trailerPlate;
    @SerializedName("repositioning")
    @Expose
    private Object repositioning;
    @SerializedName("firstDriver")
    @Expose
    private Object firstDriver;
    @SerializedName("secondDriver")
    @Expose
    private Object secondDriver;
    @SerializedName("customerPrice")
    @Expose
    private Object customerPrice;
    @SerializedName("tarifftype")
    @Expose
    private Object tarifftype;
    @SerializedName("measureUnit")
    @Expose
    private Object measureUnit;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("kmFull")
    @Expose
    private Integer kmFull;
    @SerializedName("kmEmpty")
    @Expose
    private Integer kmEmpty;
    @SerializedName("minValueInvoiced")
    @Expose
    private Integer minValueInvoiced;
    @SerializedName("currency")
    @Expose
    private Object currency;
    @SerializedName("company")
    @Expose
    private Integer company;
    @SerializedName("orders")
    @Expose
    private Integer orders;
    @SerializedName("createdDate")
    @Expose
    private Long createdDate;
    @SerializedName("modifiedDate")
    @Expose
    private Long modifiedDate;
    @SerializedName("deletedDate")
    @Expose
    private Long deletedDate;
    @SerializedName("validity")
    @Expose
    private Integer validity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getVehicle() {
        return vehicle;
    }

    public void setVehicle(Integer vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getTrailer() {
        return trailer;
    }

    public void setTrailer(Integer trailer) {
        this.trailer = trailer;
    }

    public Object getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(Object vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public Object getTrailerPlate() {
        return trailerPlate;
    }

    public void setTrailerPlate(Object trailerPlate) {
        this.trailerPlate = trailerPlate;
    }

    public Object getRepositioning() {
        return repositioning;
    }

    public void setRepositioning(Object repositioning) {
        this.repositioning = repositioning;
    }

    public Object getFirstDriver() {
        return firstDriver;
    }

    public void setFirstDriver(Object firstDriver) {
        this.firstDriver = firstDriver;
    }

    public Object getSecondDriver() {
        return secondDriver;
    }

    public void setSecondDriver(Object secondDriver) {
        this.secondDriver = secondDriver;
    }

    public Object getCustomerPrice() {
        return customerPrice;
    }

    public void setCustomerPrice(Object customerPrice) {
        this.customerPrice = customerPrice;
    }

    public Object getTarifftype() {
        return tarifftype;
    }

    public void setTarifftype(Object tarifftype) {
        this.tarifftype = tarifftype;
    }

    public Object getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(Object measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getKmFull() {
        return kmFull;
    }

    public void setKmFull(Integer kmFull) {
        this.kmFull = kmFull;
    }

    public Integer getKmEmpty() {
        return kmEmpty;
    }

    public void setKmEmpty(Integer kmEmpty) {
        this.kmEmpty = kmEmpty;
    }

    public Integer getMinValueInvoiced() {
        return minValueInvoiced;
    }

    public void setMinValueInvoiced(Integer minValueInvoiced) {
        this.minValueInvoiced = minValueInvoiced;
    }

    public Object getCurrency() {
        return currency;
    }

    public void setCurrency(Object currency) {
        this.currency = currency;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Long deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

}
