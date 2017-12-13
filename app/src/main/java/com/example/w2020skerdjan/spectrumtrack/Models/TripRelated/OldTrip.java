package com.example.w2020skerdjan.spectrumtrack.Models.TripRelated;

/**
 * Created by W2020 Android on 12/4/2017.
 */

public class OldTrip {
    String Date;
    String From;
    String Truck;
    String To;
    String Trailer;

    public OldTrip(String a, String b, String c, String d, String e ){
        Date = a;
        From = b;
        Truck = c;
        To = d;
        Trailer = e;
    }

    public String getDate(){
        return Date;
    }
    public String getFrom(){
        return From;
    }
    public String getTruck(){
        return Truck;
    }
    public String getTo(){
        return To;
    }
    public String getTrailer(){
        return Trailer;
    }

}
