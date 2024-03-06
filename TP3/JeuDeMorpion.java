package TP3;

public class JeuDeMorpion {

  // Attributs
  private Plateau plateau;
  private Joueur joueurs[];
  private int joueurActuelIndex = 0;

  // Constructeur
  public JeuDeMorpion(Joueur _joueur1, Joueur _joueur2) {
    this.plateau = new Plateau(3, 3);
    this.plateau.initialiser();
    this.joueurs = new Joueur[2];
    this.joueurs[0] = _joueur1;
    this.joueurs[1] = _joueur2;
  }

  // Methodes
  private Joueur getJoueurSuivant() {
    joueurActuelIndex = (joueurActuelIndex + 1) % 2;
    return joueurs[joueurActuelIndex];
  }

  private boolean estGagnant(Joueur _joueur) {
    // Verification des lignes
    for (int i = 0; i < 3; i++) {
      if (this.plateau.etatIdPlateau[i][0] == _joueur.getId() && this.plateau.etatIdPlateau[i][1] == _joueur.getId()
          && this.plateau.etatIdPlateau[i][2] == _joueur.getId()) {
        return true;
      }
    }

    for (int j = 0; j < 3; j++) {
      if (this.plateau.etatIdPlateau[0][j] == _joueur.getId() && this.plateau.etatIdPlateau[1][j] == _joueur.getId()
          && this.plateau.etatIdPlateau[2][j] == _joueur.getId()) {
        return true;
      }
    }

    // Vérification des diagonales
    if ((this.plateau.etatIdPlateau[0][0] == _joueur.getId() && plateau.etatIdPlateau[1][1] == _joueur.getId()
        && this.plateau.etatIdPlateau[2][2] == _joueur.getId()) ||
        (this.plateau.etatIdPlateau[0][2] == _joueur.getId() && plateau.etatIdPlateau[1][1] == _joueur.getId()
            && this.plateau.etatIdPlateau[2][0] == _joueur.getId())) {
      return true;
    }

    return false;
  }

  private boolean estNul() {
    for (int i = 0; i < plateau.longueur; i++) {
      for (int j = 0; j < plateau.largeur; j++) {
        if (plateau.etatIdPlateau[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean partieTerminee() {
    return estGagnant(joueurs[joueurActuelIndex]) || estNul();
  }

  public boolean coupPossible(Coup _coup) {
    if (_coup.x >= plateau.longueur || _coup.y >= plateau.largeur || _coup.x < 0 || _coup.y < 0) {
      return false;
    }
    return plateau.etatIdPlateau[_coup.x][_coup.y] == 0;
  }

  public Joueur jouerPartie() {
    System.out.println("Bienvenue au Jeux de morpion !");
    Joueur retour = null;
    while (!partieTerminee()) {
      Joueur joueurActuel = getJoueurSuivant();
      System.out.println(this.plateau.toString());
      System.out.println("le joueur " + joueurActuel.getId() + " joue");
      Coup c = joueurActuel.getCoup(plateau);
      if (coupPossible(c)) {
        this.plateau.appliquerCoup(c, joueurActuel.getId());
        System.out.println("Le joueur a joué : " + c.x + " " + c.y);
        System.out.println(this.plateau.toString());
        if (estGagnant(joueurActuel)) {
          retour = joueurActuel;
          System.out.println("Le joueur " + joueurActuel.getId() + " a gagné");
          System.out.println(this.plateau.toString());
          break;
        }
      } else {
        System.out.println("Coup impossible");
        continue;
      }
    }
    return retour;
  }

}
