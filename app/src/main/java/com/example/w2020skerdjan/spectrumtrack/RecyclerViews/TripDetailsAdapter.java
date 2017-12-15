package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Activities.TripDetails;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Trip;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.TripDetailsItem;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.VehicleEquipment;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W2020 Android on 12/15/2017.
 */

public class TripDetailsAdapter extends RecyclerView.Adapter<TripDetailsAdapter.ViewHolder> {
    private Context ctx;
    private ArrayList<TripDetailsItem> tripDetailsItems = new ArrayList<>();
    public TripDetailsAdapter(Context ctx,ArrayList<TripDetailsItem> td) {
        this.ctx=ctx;
        tripDetailsItems = td;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trip_detail, parent, false);
        return  new TripDetailsAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TripDetailsItem tripDetailsItem = tripDetailsItems.get(position);
        holder.tvTag.setText(tripDetailsItem.getTag());
        holder.tvContent.setText(tripDetailsItem.getContent());
    }

    @Override
    public int getItemCount() {
        return tripDetailsItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTag;
        TextView tvContent;
        public ViewHolder(View v) {
            super(v);
            tvTag = (TextView) v.findViewById(R.id.tag);
            tvContent = (TextView) v.findViewById(R.id.content);
        }

    }

}
