import java.util.Scanner;

/**
 * CrenauHoraire
 */
public class CreneauHoraire {
    public int jour;
    public int heure;
    public int minuteDebut;
    public int dureeMinitute;

    public CreneauHoraire(){
        this.jour = 0;
        this.heure = 0;
        this.minuteDebut = 0;
        this.dureeMinitute = 0;
    }
    public CreneauHoraire(int jour, int heure, int minuteDebut, int dureeMinitute){
        this.jour = jour;
        this.heure = heure;
        this.minuteDebut = minuteDebut;
        this.dureeMinitute = dureeMinitute;
    }
   // Question 4 
   // Return true 
   @Override public boolean equals (Object o){
       if ( o == this ){
           return true;
       } 
       if (!(o instanceof CreneauHoraire)){
           return false;
       }
       CreneauHoraire c = (CreneauHoraire) o;
       return (this.jour == c.jour && this.heure == c.heure && this.minuteDebut == c.minuteDebut && this.dureeMinitute == c.dureeMinitute);
    }
    
    public void SaisirCreneau(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir le jour : ");
        this.jour = sc.nextInt();
        System.out.println("Saisir l'heure : ");
        this.heure = sc.nextInt();
        System.out.println("Saisir le minute de debut : ");
        this.minuteDebut = sc.nextInt();
        System.out.println("Saisir la duree en minute : ");
        this.dureeMinitute = sc.nextInt();
        sc.close();
    }

    public void AfficherCreneau(){
        System.out.println("Jour : " + this.jour + " Heure : " + this.heure + " Minute de debut : " + this.minuteDebut + " Duree en minute : " + this.dureeMinitute);
    }
    public static void main (String agrs []){
        CreneauHoraire ch = new CreneauHoraire(87, 10, 00, 01);        
        CreneauHoraire ch2 = new CreneauHoraire(87, 10, 00, 01);
        
        // Question 3
        // Return false
        System.out.println(ch == ch2);
      
       // Question 3
       // Return false 
        System.out.println(ch.equals(ch2));

        CreneauHoraire ch3 = new CreneauHoraire();
        ch3.SaisirCreneau();
        ch3.AfficherCreneau();

             
    }
}