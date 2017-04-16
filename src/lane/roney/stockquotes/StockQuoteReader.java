/*
 * StockQuoteReader.java 1.0 Oct 28, 2015
 *
 * Copyright (c) 2015 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.stockquotes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class StockQuoteReader {

  private String officialName;
  private File ourFile;
  private String userSortChoice;
  private Scanner in;
  private ArrayList<StockQuote> quotes = new ArrayList<StockQuote>();
  private FileReader fileCounter;
  private Comparator<StockQuote> comp;

  private String date;
  private double open;
  private double high;
  private double low;
  private double close;
  private int volume;
  private double adjustedClose;

  /**
   * 
   * Creates a model call ElonStockQuoteHistory. The values will be passed to
   * the class by the controller to the view.
   *
   * @param anOfficialName
   * @param aFile
   * @param aSortChoice
   */
  public StockQuoteReader(File aFile) {

    this.ourFile = aFile;
  }

  public int numberOfLines() throws FileNotFoundException, IOException {

    FileReader fileCounter = new FileReader(ourFile);
    int maxLines = 0;

    LineNumberReader lineReader = new LineNumberReader(fileCounter);
    while (lineReader.readLine() != null) {
      maxLines++;
    }
    lineReader.close();
    return maxLines;
  }

  /**
   * 
   * Reads data from a file that will be gathered by the view class
   *
   * @return quotes - an ArrayList of StockQuote
   * @throws IOException
   */
  public ArrayList<StockQuote> readData() throws IOException {
    // COUNT NUMBER OF LINES IN THE FILE

    try {

      fileCounter = new FileReader(ourFile);

    } catch (Exception e) {

      JOptionPane.showMessageDialog(null, "This file was not found or is not" + "in the right format");
    }

    LineNumberReader lineReader = new LineNumberReader(fileCounter);

    int maxLines = 0;

    while (lineReader.readLine() != null) {
      maxLines++;
    }

    lineReader.close();
    int lineNumber = 1;

    in = new Scanner(ourFile);
    in.nextLine();

    boolean isValid = true;
    while (in.hasNext() && lineNumber <= maxLines - 2 && isValid == true) {
      Scanner line = new Scanner(in.nextLine());
      line.useDelimiter(",");

      try {
        date = line.next();
        open = line.nextDouble();
        high = line.nextDouble();
        low = line.nextDouble();
        close = line.nextDouble();
        volume = line.nextInt();
        adjustedClose = line.nextDouble();

      } catch (InputMismatchException e) {

        JOptionPane.showMessageDialog(null, "Input Mismatch: The file " + ourFile + " is not in the proper format.");
        isValid = false;
        e.printStackTrace();

      } catch (NoSuchElementException element) {

        JOptionPane.showMessageDialog(null, "NoSuchElement: The file " + ourFile + " is not in the proper format.");
        isValid = false;
        element.printStackTrace();

      } catch (Exception e) {

        JOptionPane.showMessageDialog(null, "Exception: The file " + ourFile + " is not in the proper format.");
        isValid = false;
        e.printStackTrace();

      }

      System.out.println("test reader" + date + " " + " " + open + " " + high + " " + low + " " + close + " " + volume + " "
              + adjustedClose);

      // At this point we have successfully read in a line of financial data.
      // Since there are several types of data involved, we need to use an
      // object
      // To store each row. (Good constructor practice).

      quotes.add(new StockQuote(date, open, high, low, close, volume, adjustedClose));

      isValid = true;

      lineNumber++;
      if (lineNumber == maxLines) {
        line.close();
      }
    }
    return quotes;
  }

}
