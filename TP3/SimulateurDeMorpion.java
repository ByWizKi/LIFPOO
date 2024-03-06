package TP3;

public class SimulateurDeMorpion {

  public static void main (String args[]) {
    Plateau p = new Plateau(3, 3);
    p.initialiser();
    Coup coup = new Coup(1, 1); 
    p.appliquerCoup(coup, 1);
    System.out.println(p);
  }
}
