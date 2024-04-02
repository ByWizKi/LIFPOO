package models;

import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * Void
 */
public class Void extends GameObject {

  public Void(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
    this.img = new ImageIcon(this.imgPath).getImage();
  }

  /**
   * Draws the Void object on the provided Graphics object.
   *
   * @param  g  the Graphics object to draw on
   */
  @Override
  public void draw(Graphics g) {
    // Draws the Void object on the provided Graphics object.
    // The img image is drawn at the xPosition, yPosition coordinates.
    // The null parameter specifies that the Image is not observer and therefore
    // does not need to be scaled to fit within the specified dimensions.
    g.drawImage(this.img, this.xPosition, this.yPosition, null);
  }
}