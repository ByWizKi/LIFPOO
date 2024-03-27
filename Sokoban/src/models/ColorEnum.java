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

  public String getHexValue() {
    return hexValue;
  }
}
