package com.squareup.timessquare;

import android.view.ContextThemeWrapper;
import android.widget.TextView;

import java.io.Serializable;

public class DefaultDayViewAdapter implements DayViewAdapter, Serializable {
  @Override
  public void makeCellView(CalendarCellView parent) {
      TextView textView = new TextView(
              new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_CalendarDate));
      textView.setDuplicateParentStateEnabled(true);
      parent.addView(textView);
      parent.setDayOfMonthTextView(textView);

      /*
      if(highlighted) {
          TextView textView1 = new TextView(new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_Calendartrip));
          textView.setDuplicateParentStateEnabled(true);
          textView1.setText("Trip");
          parent.addView(textView1);
          parent.setTripText(textView1);
      }
      */
  }

    @Override
    public void makeEventName(CalendarCellView parent) {
        TextView textView = new TextView(
                new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_Calendartrip));
        textView.setDuplicateParentStateEnabled(true);
        parent.addView(textView);
        parent.setEventName(textView);
    }
}
