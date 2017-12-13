package com.example.w2020skerdjan.spectrumtrack.Adapters;

/**
 * Created by W2020 Android on 12/13/2017.
 */
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.w2020skerdjan.spectrumtrack.Models.DemoItem;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.List;

public class DefaultListAdapter extends ArrayAdapter<DemoItem> implements DashboardAdapter {

    private final LayoutInflater layoutInflater;

    public DefaultListAdapter(Context context, List<DemoItem> items) {
        super(context, 0, items);
        layoutInflater = LayoutInflater.from(context);
    }

    public DefaultListAdapter(Context context) {
        super(context, 0);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View v;

        DemoItem item = getItem(position);
        boolean isRegular = getItemViewType(position) == 0;

        if (convertView == null) {
            v = layoutInflater.inflate(
                    isRegular ? R.layout.trip_detail : R.layout.trip_detail, parent, false);
        } else {
            v = convertView;
        }

        TextView textView;
        if (isRegular) {
            textView = (TextView) v.findViewById(R.id.tag);
        } else {
            textView = (TextView) v.findViewById(R.id.content);
        }

        textView.setText(String.valueOf(item.getPosition()));

        return v;
    }

    @Override public int getViewTypeCount() {
        return 2;
    }

    @Override public int getItemViewType(int position) {
        return position % 2 == 0 ? 1 : 0;
    }

    public void appendItems(List<DemoItem> newItems) {
        addAll(newItems);
        notifyDataSetChanged();
    }

    public void setItems(List<DemoItem> moreItems) {
        clear();
        appendItems(moreItems);
    }
}
