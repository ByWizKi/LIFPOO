import javax.swing.text.StyledEditorKit;

public class Moto {
  String modele;
  String marque;
  Moteur moteur_moto;
  Phare phare;
  Roue roue;
  public Moto(){
    this.moteur_moto = new Moteur();
    this.phare = new Phare();
    this.roue = new Roue();
  } 

  public Moto(String modele, String marque){
    this.modele = modele;
    this.marque = marque;
    this.moteur_moto = new Moteur();
    this.phare = new Phare();
    this.roue = new Roue();
  }

  public void speed_up(){
    if(this.moteur_moto.isOn() && this.phare.isOn()){
      System.out.println("Je fonce !");
    }
    else{
      System.out.println("Je ne fonce pas");
    }
  }

  public class Moteur{
    private Boolean on = false;
    public Moteur(){}
    public void setOn(){
      this.on = true;
      System.out.println("Moteur allume");
    }

    public void setOff(){
      this.on = false;
      System.out.println("Moteur eteint");
    }
    public Boolean isOn(){return this.on;}
  }

  public class Phare{
    private Boolean on = false;
    public Phare(){}
    public void setOn(){
      this.on = true;
      System.out.println("Phare allume");
    }
    public void setOff(){
      this.on = false;
      System.out.println("Phare eteint");
    }
    public Boolean isOn(){return this.on;}
  }

  public class Roue{
   public Roue(){} 
  }

  public static void main(String[] args) {
    Moto moto = new Moto();
    moto.speed_up();
    moto.phare.setOn();
    moto.moteur_moto.setOn();
    moto.speed_up();
    Moto moto2 = new Moto("Suzuki","Yamaha");
    moto2.speed_up();
    moto2.phare.setOn();
    moto2.moteur_moto.setOn();
    moto2.speed_up();
    moto = moto2;
    System.out.println(moto.modele);
    moto2.modele = "Honda";
    System.out.println(moto.modele);
  }
}