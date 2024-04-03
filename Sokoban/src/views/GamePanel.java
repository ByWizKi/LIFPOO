package views;

import java.awt.Graphics;

import javax.swing.JPanel;

import models.Case;
import models.CheckPoint;
import models.Game;
import models.Heros;
import models.IceBlock;
import models.Void;
import models.Wall;

public class GamePanel extends JPanel {
  private int sizeXPanel;
  private int sizeYPanel;
  private Game game;

  public GamePanel(Game game) {
    this.sizeXPanel = 900;
    this.sizeYPanel = 500;
    this.setSize(this.sizeXPanel, this.sizeYPanel);
    this.setLayout(null);
    this.setFocusable(true);

    this.game = game;
  }

  /**
   * Update the game and redraw the panel to reflect the changes.
   *
   * @param game the new game to set
   */
  public void updateGame(Game game) {
    // Set the new game
    this.game = game;

    // Redraw the panel to reflect the changes
    this.repaint();
  }

  /**
   * Returns the Game object associated with this GamePanel.
   *
   * @return The Game object associated with this GamePanel.
   */
  public Game getGame() {
    // Returns the Game object associated with this GamePanel.
    return this.game;
  }

  /**
   * This function is called by the repaint() method to
   * paint the contents of the component.
   *
   * @param g the graphics context for the paint
   */
  @Override
  protected void paintComponent(Graphics g) {
    // Call the paintComponent method of the superclass
    super.paintComponent(g);

    // Iterate over each wall in the game and draw it
    for (Wall wall : this.game.getWallList()) {
      // Draw the wall
      // wall.draw(g);
      g.drawImage(wall.getImage(), wall.getXPosition(), wall.getYPosition(), getFocusCycleRootAncestor());
    }

    // Iterate over each void object in the game and draw it
    for (Void voidObject : this.game.getVoidList()) {
      // Draw the void object
      g.drawImage(voidObject.getImage(), voidObject.getXPosition(), voidObject.getYPosition(),
          getFocusCycleRootAncestor());
    }

    // Iterate over each checkpoint in the game and draw it
    for (CheckPoint checkpoint : this.game.getCheckPointList()) {
      // Draw the checkpoint
      g.drawImage(checkpoint.getImage(), checkpoint.getXPosition(), checkpoint.getYPosition(),
          getFocusCycleRootAncestor());
    }

    // Iterate over each ice block in the game and draw it
    for (IceBlock iceBlock : this.game.getIceBlockList()) {
      g.drawImage(iceBlock.getImage(), iceBlock.getXPosition(), iceBlock.getYPosition(), getFocusCycleRootAncestor());
    }
    // Iterate over each case in the game and draw it
    for (Case caseObject : this.game.getCaseList()) {
      // Draw the case
      g.drawImage(caseObject.getImage(), caseObject.getXPosition(), caseObject.getYPosition(),
          getFocusCycleRootAncestor());
    }

    // Iterate over each hero in the game and draw it
    for (Heros heros : this.game.getHerosList()) {
      // Draw the hero
      g.drawImage(heros.getImage(), heros.getXPosition(), heros.getYPosition(), getFocusCycleRootAncestor());
    }

  }
}
