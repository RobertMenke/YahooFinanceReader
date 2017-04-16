/*
 * Workout.java 1.0 Oct 15, 2015
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
public class Workout {

  private String type = "";
  private String name = "";

  /**
   * 
   * Creates a workout object with a type and a name
   *
   * @param aType
   * @param aName
   */
  public Workout(String aType, String aName) {
    this.type = aType;
    this.name = aName;
  }

  /**
   * Gets ...
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets ...
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets ...
   *
   * @param aName the name to set
   */
  public void setName(String aName) {
    name = aName;
  }

  /**
   * Sets ...
   *
   * @param aType the type to set
   */
  public void setType(String aType) {
    type = aType;
  }

}
