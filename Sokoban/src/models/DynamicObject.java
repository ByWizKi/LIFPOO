package models;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class DynamicObject implements GameObject {
  protected int xPosition;
  protected int yPosition;
  protected String imgPath;
  protected Image img;

  public DynamicObject(int x, int y, String imgPath) {
    this.xPosition = x;
    this.yPosition = y;
    this.img = new ImageIcon(imgPath).getImage();
  }

  @Override
  public int getXPosition() {
    return xPosition;
  }

  @Override
  public int getYPosition() {
    return yPosition;
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

  // Méthode abstraite pour mettre à jour la position de l'objet
  public abstract boolean tryMove(String direction, ArrayList<Wall> walls, ArrayList<Case> cases,
      ArrayList<IceBlock> ices);
}
