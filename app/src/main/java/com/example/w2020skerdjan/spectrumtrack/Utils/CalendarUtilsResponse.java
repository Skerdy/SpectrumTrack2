package com.example.w2020skerdjan.spectrumtrack.Utils;

import android.graphics.Color;
import android.util.Log;

import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.ResponseModel.CalendarEvent;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.ResponseModel.CalendarInfo;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.CalendarResponse;
import com.squareup.timessquare.LegendHighLight;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by W2020 Android on 12/20/2017.
 */

public class CalendarUtilsResponse {
    private CalendarResponse calendarResponse;
    private Map<CalendarEvent, ArrayList<Date>> highlightedDates;
    private CalendarEvent calendarEvent;
    private ArrayList<Date> eventDuration;
    private List<CalendarInfo> calendarInfos;
    private List<CalendarEvent> calendarEvents;
    private ArrayList<Date> resultHighlight;
    private ArrayList<LegendHighLight> organizedHighlight;
    private int[] colors;


    public CalendarUtilsResponse(CalendarResponse calendarResponse) {
        this.calendarResponse = calendarResponse;
        highlightedDates = new HashMap<>();
        calendarInfos = new ArrayList<>();
        calendarEvents = new ArrayList<>();
        eventDuration = new ArrayList<>();
        resultHighlight = new ArrayList<>();
        organizedHighlight = new ArrayList<>();
        setupColorsList(7);
        mapEventsWithDates();
    }

    public static ArrayList<Date> ktheDatatNdermjet(Date startDate, Date endDate) {
        ArrayList<Date> result = new ArrayList<>();
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.add(Calendar.DAY_OF_YEAR, 1);
        while (start.before(end)) {
            result.add(start.getTime());
            start.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    public static ArrayList<Date> getDatesFromEvent(CalendarEvent calendarEvent) {
        Date startingDate = new Date(calendarEvent.getLoadingPointDate());
        Date endingDate = new Date(calendarEvent.getDeliveryPointDate());
        return ktheDatatNdermjet(startingDate, endingDate);
    }

    public void mapEventsWithDates() {
        calendarInfos = calendarResponse.getData();
        for (int i = 0; i < calendarInfos.size(); i++) {
            //logjika per cdo Calendar Info
            Log.d("CalendarUtil", "Jemi ne Calendar Info. Blloku = " + i);
            Log.d("CalendarUtil", "Activity Size " + calendarInfos.get(i).getActivity().size());
            Log.d("CalendarUtil", "tipi i Eventit :  " + calendarInfos.get(i).getLegend());
            calendarEvents.addAll(calendarInfos.get(i).getActivity());

            for (int j = 0; j < calendarInfos.get(i).getActivity().size(); j++) {
                //Logjika per cdo kalendar Activity
                Log.d("CalendarUtil", "Jemi ne Calendar Activity");

                if (calendarInfos.get(i).getLegend().toString().equals("Deadline")) {


                    Log.d("CalendarUtil", "Jemi ne deadLine");
                    //Logjika per objektin DeadLine
                    Date today = new Date();
                    Date eventLoadDate = new Date(calendarInfos.get(i).getActivity().get(j).getLoadingPointDate());
                    if (eventLoadDate.compareTo(today) >= 0) {
                        String eventName = calendarInfos.get(i).getActivity().get(j).getName().toString();
                        Date eventDeliveryDate = new Date(calendarInfos.get(i).getActivity().get(j).getDeliveryPointDate());
                        eventDuration = ktheDatatNdermjet(eventLoadDate, eventDeliveryDate);

                        LegendHighLight legendHighLight = new LegendHighLight(eventName, eventDuration, colors[j]);
                        organizedHighlight.add(legendHighLight);

                        for (int k = 0; k < eventDuration.size(); k++) {
                            resultHighlight.add(eventDuration.get(k));
                        }

                    }

                } else {
                    Log.d("CalendarUtil", "Jemi ne TripActivityCalendar");
                    //logjika per objektin Trip
                }
            }


        }
    }

    private void setupColorsList(int size) {
        colors = new int[size];
        colors[0] = Color.RED;
        colors[1] = Color.BLUE;
        colors[2] = Color.GREEN;
        colors[3] = Color.YELLOW;
        colors[4] = Color.MAGENTA;
        colors[5] = Color.BLACK;
        colors[6] = Color.CYAN;
    }

    public void clearHighlightedResult() {
        if (this.resultHighlight.size() != 0) {
            resultHighlight.clear();
        }
    }

    public CalendarResponse getCalendarResponse() {
        return calendarResponse;
    }

    public void setCalendarResponse(CalendarResponse calendarResponse) {
        this.calendarResponse = calendarResponse;
    }

    public Map<CalendarEvent, ArrayList<Date>> getHighlightedDates() {
        return highlightedDates;
    }

    public void setHighlightedDates(Map<CalendarEvent, ArrayList<Date>> highlightedDates) {
        this.highlightedDates = highlightedDates;
    }

    public CalendarEvent getCalendarEvent() {
        return calendarEvent;
    }

    public void setCalendarEvent(CalendarEvent calendarEvent) {
        this.calendarEvent = calendarEvent;
    }

    public ArrayList<Date> getEventDuration() {
        return eventDuration;
    }

    public void setEventDuration(ArrayList<Date> eventDuration) {
        this.eventDuration = eventDuration;
    }

    public ArrayList<Date> getResultHighlight() {
        Log.d("EventDuration", "Size i HighLightDurations = " + resultHighlight.size());
        return resultHighlight;
    }

    public void setResultHighlight(ArrayList<Date> resultHighlight) {
        this.resultHighlight = resultHighlight;
    }

    public ArrayList<LegendHighLight> getOrganizedHighlight() {
        return organizedHighlight;
    }

    public void setOrganizedHighlight(ArrayList<LegendHighLight> organizedHighlight) {
        this.organizedHighlight = organizedHighlight;
    }

    public List<CalendarEvent> getCalendarEvents() {
        return calendarEvents;
    }

    public void setCalendarEvents(List<CalendarEvent> calendarEvents) {
        this.calendarEvents = calendarEvents;
    }
}
