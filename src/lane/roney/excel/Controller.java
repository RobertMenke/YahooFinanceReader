/*
 * Controlle.java 1.0 Oct 15, 2015
 *
 * Copyright (c) 2015 David J. Powell
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package lane.roney.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Models ...
 *
 * @author rbmenke
 * @version 1.0
 * @since 1.0
 * 
 */
public class Controller {

  public File file;
  public View view;
  public Model model;
  public Read read;

  public Controller() {

    view = new View();
    model = new Model();
    read = new Read();
  }

  public void go() throws FileNotFoundException {
    try {
      file = view.getInput();
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "The file " + file
              + " was not found.");
    }

    ArrayList<Workout> lifts = read.readExcelFile(file);
    String[] types = new String[lifts.size()];
    String[] names = new String[lifts.size()];
    for (int i = 0; i < lifts.size(); i++) {

      types[i] = lifts.get(i).getType();
      names[i] = lifts.get(i).getName();

      // System.out.println(types[i] + " - " + names[i]);
    }

    model.iteration(types, names);
  }

}
