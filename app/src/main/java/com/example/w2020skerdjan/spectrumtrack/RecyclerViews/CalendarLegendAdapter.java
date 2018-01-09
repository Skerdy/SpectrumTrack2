package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.w2020skerdjan.spectrumtrack.Fragments.MonthFragment;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.FragmentCalendarState;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.ResponseModel.CalendarEvent;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.Utils.CalendarUtilsResponse;
import com.example.w2020skerdjan.spectrumtrack.Utils.Interfaces.LegendClicker;
import com.squareup.timessquare.LegendHighLight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W2020 Android on 1/4/2018.
 */

public class CalendarLegendAdapter extends  RecyclerView.Adapter<CalendarLegendAdapter.ViewHolder> implements View.OnClickListener {
    private Context ctx;
    private List<CalendarEvent> calendarEvents = new ArrayList<>();
    private MonthFragment monthFragment;
    private FragmentCalendarState fragmentCalendarState;
    private CalendarUtilsResponse calendarUtilsResponse;
    private CalendarEvent calendarEvent;
    private LegendHighLight legendHighLight;
    private View.OnClickListener mClickListener;



    public CalendarLegendAdapter ( Context ctx , CalendarUtilsResponse calendarUtilsResponse, MonthFragment monthFragment, FragmentCalendarState fragmentCalendarState){
        this.ctx = ctx;
        this.calendarUtilsResponse = calendarUtilsResponse;
        this.calendarEvents = calendarUtilsResponse.getCalendarEvents();
        this.monthFragment = monthFragment;
        this.fragmentCalendarState = fragmentCalendarState;
    }


    @Override
    public CalendarLegendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.legend_item_footer, parent, false);
        return  new CalendarLegendAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CalendarLegendAdapter.ViewHolder holder, final int position) {
        calendarEvent = calendarEvents.get(position);
        legendHighLight = calendarUtilsResponse.getOrganizedHighlight().get(position);
        holder.legendText.setText(calendarEvent.getName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(position+1);
        stringBuilder.append(".");
        holder.numberTextView.setText(stringBuilder.toString());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int p = position;
                if(p!= position){
                    Log.d("Skerdi" , "Position = " + position + " p = "  + p);
                    calendarEvent = calendarEvents.get(p);
                    legendHighLight = calendarUtilsResponse.getOrganizedHighlight().get(p);
                }
                else {
                    Log.d("Skerdi" , "Position = " + position + " p = "  + p);
                }
                ArrayList<LegendHighLight> legendHighLights = new ArrayList<>();
                legendHighLights.add(legendHighLight);
                fragmentCalendarState.clearHighLightedDates();
                fragmentCalendarState.clearOrganizedDates();
                fragmentCalendarState.setHighlighteddates(calendarUtilsResponse.getDatesFromEvent(calendarEvent));
                fragmentCalendarState.setOrganizedHighLightedDates(legendHighLights);
                monthFragment.initCalendarData(fragmentCalendarState);
            }
        });

        holder.coloredView.setBackgroundColor(legendHighLight.getEventCellsHighlightColor());
    }

    @Override
    public int getItemCount() {
        return calendarUtilsResponse.getOrganizedHighlight().size();
    }


    @Override
    public void onClick(View v) {

    }

    public void setClickListener(View.OnClickListener callback) {
        mClickListener = callback;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private LegendClicker legendClicker;

        View coloredView;
        TextView legendText;
        TextView numberTextView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
           // this.legendClicker = legendClicker;
           // itemView.setOnClickListener(this);
            cardView = (CardView) itemView.findViewById(R.id.legend);
            coloredView = (View) itemView.findViewById(R.id.legendColor);
            legendText = (TextView) itemView.findViewById(R.id.legendText);
            numberTextView = (TextView) itemView.findViewById(R.id.number);

        }
    }
}
