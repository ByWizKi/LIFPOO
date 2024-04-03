package models;

import java.awt.Graphics;

/**
 * Wall
 */
public class Wall extends GameObject {

  public Wall(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
  }

  /**
   * Draws the Wall object on the screen using the provided Graphics object.
   *
   * @param g The Graphics object used for drawing.
   */
  @Override
  public void draw(Graphics g) {
    // Draw the image of the Wall object at the specified position
    // using the provided Graphics object. The null argument is used
    // to specify that the Image is not observer and therefore does not
    // need to be scaled to fit within the specified dimensions.
    g.drawImage(this.img, this.xPosition, this.yPosition, null);
  }
}