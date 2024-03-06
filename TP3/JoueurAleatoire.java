package TP3;

public class JoueurAleatoire extends Joueur {

  public JoueurAleatoire(int _id) {
    super(_id);
  }

  public Coup getCoup(Plateau _etatPlateau) {
    // On genere les coup aleatoirement
    int x = Tool.monRandom(_etatPlateau.longueur - 1, 0);
    int y = Tool.monRandom(_etatPlateau.largeur - 1, 0);
    // On test si la case n'est pas occupee
    if (_etatPlateau.etatIdPlateau[x][y] == 0) {
      return new Coup(x, y);
    }
    return getCoup(_etatPlateau);
  }

}
