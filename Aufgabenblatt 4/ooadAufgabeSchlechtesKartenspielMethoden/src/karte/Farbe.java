package karte;

public enum Farbe {
       KARO("Karo"), HERZ("Herz"), KREUZ("Kreuz"), PIK("Pik");
       
       private String text;
       
       Farbe(String text){
           this.text=text;
       }
       
       public String toString(){
           return text;
       }
}
