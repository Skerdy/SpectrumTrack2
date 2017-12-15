package com.example.w2020skerdjan.spectrumtrack.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.TripDetailsItem;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.List;

/**
 * Created by W2020 Android on 12/4/2017.
 */

public class TripDetailsAdapter extends BaseAdapter {

    private List<TripDetailsItem> list;
    private LayoutInflater inflater;
    private Context context;

    public TripDetailsAdapter(Context context, List<TripDetailsItem> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TripDetailsViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.trip_detail, null);
            holder = new TripDetailsViewHolder();
            holder.tvTag = (TextView) convertView.findViewById(R.id.tag);
            holder.tvContent = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        }
        holder = (TripDetailsViewHolder) convertView.getTag();
        TripDetailsItem data = list.get(position);
        holder.tvTag.setText(data.getTag());
        holder.tvContent.setText(data.getContent());
        return convertView;
    }
}

class TripDetailsViewHolder {
    TextView tvTag;
    TextView tvContent;
}
