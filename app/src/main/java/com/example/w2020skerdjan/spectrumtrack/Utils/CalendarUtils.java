package com.example.w2020skerdjan.spectrumtrack.Utils;

import android.icu.util.Calendar;
import android.util.Log;

import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarEntity;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CalendarTrip;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.CustomCalendarEvent;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.DrivingSession;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.DrivingSessionAddress;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.ResponseModel.CalendarEvent;
import com.example.w2020skerdjan.spectrumtrack.Models.CalendarRelated.ResponseModel.CalendarInfo;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.CalendarResponse;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.DeliveryPointAddress;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.Disposition;
import com.example.w2020skerdjan.spectrumtrack.Models.TripRelated.LoadingPointAddress;
import com.example.w2020skerdjan.spectrumtrack.Utils.CalendarUtilsResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by W2020 Android on 1/8/2018.
 */

public class CalendarUtils {
    private final static String LEGEND_TRIP = "Trip";
    private final static String LEGEND_DEADLINE = "Deadline";

    private CalendarResponse calendarResponse;
    private List<CalendarInfo> calendarInfos;
    private ArrayList<CalendarTrip> calendarTrips;
    private ArrayList<CustomCalendarEvent> customCalendarEvents;


    public CalendarUtils (CalendarResponse calendarResponse) {
        this.calendarResponse = calendarResponse;
        calendarTrips = new ArrayList<>();
        if (validateResponse()){
            Log.d("CalendarUtil", "Validimi i Calendar Response me sukses");
            generateAllCalendarTrips();
        }
        else {
            Log.d("CalendarUtil", "Validimi i Calendar Response pa sukses");
        }
    }

    //kemi mbaruar me gjenerimin e sakte te allTrips

