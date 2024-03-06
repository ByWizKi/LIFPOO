package TP3;

public class SimulateurDeMorpion {

  public static void main(String[] args) {
    Joueur j1 = new JoueurAleatoire(1);
    Joueur j2 = new JoueurHumain(2);
    JeuDeMorpion jeu = new JeuDeMorpion(j1, j2);
    jeu.jouerPartie();
  }
}
