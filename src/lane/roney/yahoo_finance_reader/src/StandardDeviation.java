/*
 * StandardDeviation.java 1.0 Oct 17, 2015
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
public class StandardDeviation {

  public double average(ArrayList<Double> someNumbers) {

    double sum = 0;

    for (int i = 0; i < someNumbers.size(); i++) {

      sum += someNumbers.get(i);
    }

    // System.out.println("average " + sum / someNumbers.length);

    return sum / (someNumbers.size());
  }

  /**
   * 
   * The purpose of this exercise is to demonstrate how we can construct several
   * small functions that do small jobs to complete more complicated tasks.
   * 
   * Here's the low down on functions in Java:
   * 
   * A function is a block of code (think curly braces) that will execute line
   * by line when it is called. Functions have zero or more inputs and and can
   * produce an output (return a value). First we write functions - this step is
   * like creating a recipe before you have any of the ingredients, and then
   * when we want to use them we supply the function with any inputs it needs,
   * and if the function returns a value we store its output in a variable.
   * Calling a function just looks like this:
   * 
   * int numberOfItems = count(anArrayOfNumbers);
   * 
   * The name of this function is count. Count has 1 input, anArrayOfNumbers
   * which, as you may have guessed, is an array of numbers. Count outputs the
   * number of values that it counted, so we have to store its output in a
   * variable. This is what the recipe for a count function would look like in
   * Java:
   */

  public int count(ArrayList<Integer> someNumbers) {

    int numberOfValues = 0; // Set up a variable to store the output

    for (int i = 0; i < someNumbers.size(); i++) {

      numberOfValues = numberOfValues + 1;
    }

    return numberOfValues; // Return a value of type int
  }

  public double stdev(ArrayList<Double> anyDoubleArray) {

    return Math.sqrt(variance(anyDoubleArray));
  }

  /*
   * Notice that at this point we're essentially making a contract for the
   * future - we're specifying that in order for count to run, we will provide
   * the function with an array of integers like we did when we called it above
   * and specifying that we want back is a single integer.
   * 
   * --------------------------------------------------------------------------
   * 
   * The formula for standard deviation is here:
   * https://www.mathsisfun.com/data/standard-deviation-formulas.html
   * 
   * We're going to make several small functions that make this problem very
   * easy to solve.
   */

  public double variance(ArrayList<Double> otherNumbers) {

    double avg = average(otherNumbers);
    double var = 0;

    for (int i = 0; i < otherNumbers.size(); i++) {

      var += Math.pow(otherNumbers.get(i) - avg, 2);

    }

    // System.out.println("variance" + var / otherNumbers.length);

    return var / otherNumbers.size();
  }

}
