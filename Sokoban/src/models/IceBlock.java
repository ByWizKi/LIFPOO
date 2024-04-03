package models;

import javax.swing.ImageIcon;

public class IceBlock extends GameObject {

  public IceBlock(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
    this.img = new ImageIcon(this.imgPath).getImage();
  }
}
