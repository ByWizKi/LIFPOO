package models;

import java.awt.Graphics;
import java.util.ArrayList;

public class Case extends GameObject {

    public Case(int xPosition, int yPosition, String imgPath) {
        super(xPosition, yPosition, imgPath);
        // Utilize the superclass constructor to initialize fields
    }

    @Override
    public void draw(Graphics g) {
        // Draw the image at its current position
        g.drawImage(this.img, this.xPosition, this.yPosition, null);
    }

    public boolean tryMove(int deltaX, int deltaY, ArrayList<Wall> walls, ArrayList<Case> cases) {
        int newX = this.xPosition + deltaX;
        int newY = this.yPosition + deltaY;

        // Check for collisions with walls and other cases
        if (isCollision(newX, newY, walls) || isCollisionWithCases(newX, newY, cases)) {
            return false; // Movement blocked due to collision
        }

        // Update position if no collision
        this.xPosition = newX;
        this.yPosition = newY;
        return true;
    }

    // Checks for collision with any wall
    private boolean isCollision(int newX, int newY, ArrayList<Wall> walls) {
        return walls.stream().anyMatch(wall -> checkCollision(newX, newY, wall));
    }

    // Checks for collision with other cases, excluding itself
    private boolean isCollisionWithCases(int newX, int newY, ArrayList<Case> cases) {
        return cases.stream().anyMatch(otherCase -> this != otherCase && checkCollision(newX, newY, otherCase));
    }

    // Determines if the proposed new position collides with another game object
    private boolean checkCollision(int newX, int newY, GameObject object) {
        return newX < object.getXPosition() + object.getWidth() && newX + getWidth() > object.getXPosition() &&
                newY < object.getYPosition() + object.getHeight() && newY + getHeight() > object.getYPosition();
    }
}
