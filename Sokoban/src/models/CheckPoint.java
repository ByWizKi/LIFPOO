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

  @Override
  public void draw(Graphics g) {
    g.drawImage(this.img, this.xPosition, this.yPosition, null);
  }

}