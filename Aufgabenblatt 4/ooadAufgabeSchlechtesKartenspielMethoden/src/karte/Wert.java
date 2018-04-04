package karte;

public enum Wert {
   SIEBEN("7"), ACHT("8"), NEUN("9"), ZEHN("10"), BUBE("Bube"), DAME("Dame"), KOENIG("Koenig"), AS("As");
   
   private String text;
   
   Wert(String text){
       this.text=text;
   }
   
   public String toString(){
       return text;
   }
   
    
}
