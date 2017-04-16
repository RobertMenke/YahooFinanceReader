/*
 * Main.java 1.0 Jan 13, 2016
 *
 * Copyright (c) 2016 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.yahoo_finance_reader.src;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class Main {

  /**
   * Verb ...
   *
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    URLReader getData = new URLReader("AMZN");
    File csv = getData.grabData();
    // UserPrompt prompt = new UserPrompt();
    // File userChoice = prompt.requestFile();
    CsvReader reader = new CsvReader(csv);

    try {

      ArrayList<StockQuote> historicalStockPrices = reader.readData();
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

      Date d = sdf.parse("21/12/2017");

      Analyzeable low = new RegressionTester(historicalStockPrices, "date", "low", (double) d.getTime());
      Analyzeable high = new RegressionTester(historicalStockPrices, "date", "high", (double) d.getTime());

      Double lowVal = low.performAnalysis();
      Double highVal = high.performAnalysis();
      System.out.println("low: " + lowVal);
      System.out.println("high: " + highVal);
    } catch (Exception e) {

      e.printStackTrace();

    }

  }
}