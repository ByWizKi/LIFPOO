package models;

import java.util.ArrayList;

public class Case extends DynamicObject {

    public Case(int xPosition, int yPosition, String imgPath) {
        super(xPosition, yPosition, imgPath);
        // Utilize the superclass constructor to initialize fields
    }

    /**
     * Attempts to move the Case object by the specified direction.
     *
     * @param direction the direction in which to move the Case. Valid values are
     *                  "UP", "DOWN",
     *                  "LEFT", and "RIGHT".
     * @param walls     the list of walls to check collision with
     * @param cases     the list of other Cases to check collision with
     * @param ices      the list of ice blocks to check collision with
     * @return true if the movement is successful, false otherwise
     */
    @Override
    public boolean tryMove(String direction, ArrayList<Wall> walls, ArrayList<Case> cases, ArrayList<IceBlock> ices) {
        // Calculate the deltas based on the direction
        int deltaX = 0;
        int deltaY = 0;

        switch (direction) {
            case "UP":
                deltaY = -100;
                break; // Avoid "fall-through"
            case "DOWN":
                deltaY = 100;
                break;
            case "LEFT":
                deltaX = -100;
                break;
            case "RIGHT":
                deltaX = 100;
                break;
            default:
                return false; // Handle undefined directions
        }

        // Calculate the new position
        int newX = this.xPosition + deltaX;
        int newY = this.yPosition + deltaY;

        // Check for collisions with walls and other Cases
        if (isCollision(newX, newY, walls) || isCollisionWithCases(newX, newY, cases)) {
            return false; // Movement blocked due to collision
        }

        // Check for collisions with ice blocks
        if (isCollisionWithIce(newX, newY, ices)) {
            // If collision with ice, "slide" an additional 100 pixels in the same direction
            newX += (deltaX != 0) ? ((deltaX > 0) ? 100 : -100) : 0;
            newY += (deltaY != 0) ? ((deltaY > 0) ? 100 : -100) : 0;

            // Ensure slide movement doesn't result in another collision
            if (isCollision(newX, newY, walls) || isCollisionWithCases(newX, newY, cases)) {
                return false; // Movement blocked after slide
            }

            this.xPosition = newX;
            this.yPosition = newY;
            return true;
        }

        // If no collision is detected, update the position
        this.xPosition = newX;
        this.yPosition = newY;
        return true; // Successful movement
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

    /**
     * Checks for collision with any ice block.
     *
     * @param newX         the x coordinate of the proposed new position
     * @param newY         the y coordinate of the proposed new position
     * @param iceBlockList the list of ice blocks to check collision with
     * @return true if there is a collision, false otherwise
     */
    private boolean isCollisionWithIce(int newX, int newY, ArrayList<IceBlock> ices) {
        // Iterate over each ice block and check for collision
        // If any ice block is collided, return true
        return ices.stream()
                // Check for collision with each ice block
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
         * Checks if the proposed new position collides with the given game object.
         * This is done by checking if the proposed new position falls within the
         * boundaries of the object.
         */
        // Check if the proposed new position's x coordinate is within the object's x
        // range
        boolean isXInRange = (newX < object.getXPosition() + object.getWidth())
                && (newX + getWidth() > object.getXPosition());
        // Check if the proposed new position's y coordinate is within the object's y
        // range
        boolean isYInRange = (newY < object.getYPosition() + object.getHeight())
                && (newY + getHeight() > object.getYPosition());

        // Return true if there is a collision, false otherwise
        return isXInRange && isYInRange;
    }
}
