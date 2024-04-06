package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Observable;
import java.util.stream.Collectors;

/**
 * Represents the game logic, including the management of game objects and
 * levels.
 */
@SuppressWarnings("deprecation")
public class Game extends Observable {

  // Lists to store different types of game objects.
  private ArrayList<Wall> wallList = new ArrayList<>();
  private ArrayList<CheckPoint> checkPointList = new ArrayList<>();
  private ArrayList<Void> voidList = new ArrayList<>();
  private ArrayList<Case> caseList = new ArrayList<>();
  private ArrayList<IceBlock> iceBlockList = new ArrayList<>();
  private ArrayList<Heros> herosList = new ArrayList<>();
  private ArrayList<String> levelList = new ArrayList<>();
  private int currentLevelIndex = 0;
  private boolean allLevelsCompleted = false;

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
   * Returns the list of walls in the game.
   *
   * @return The list of walls.
   */
  public ArrayList<Wall> getWallList() {
    // This getter method returns the list of walls in the game.
    // It provides access to the private field 'wallList'.

    // The 'wallList' field stores all the walls in the game.
    // Each wall is an instance of the Wall class, which represents a wall in
    // the game.

    // The walls are used to create the layout of the game map. They define
    // the boundaries of the map and the obstacles that the heroes of the
    // game need to navigate around.

    // This method is part of the Game class, which represents the game logic.
    // It is used to retrieve the list of walls from the game.

    return wallList;
  }

  /**
   * Retrieves the list of Void objects.
   *
   * @return The list of Void objects. This list is used to represent the
   *         Voids (empty spaces) in the game map.
   */
  public ArrayList<Void> getVoidList() {
    // The 'voidList' field stores all the Void objects in the game.
    // Each Void is an instance of the Void class, which represents an
    // empty space in the game map.

    // Voids are used to represent the empty spaces in the game map. They
    // are typically represented as transparent squares in the game.

    // This method is part of the Game class, which represents the game
    // logic. It is used to retrieve the list of Voids from the game.

    return voidList;
  }

  /**
   * Returns the list of checkpoints in the game.
   *
   * @return The list of checkpoints.
   */
  public ArrayList<CheckPoint> getCheckPointList() {
    // This getter method returns the list of checkpoints in the game.
    // It provides access to the private field 'checkPointList'.

    // The 'checkPointList' field stores all the checkpoints in the game.
    // Each checkpoint is an instance of the CheckPoint class, which
    // represents a location in the game where the heroes can collect points
    // or items.

    // Checkpoints are used to define the locations in the game where the
    // heroes can stop and collect points or items. They are typically
    // represented as green squares in the game.

    // This method is part of the Game class, which represents the game
    // logic. It is used to retrieve the list of checkpoints from the game.

    return checkPointList;
  }

  /**
   * Retrieve the list of cases.
   *
   * This method returns the list of cases in the game. It provides access to the
   * private field 'caseList'.
   *
   * @return the list of cases
   */
  public ArrayList<Case> getCaseList() {
    /*
     * The 'caseList' field stores all the cases in the game.
     * Each case is an instance of the Case class, which represents a location
     * in the game where the heroes can collect points or items.
     *
     * Cases are used to define the locations in the game where the heroes
     * can stop and collect points or items. They are typically represented as
     * green squares in the game.
     *
     * This method is part of the Game class, which represents the game logic.
     * It is used to retrieve the list of cases from the game.
     */
    return caseList;
  }

  public ArrayList<IceBlock> getIceBlockList() {
    return this.iceBlockList;
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
   * 
   *
   * @return description of return value
   */
  public ArrayList<String> getLevelList() {
    return levelList;
  }

  /**
   * Indicates whether all levels have been completed.
   *
   * @return true if all levels have been completed, false otherwise
   */
  public boolean areAllLevelsCompleted() {
    /*
     * This method returns a boolean value indicating whether all levels have
     * been completed. It returns the value of the 'allLevelsCompleted' field.
     */
    return allLevelsCompleted;
  }

  /**
   * Sets the value of the 'allLevelsCompleted' field, indicating whether all
   * levels have been completed.
   *
   * @param allLevelsCompleted the new value of the 'allLevelsCompleted' field.
   */
  public void setAllLevelsCompleted(boolean allLevelsCompleted) {
    // Sets the value of the 'allLevelsCompleted' field, indicating whether all
    // levels have been completed.
    this.allLevelsCompleted = allLevelsCompleted;
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

    // Clear the list of ice blocks
    iceBlockList.clear();
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
   * @throws IOException If there is an error reading the file.
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
            // Ice types
            case 'i':
              iceBlockList.add(new IceBlock(x * 100, y * 100, "assets/img/ice_block.png"));
              break;
            // Wall types
            case 't':
            case 'l':
            case 'r':
            case 'b':
            case 'L':
            case 'R':
            case 'Z':
            case 'U':
              // Create a new wall object and add it to the wall list
              wallList.add(new Wall(x * 100, y * 100, getWallImgPath(c)));
              break;
            // Void types
            case 'v':
            case 'h':
              // Create a new void object and add it to the void list
              voidList.add(new Void(x * 100, y * 100, "assets/img/void.png"));
              // If the character is 'h', create a new hero object and add it to the hero list
              if (c == 'h') {
                herosList.add(new Heros(x * 100, y * 100, "assets/img/mario_left_side.png"));
              }
              break;
            // Case and Check Point types
            case 'c':
            case 'o':
              // Create a new void object and add it to the void list
              voidList.add(new Void(x * 100, y * 100, "assets/img/void.png"));
              // Depending on the character, create a new case or check point object and add
              // it to the respective list
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
