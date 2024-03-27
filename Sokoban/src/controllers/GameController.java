package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.Window;

public class GameController implements ActionListener {
  private Window window;

  public GameController(Window window) {
    this.window = window;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "EXIT GAME":
        System.exit(0);
        break;
      case "EDIT LEVEL":
        // Ici, invoquez la méthode pour modifier le texte dans MenuPanel
        break;
      default:
        System.out.println("Action non reconnue");
    }
  }
}
