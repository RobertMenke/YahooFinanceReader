/*
 * StockQuote.java 1.0 Oct 28, 2015
 *
 * Copyright (c) 2015 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.stockquotes;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class StockQuote {

  private String date;
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
   */
  public StockQuote(String aDate, double anOpen, double aHigh, double aLow, double aClose, int aVolume, double adjustedClose) {

    this.date = aDate;
    this.open = anOpen;
    this.high = aHigh;
    this.low = aLow;
    this.close = aClose;
    this.volume = aVolume;
    this.adjustedClose = adjustedClose;
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

  public String getDate() {
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

  public void setDate(String aDate) {
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

}
