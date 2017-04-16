/*
 * Model.java 1.0 Oct 15, 2015
 *
 * Copyright (c) 2015 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.excel;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class Model {

  public void iteration(String[] types, String[] names) {

    // Make an array of Strings:
    // syntax to create array is: Type [] name = new Type [number of variables]
    // In action it would look like this:
    // String [] listOfStrings = new String[5];
    // That gives you an array that can store 5 Strings

    String[] listOfStrings = new String[5];
    listOfStrings[0] = "My first array";

    for (int i = 0; i < names.length; i = i + 1) {

      // System.out.println(names[i]);
    }

    // part 2

    String[] legStrings = new String[names.length];
    int counter = 0;

    for (int i = 0; i < names.length; i++) {

      if (types[i].trim().toLowerCase().equals("legs")) {

        legStrings[counter] = names[i];
        counter++;
      } else {

        System.out.println(types[i] + " " + names[i]);
      }
    }

    for (int i = 0; i < counter; i++) { //

      System.out.println("Leg exercise - " + legStrings[i]);
    }
  }
}
