package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class StaticObject implements GameObject {
  protected int xPosition;
  protected int yPosition;
  protected String imgPath;
  protected Image img;

  public StaticObject(int x, int y, String imgPath) {
    this.xPosition = x;
    this.yPosition = y;
    this.img = new ImageIcon(imgPath).getImage();
  }

  @Override
  public int getXPosition() {
    return this.xPosition;
  }

  @Override
  public int getYPosition() {
    return this.yPosition;
  }

  @Override
  public int getWidth() {
    return this.img.getWidth(null);
  }

  @Override
  public int getHeight() {
    return this.img.getHeight(null);
  }

  @Override
  public Image getImage() {
    return this.img;
  }

}
