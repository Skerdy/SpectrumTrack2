package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

/**
 * Created by W2020 Android on 12/11/2017.
 */
import java.util.List;

import com.example.w2020skerdjan.spectrumtrack.Retrofit.MessageList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EquipmentResponseModel {

        @SerializedName("messagePresent")
        @Expose
        private Boolean messagePresent;
        @SerializedName("messageList")
        @Expose
        private List<MessageList> messageList = null;
        @SerializedName("data")
        @Expose
        private List<VehicleEquipment> data = null;

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

        public List<VehicleEquipment> getData() {
            return data;
        }

        public void setData(List<VehicleEquipment> data) {
            this.data = data;
        }
}
