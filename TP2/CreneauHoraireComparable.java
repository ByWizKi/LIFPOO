/**
 * CreneauHoraireComparable
 */
public class CreneauHoraireComparable extends CreneauHoraire implements Comparable<CreneauHoraire> {

  public CreneauHoraireComparable() {
    this.jour = 0;
    this.heure = 0;
    this.minuteDebut = 0;
    this.dureeMinitute = 0;
  }

  public CreneauHoraireComparable(int jour, int heure, int minuteDebut, int dureeMinitute) {
    super(jour, heure, minuteDebut, dureeMinitute);
  }

  @Override
  public int compareTo(Comparable<CreneauHoraire> o) {

    if (!(o instanceof CreneauHoraire)) {
      return -1;
    }
    CreneauHoraire c = (CreneauHoraire) o;
    if (this.dureeMinitute > c.dureeMinitute) {
      return 1;
    } else if (this.dureeMinitute < c.dureeMinitute) {
      return -1;
    } else {
      return 0;
    }
  }

  public static void main(String agrs[]) {
    // Les test
    CreneauHoraireComparable ch = new CreneauHoraireComparable(87, 10, 00, 01);
    CreneauHoraireComparable ch2 = new CreneauHoraireComparable(87, 10, 00, 01);
    System.out.println(ch.compareTo(ch2));
    // res = 0

    CreneauHoraireComparable ch3 = new CreneauHoraireComparable();
    ch3.SaisirCreneau();
    ch3.AfficherCreneau();

  }

}