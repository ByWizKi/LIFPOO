package models;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

public enum FontEnum {
  WINDOW_TITLE_FONT("/assets/fonts/RoadRage-Regular.ttf", 100),
  MENU_TITLE_FONT("/assets/fonts/RoadRage-Regular.ttf", 100),
  MENU_TEXT_FONT("/assets/fonts/RoadRage-Regular.ttf", 64),
  HELP_WINDOW_FONT("/assets/fonts/RoadRage-Regular.ttf", 25);

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

  /**
   * Get the font associated with this enum constant.
   *
   * @return The font associated with this constant.
   */
  public Font getFont() {
    /* Returns the font associated with this constant.
     *
     * @return The font associated with this constant.
     */
    return this.font;
  }
}
