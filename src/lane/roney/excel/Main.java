/*
 * Main.java 1.0 Oct 15, 2015
 *
 * Copyright (c) 2015 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.excel;

import java.io.FileNotFoundException;

import javax.swing.SwingUtilities;

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
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        Controller c = new Controller();
        try {
          c.go();
        } catch (FileNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
  }
}
