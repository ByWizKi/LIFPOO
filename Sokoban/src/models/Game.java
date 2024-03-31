package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Game
 */
public class Game {

  private ArrayList<Wall> wallList = new ArrayList<>();
  private ArrayList<CheckPoint> checkPointList = new ArrayList<>();
  private ArrayList<Void> voidList = new ArrayList<>();
  private ArrayList<Case> caseList = new ArrayList<>();
  private ArrayList<Heros> herosList = new ArrayList<>();

  public ArrayList<Wall> getWallList() {
    return this.wallList;
  }

  public ArrayList<CheckPoint> getCheckPointList() {
    return this.checkPointList;
  }

  public ArrayList<Void> getVoidList() {
    return this.voidList;
  }

  public ArrayList<Case> getCaseList() {
    return this.caseList;
  }

  public ArrayList<Heros> getHerosList() {
    return this.herosList;
  }

  public Game() {
    // loading first level map
  }

  public Game getGame() {
    return this;
  }

  public void loadingMap(String path) {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line;
      int y = 0;
      while ((line = br.readLine()) != null) {
        for (int x = 0; x < line.length(); x++) {
          char c = line.charAt(x);
          switch (c) {
            case 't': // Top Wall
              this.wallList.add(new Wall(x * 100, y * 100, "assets/img/top_wall.png"));
              break;
            case 'b': // Bottom Wall
              this.wallList.add(new Wall(x * 100, y * 100, "assets/img/bottom_wall.png"));
              break;
            case 'l': // Left Wall
              this.wallList.add(new Wall(x * 100, y * 100, "assets/img/left_wall.png"));
              break;
            case 'r': // Right Wall
              this.wallList.add(new Wall(x * 100, y * 100, "assets/img/right_wall.png"));
              break;
            case 'L': // Top Left Wall
              this.wallList.add(new Wall(x * 100, y * 100, "assets/img/top_left_wall.png"));
              break;
            case 'R': // Top Right Wall
              this.wallList.add(new Wall(x * 100, y * 100, "assets/img/top_right_wall.png"));
              break;
            case 'Z': // Bottom Left Wall
              this.wallList.add(new Wall(x * 100, y * 100, "assets/img/bottom_left_wall.png"));
              break;
            case 'U': // Bottom Right Wall
              this.wallList.add(new Wall(x * 100, y * 100, "assets/img/bottom_right_wall.png"));
              break;
            case 'o': // Check Point
              this.checkPointList.add(new CheckPoint(x * 100, y * 100, "assets/img/check_point.png"));
              this.voidList.add(new Void(x * 100, y * 100, "assets/img/void.png"));
              break;
            case 'v': // Void
              this.voidList.add(new Void(x * 100, y * 100, "assets/img/void.png"));
              break;
            case 'c': // Case
              this.voidList.add(new Void(x * 100, y * 100, "assets/img/void.png"));
              this.caseList.add(new Case(x * 100, y * 100, "assets/img/case.png"));
              break;
            case 'h': // Heros
              this.voidList.add(new Void(x * 100, y * 100, "assets/img/void.png"));
              this.herosList.add(new Heros(x * 100, y * 100, "assets/img/mario_left_side.png"));
              break;
          }
          // Debug
          // System.out.println("Caractère lu: " + c + ", Position: x=" + x + ", y=" + y);
        }
        y += 1;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}