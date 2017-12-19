package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Stops;

/**
 * Created by W2020 Android on 12/18/2017.
 */

import java.util.List;

import com.example.w2020skerdjan.spectrumtrack.Retrofit.MessageList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllStops {

    @SerializedName("messagePresent")
    @Expose
    private Boolean messagePresent;
    @SerializedName("messageList")
    @Expose
    private List<MessageList> messageList = null;
    @SerializedName("data")
    @Expose
    private List<TripStop> data = null;

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

    public List<TripStop> getData() {
        return data;
    }

    public void setData(List<TripStop> data) {
        this.data = data;
    }

}
