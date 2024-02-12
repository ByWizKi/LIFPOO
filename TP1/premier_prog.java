// Premier programme Java
public class premier_prog {
  public static void main (String args []){
    String maChaine = args[0];
    int monEntier = 0;
    monEntier = Integer.parseInt(maChaine);
    double res = 1.0;
    for(int i = 1; i <= monEntier; i++){
     res += 1/i; 
    }
    System.out.println(res);
  };
};