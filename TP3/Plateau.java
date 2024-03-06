package TP3;

public class Plateau {

  public int longueur;
  int largeur;
  int etatIdPlateau[][];

  public Plateau(int longueur, int largeur) {
    this.longueur = longueur;
    this.largeur = largeur;
    this.etatIdPlateau = new int[longueur][largeur]; 
  }

  public void initialiser() {
    for (int i = 0; i < this.longueur; i++) {
      for (int j = 0; j < this.largeur; j++) {
        this.etatIdPlateau[i][j] = 0;
      }
    }
  }

  public boolean appliquerCoup(Coup c, int id) {
    try {
      this.etatIdPlateau[c.x][c.y] = id;
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public String toString() {
    String res = "";
    for (int i = 0; i < this.longueur; i++) {
      for (int j = 0; j < this.largeur; j++) {
        res += this.etatIdPlateau[i][j] + " ";
      }
      res += "\n";
    }
    return res;
  }
}
