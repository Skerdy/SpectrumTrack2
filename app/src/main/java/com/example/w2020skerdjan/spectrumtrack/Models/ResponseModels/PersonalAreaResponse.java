package com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels;

/**
 * Created by W2020 Android on 12/21/2017.
 */

import java.util.List;

import com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated.PersonalAreaData;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.MessageList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonalAreaResponse {

    @SerializedName("messagePresent")
    @Expose
    private Boolean messagePresent;
    @SerializedName("messageList")
    @Expose
    private List<MessageList> messageList = null;
    @SerializedName("data")
    @Expose
    private PersonalAreaData data;

    public Boolean getMessagePresent() {
        return messagePresent;
    }

    public void setMessagePresent(Boolean messagePresent) {
        this.messagePresent = messagePresent;
    }

    public List<MessageList> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageList> messageList) {
        this.messageList = messageList;
    }

    public PersonalAreaData getData() {
        return data;
    }

    public void setData(PersonalAreaData data) {
        this.data = data;
    }

}