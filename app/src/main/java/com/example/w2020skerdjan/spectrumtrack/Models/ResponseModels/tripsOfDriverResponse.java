package com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels;

/**
 * Created by W2020 Android on 12/13/2017.
 */
import java.util.List;

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Trip;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.MessageList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class tripsOfDriverResponse {
        @SerializedName("messagePresent")
        @Expose
        private Boolean messagePresent;
        @SerializedName("messageList")
        @Expose
        private List<MessageList> messageList = null;
        @SerializedName("data")
        @Expose
        private List<Trip> data = null;

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

        public List<Trip> getData() {
            return data;
        }

        public void setData(List<Trip> data) {
            this.data = data;
        }
    }

