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
    this.levelLabel = new JLabel("Level :" + this.level, JLabel.CENTER);
    this.levelLabel.setFont(FontEnum.MENU_TEXT_FONT.getFont());
    this.levelLabel.setForeground(Color.decode(ColorEnum.SECONDARY.getHexValue()));
    this.add(this.levelLabel, constraintsLayout);

    // Scores Label
    this.scoresLabel = new JLabel("Scores: " + this.score, JLabel.CENTER);
    this.scoresLabel.setFont(FontEnum.MENU_TEXT_FONT.getFont());
    this.scoresLabel.setForeground(Color.decode(ColorEnum.SECONDARY.getHexValue()));
    this.add(this.scoresLabel, constraintsLayout);

    // Step Label
    this.stepLabel = new JLabel("Step: " + this.step, JLabel.CENTER);
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

  public void addStep() {
    this.step++;
    this.stepLabel.setText("Step: " + this.step);
  }

  public void addScore() {
    this.score += 10;
    this.scoresLabel.setText("Scores: " + this.score);
  }

  public void addLevel() {
    this.level++;
    this.levelLabel.setText("Level: " + this.level);
  }

  public void reset() {
    this.level = 1;
    this.score = 0;
    this.step = 0;
    this.levelLabel.setText("Level: " + this.level);
    this.scoresLabel.setText("Scores: " + this.score);
    this.stepLabel.setText("Step: " + this.step);
  }

  public void resetStep() {
    this.step = 0;
    this.stepLabel.setText("Step: " + this.step);
  }
}