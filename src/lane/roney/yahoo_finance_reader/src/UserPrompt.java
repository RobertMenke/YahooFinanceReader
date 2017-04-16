/*
 * UserPrompt.java 1.0 Jan 13, 2016
 *
 * Copyright (c) 2016 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.yahoo_finance_reader.src;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class UserPrompt {

  /**
   * 
   * Use a JFileChooser object to allow users to select a file
   *
   * @return
   */

  public File requestFile() {

    JFileChooser filePicker = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("looking for csvs", "csv");
    filePicker.setFileFilter(filter);

    int returnVal = filePicker.showOpenDialog(null);
    if (returnVal == JFileChooser.APPROVE_OPTION) {

      return filePicker.getSelectedFile();
    } else {

      System.exit(0);
      return null;
    }
  }
}
