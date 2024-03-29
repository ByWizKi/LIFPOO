package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.GameController;
import models.ColorEnum;
import models.FontEnum;

/**
 * Window
 */
public class Window extends JFrame {
  private JLabel titleWindow;
  private int sizeXWindow;
  private int sizeYWindow;

  // private GamePanel gameView
  private MenuPanel menuView;
  private GameController gameController;

  public Window() {
    // Setup Controller
    GameController controller = new GameController(this);
    this.gameController = controller;

    // Properties window
    sizeXWindow = 1280;
    sizeYWindow = 720;

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

    /*
     * Style
     * 
     * 
     * 
     * 
     */
    this.titleWindow.setBounds(489, 0, 303, 110);
    this.add(this.titleWindow);

    // MenuPanel
    MenuPanel menu = new MenuPanel(this.gameController);
    this.menuView = menu;
    this.menuView.setBounds(43, 122, 300, 500);
    this.add(this.menuView);

    // GamePanel

  }

}