    public void generateAllCalendarTrips () {
        calendarInfos = calendarResponse.getData();
        Log.d("CalendarUtil", calendarInfos.get(0).getLegend() + "  " + calendarInfos.get(1).getLegend());
        //iterojme neper objektet CalendarInfo
            CalendarInfo calendarInfotrip = calendarInfos.get(0);

            //iterojme per cdo objekt CalendarEvent
            for (int j = 0 ; j<calendarInfotrip.getActivity().size();j++) {
                CalendarEvent calendarEvent = calendarInfotrip.getActivity().get(j);
                // nese jemi ne legjenden trip krijojme nje objekt Calendar Trip dhe e shtojme ne listen e calendarTrip
                Log.d("CalendarUtil", "U krijua Nje Calendar trip");
                CalendarTrip calendarTrip = calendarTripFromCalendarEvent(calendarEvent);
                calendarTrips.add(calendarTrip);
            }

            CalendarInfo calendarInfodeadline = calendarInfos.get(1);
        Log.d("CalendarUtil", " Size i tere activiteteve ne deadline = " + calendarInfodeadline.getActivity().size());


            for (int j = 0; j <calendarInfodeadline.getActivity().size(); j++){

                CalendarEvent calendarEvent = calendarInfodeadline.getActivity().get(j);
                 if(calendarEvent.getTripLoadId()==calendarEvent.getTripUnloadId()) {
                     Log.d("CalendarUtil", "U krijua Nje calendar Event nga kushti i pare");
                     String CustomCalendarEventType;
                     DrivingSession startDrivingSession;
                     DrivingSession finishDrivingSession;
                     Integer tripID;
                     tripID = calendarEvent.getTripLoadId();
                     CustomCalendarEventType = CustomCalendarEvent.FULL_EVENT;
                     startDrivingSession = createDrivingSession(calendarEvent, DrivingSession.LOAD);
                     finishDrivingSession = createDrivingSession(calendarEvent, DrivingSession.UNLOAD);
                     CustomCalendarEvent customCalendarEvent = new CustomCalendarEvent(CustomCalendarEventType, startDrivingSession, finishDrivingSession);
                     customCalendarEvent.setTripID(tripID);
                     calendarTrips.get(ktheTripID(customCalendarEvent)).addCustomCalendarEvent(customCalendarEvent);

                }
                else if (calendarEvent.getTripLoadId()==null){
                     Log.d("CalendarUtil", "U krijua Nje calendar Event nga kushti i dyte");
                     String CustomCalendarEventType;
                     DrivingSession startDrivingSession;
                     DrivingSession finishDrivingSession;
                     Integer tripID;
                     tripID = calendarEvent.getTripUnloadId();
                     CustomCalendarEventType = CustomCalendarEvent.HALF_EVENT;
                     finishDrivingSession = createDrivingSession(calendarEvent, DrivingSession.UNLOAD);
                     startDrivingSession = null;
                     CustomCalendarEvent customCalendarEvent = new CustomCalendarEvent(CustomCalendarEventType, startDrivingSession, finishDrivingSession);
                     customCalendarEvent.setTripID(tripID);
                     calendarTrips.get(ktheTripID(customCalendarEvent)).addCustomCalendarEvent(customCalendarEvent);
                }
                else if (calendarEvent.getTripUnloadId()==null){
                     Log.d("CalendarUtil", "U krijua Nje calendar Event nga kushti i trete");
                     String CustomCalendarEventType;
                     DrivingSession startDrivingSession;
                     DrivingSession finishDrivingSession;
                     Integer tripID;
                     tripID = calendarEvent.getTripLoadId();
                     CustomCalendarEventType = CustomCalendarEvent.HALF_EVENT;
                     startDrivingSession = createDrivingSession(calendarEvent, DrivingSession.LOAD);
                     finishDrivingSession = null;
                     CustomCalendarEvent customCalendarEvent = new CustomCalendarEvent(CustomCalendarEventType, startDrivingSession, finishDrivingSession);
                     customCalendarEvent.setTripID(tripID);
                     calendarTrips.get(ktheTripID(customCalendarEvent)).addCustomCalendarEvent(customCalendarEvent);
                }
                 else if (!calendarEvent.getTripLoadId().equals(calendarEvent.getTripUnloadId())){
                     Log.d("CalendarUtil", "U krijua Nje calendar Event nga kushti i katert");
                     String CustomCalendarEventType;
                     DrivingSession startDrivingSession;
                     DrivingSession finishDrivingSession;
                     Integer tripID;
                     tripID = calendarEvent.getTripLoadId();
                     CustomCalendarEventType = CustomCalendarEvent.HALF_EVENT;
                     startDrivingSession = createDrivingSession(calendarEvent, DrivingSession.LOAD);
                     finishDrivingSession = null;
                     CustomCalendarEvent customCalendarEvent = new CustomCalendarEvent(CustomCalendarEventType, startDrivingSession, finishDrivingSession);
                     customCalendarEvent.setTripID(tripID);
                     calendarTrips.get(ktheTripID(customCalendarEvent)).addCustomCalendarEvent(customCalendarEvent);


                     Log.d("CalendarUtil", "U krijua Nje calendar Event");
                     tripID = calendarEvent.getTripUnloadId();
                     CustomCalendarEventType = CustomCalendarEvent.HALF_EVENT;
                     finishDrivingSession = createDrivingSession(calendarEvent,DrivingSession.UNLOAD);
                     startDrivingSession = null;
                     customCalendarEvent = new CustomCalendarEvent(CustomCalendarEventType, startDrivingSession, finishDrivingSession);
                     customCalendarEvent.setTripID(tripID);
                     calendarTrips.get(ktheTripID(customCalendarEvent)).addCustomCalendarEvent(customCalendarEvent);
                 }
            }

    }

    /*
    private CustomCalendarEvent customCalendarEventFromCalendarEvent(CalendarEvent calendarEvent) {
        String CustomCalendarEventType;
        DrivingSession startDrivingSession;
        DrivingSession finishDrivingSession;

        Integer tripID;
         if(calendarEvent.getTripLoadId()==calendarEvent.getTripUnloadId()) {
              tripID = calendarEvent.getTripLoadId();
              CustomCalendarEventType = CustomCalendarEvent.FULL_EVENT;
              startDrivingSession = createDrivingSession(calendarEvent, DrivingSession.LOAD);
              finishDrivingSession = createDrivingSession(calendarEvent, DrivingSession.UNLOAD);

         }
         else if (calendarEvent.getTripLoadId()==null){
              tripID = calendarEvent.getTripUnloadId();
              CustomCalendarEventType = CustomCalendarEvent.HALF_EVENT;
              finishDrivingSession = createDrivingSession(calendarEvent, DrivingSession.UNLOAD);
              startDrivingSession = null;
         }
         else if (calendarEvent.getTripUnloadId()==null){
             tripID = calendarEvent.getTripLoadId();
             CustomCalendarEventType = CustomCalendarEvent.HALF_EVENT;
             startDrivingSession = createDrivingSession(calendarEvent, DrivingSession.LOAD);
             finishDrivingSession = null;
         }


         CustomCalendarEvent customCalendarEvent = new CustomCalendarEvent(CustomCalendarEventType, startDrivingSession, finishDrivingSession);
         customCalendarEvent.setTripID(tripID);

         return  customCalendarEvent;

    }
    */

