package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Activities.TripDetails;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Trip;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.ArrayList;

/**
 * Created by W2020 Android on 12/2/2017.
 */

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.ViewHolder> {
    private ArrayList<Trip> trips =  new ArrayList<>();
    private Context ctx;

    public TripsAdapter(Context ctx, ArrayList<Trip> trips) {
        this.trips = trips;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv=  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trips_view, parent, false);
        ViewHolder vh= new ViewHolder(cv);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trip trip = trips.get(position);
        final int p = position;
        holder.from.setText(trip.getFrom());
        holder.date.setText(trip.getDate());
        holder.to.setText(trip.getTo());
        holder.truck.setText(trip.getTruck());
        holder.trailer.setText(trip.getTrailer());
        holder.openTripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, TripDetails.class );
                intent.putExtra("TripPosition", p);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        private TextView from, to , date, truck, trailer;
        private ImageButton openTripButton;
        public ViewHolder(View v) {
            super(v);
            from = (TextView) v.findViewById(R.id.fromText);
            to = (TextView) v.findViewById(R.id.toText);
            date = (TextView) v.findViewById(R.id.dateText);
            truck = (TextView) v.findViewById(R.id.truckText);
            trailer = (TextView) v.findViewById(R.id.trailerText);
            openTripButton = (ImageButton) v.findViewById(R.id.image_button_trips);
        }

    }

}
