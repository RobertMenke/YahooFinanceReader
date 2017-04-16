/*
 * StockQuote.java 1.0 Oct 28, 2015
 *
 * Copyright (c) 2015 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.yahoo_finance_reader.src;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class StockQuote {

  private Date date;
  private double open;
  private double high;
  private double low;
  private double close;
  private int volume;
  private double adjustedClose;

  /**
   * 
   * Creates ...
   *
   * @param aDate
   * @param anOpen
   * @param aHigh
   * @param aLow
   * @param aClose
   * @param aVolume
   * @param anAdjustedClose
   */
  public StockQuote(String aDate, double anOpen, double aHigh, double aLow, double aClose, int aVolume, double adjustedClose) {

    this.date = stringToDate(aDate);
    this.open = anOpen;
    this.high = aHigh;
    this.low = aLow;
    this.close = aClose;
    this.volume = aVolume;
    this.adjustedClose = adjustedClose;
  }

  public Double callMethodWithString(String fieldName) {

    fieldName = fieldName.toLowerCase();
    if (fieldName.equals("date")) {

      return new Double(getUnixTimestamp());

    } else if (fieldName.equals("open")) {

      return new Double(getOpen());

    } else if (fieldName.equals("high")) {

      return new Double(getHigh());

    } else if (fieldName.equals("low")) {

      return new Double(getLow());

    } else if (fieldName.equals("close")) {

      return new Double(getClose());

    } else if (fieldName.equals("volume")) {

      return new Double(getVolume());

    } else if (fieldName.equals("adjusted close")) {

      return new Double(getAdjustedClose());

    } else {

      throw new IllegalArgumentException("The string you provided did not match any legal inputs");
    }
  }

  /**
   * Gets ...
   *
   * @return the adjustedClose
   */
  public double getAdjustedClose() {
    return adjustedClose;
  }

  /**
   * Gets ...
   *
   * @return the close
   */
  public double getClose() {
    return close;
  }

  public Date getDate() {
    return date;
  }

  /**
   * Gets ...
   *
   * @return the high
   */
  public double getHigh() {
    return high;
  }

  /**
   * Gets ...
   *
   * @return the low
   */
  public double getLow() {
    return low;
  }

  /**
   * Gets ...
   *
   * @return the open
   */
  public double getOpen() {
    return open;
  }

  public long getUnixTimestamp() {
    return date.getTime();
  }

  /**
   * Gets ...
   *
   * @return the volume
   */
  public int getVolume() {
    return volume;
  }

  /**
   * Sets ...
   *
   * @param aAdjustedClose the adjustedClose to set
   */
  public void setAdjustedClose(double aAdjustedClose) {
    adjustedClose = aAdjustedClose;
  }

  /**
   * Sets ...
   *
   * @param aClose the close to set
   */
  public void setClose(double aClose) {
    close = aClose;
  }

  public void setDate(Date aDate) {
    this.date = aDate;
  }

  /**
   * Sets ...
   *
   * @param aHigh the high to set
   */
  public void setHigh(double aHigh) {
    high = aHigh;
  }

  /**
   * Sets ...
   *
   * @param aLow the low to set
   */
  public void setLow(double aLow) {
    low = aLow;
  }

  /**
   * Sets ...
   *
   * @param aOpen the open to set
   */
  public void setOpen(double aOpen) {
    open = aOpen;
  }

  /**
   * Sets ...
   *
   * @param aVolume the volume to set
   */
  public void setVolume(int aVolume) {
    volume = aVolume;
  }

  private Date stringToDate(String stringDate) {
    DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
    Date aDate = new Date();
    try {
      aDate = format.parse(stringDate);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return aDate;
  }

}