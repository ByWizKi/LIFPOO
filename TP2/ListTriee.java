import java.util.ArrayList;

/**
 * ListTriee
 */
public class ListTriee<T> extends ArrayList<T> {
  @Override 
  public boolean add(T o){
    try {
      super.add(o);
      super.sort(null);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
  @Override 
  public boolean remove(Object o){
    try {
      super.remove(o);
      super.sort(null);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public T get(int index) {
    T t = super.get(index);
    return t;
  }

  @Override
  public T remove(int index) {
    try {
      super.remove(index);
      super.sort(null);
      return get(index);
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public void clear() {
    super.clear();
  }
  
  public static void main (String args []){
    // test 
    ListTriee<String> lt = new ListTriee<String>();
    lt.add("a");
    lt.add("f");
    lt.add("b");
    lt.add("c");
    lt.add("d");
    lt.remove("b");
    lt.add("e"); 
    System.out.println(lt);

  }
}