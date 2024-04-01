package models;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Heros extends GameObject {
  private HashMap<String, Image> heroImages = new HashMap<>();

  public Heros(int xPosition, int yPosition, String imgPath) {
    super(xPosition, yPosition, imgPath);
    // Précharger toutes les images nécessaires
    preloadImages();
    // Définir l'image initiale
    this.img = heroImages.get("default");
  }

  private void preloadImages() {
    heroImages.put("default", new ImageIcon(this.imgPath).getImage());
    heroImages.put("left", new ImageIcon("assets/img/mario_left_side.png").getImage());
    heroImages.put("right", new ImageIcon("assets/img/mario_right_side.png").getImage());
    // Ajoutez d'autres directions ou états si nécessaire
  }

  @Override
  public void draw(Graphics g) {
    g.drawImage(this.img, this.xPosition, this.yPosition, null);
  }

  public boolean tryMove(int deltaX, int deltaY, ArrayList<Wall> walls, ArrayList<Case> cases) {
    int newX = this.xPosition + deltaX;
    int newY = this.yPosition + deltaY;

    // Vérifier les collisions avec les murs
    for (Wall wall : walls) {
      if (checkCollision(newX, newY, wall)) {
        return false;
      }
    }

    // Vérifier les collisions et tenter de déplacer les cases
    for (Case caseObject : cases) {
      if (checkCollision(newX, newY, caseObject)) {
        if (!caseObject.tryMove(deltaX, deltaY, walls, cases)) {
          return false; // Collision détectée, arrêt du mouvement
        }
        break; // Gère une seule case à la fois
      }
    }

    // Mettre à jour l'image en fonction de la direction du mouvement
    if (deltaX < 0) {
      this.img = heroImages.get("left");
    } else if (deltaX > 0) {
      this.img = heroImages.get("right");
    }

    // Pas de collision, mise à jour de la position
    this.xPosition = newX;
    this.yPosition = newY;
    return true;
  }

  private boolean checkCollision(int newX, int newY, GameObject object) {
    return newX < object.getXPosition() + object.getWidth() &&
        newX + this.getWidth() > object.getXPosition() &&
        newY < object.getYPosition() + object.getHeight() &&
        newY + this.getHeight() > object.getYPosition();
  }

  // Méthodes pour obtenir la largeur et la hauteur de l'image du héros
  @Override
  public int getWidth() {
    return this.img.getWidth(null);
  }

  @Override
  public int getHeight() {
    return this.img.getHeight(null);
  }
}
