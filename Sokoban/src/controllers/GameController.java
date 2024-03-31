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

    // Function for exit game
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "EXIT GAME":
                System.exit(0);
                break;
            case "EDIT LEVEL":
                break;
            default:
                System.out.println("Unknown action: " + e.getActionCommand());
        }
    }

    // Function for move hero
    public void moveHero(String direction) {
        // Debug
        // System.out.println("You press : " + direction);
        Game game = window.getGamePanel().getGame();
        Heros hero = game.getHerosList().get(0);

        int deltaX = 0, deltaY = 0;
        switch (direction) {
            case "UP":
                deltaY = -100;
                break;
            case "DOWN":
                deltaY = 100;
                break;
            case "LEFT":
                deltaX = -100;
                break;
            case "RIGHT":
                deltaX = 100;
                break;
        }
        if (hero.tryMove(deltaX, deltaY, game.getWallList())) {
            window.getGamePanel().repaint();
        }
    }
}
