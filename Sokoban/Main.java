import views.Window;

public class Main {

  public static void main(String[] args) {

    // Init Main Window

    Window window = new Window();
    window.setVisible(true);
    window.getGamePanel().requestFocusInWindow();
  }
}
