package models;

import javax.swing.ImageIcon;

/**
 * CheckPoint
 */
public class CheckPoint extends GameObject {

  public CheckPoint(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
    this.img = new ImageIcon(this.imgPath).getImage();
  }

}