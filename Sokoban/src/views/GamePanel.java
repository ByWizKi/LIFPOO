package views;

import java.awt.Graphics;

import javax.swing.JPanel;

import models.Case;
import models.CheckPoint;
import models.Game;
import models.Heros;
import models.Void;
import models.Wall;

public class GamePanel extends JPanel {
  private int sizeXPanel;
  private int sizeYPanel;
  private Game game;

  public GamePanel(Game game) {
    // Propriétés du panneau
    this.sizeXPanel = 800;
    this.sizeYPanel = 500;
    this.setSize(this.sizeXPanel, this.sizeYPanel);
    this.setLayout(null);
    this.setFocusable(true);
    this.requestFocusInWindow();

    // Référence au jeu
    this.game = game;
  }

  // function for update game
  public void updateGame(Game game) {
    this.game = game;
    this.repaint(); // Redessiner le panneau pour refléter les changements
  }

  // Getter for Game
  public Game getGame() {
    return this.game;
  }

  // function for draw map
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // draw wall
    for (Wall wall : this.game.getWallList()) {
      wall.draw(g);
    }
    // draw void cases
    for (Void voidObject : this.game.getVoidList()) {
      voidObject.draw(g);
    }
    // draw checkpoints
    for (CheckPoint checkpoint : this.game.getCheckPointList()) {
      checkpoint.draw(g);
    }
    // draw heros
    for (Heros heros : this.game.getHerosList()) {
      heros.draw(g);
    }
    // draw cases
    for (Case caseObject : this.game.getCaseList()) {
      caseObject.draw(g);
    }
  }
}
