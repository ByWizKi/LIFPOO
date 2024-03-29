package models;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

public enum FontEnum {
  WINDOW_TITLE_FONT("/assets/fonts/RoadRage-Regular.ttf", 100),
  MENU_TITLE_FONT("/assets/fonts/RoadRage-Regular.ttf", 100),
  MENU_TEXT_FONT("/assets/fonts/RoadRage-Regular.ttf", 64);

  private Font font;

  FontEnum(String fontFileName, float size) {
    try {
      InputStream is = FontEnum.class.getResourceAsStream(fontFileName);
      if (is == null) {
        throw new RuntimeException("Could not load font: " + fontFileName);
      }
      Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(size);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(font);
      this.font = font;
    } catch (Exception e) {
      e.printStackTrace();
      this.font = new Font("Serif", Font.PLAIN, 24); // Fallback font in case of error
    }
  }

  public Font getFont() {
    return this.font;
  }
}
