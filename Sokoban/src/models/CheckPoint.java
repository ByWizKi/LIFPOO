package models;

import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * CheckPoint
 */
public class CheckPoint extends GameObject {

  public CheckPoint(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
    this.img = new ImageIcon(this.imgPath).getImage();
  }

  /**
   * Draws the checkpoint image at its current position on the screen.
   *
   * @param  g  The Graphics object used for drawing.
   */
  @Override
  public void draw(Graphics g) {
    // The drawImage method is used to draw the image at the specified
    // (x, y) position on the screen. The null parameter indicates that
    // the image should not be scaled.
    //
    // The arguments used are:
    // g: The Graphics object used for drawing.
    // this.img: The image to be drawn.
    // this.xPosition: The x-coordinate of the position where the image
    //                should be drawn.
    // this.yPosition: The y-coordinate of the position where the image
    //                should be drawn.
    g.drawImage(this.img, this.xPosition, this.yPosition, null);
  }


}