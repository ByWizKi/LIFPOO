
/**
 * ListeTrieeBis
 */
import java.util.ArrayList;

public class ListeTrieeBis<T> extends ArrayList<Comparable<T>> {

  // public void trie() {
  //   System.out.println("je suis la ");
  //   for (int i = 0; i < super.size(); i++) {
  //     for (int j = 0; j < super.size() - 1; j++) {
  //       if (super.get(j).compareTo(super.get(j + 1)) > 0) {
  //         Comparable<T> temp = super.get(j);
  //         super.set(j, super.get(j + 1));
  //         super.set(j + 1, temp);
  //       }
  //     }
  //   }
  // }

  @Override 
  public boolean add(Comparable<T> o){
    try {
      super.add(o); 
      return true;
    } catch (Exception e) {
      return false;
    }
  }



  public static void main(String args[]) {
    // Test Avec CreneauHoraire
    ListeTrieeBis<CreneauHoraire> lt = new ListeTrieeBis<CreneauHoraire>();
    lt.add(new CreneauHoraire(87, 10, 00, 01));
    


    System.out.println(lt);
  }
}