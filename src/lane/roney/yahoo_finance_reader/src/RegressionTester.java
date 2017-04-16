/*
 * RegressionTester.java 1.0 Jan 17, 2016
 *
 * Copyright (c) 2016 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.yahoo_finance_reader.src;

import java.util.ArrayList;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @param <T>
 * @since 1.0
 * 
 */
public class RegressionTester extends Analyzeable {

  private String xstr;
  private String ystr;
  private Double futureX;
  private ArrayList<StockQuote> quotes;
  private ArrayList<?> xvals;
  private ArrayList<?> yvals;

  public RegressionTester(ArrayList<StockQuote> someQuotes, String xCategory, String yCategory, Double futureX) {

    super(someQuotes);
    this.xstr = xCategory;
    this.ystr = yCategory;
    this.quotes = someQuotes;
    this.futureX = futureX;
  }

  /*
   * (non-Javadoc)
   * 
   * @see lane.roney.project.Analyzeable#analysisPerformed()
   */
  @Override
  public Double performAnalysis() {
    // TODO Auto-generated method stub
    // ArrayList<Double> xcat = this.createList(xstr);
    // ArrayList<Double> ycat = this.createList(ystr);
    //
    ArrayList<Double> xcat = new ArrayList<Double>();
    ArrayList<Double> ycat = new ArrayList<Double>();
    try {

      xcat = this.getListByCategory(xstr);
      ycat = this.getListByCategory(ystr);
    } catch (Exception e) {
      e.printStackTrace();
    }

    Regression reg = new Regression(xcat, ycat);
    return reg.predictY(futureX);
  }

}
