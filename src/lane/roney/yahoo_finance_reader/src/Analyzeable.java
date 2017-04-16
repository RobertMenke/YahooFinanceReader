/*
 * Analyzeable.java 1.0 Jan 17, 2016
 *
 * Copyright (c) 2016 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.yahoo_finance_reader.src;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
abstract public class Analyzeable {

  protected ArrayList<StockQuote> quotes;
  protected HashMap<String, String> functionMap = new HashMap<String, String>() {
    {

      put("date", "getUnixTimestamp");
      put("open", "getOpen");
      put("high", "getHigh");
      put("low", "getLow");
      put("close", "getClose");
      put("volume", "getVolume");
      put("adjusted close", "getAdjustedClose");

    }
  };

  /**
   * 
   * Constructs the Analyzeable abstract class with the ArrayList of stock
   * quotes that we received from Yahoo Finance
   *
   * @param quotes - an ArrayList of StockQuote objects
   */
  public Analyzeable(ArrayList<StockQuote> quotes) {

    this.quotes = quotes;
  }

  /**
   * 
   * create a list based on a particular stock quote category
   *
   * @param category
   * @return
   * @throws Exception
   */
  public ArrayList<Double> getListByCategory(String category) throws Exception {

    Class myClass = Class.forName("lane.roney.project.StockQuote");
    Method classMethod = myClass.getMethod(functionMap.get(category.toLowerCase()));

    ArrayList<Double> list = new ArrayList<Double>();

    for (int i = 0; i < quotes.size(); i++) {

      Double aVal = Double.parseDouble(classMethod.invoke(quotes.get(i)).toString());
      list.add(aVal);
    }
    return list;
  }

  /**
   * 
   * abstract method that each child class must implement. Performs whatever
   * analysis the child class is designed to perform.
   *
   * @return Double
   */
  abstract public Double performAnalysis();

  /**
   * 
   * The developer will need ArrayList of a particular category at times to
   * perform analyses like regression or risk adjusted return. Based on a
   * category string we'll add data to a new ArrayList and return it.
   *
   * @param category
   * @return an ArrayList of Double objects based on a particular category
   */
  protected ArrayList<Double> createList(String category) {

    ArrayList<Double> list = new ArrayList<Double>();

    for (int i = 0; i < quotes.size(); i++) {

      list.add(quotes.get(i).callMethodWithString(category));
    }
    return list;
  }
}
