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

  private void configureWindow() {
    this.sizeXWindow = 1280;
    this.sizeYWindow = 720;
    this.setSize(this.sizeXWindow, this.sizeYWindow);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setTitle("Sokoban by thiebaud enzo");
    this.setLayout(null);

    // Configuration du titre
    this.titleWindow = new JLabel("Sokoban", JLabel.CENTER);
    this.titleWindow.setFont(FontEnum.WINDOW_TITLE_FONT.getFont());
    this.titleWindow.setForeground(Color.decode(ColorEnum.PRIMARY.getHexValue()));
    this.titleWindow.setBounds(489, 0, 303, 110);
    this.add(this.titleWindow);
  }

  private void configurePanels() {
    // Configuration de GamePanel
    this.gameView = new GamePanel(this.game);
    this.gameView.setLocation(437, 122);
    this.gameView.setSize(800, 600);
    this.gameView.setFocusable(true);
    this.add(this.gameView);

    // Assurez-vous que GameController est initialisé après GamePanel
    this.gameController = new GameController(this);

    // Configuration de MenuPanel
    this.menuView = new MenuPanel(gameController);
    this.menuView.setBounds(43, 122, 300, 500);
    this.add(this.menuView);
  }

  private void configureKeyHandling() {
    this.gameView.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        handleKeyPress(e);
      }
    });
    this.gameView.requestFocusInWindow();
  }

  private void handleKeyPress(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_UP:
        gameController.moveHero("UP");
        break;
      case KeyEvent.VK_DOWN:
        gameController.moveHero("DOWN");
        break;
      case KeyEvent.VK_LEFT:
        gameController.moveHero("LEFT");
        break;
      case KeyEvent.VK_RIGHT:
        gameController.moveHero("RIGHT");
        break;
      case KeyEvent.VK_R:
        gameController.refreshLevel();
        break;
    }
    gameView.repaint(); // Rafraîchir le panneau après un déplacement
  }

  public GamePanel getGamePanel() {
    return this.gameView;
  }

  public MenuPanel getMenuPanel() {
    return this.menuView;
  }

  // Peut-être ajouter un getter pour Game si nécessaire
  public Game getGame() {
    return this.game;
  }
}
