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


    /**
     * Getter for the xPosition field.
     *
     * @return the xPosition of the object
     */
    public int getXPosition() {
        // Returns the xPosition of the object
        return this.xPosition;
    }


    /**
     * Setter for the xPosition field.
     *
     * @param  xPosition  the new xPosition of the object
     */
    public void setXPosition(int xPosition) {
        // Sets the xPosition of the object
        this.xPosition = xPosition;
    }


    /**
     * Getter for the yPosition field.
     *
     * @return the yPosition of the object
     */
    public int getYPosition() {
        // Returns the yPosition of the object
        return this.yPosition;
    }


    /**
     * Setter for the yPosition field.
     *
     * @param  yPosition  the new yPosition of the object
     */
    public void setYPosition(int yPosition) {
        /*
         * Sets the yPosition of the object.
         *
         * @param  yPosition  the new yPosition of the object
         */
        this.yPosition = yPosition;
    }


    /**
     * Returns the width of the image of the object.
     *
     * @return the width of the image of the object
     */
    public int getWidth() {
        // Retrieves the width of the image of the object
        // using the getWidth() method of the img Image object.
        // The null argument is used to specify that the Image
        // is not observer and therefore does not need to be
        // scaled to fit within the specified dimensions.
        // The method returns an integer representing the width
        // of the image in pixels.
        return this.img.getWidth(null);
    }


    /**
     * Returns the height of the image of the object.
     *
     * @return the height of the image of the object
     */
    public int getHeight() {
        /*
         * Retrieves the height of the image of the object
         * using the getHeight() method of the img Image object.
         * The null argument is used to specify that the Image
         * is not observer and therefore does not need to be
         * scaled to fit within the specified dimensions.
         * The method returns an integer representing the height
         * of the image in pixels.
         */
        return this.img.getHeight(null);
    }

    public abstract void draw(Graphics g);
}
