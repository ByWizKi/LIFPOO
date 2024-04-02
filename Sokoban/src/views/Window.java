package views;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.GameController;
import models.ColorEnum;
import models.FontEnum;
import models.Game; // Assurez-vous d'importer Game

public class Window extends JFrame {
  private JLabel titleWindow;
  private JLabel helpGame;
  private int sizeXWindow;
  private int sizeYWindow;
  private MenuPanel menuView;
  private GamePanel gameView;
  private GameController gameController;
  private Game game;

  public Window() {
    // Initialisation du jeu
    this.game = new Game();

    // Configuration de la fenêtre
    configureWindow();

    // Configuration des panels
    configurePanels();

    // Configuration de la gestion des touches
    configureKeyHandling();

    // Démarrage du jeu
    this.game.start();

  }

  /**
   * Configures the window of the game.
   * It sets the size, default close operation, location, resizability, title, and layout.
   * Also adds a title label and a help label to the window.
   */
  private void configureWindow() {
    // Set the size of the window
    this.sizeXWindow = 1280;
    this.sizeYWindow = 720;
    this.setSize(this.sizeXWindow, this.sizeYWindow);

    // Set the default close operation to exit the program when the window is closed
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Center the window on the screen
    this.setLocationRelativeTo(null);

    // Disable resizing of the window
    this.setResizable(false);

    // Set the title of the window
    this.setTitle("Sokoban by thiebaud enzo");

    // Set the layout of the window to null
    this.setLayout(null);

    // Add a title label to the window
    this.titleWindow = new JLabel("Sokoban", JLabel.CENTER);
    this.titleWindow.setFont(FontEnum.WINDOW_TITLE_FONT.getFont());
    this.titleWindow.setForeground(Color.decode(ColorEnum.PRIMARY.getHexValue()));
    this.titleWindow.setBounds(489, 0, 303, 110);
    this.add(this.titleWindow);

    // Add a help label to the window
    this.helpGame = new JLabel(
        "'r' pour recommencer un niveau| fleche haut pour monter| fleche bas pour descendre| fleche droite pour aller à droite| fleche gauche pour aller à gauche",
        JLabel.CENTER);
    this.helpGame.setFont(FontEnum.HELP_WINDOW_FONT.getFont());
    this.helpGame.setForeground(Color.decode(ColorEnum.PRIMARY.getHexValue()));
    this.helpGame.setBounds(85, 642, 1110, 28);
    this.add(this.helpGame);
  }

  /**
   * Configures the panels of the game window.
   * This method initializes and configures the GamePanel and MenuPanel,
   * ensuring that the GamePanel is initialized before the MenuPanel.
   */
  private void configurePanels() {
    // Configuration de GamePanel
    // Initialize the GamePanel and set its location, size, and focusable properties
    this.gameView = new GamePanel(this.game);
    this.gameView.setLocation(437, 122);
    this.gameView.setSize(800, 500);
    this.gameView.setFocusable(true);
    
    // Add the GamePanel to the window
    this.add(this.gameView);
    
    // Ensure that GameController is initialized after GamePanel
    this.gameController = new GameController(this);
    
    // Configuration de MenuPanel
    // Initialize the MenuPanel and set its bounds
    this.menuView = new MenuPanel(gameController);
    this.menuView.setBounds(43, 122, 300, 500);
    
    // Add the MenuPanel to the window
    this.add(this.menuView);
  }

  /**
   * Configures the key handling for the game window.
   * This method adds a KeyListener to the GamePanel and handles key press events.
   * The key press handler is defined in the handleKeyPress method.
   * The KeyListener is added to the GamePanel and the GamePanel is set to have focus.
   */
  private void configureKeyHandling() {
    // Add a KeyListener to the GamePanel to handle key press events
    this.gameView.addKeyListener(new KeyAdapter() {
      /**
       * Handles key press events by invoking the handleKeyPress method.
       * This method is called by the KeyListener when a key is pressed.
       *
       * @param  e  the KeyEvent representing the key press
       */
      @Override
      public void keyPressed(KeyEvent e) {
        handleKeyPress(e);
      }
    });

    // Set the GamePanel to have focus
    this.gameView.requestFocusInWindow();
  }

  /**
   * Handles key press events by invoking the appropriate method from GameController.
   * This method is called by the KeyListener when a key is pressed.
   * 
   * @param  e  the KeyEvent representing the key press
   */
  private void handleKeyPress(KeyEvent e) {
    // Switch based on the key code to determine the appropriate action
    switch (e.getKeyCode()) {
      case KeyEvent.VK_UP:
        // Move the hero up
        gameController.moveHero("UP");
        break;
      case KeyEvent.VK_DOWN:
        // Move the hero down
        gameController.moveHero("DOWN");
        break;
      case KeyEvent.VK_LEFT:
        // Move the hero left
        gameController.moveHero("LEFT");
        break;
      case KeyEvent.VK_RIGHT:
        // Move the hero right
        gameController.moveHero("RIGHT");
        break;
      case KeyEvent.VK_R:
        // Refresh the level
        gameController.refreshLevel();
        break;
    }
    
    // Repaint the game panel after a move
    gameView.repaint(); 
  }

  /**
   * Returns the GamePanel instance of this Window.
   *
   * @return The GamePanel instance.
   */
  public GamePanel getGamePanel() {
    // Returns the GamePanel instance of this Window.
    // This method is used to get the GamePanel instance of this Window.
    return this.gameView;
  }

  /**
   * Returns the MenuPanel instance of this Window.
   *
   * @return The MenuPanel instance of this Window.
   */
  public MenuPanel getMenuPanel() {
    // Returns the MenuPanel instance of this Window.
    // This method is used to get the MenuPanel instance of this Window.
    // It can be used to access the MenuPanel of the Window for further manipulation.
    return this.menuView;
  }


  /**
   * Returns the Game instance of this Window.
   *
   * @return The Game instance of this Window.
   */
  public Game getGame() {
    // Returns the Game instance of this Window.
    // This getter is used to get the Game instance of this Window.
    // It can be used to access the Game of the Window for further manipulation.
    return this.game;
  }
}
