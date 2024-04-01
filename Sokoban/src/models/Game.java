package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents the game logic, including the management of game objects and
 * levels.
 */
public class Game {

  // Lists to store different types of game objects.
  private ArrayList<Wall> wallList = new ArrayList<>();
  private ArrayList<CheckPoint> checkPointList = new ArrayList<>();
  private ArrayList<Void> voidList = new ArrayList<>();
  private ArrayList<Case> caseList = new ArrayList<>();
  private ArrayList<Heros> herosList = new ArrayList<>();
  private ArrayList<String> levelList = new ArrayList<>();
  private int currentLevelIndex = 0;
  private boolean allLevelsCompleted = false; // Indique si tous les niveaux ont été complétés

  // Méthode pour vérifier si tous les niveaux ont été complétés
  public boolean areAllLevelsCompleted() {
    return allLevelsCompleted;
  }

  // Méthode pour définir si tous les niveaux ont été complétés
  public void setAllLevelsCompleted(boolean allLevelsCompleted) {
    this.allLevelsCompleted = allLevelsCompleted;
  }

  /**
   * Constructor for the Game class. It initializes the game by loading the list
   * of level paths.
   */
  public Game() {
    try {
      // Automatically load the list of levels from the directory
      Path levelsDir = Paths.get("assets/level/");
      this.levelList = Files.walk(levelsDir, 1)
          .filter(Files::isRegularFile)
          .map(Path::toString)
          .sorted()
          .collect(Collectors.toCollection(ArrayList::new));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Getter for the list of walls in the game.
   *
   * @return The list of walls.
   */
  public ArrayList<Wall> getWallList() {
    // Returns the list of walls in the game.
    return wallList;
  }

  /**
   * Retrieves the list of checkpoints.
   *
   * @return the list of checkpoints
   */
  public ArrayList<CheckPoint> getCheckPointList() {
    return checkPointList;
  }

  /**
   * A description of the entire Java function.
   *
   * @return description of return value
   */
  public ArrayList<Void> getVoidList() {
    return voidList;
  }

  /**
   * Retrieve the list of cases.
   *
   * @return the list of cases
   */
  public ArrayList<Case> getCaseList() {
    return caseList;
  }

  /**
   * Returns the list of Heros objects.
   *
   * @return the list of Heros objects
   */
  public ArrayList<Heros> getHerosList() {
    return herosList;
  }

  /**
   * Retrieves the current level index.
   *
   * @return the current level index
   */
  public int getCurrentLevelIndex() {
    return currentLevelIndex;
  }

  /**
   * 
   *
   * @return description of return value
   */
  public ArrayList<String> getLevelList() {
    return levelList;
  }

  /**
   * Checks if all cases are on checkpoints to determine if the level is
   * completed.
   * 
   * @return true if all cases are on checkpoints, false otherwise.
   */
  public boolean checkLevelCompletion() {
    return caseList.stream().allMatch(c -> checkPointList.stream()
        .anyMatch(p -> c.getXPosition() == p.getXPosition() && c.getYPosition() == p.getYPosition()));
  }

  /**
   * Starts the game by loading the first level or the current level based on the
   * index.
   * 
   */
  public void start() {
    try {
      loadingMap(levelList.get(currentLevelIndex));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Loads the next level if available. If the current level is the last one,
   * displays a message indicating that all levels have been completed.
   * If implemented, it can also handle the logic for the end of the game,
   * such as returning to the main menu or displaying a victory screen, etc.
   * This function should also refresh the UI if necessary.
   * 
   * @throws IOException
   */
  public void loadNextLevel() {
    try {
      // Check if the current level is the last one
      if (currentLevelIndex < levelList.size() - 1) {
        // Load the next level
        currentLevelIndex++;
        cleanMap();
        loadingMap(levelList.get(currentLevelIndex));
      } else {
        // Display message indicating that all levels have been completed
        System.out.println("Congratulations! You have completed all levels.");
        // Implement logic for handling the end of the game
        // For example, return to the main menu, display a victory screen, etc.
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    // Refresh the UI if necessary
    // Implementation of this method depends on the UI framework used
  }

  /**
   * Clears all game object lists to prepare for loading a new level.
   *
   * This function is responsible for resetting the state of the game by clearing
   * all the lists containing game objects.
   */
  private void cleanMap() {
    // Clear the list of walls
    wallList.clear();

    // Clear the list of checkpoints
    checkPointList.clear();

    // Clear the list of voids (regions of the map where a hero cannot pass)
    voidList.clear();

    // Clear the list of cases (goal points in the level)
    caseList.clear();

    // Clear the list of heroes
    herosList.clear();
  }

  /**
   * Reloads the current level, resetting all game objects to their initial state.
   *
   * This function cleans the current state of the game by resetting all the lists
   * containing game objects. Then, it loads the current level again from the
   * list.
   * 
   *
   */
  public void reloadCurrentLevel() {
    try {
      // Cleans the current state of the game by resetting all the lists containing
      // game objects.
      cleanMap();

      // Loads the current level again from the list.
      loadingMap(levelList.get(currentLevelIndex));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Loads the map from a file, creating game objects based on the file content.
   *
   * @param path Path to the map file.
   *
   * 
   */
  public void loadingMap(String path) throws IOException {
    // Read the map file line by line
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      // Initialize y coordinate to 0
      int y = 0;
      // Read each line of the map
      String line;
      while ((line = br.readLine()) != null) {
        // For each character in the line
        for (int x = 0; x < line.length(); x++) {
          // Get the character at the current position
          char c = line.charAt(x);
          // Create the appropriate game object based on the character
          switch (c) {
            // Wall types
            case 't':
            case 'l':
            case 'r':
            case 'b':
            case 'L':
            case 'R':
            case 'Z':
            case 'U':
              wallList.add(new Wall(x * 100, y * 100, getWallImgPath(c)));
              break;
            // Void types
            case 'v':
            case 'h':
              voidList.add(new Void(x * 100, y * 100, "assets/img/void.png"));
              if (c == 'h') {
                herosList.add(new Heros(x * 100, y * 100, "assets/img/mario_right_side.png"));
              }
              break;
            // Case and Check Point types
            case 'c':
            case 'o':
              voidList.add(new Void(x * 100, y * 100, "assets/img/void.png"));
              switch (c) {
                case 'c':
                  caseList.add(new Case(x * 100, y * 100, "assets/img/case.png"));
                  break;
                case 'o':
                  checkPointList.add(new CheckPoint(x * 100, y * 100, "assets/img/check_point.png"));
                  break;
              }
              break;
          }
        }
        // Increment y coordinate for the next line
        y += 1;
      }
    }
  }

  /**
   * Get the image path for a wall based on its character.
   *
   * @param c The character representing the wall type.
   * @return The image path for the wall.
   */
  private String getWallImgPath(char c) {
    switch (c) {
      case 't':
        return "assets/img/top_wall.png";
      case 'l':
        return "assets/img/left_wall.png";
      case 'r':
        return "assets/img/right_wall.png";
      case 'b':
        return "assets/img/bottom_wall.png";
      case 'L':
        return "assets/img/top_left_wall.png";
      case 'R':
        return "assets/img/top_right_wall.png";
      case 'Z':
        return "assets/img/bottom_left_wall.png";
      case 'U':
        return "assets/img/bottom_right_wall.png";
      default:
        throw new IllegalArgumentException("Invalid wall character: " + c);
    }
  }
}
