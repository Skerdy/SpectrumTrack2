package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Fragments.TripActivitiesFragment;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Activities.TripActivity;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.TripDetailsItem;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W2020 Android on 12/18/2017.
 */

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> implements View.OnClickListener {

    private Context ctx;
    private List<TripActivity> tripActivities = new ArrayList<>();


    public ActivityAdapter(Context ctx,List<TripActivity> tAF) {
        this.ctx=ctx;
        tripActivities = tAF;
    }


    @Override
    public ActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trip_activity_view, parent, false);
        return  new ActivityAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ActivityAdapter.ViewHolder holder, int position) {
        TripActivity tripActivity = tripActivities.get(position);
        holder.name.setText(tripActivity.getName());
        holder.activity.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return tripActivities.size();
    }

    @Override
    public void onClick(View v) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView activity;
        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.activity_name);
            activity = (CardView) v.findViewById(R.id.trip_activity_Item);
        }
    }
}
