package TP3;
import java.util.Scanner;
public class JoueurHumain extends Joueur {
 
  JoueurHumain (int _id) {
    super(_id);
  }

  public Coup getCoup(Plateau _etatPlateau) {
    Scanner sc = new Scanner(System.in);
    Coup c = new Coup(0, 0);
    System.out.println("Entrez une coordonnee x :  ");
    c.x = sc.nextInt();
    System.out.println("Entrez une coordonnee y :  ");
    c.y = sc.nextInt();
    return c;
  }
}
