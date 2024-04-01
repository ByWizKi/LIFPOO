package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Game;
import models.Heros;
import views.Window;

public class GameController implements ActionListener {
    private Window window;

    public GameController(Window window) {
        this.window = window;
    }

    /**
     * Handles different game actions based on the action command received.
     *
     * @param e the ActionEvent containing the action command
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle different game actions based on the action command

        // Get the action command from the ActionEvent
        String actionCommand = e.getActionCommand();

        // Switch on the action command to determine the appropriate action to take
        switch (actionCommand) {
            // Exit the game
            case "EXIT GAME":
                System.exit(0);
                break;
            // Placeholder for future level editing functionality
            case "EDIT LEVEL":
                break;
            // Unknown action command, print a warning message
            default:
                System.out.println("Unknown action: " + actionCommand);
        }
    }

    /**
     * Moves the hero in the specified direction if possible.
     *
     * @param direction The direction in which to move the hero (UP, DOWN, LEFT,
     *                  RIGHT).
     */
    public void moveHero(String direction) {
        // Get the game panel and the game from the window
        Game game = window.getGamePanel().getGame();

        // Get the first hero from the game's hero list
        Heros hero = game.getHerosList().get(0); // Assuming single hero for simplicity

        if (game.areAllLevelsCompleted()) {
            System.out.println("All levels completed. Movement disabled.");
            return; // Quitte la méthode sans déplacer le héros
        }

        // Calculate the movement deltas based on the input direction
        int deltaX = 0, deltaY = 0;
        switch (direction) {
            case "UP":
                deltaY = -100; // Move up by 100 pixels
                break;
            case "DOWN":
                deltaY = 100; // Move down by 100 pixels
                break;
            case "LEFT":
                deltaX = -100; // Move left by 100 pixels
                break;
            case "RIGHT":
                deltaX = 100; // Move right by 100 pixels
                break;
        }

        // Attempt to move the hero and update the game state if successful
        if (hero.tryMove(deltaX, deltaY, game.getWallList(), game.getCaseList())) {
            updateGameState(); // Update the game state after moving the hero
        }
    }

    /**
     * Updates the game state after a successful move. This method includes the
     * following actions:
     * - Redraws the game panel to reflect the move.
     * - Increments the step counter.
     * - Checks if the level is completed and if there are more levels to load.
     * - If the level is completed and there are more levels to load, it loads the
     * next level.
     * - If there are no more levels to load, it prints a congratulations message.
     * - Repaints the game panel to display the changes.
     * - Restores the focus to the GamePanel.
     */
    private void updateGameState() {
        // Get the Game object from the GamePanel
        Game game = window.getGamePanel().getGame();

        // Repaint the GamePanel to reflect the move
        window.getGamePanel().repaint();

        // Increment the step counter
        window.getMenuPanel().addStep();

        // Check if the level is completed and if there are more levels to load
        if (game.checkLevelCompletion()) {

            // If there are more levels to load
            if (game.getCurrentLevelIndex() < game.getLevelList().size() - 1) {

                // Load the next level
                game.loadNextLevel();

                // Reset the step counter and update the level display
                window.getMenuPanel().resetStep();
                window.getMenuPanel().addLevel();
                // Increment the score counter
                window.getMenuPanel().addScore();

            } else {
                // Increment the score counter for completing the last level
                window.getMenuPanel().addScore();
                game.setAllLevelsCompleted(true);
                // Print a congratulations message if there are no more levels to load
                System.out.println("Congratulations! You have completed all levels.");
            }
        }

        // Repaint the GamePanel to display the changes
        window.getGamePanel().repaint();

        // Restore the focus to the GamePanel
        window.getGamePanel().requestFocusInWindow();
    }

    /**
     * Refreshes the level by reloading the current level in the game and
     * forcing the refresh of the GamePanel to display the changes.
     */
    public void refreshLevel() {
        // Get the Game object from the GamePanel
        Game game = window.getGamePanel().getGame();

        // Reload the current level in the game
        game.reloadCurrentLevel();

        // Force the repaint of the GamePanel to display the changes
        window.getGamePanel().repaint();
    }
}