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
   * @param  g  The Graphics object used for drawing.
   */
  @Override
  public void draw(Graphics g) {
    // Draw the image of the Wall object at the specified position
    // using the provided Graphics object. The null argument is used
    // to specify that the Image is not observer and therefore does not
    // need to be scaled to fit within the specified dimensions.
    g.drawImage(this.img, this.xPosition, this.yPosition, null);
  }


  /**
   * Get the x position of the Wall object.
   *
   * @return the x position of the Wall object
   */
  @Override
  public int getXPosition() {
    /*
     * Returns the x position of the Wall object.
     *
     * @return the x position of the Wall object
     */
    return this.xPosition;
  }


  /**
   * Get the y position of the Wall object.
   *
   * @return the y position of the Wall object
   */
  @Override
  public int getYPosition() {
    /*
     * Returns the y position of the Wall object.
     *
     * @return the y position of the Wall object
     */
    return this.yPosition; 
  }

}