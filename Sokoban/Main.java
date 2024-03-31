import views.Window;

public class Main {

  public static void main(String[] args) {

    // Init Main Window

    Window window = new Window();
    window.setVisible(true);
    // Pour avoir le focus du panel sinon il capte pas que l'utilisateur appuie sur une touche
    window.getGamePanel().requestFocusInWindow();
  }
}
