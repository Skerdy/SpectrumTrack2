package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

/**
 * Created by W2020 Android on 12/4/2017.
 */

public class TripDetailsItem {
    private String tag;
    private String content;

    public TripDetailsItem(String tag, String content) {
        this.tag = tag;
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
