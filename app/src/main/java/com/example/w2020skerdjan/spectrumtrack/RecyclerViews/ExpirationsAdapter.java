package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Models.DriverRelated.UserExpiration;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Activities.TripActivity;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by W2020 Android on 12/26/2017.
 */

public class ExpirationsAdapter extends RecyclerView.Adapter<ExpirationsAdapter.ViewHolder> {

    private Context ctx;
    private List<UserExpiration> userExpirations = new ArrayList<>();

    public ExpirationsAdapter(Context ctx, List<UserExpiration> userExpirations){
        this.ctx = ctx;
        this.userExpirations = userExpirations;
    }


    @Override
    public ExpirationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expiration_item, parent, false);
        return  new ExpirationsAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserExpiration userExpiration = userExpirations.get(position);
        holder.expiration_name.setText(userExpiration.getExpiration());
        holder.expiration_date.setText(getStringDate(userExpiration.getExpirationsDate()));
        holder.expiration_duration.setText(getExpirationduration(new Date(userExpiration.getExpirationsDate())));
    }

    @Override
    public int getItemCount() {
        return userExpirations.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView expiration_name;
        TextView expiration_date;
        TextView expiration_duration;
        public ViewHolder(View v) {
            super(v);
            expiration_name = (TextView) v.findViewById(R.id.expiration_name);
            expiration_date = (TextView) v.findViewById(R.id.expiration_date);
            expiration_duration = (TextView) v.findViewById(R.id.expiration_duration);
        }
    }


    public String getStringDate (long dt){
        Date date = new Date(dt);
        return  getStringFromDate(date);
    }

    private String getStringFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        StringBuilder string = new StringBuilder();
        string.append(" " + month +"/"+day +"/"+year);
        return string.toString();
    }

    private String getExpirationduration(Date date){
        int number_of_days = 0;
        Date today = new Date();
        Calendar start = Calendar.getInstance();
        start.setTime(today);
        Calendar end = Calendar.getInstance();
        end.setTime(date);
        end.add(Calendar.DAY_OF_YEAR, 1);
        while (start.before(end)) {
            number_of_days++;
            start.add(Calendar.DAY_OF_YEAR, 1);
        }
        number_of_days--;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(number_of_days).append(" day(s)");
        return stringBuilder.toString();
    }
}
