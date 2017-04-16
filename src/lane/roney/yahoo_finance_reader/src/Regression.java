/*
 * Regression.java 1.0 Oct 27, 2015
 *
 * Copyright (c) 2015 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.yahoo_finance_reader.src;

import java.util.ArrayList;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class Regression {

  private ArrayList<Double> xCoordinates;
  private ArrayList<Double> yCoordinates;

  public String someProperty = "I'm a property";

  StandardDeviation mean = new StandardDeviation();

  public Regression(ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates) {

    this.xCoordinates = xCoordinates;
    this.yCoordinates = yCoordinates;

  }

  public double denominator() {

    double den = 0;

    for (int i = 0; i < xCoordinates.size(); i++) {

      den += Math.pow(xCoordinates.get(i) - mean.average(xCoordinates), 2);
    }

    return den;
  }

  public double numerator() {

    double num = 0;

    for (int i = 0; i < xCoordinates.size() && i < yCoordinates.size(); i++) {

      num += (xCoordinates.get(i) - mean.average(xCoordinates)) * (yCoordinates.get(i) - mean.average(yCoordinates));
    }

    return num;

  }

  /**
   * 
   * This predicts the y value of a data set
   *
   * @param xCoordinates
   * @param yCoordinates
   * @param xCoordinate
   * @return
   */
  public double predictY(Double xCoordinate) {

    return slope() * xCoordinate + yIntercept();
  }

  public double slope() {

    return numerator() / denominator();
  }

  /**
   * 
   * Verb ...
   *
   * @param xCoordinates
   * @param yCoordinates
   * @return
   */
  public double yIntercept() {

    return mean.average(yCoordinates) - slope() * mean.average(xCoordinates);
  }
}
