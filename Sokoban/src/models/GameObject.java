package models;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * GameObject
 */
abstract class GameObject {
    protected int xPosition, yPosition;
    protected String imgPath;
    protected Image img;

    public GameObject(int xPosition, int yPosition, String imgPath) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.imgPath = imgPath;
        this.img = new ImageIcon(this.imgPath).getImage();
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getWidth() {
        return this.img.getWidth(null);
    }

    public int getHeight() {
        return this.img.getHeight(null);
    }

    public abstract void draw(Graphics g);
}
