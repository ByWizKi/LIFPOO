package models;

import java.awt.Graphics;

/**
 * Wall
 */
public class Wall extends GameObject {

  public Wall(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
  }

  @Override
  public void draw(Graphics g) {
    g.drawImage(this.img, this.xPosition, this.yPosition, null);
  }

  @Override
  public int getXPosition() {
    return this.xPosition;
  }

  @Override
  public int getYPosition() {
    return this.yPosition;
  }

}