    private void createCustomCalendarEvent (){

    }

    private DrivingSession createDrivingSession(CalendarEvent calendarEvent, String load) {
        Date date;
        DrivingSessionAddress drivingSessionAddress = new DrivingSessionAddress();

        if(load.equals(DrivingSession.LOAD)) {
            LoadingPointAddress loadingPointAddress = calendarEvent.getLoadingPointAddress();
            date = new Date();
            /*
            if(calendarEvent.getDeliveryPointAddress() != null)
            date = new Date(calendarEvent.getLoadingPointDate());
            else {
                date = new Date();
            }
            */
            drivingSessionAddress.setCity(loadingPointAddress.getCity());
            drivingSessionAddress.setCountry(loadingPointAddress.getCountry());
            drivingSessionAddress.setLatitude(loadingPointAddress.getLatitude());
            drivingSessionAddress.setLongitude(loadingPointAddress.getLongitude());
            drivingSessionAddress.setState(loadingPointAddress.getState());
            drivingSessionAddress.setStreet(loadingPointAddress.getStreet());
            drivingSessionAddress.setZipCode(loadingPointAddress.getZipCode());
        }
        else {
            DeliveryPointAddress deliveryPointAddress = calendarEvent.getDeliveryPointAddress();
            date = new Date(); /*
            if(calendarEvent.getDeliveryPointAddress() != null)
            date = new Date(calendarEvent.getLoadingPointDate());
            else {
                date = new Date();
            } */
            drivingSessionAddress.setCity(deliveryPointAddress.getCity());
            drivingSessionAddress.setCountry(deliveryPointAddress.getCountry());
            drivingSessionAddress.setLatitude(deliveryPointAddress.getLatitude());
            drivingSessionAddress.setLongitude(deliveryPointAddress.getLongitude());
            drivingSessionAddress.setState(deliveryPointAddress.getState());
            drivingSessionAddress.setStreet(deliveryPointAddress.getStreet());
            drivingSessionAddress.setZipCode(deliveryPointAddress.getZipCode());
        }

          DrivingSession drivingSession = new DrivingSession(load,date,drivingSessionAddress);
          return drivingSession;
    }


    private CalendarTrip calendarTripFromCalendarEvent(CalendarEvent calendarEvent) {
         Integer id = calendarEvent.getId();
         String name = calendarEvent.getName();
         String instructions = calendarEvent.getInstructions();
         Disposition disposition = calendarEvent.getDisposition();
         Long createdAt = calendarEvent.getCreatedAt();

         CalendarTrip calendarTrip = new CalendarTrip(id, name, instructions, disposition, createdAt);

         return calendarTrip;
    }

    private int ktheTripID(CustomCalendarEvent customCalendarEvent) {
        for(int i = 0 ; i < calendarTrips.size();i++ ){
         if(customCalendarEvent.getTripID()==calendarTrips.get(i).getId()){
             return i;
         }
        }
        return 0;
    }

    private boolean validateResponse (){
        boolean flag = true;
        if(calendarResponse==null){
            flag=false;
        }
        return flag;
    }



    public static String getStringDate (long dt){
        Date date = new Date(dt);
        return  getStringFromDate(date);
    }

    private static String getStringFromDate(Date date){
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(java.util.Calendar.YEAR);
        int month = cal.get(java.util.Calendar.MONTH)+1;
        int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
        StringBuilder string = new StringBuilder();
        string.append(" " + month +"/"+day +"/"+year);
        return string.toString();
    }

    public CalendarResponse getCalendarResponse() {
        return calendarResponse;
    }

    public void setCalendarResponse(CalendarResponse calendarResponse) {
        this.calendarResponse = calendarResponse;
    }

    public List<CalendarInfo> getCalendarInfos() {
        return calendarInfos;
    }

    public void setCalendarInfos(List<CalendarInfo> calendarInfos) {
        this.calendarInfos = calendarInfos;
    }

    public ArrayList<CalendarTrip> getCalendarTrips() {
        return calendarTrips;
    }

    public void setCalendarTrips(ArrayList<CalendarTrip> calendarTrips) {
        this.calendarTrips = calendarTrips;
    }

    public ArrayList<CustomCalendarEvent> getCustomCalendarEvents() {
        return customCalendarEvents;
    }

    public void setCustomCalendarEvents(ArrayList<CustomCalendarEvent> customCalendarEvents) {
        this.customCalendarEvents = customCalendarEvents;
    }

}
