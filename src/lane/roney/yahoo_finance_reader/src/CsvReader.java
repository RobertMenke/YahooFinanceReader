/*
 * CsvReader.java 1.0 Jan 13, 2016
 *
 * Copyright (c) 2016 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.yahoo_finance_reader.src;

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
public class CsvReader {

  private File ourFile;
  private ArrayList<StockQuote> quotes = new ArrayList<StockQuote>();
  private Scanner rows;
  private String date;
  private double open;
  private double high;
  private double low;
  private double close;
  private int volume;
  private double adjustedClose;

  public CsvReader(File aFile) {

    this.ourFile = aFile;

  }

  public int numberOfLines() throws FileNotFoundException, IOException {

    int maxLines = 0;
    FileReader reader = new FileReader(ourFile);
    LineNumberReader lineReader = new LineNumberReader(reader);

    while (lineReader.readLine() != null) {
      maxLines++;
    }

    lineReader.close();
    return maxLines;
  }

  /**
   * 
   * Verb ...
   *
   * @return
   * @throws IOException
   */
  public ArrayList<StockQuote> readData() throws IOException {

    int numLines = 0;
    try {

      numLines = numberOfLines();

    } catch (Exception e) {

      e.printStackTrace();
      System.out.println("This file was not found or is not in the right format");
    }

    int lineNumber = 1;

    rows = new Scanner(ourFile);
    rows.nextLine();

    while (rows.hasNext() && lineNumber < numLines - 1) {

      Scanner columns = new Scanner(rows.nextLine());
      columns.useDelimiter(",");

      try {

        date = columns.next();

      } catch (Exception e) {

        date = "";
      }

      try {

        open = columns.nextDouble();

      } catch (Exception e) {

        open = 0;

      }

      try {

        high = columns.nextDouble();

      } catch (Exception e) {

        high = 0;
      }

      try {

        low = columns.nextDouble();

      } catch (Exception e) {

        low = 0;

      }

      try {

        close = columns.nextDouble();

      } catch (Exception e) {

        close = 0;

      }

      try {

        volume = columns.nextInt();

      } catch (Exception e) {

        volume = 0;

      }

      try {

        adjustedClose = columns.nextDouble();

      } catch (Exception e) {

        adjustedClose = 0;

      }

      // At this point we have successfully read in a line of financial data.
      // Since there are several types of data involved, we need to use an
      // object
      // To store each row. (Good constructor practice).

      quotes.add(new StockQuote(date, open, high, low, close, volume, adjustedClose));
      System.out.println(date + " " + open + " " + high + " " + low + " " + close + " " + volume + " " + adjustedClose);
      lineNumber++;

      if (lineNumber == numLines) {
        columns.close();
      }
    }

    return quotes;

  }
}
