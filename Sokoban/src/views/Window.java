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
  private GamePanel gamePanel;
  private GameController gameController;
  private Game game; // Instance de Game

  public Window() {
    // Setup Controller
    this.gameController = new GameController(this);

    // Création de l'instance de Game
    this.game = new Game();

    // Properties window
    this.sizeXWindow = 1280;
    this.sizeYWindow = 720;

    // Properties frame
    this.setSize(this.sizeXWindow, this.sizeYWindow);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setTitle("Sokoban by thiebaud enzo");

    // Layout
    this.setLayout(null);

    // Title Window
    this.titleWindow = new JLabel("Sokoban", JLabel.CENTER);
    this.titleWindow.setFont(FontEnum.WINDOW_TITLE_FONT.getFont());
    this.titleWindow.setForeground(Color.decode(ColorEnum.PRIMARY.getHexValue()));
    this.titleWindow.setBounds(489, 0, 303, 110);
    this.add(this.titleWindow);

    // MenuPanel
    this.menuView = new MenuPanel(this.gameController);
    this.menuView.setBounds(43, 122, 300, 500);
    this.add(this.menuView);

    // GamePanel, maintenant initialisé avec game
    this.gamePanel = new GamePanel(this.game);
    this.gamePanel.setLocation(437, 122);
    this.gamePanel.setSize(800, 500); // Assurez-vous que la taille est définie pour rendre le panel focusable
    this.gamePanel.setFocusable(true);
    this.gamePanel.requestFocusInWindow();
    this.gamePanel.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        handleKeyPress(e);
      }
    });
    this.add(this.gamePanel);
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
    }
    gamePanel.repaint(); // Redessinez après mouvement
  }

  public GamePanel getGamePanel() {
    return this.gamePanel;
  }

  // Peut-être ajouter un getter pour Game si nécessaire
  public Game getGame() {
    return this.game;
  }
}
