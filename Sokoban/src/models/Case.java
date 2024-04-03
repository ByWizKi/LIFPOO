package models;

import java.util.ArrayList;

public class Case extends GameObject {

    public Case(int xPosition, int yPosition, String imgPath) {
        super(xPosition, yPosition, imgPath);
        // Utilize the superclass constructor to initialize fields
    }

    /**
     * Attempts to move the Case object by the specified deltas.
     *
     * @param deltaX the horizontal displacement
     * @param deltaY the vertical displacement
     * @param walls  the list of walls to check collision with
     * @param cases  the list of other Cases to check collision with
     * @return true if the movement is successful, false otherwise
     */
    public boolean tryMove(int deltaX, int deltaY, ArrayList<Wall> walls, ArrayList<Case> cases,
            ArrayList<IceBlock> iceBlockList) {
        // Calculate the new position
        int newX = this.xPosition + deltaX;
        int newY = this.yPosition + deltaY;

        // Check for collisions with walls and other Cases
        // If any collision is detected, movement is blocked
        if (isCollision(newX, newY, walls) || isCollisionWithCases(newX, newY, cases)) {
            return false; // Movement blocked due to collision
        }

        // Check for collisions with ice blocks
        if (isCollisionWithIce(newX, newY, iceBlockList)) {
            if(deltaX > 0) {
                newX += 100;
            } else if(deltaX < 0) {
                newX -= 100;
            }

            if(deltaY > 0) {
                newY += 100;
            }
            else if(deltaY < 0) {
                newY -= 100;
            }
            this.xPosition = newX;
            this.yPosition = newY;
            return true;
        }

        // If no collision is detected, update the position
        this.xPosition = newX;
        this.yPosition = newY;

        // Movement successful
        return true;
    }

    /**
     * Checks for collision with any wall.
     *
     * @param newX  the x coordinate of the proposed new position
     * @param newY  the y coordinate of the proposed new position
     * @param walls the list of walls to check collision with
     * @return true if there is a collision, false otherwise
     */
    private boolean isCollision(int newX, int newY, ArrayList<Wall> walls) {
        // Iterate over each wall and check for collision
        // If any wall is collided, return true
        return walls.stream()
                .anyMatch(wall -> checkCollision(newX, newY, wall));
    }

    /**
     * Checks for collision with other cases, excluding itself
     *
     * @param newX  the x coordinate of the proposed new position
     * @param newY  the y coordinate of the proposed new position
     * @param cases the list of cases to check collision with
     * @return true if there is a collision, false otherwise
     */
    private boolean isCollisionWithCases(int newX, int newY, ArrayList<Case> cases) {
        // Checks if there is a collision with any other case, excluding itself
        return cases.stream()
                // Filter out itself
                .filter(otherCase -> this != otherCase)
                // Check for collision with other cases
                .anyMatch(otherCase -> checkCollision(newX, newY, otherCase));
    }

    private boolean isCollisionWithIce(int newX, int newY, ArrayList<IceBlock> iceBlockList) {
        return iceBlockList.stream()
                .anyMatch(iceBlock -> checkCollision(newX, newY, iceBlock));
    }

    /**
     * Determines if the proposed new position collides with another game object.
     *
     * @param newX   the x coordinate of the proposed new position
     * @param newY   the y coordinate of the proposed new position
     * @param object the game object to check collision with
     * @return true if there is a collision, false otherwise
     */
    private boolean checkCollision(int newX, int newY, GameObject object) {
        /*
         * Check if the proposed new position's x coordinate is less than the object's x
         * coordinate plus its width
         * and if the proposed new position's x coordinate plus this object's width is
         * greater than the object's x coordinate.
         * Also check if the proposed new position's y coordinate is less than the
         * object's y coordinate plus its height
         * and if the proposed new position's y coordinate plus this object's height is
         * greater than the object's y coordinate.
         */
        return (newX < object.getXPosition() + object.getWidth() &&
                newX + getWidth() > object.getXPosition() &&
                newY < object.getYPosition() + object.getHeight() &&
                newY + getHeight() > object.getYPosition());
    }
}
