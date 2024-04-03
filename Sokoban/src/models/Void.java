package models;

import javax.swing.ImageIcon;

public class Void extends GameObject {

  public Void(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
    this.img = new ImageIcon(this.imgPath).getImage();
  }

}