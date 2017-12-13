package com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated;

/**
 * Created by W2020 Android on 12/13/2017.
 */

import java.io.Serializable;
import java.util.List;

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Department;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Parking;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Driver implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("birthday")
    @Expose
    private Long birthday;
    @SerializedName("staffNumber")
    @Expose
    private String staffNumber;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("faxNumber")
    @Expose
    private String faxNumber;
    @SerializedName("drivingCardCode")
    @Expose
    private String drivingCardCode;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("birthPlace")
    @Expose
    private String birthPlace;
    @SerializedName("vat")
    @Expose
    private String vat;
    @SerializedName("driverCardValidUntil")
    @Expose
    private Long driverCardValidUntil;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("hireDate")
    @Expose
    private Long hireDate;
    @SerializedName("fireDate")
    @Expose
    private Long fireDate;
    @SerializedName("wage")
    @Expose
    private Integer wage;
    @SerializedName("isDriver")
    @Expose
    private Integer isDriver;
    @SerializedName("photoUrl")
    @Expose
    private Object photoUrl;
    @SerializedName("domicile")
    @Expose
    private Object domicile;
    @SerializedName("residences")
    @Expose
    private Object residences;
    @SerializedName("language")
    @Expose
    private Integer language;
    @SerializedName("parking")
    @Expose
    private Parking parking;
    @SerializedName("createdAt")
    @Expose
    private Long createdAt;
    @SerializedName("updatedAt")
    @Expose
    private Long updatedAt;
    @SerializedName("deletedAt")
    @Expose
    private Long deletedAt;
    @SerializedName("createdBy")
    @Expose
    private Integer createdBy;
    @SerializedName("deletedBy")
    @Expose
    private Object deletedBy;
    @SerializedName("company")
    @Expose
    private Integer company;
    @SerializedName("validity")
    @Expose
    private Integer validity;
    @SerializedName("expirations")
    @Expose
    private List<Expiration> expirations = null;
    @SerializedName("equipments")
    @Expose
    private List<Equipment> equipments = null;
    @SerializedName("departments")
    @Expose
    private List<Department> departments = null;
    @SerializedName("branches")
    @Expose
    private List<Object> branches = null;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getDrivingCardCode() {
        return drivingCardCode;
    }

    public void setDrivingCardCode(String drivingCardCode) {
        this.drivingCardCode = drivingCardCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public Long getDriverCardValidUntil() {
        return driverCardValidUntil;
    }

    public void setDriverCardValidUntil(Long driverCardValidUntil) {
        this.driverCardValidUntil = driverCardValidUntil;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getHireDate() {
        return hireDate;
    }

    public void setHireDate(Long hireDate) {
        this.hireDate = hireDate;
    }

    public Long getFireDate() {
        return fireDate;
    }

    public void setFireDate(Long fireDate) {
        this.fireDate = fireDate;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public Integer getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(Integer isDriver) {
        this.isDriver = isDriver;
    }

    public Object getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(Object photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Object getDomicile() {
        return domicile;
    }

    public void setDomicile(Object domicile) {
        this.domicile = domicile;
    }

    public Object getResidences() {
        return residences;
    }

    public void setResidences(Object residences) {
        this.residences = residences;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Object getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Object deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public List<Expiration> getExpirations() {
        return expirations;
    }

    public void setExpirations(List<Expiration> expirations) {
        this.expirations = expirations;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Object> getBranches() {
        return branches;
    }

    public void setBranches(List<Object> branches) {
        this.branches = branches;
    }

}
