package com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels;

import java.util.List;

import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.ResponseModel.CalendarInfo;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.MessageList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by W2020 Android on 12/19/2017.
 **/



public class CalendarResponse {

    @SerializedName("messagePresent")
    @Expose
    private Boolean messagePresent;
    @SerializedName("messageList")
    @Expose
    private List<MessageList> messageList = null;
    @SerializedName("data")
    @Expose
    private List<CalendarInfo> data = null;

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

    public List<CalendarInfo> getData() {
        return data;
    }

    public void setData(List<CalendarInfo> data) {
        this.data = data;
    }

}