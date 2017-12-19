package com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.ResponseModel;

/**
 * Created by W2020 Android on 12/19/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CalendarInfo {

    @SerializedName("legend")
    @Expose
    private String legend;
    @SerializedName("activity")
    @Expose
    private List<CalendarEvent> activity = null;

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public List<CalendarEvent> getActivity() {
        return activity;
    }

    public void setActivity(List<CalendarEvent> activity) {
        this.activity = activity;
    }

}
