/*
 * View.java 1.0 Oct 15, 2015
 *
 * Copyright (c) 2015 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.excel;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class View {

  /**
   * 
   * Asks the user to select a file for analysis using the JFileChooser GUI
   *
   * @return selectedFile - the file selected by the user
   * @throws FileNotFoundException
   */
  public File getInput() throws FileNotFoundException {
    JFileChooser choose = new JFileChooser();
    choose.setDialogTitle("Gimme dem workouts hoe");
    if (choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      File selectedFile = choose.getSelectedFile();
      return selectedFile;
    }
    return null;

  }

}
