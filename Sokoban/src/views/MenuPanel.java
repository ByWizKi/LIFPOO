package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.ColorEnum;
import models.FontEnum;

/**
 * MenuPanel
 */
public class MenuPanel extends JPanel {

  private JLabel titleMenu;
  private int sizeXPanel;
  private int sizeYPanel;
  private int level = 1;
  private int score = 0;
  private int step = 0;
  private JLabel levelLabel;
  private JLabel scoresLabel;
  private JLabel stepLabel;
  private JButton exitButton;

  public MenuPanel(ActionListener listener) {

    // Properties panel
    sizeXPanel = 300;
    sizeYPanel = 500;

    // Properties frame
    this.setSize(this.sizeXPanel, this.sizeYPanel);
    this.setBackground(Color.decode(ColorEnum.PRIMARY.getHexValue()));
    this.setBorder(new javax.swing.border.LineBorder(Color.decode(ColorEnum.WHITE.getHexValue()), 5));

    // Layout
    this.setLayout(new GridBagLayout());
    GridBagConstraints constraintsLayout = new GridBagConstraints();
    constraintsLayout.gridx = GridBagConstraints.REMAINDER;
    constraintsLayout.anchor = GridBagConstraints.NORTH;
    constraintsLayout.insets = new Insets(10, 10, 10, 10);

    // Title Menu
    this.titleMenu = new JLabel("Menu", JLabel.CENTER);
    this.titleMenu.setFont(FontEnum.MENU_TITLE_FONT.getFont());
    this.titleMenu.setForeground(Color.decode(ColorEnum.BLACK.getHexValue()));
    this.add(this.titleMenu, constraintsLayout);

    // Level Label
    this.levelLabel = new JLabel("Level : " + this.level, JLabel.CENTER);
    this.levelLabel.setFont(FontEnum.MENU_TEXT_FONT.getFont());
    this.levelLabel.setForeground(Color.decode(ColorEnum.SECONDARY.getHexValue()));
    this.add(this.levelLabel, constraintsLayout);

    // Scores Label
    this.scoresLabel = new JLabel("Scores : " + this.score, JLabel.CENTER);
    this.scoresLabel.setFont(FontEnum.MENU_TEXT_FONT.getFont());
    this.scoresLabel.setForeground(Color.decode(ColorEnum.SECONDARY.getHexValue()));
    this.add(this.scoresLabel, constraintsLayout);

    // Step Label
    this.stepLabel = new JLabel("Step : " + this.step, JLabel.CENTER);
    this.stepLabel.setFont(FontEnum.MENU_TEXT_FONT.getFont());
    this.stepLabel.setForeground(Color.decode(ColorEnum.SECONDARY.getHexValue()));
    this.add(this.stepLabel, constraintsLayout);

    // Exit Button
    this.exitButton = new JButton("Exit");
    this.exitButton.setFont(FontEnum.MENU_TEXT_FONT.getFont());
    this.exitButton.setForeground(Color.decode(ColorEnum.WHITE.getHexValue()));
    this.exitButton.setBorderPainted(false);
    this.exitButton.setFocusPainted(false);
    this.exitButton.setContentAreaFilled(false);
    this.exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.exitButton.setBackground(Color.decode(ColorEnum.SECONDARY.getHexValue()));
    this.exitButton.setActionCommand("EXIT GAME");
    this.exitButton.addActionListener(listener);
    this.add(this.exitButton, constraintsLayout);
  }

  /**
   * Increases the step counter by 1 and updates the step label.
   */
  public void addStep() {
    // Increment the step counter
    this.step++;

    // Update the step label with the new step value
    this.stepLabel.setText("Step: " + this.step);
  }

  /**
   * Increases the score counter by 10 and updates the scores label.
   * This method is called when the player completes a level.
   */
  public void addScore() {
    // Increment the score counter by 10
    this.score += 10;

    // Update the scores label with the new score value
    this.scoresLabel.setText("Scores: " + this.score);
  }

  /**
   * Increases the level counter by 1 and updates the level label.
   * This method is called when the player completes a level.
   */
  public void addLevel() {
    // Increment the level counter by 1
    this.level++;

    // Update the level label with the new level value
    this.levelLabel.setText("Level: " + this.level);
  }

  /**
   * Resets the level, score, and step counters and updates the labels.
   * This method is called when the player starts a new game.
   */
  public void reset() {
    // Reset the level counter
    this.level = 1;

    // Reset the score counter
    this.score = 0;

    // Reset the step counter
    this.step = 0;

    // Update the level label with the new level value
    this.levelLabel.setText("Level: " + this.level);

    // Update the scores label with the new score value
    this.scoresLabel.setText("Scores: " + this.score);

    // Update the step label with the new step value
    this.stepLabel.setText("Step: " + this.step);
  }

  /**
   * Resets the step counter and updates the step label.
   * This method is called when the player starts a new game or completes a level.
   */
  public void resetStep() {
    // Reset the step counter
    this.step = 0;

    // Update the step label with the new step value
    this.stepLabel.setText("Step: " + this.step);
  }
}