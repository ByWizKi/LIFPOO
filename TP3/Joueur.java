package TP3;

abstract public class Joueur {
  private int id;

  public Joueur(int _id) {
    this.id = _id;
  }

  public int getId() {
    return this.id;
  }

  abstract public Coup getCoup(Plateau _etatPlateau);

}
