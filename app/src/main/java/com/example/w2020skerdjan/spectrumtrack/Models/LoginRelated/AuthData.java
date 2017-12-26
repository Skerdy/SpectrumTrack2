package com.example.w2020skerdjan.spectrumtrack.Models.LoginRelated;

/**
 * Created by W2020 Android on 12/26/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthData {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("roles")
    @Expose
    private List<UserRole> roles = null;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
