package models;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Heros extends DynamicObject {
  private HashMap<String, Image> heroImages = new HashMap<>();

  public Heros(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
    preloadImages();
  }

  /**
   * Preloads images for the hero.
   * 
   * This method loads the default image, and also images for the left and right
   * directions. Add more directions or states as needed.
   */
  private void preloadImages() {
    // Load left image
    heroImages.put("left", new ImageIcon("assets/img/mario_left_side.png").getImage());

    // Load right image
    heroImages.put("right", new ImageIcon("assets/img/mario_right_side.png").getImage());
  }

  /**
   * Attempts to move the hero by the specified deltas.
   * 
   * @param deltaX the horizontal displacement
   * @param deltaY the vertical displacement
   * @param walls  the list of walls to check collision with
   * @param cases  the list of cases to check collision with
   * @return true if the movement is successful, false otherwise
   */
  @Override
  public boolean tryMove(String direction, ArrayList<Wall> walls, ArrayList<Case> cases, ArrayList<IceBlock> ices) {

    // Calculate the deltas based on the direction
    int deltaX = 0;
    int deltaY = 0;
    switch (direction) {
      case "UP":
        deltaY = -100;
        break;
      case "DOWN":
        deltaY = 100;
        break;
      case "LEFT":
        deltaX = -100;
        break;
      case "RIGHT":
        deltaX = 100;
        break;

      default:
        break;
    }

    // Calculate the new position
    int newX = this.xPosition + deltaX;
    int newY = this.yPosition + deltaY;

    // Check for collisions with walls
    for (Wall wall : walls) {
      // If any collision is detected, movement is blocked
      if (checkCollision(newX, newY, wall)) {
        return false;
      }
    }

    // Check for collisions and attempt to move cases
    for (Case caseObject : cases) {
      // If any collision is detected, attempt to move the case
      if (checkCollision(newX, newY, caseObject)) {
        if (!caseObject.tryMove(direction, walls, cases, ices)) {
          return false; // Movement blocked due to collision
        }
        break; // Handle only one case at a time
      }
    }

    // Update the image based on the direction of movement
    if (deltaX < 0) {
      this.img = heroImages.get("left");
    } else if (deltaX > 0) {
      this.img = heroImages.get("right");
    }

    // No collision, update the position
    this.xPosition = newX;
    this.yPosition = newY;

    // Movement successful
    return true;
  }

  /**
   * Checks if there is a collision between the new position of the hero and a
   * game object.
   *
   * @param newX   the x coordinate of the proposed new position
   * @param newY   the y coordinate of the proposed new position
   * @param object the game object to check collision with
   * @return true if there is a collision, false otherwise
   */
  private boolean checkCollision(int newX, int newY, GameObject object) {
    // Check if the new position of the hero is to the right of the game object
    // and if the left edge of the hero is to the left of the right edge of the game
    // object
    // Also check if the new position of the hero is below the game object
    // and if the top edge of the hero is above the bottom edge of the game object
    return (newX < object.getXPosition() + object.getWidth()) &&
        (newX + this.getWidth() > object.getXPosition()) &&
        (newY < object.getYPosition() + object.getHeight()) &&
        (newY + this.getHeight() > object.getYPosition());
  }

}
