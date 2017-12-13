package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

/**
 * Created by W2020 Android on 12/13/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Department implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("departmentName")
    @Expose
    private String departmentName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("companies")
    @Expose
    private Integer companies;
    @SerializedName("createdDate")
    @Expose
    private Long createdDate;
    @SerializedName("updatedDate")
    @Expose
    private Long updatedDate;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompanies() {
        return companies;
    }

    public void setCompanies(Integer companies) {
        this.companies = companies;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
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
