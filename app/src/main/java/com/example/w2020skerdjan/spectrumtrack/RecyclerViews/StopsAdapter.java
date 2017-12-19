package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Activities.TripActivity;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Stops.TripStop;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W2020 Android on 12/18/2017.
 */

public class StopsAdapter extends RecyclerView.Adapter<StopsAdapter.ViewHolder> implements View.OnClickListener {

    private Context ctx;
    private List<TripStop> tripStops = new ArrayList<>();


    public StopsAdapter(Context ctx, List<TripStop> tS){
        this.ctx = ctx;
        tripStops = tS;
    }



    @Override
    public StopsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trip_stops_view, parent, false);
        return  new StopsAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(StopsAdapter.ViewHolder holder, int position) {
        TripStop tripStop = tripStops.get(position);
        holder.name.setText(tripStop.getName());
        holder.stops.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return tripStops.size();
    }

    @Override
    public void onClick(View v) {

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView stops;
        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.stops_name);
            stops = (CardView) v.findViewById(R.id.trip_stops_Item);
        }
    }
}
