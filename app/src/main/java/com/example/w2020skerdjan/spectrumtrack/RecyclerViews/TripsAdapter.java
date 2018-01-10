package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Activities.TripDetails;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.OldTrip;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Trip;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.Utils.CalendarUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by W2020 Android on 12/2/2017.
 */

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.ViewHolder>{
    private List<Trip> trips =  new ArrayList<>();
    private Context ctx;

    public TripsAdapter(Context ctx, List<Trip> trips) {
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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Trip trip = trips.get(position);
        String from, date, to, truck, trailer;
        if(trip.getLoadUnloads().get(0).getLoadingPointAddress().getCity()!=null)
         from = trip.getLoadUnloads().get(0).getLoadingPointAddress().getCity().toString();
        else from = "NoDataEntry";

        if(CalendarUtils.getStringDate(trip.getLoadUnloads().get(0).getLoadingPointDate())!=null){
            date = CalendarUtils.getStringDate(trip.getLoadUnloads().get(0).getLoadingPointDate());
        }
        else{
            date = "NoDataEntry";
        }

        if(trip.getLoadUnloads().get(trip.getLoadUnloads().size()-1).getDeliveryPointAddress().getCity()!=null)
         to = trip.getLoadUnloads().get(trip.getLoadUnloads().size()-1).getDeliveryPointAddress().getCity();
        else {
            to = "NoDataEntry";
        }
        if(trip.getDisposition().getVehicle()!= null)
         truck = trip.getDisposition().getVehicle();
        else {
            truck= "NoDataEntry";
        }
        if(trip.getDisposition().getTrailer()!=null)
         trailer = trip.getDisposition().getTrailer();
        else {
            trailer = "NoDataEntry";
        }
        final int p = position;
        holder.from.setText(from);
        holder.date.setText(date);
        holder.to.setText(to);
        holder.truck.setText(truck);
        holder.trailer.setText(trailer);

        holder.openTripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, TripDetails.class );
                Bundle bundle = new Bundle();
                bundle.putSerializable("TripPosition", trips.get(position));
                intent.putExtra("Bundle", bundle);
                ctx.startActivity(intent);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, TripDetails.class );
                Bundle bundle = new Bundle();
                bundle.putSerializable("TripPosition", trips.get(position));
                intent.putExtra("Bundle", bundle);
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
        private CardView cardView;
        public ViewHolder(View v) {
            super(v);
            from = (TextView) v.findViewById(R.id.fromText);
            to = (TextView) v.findViewById(R.id.toText);
            date = (TextView) v.findViewById(R.id.dateText);
            truck = (TextView) v.findViewById(R.id.truckText);
            trailer = (TextView) v.findViewById(R.id.trailerText);
            openTripButton = (ImageButton) v.findViewById(R.id.image_button_trips);
            cardView = (CardView) v.findViewById(R.id.TripCard);
        }

    }



}
