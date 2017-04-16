/*
 * Read.java 1.0 Oct 15, 2015
 *
 * Copyright (c) 2015 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class Read {

  String name = "";
  String type = "";
  ArrayList<Workout> workouts = new ArrayList<Workout>();

  public int getMaxLines(File ourFile) throws FileNotFoundException {

    FileReader fileCounter = new FileReader(ourFile);
    LineNumberReader lineReader = new LineNumberReader(fileCounter);
    int maxLines = 0;

    try {
      while (lineReader.readLine() != null) {
        maxLines++;
      }
    } catch (IOException e2) {
      // TODO Auto-generated catch block
      e2.printStackTrace();
    }
    try {
      lineReader.close();
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    return maxLines;
  }

  public ArrayList<Workout> readExcelFile(File ourFile)
          throws FileNotFoundException {
    // GET A VALID FILE

    /*
     * ======================================================================
     * Dynamically count number of lines in the file
     * ======================================================================
     */
    int maxLines = this.getMaxLines(ourFile);
    int lineNumber = 1;

    Scanner in = new Scanner(ourFile);
    in.nextLine(); // Skip ahead 1 line

    boolean isValid = true;
    while (in.hasNext() && lineNumber <= maxLines - 2 && isValid == true) {

      Scanner line = new Scanner(in.nextLine());
      line.useDelimiter(",");

      try {
        type = line.next();
        name = line.next();

      } catch (Exception e) {
        e.printStackTrace();
      }

      Workout w = new Workout(type, name);

      workouts.add(w);

      isValid = true;

      lineNumber++;
      if (lineNumber == maxLines) {
        line.close();
      }
    }
    return workouts;

  }
}
