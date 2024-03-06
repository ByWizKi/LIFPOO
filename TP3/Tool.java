package TP3;

public class Tool {

  public static int monRandom(int max, int min) {
    return (int) Math.floor(Math.random() * (max - min + 1) + min);
  }

}
