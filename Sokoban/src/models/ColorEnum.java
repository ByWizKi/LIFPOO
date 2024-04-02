package models;

public enum ColorEnum {

  PRIMARY("#4DBCE0"),
  SECONDARY("#FAFF12"),
  BLACK("#000000"),
  WHITE("#FFFFFF");

  private final String hexValue;

  ColorEnum(String hexValue) {
    this.hexValue = hexValue;
  }

  /**
   * Get the hexadecimal value of the color.
   *
   * @return The hexadecimal value of the color.
   */
  public String getHexValue() {
    // Returns the hexadecimal value of the color.
    //
    // This method returns the hexadecimal value of the color,
    // which is stored in the private field `hexValue`.
    return hexValue;
  }

}
