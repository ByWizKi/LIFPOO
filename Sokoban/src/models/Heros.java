package models;

import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * Heros
 */
public class Heros extends GameObject {

  public Heros(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
    this.img = new ImageIcon(this.imgPath).getImage();
  }

  @Override
  public void draw(Graphics g) {
    g.drawImage(this.img, this.xPosition, this.yPosition, null);
  }

  public boolean tryMove(int deltaX, int deltaY, List<Wall> walls) {
    int newX = this.xPosition + deltaX;
    int newY = this.yPosition + deltaY;

    // Try if wall collide
    for (Wall wall : walls) {
      if (newX < wall.getXPosition() + 100 && newX + 100 > wall.getXPosition() &&
          newY < wall.getYPosition() + 100 && newY + 100 > wall.getYPosition()) {
        return false;
      }
    }

    // If we press left or right
    if (deltaX < 0) {
      this.img = new ImageIcon("assets/img/mario_left_side.png").getImage();
    }
    if (deltaX > 0) {
      this.img = new ImageIcon("assets/img/mario_right_side.png").getImage();
    }

    // Update position
    this.xPosition = newX;
    this.yPosition = newY;
    return true;
  }
}
