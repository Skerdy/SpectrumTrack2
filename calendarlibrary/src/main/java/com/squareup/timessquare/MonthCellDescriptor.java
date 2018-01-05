// Copyright 2012 Square, Inc.

package com.squareup.timessquare;

import android.graphics.Color;

import java.io.Serializable;
import java.util.Date;

/** Describes the state of a particular date cell in a {@link MonthView}. */
class MonthCellDescriptor implements Serializable {

  public static final int RED= Color.parseColor("#e53935");
  public static final int BLUE= Color.parseColor("#43a047");
  public static final int GREEN= Color.parseColor("#1e88e5");
  public static final int GRAY= Color.parseColor("#74756e");



  private final Date date;
  private final int value;
  private final boolean isCurrentMonth;
  private boolean isSelected;
  private final boolean isToday;
  private final boolean isSelectable;
  private boolean isHighlighted;
  private RangeState rangeState;
  private String tripName = "bosh";



  private int HIGHLIGHT_COLOR ;

  MonthCellDescriptor(Date date, boolean currentMonth, boolean selectable, boolean selected,
      boolean today, boolean highlighted, int value, RangeState rangeState, String tripName) {
    this.date = date;
    isCurrentMonth = currentMonth;
    isSelectable = selectable;
    isHighlighted = highlighted;
    isSelected = selected;
    isToday = today;
    this.value = value;
    this.rangeState = rangeState;
    this.tripName = tripName;
  }

  public Date getDate() {
    return date;
  }

  public boolean isCurrentMonth() {
    return isCurrentMonth;
  }

  public boolean isSelectable() {
    return isSelectable;
  }

  public boolean isSelected() {
    return isSelected;
  }

  public void setSelected(boolean selected) {
    isSelected = selected;
  }

  boolean isHighlighted() {
    return isHighlighted;
  }

  void setHighlighted(boolean highlighted) {
    isHighlighted = highlighted;
  }

  public boolean isToday() {
    return isToday;
  }

  public RangeState getRangeState() {
    return rangeState;
  }

  public void setRangeState(RangeState rangeState) {
    this.rangeState = rangeState;
  }

  public int getValue() {
    return value;
  }

  public String getTripName() {
    return tripName;
  }

  public void setTripName(String tripName){
    this.tripName=tripName;
  }

  public int getHIGHLIGHT_COLOR() {
    return HIGHLIGHT_COLOR;
  }

  public void setHIGHLIGHT_COLOR(int HIGHLIGHT_COLOR) {
    this.HIGHLIGHT_COLOR = HIGHLIGHT_COLOR;
  }

  @Override public String toString() {
    return "MonthCellDescriptor{"
        + "date="
        + date
        + ", value="
        + value
        + ", Trip Name"
        + tripName
        + ", isCurrentMonth="
        + isCurrentMonth
        + ", isSelected="
        + isSelected
        + ", isToday="
        + isToday
        + ", isSelectable="
        + isSelectable
        + ", isHighlighted="
        + isHighlighted
        + ", rangeState="
        + rangeState
        + '}';
  }
}
