package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

/**
 * Created by W2020 Android on 12/27/2017.
 */

public class CheckedTextViewModel {
    private String name;
    private boolean checked;

    public CheckedTextViewModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }
}