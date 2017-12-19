package com.example.w2020skerdjan.spectrumtrack.Utils;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by W2020 Android on 12/18/2017.
 */

public class RetrofitHeaderManager {

    public static Map<String,String> loginMap (String em , String pass){
        Map<String,String> newMap = new HashMap<>();
        newMap.put("email", em);
        newMap.put("password", pass);
        return  newMap;
    }


    public static Map<String,String> getAuthMap (Context ctx){
        MySharedPref mySharedPref = new MySharedPref(ctx);
        String auth = mySharedPref.getSavedObjectFromPreference("Auth", String.class);
        Map<String,String> newMap = new HashMap<>();
        newMap.put("x-auth-token", auth);
        return  newMap;
    }

    public static Map<String,String> getCalendarMap(Context ctx , int m, int y){
        String month = ""+m;
        String year=""+y;
        MySharedPref mySharedPref = new MySharedPref(ctx);
        String auth = mySharedPref.getSavedObjectFromPreference("Auth", String.class);
        Map<String,String> newMap = new HashMap<>();
        newMap.put("x-auth-token", auth);
        newMap.put("month", month);
        newMap.put("year", year);
        return  newMap;
    }
}
