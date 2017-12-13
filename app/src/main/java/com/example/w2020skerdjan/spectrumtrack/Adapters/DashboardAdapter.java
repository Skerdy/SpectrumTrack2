package com.example.w2020skerdjan.spectrumtrack.Adapters;

import android.widget.ListAdapter;

import com.example.w2020skerdjan.spectrumtrack.Models.DemoItem;

import java.util.List;

/**
 * Created by W2020 Android on 12/13/2017.
 */

public interface DashboardAdapter extends ListAdapter {

        void appendItems(List<DemoItem> newItems);

        void setItems(List<DemoItem> moreItems);

}
