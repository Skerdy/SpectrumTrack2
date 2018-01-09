package com.example.w2020skerdjan.spectrumtrack.RecyclerViews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter;
import com.afollestad.sectionedrecyclerview.SectionedViewHolder;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarTrip;
import com.example.w2020skerdjan.spectrumtrack.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by W2020 Android on 1/9/2018.
 */

public class SectionedLegendAdapter extends SectionedRecyclerViewAdapter<SectionedLegendAdapter.ViewHolder> {
    private  Context ctx;
    private  ArrayList<CalendarTrip> calendarTrips;

    public  SectionedLegendAdapter (Context ctx , ArrayList<CalendarTrip> calendarTrips){
        this.ctx = ctx;
        this.calendarTrips = calendarTrips;
        for(int i = 0; i<calendarTrips.size(); i++) {
            Log.d("CalendarUtils", "Section 1 : " + calendarTrips.get(i).getName() + " ka gjithsej : " + calendarTrips.get(i).getCalendarCustomEvents().size() + " Evente");
        }
    }



    @Override
    public int getSectionCount() {
        return  calendarTrips.size();
    }

    @Override
    public int getItemCount(int section) {
        return calendarTrips.get(section).getCalendarCustomEvents().size();
       // return 2;
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder, int section, boolean expanded) {
        CalendarTrip calendarTrip = calendarTrips.get(section);
        holder.title.setText(calendarTrip.getName());
        holder.caret.setImageResource(expanded ? R.drawable.legend_collapse_header : R.drawable.legend_expand_header);
    }

    @Override
    public void onBindFooterViewHolder(ViewHolder holder, int section) {

    }

    @Override
    public void onBindViewHolder(SectionedLegendAdapter.ViewHolder holder, int section, int relativePosition, int absolutePosition) {
       /* SectionedLegendAdapter.ViewHolder holder, int section, int relativePosition, int absolutePosition) {
            holder.title.setText(
                    String.format("S:%d, P:%d, A:%d", section, relativePosition, absolutePosition));
    }
    */
    }

    @Override
    public SectionedLegendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                layout = R.layout.legend_item_header;
                break;
            case VIEW_TYPE_ITEM:
                layout = R.layout.legend_item_footer;
                break;
            default:
                // Our custom item, which is the 0 returned in getItemViewType() above
                layout = R.layout.legend_item_footer;
                break;
        }

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new SectionedLegendAdapter.ViewHolder(v, this);
    }

    public class ViewHolder extends SectionedViewHolder implements View.OnClickListener {
        final SectionedRecyclerViewAdapter adapter;
        final TextView title;
        final ImageView caret;

        public ViewHolder(View itemView, SectionedRecyclerViewAdapter adapter) {
            super(itemView);
            this.title = itemView.findViewById(R.id.header_title);
            this.caret = itemView.findViewById(R.id.caret);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            if (isFooter()) {
                // ignore footer clicks
                return;
            }

            if (isHeader()) {
                adapter.toggleSectionExpanded(getRelativePosition().section());
            }
            else {
                // logjika per te bere filtrimin
            }
        }
    }
}
