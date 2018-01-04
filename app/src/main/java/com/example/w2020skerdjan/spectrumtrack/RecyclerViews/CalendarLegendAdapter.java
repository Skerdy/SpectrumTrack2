package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Fragments.MonthFragment;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarEntity;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.FragmentCalendarState;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.ResponseModel.CalendarEvent;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.CalendarResponse;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Activities.TripActivity;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.Utils.CalendarUtilsResponse;
import com.squareup.timessquare.CalendarPickerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by W2020 Android on 1/4/2018.
 */

public class CalendarLegendAdapter extends  RecyclerView.Adapter<CalendarLegendAdapter.ViewHolder> {
    private Context ctx;
    private List<CalendarEvent> calendarEvents = new ArrayList<>();
    private MonthFragment monthFragment;
    private FragmentCalendarState fragmentCalendarState;

    public CalendarLegendAdapter ( Context ctx , List<CalendarEvent> calendarEvents, MonthFragment monthFragment, FragmentCalendarState fragmentCalendarState){
        this.ctx = ctx;
        this.calendarEvents = calendarEvents;
        this.monthFragment = monthFragment;
        this.fragmentCalendarState = fragmentCalendarState;
    }


    @Override
    public CalendarLegendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.legend, parent, false);
        return  new CalendarLegendAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CalendarLegendAdapter.ViewHolder holder, int position) {
        final CalendarEvent calendarEvent = calendarEvents.get(position);
        holder.legendText.setText(calendarEvent.getName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(position+1);
        stringBuilder.append(".");
        holder.numberTextView.setText(stringBuilder.toString());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Date> highlightSelectDate = new ArrayList<>();

                fragmentCalendarState.clearHighLightedDates();
                fragmentCalendarState.setHighlighteddates(CalendarUtilsResponse.getDatesFromEvent(calendarEvent));
                monthFragment.initCalendarData(fragmentCalendarState);
            }
        });
    }

    @Override
    public int getItemCount() {
        return calendarEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View coloredView;
        TextView legendText;
        TextView numberTextView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.legend);
            coloredView = (View) itemView.findViewById(R.id.legendColor);
            legendText = (TextView) itemView.findViewById(R.id.legendText);
            numberTextView = (TextView) itemView.findViewById(R.id.number);

        }
    }
}
