package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.ColorEnum;

/**
 * MenuPanel
 */
public class MenuPanel extends JPanel {

  private JLabel titleMenu;
  private int sizeXPanel;
  private int sizeYPanel;
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
    this.setLayout(new BorderLayout());

    // Title Menu
    this.titleMenu = new JLabel("Menu", JLabel.CENTER);
    /*
     * Style
     * 
     */
    this.add(this.titleMenu, BorderLayout.NORTH);

    // Level Label
    this.levelLabel = new JLabel("Level 1", JLabel.CENTER);
    /*
     * Style
     * 
     */
    this.add(this.levelLabel);

    // Scores Label
    this.scoresLabel = new JLabel("Scores: 0", JLabel.CENTER);
    /*
     * Style
     * 
     * 
     * 
     */
    this.add(this.scoresLabel);

    // Step Label
    this.stepLabel = new JLabel("Step: 0", JLabel.CENTER);
    /*
     * Style
     * 
     * 
     * 
     */
    this.add(this.stepLabel);

    // Exit Button
    this.exitButton = new JButton("Exit");
    /*
     * Style
     * 
     * 
     */
    this.exitButton.setBackground(Color.decode(ColorEnum.SECONDARY.getHexValue()));
    this.exitButton.setActionCommand("EXIT GAME");
    this.exitButton.addActionListener(listener);
    this.add(this.exitButton, BorderLayout.SOUTH);
  }
}