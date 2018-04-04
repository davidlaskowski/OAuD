package karte;
public class Karte {
    private Farbe farbe;
    private Wert wert;
    
    /** Creates a new instance of Karte */
    public Karte(Farbe farbe, Wert wert) {
        this.farbe=farbe;
        this.wert=wert;
    }
    
    public Karte(int f, int w){
        Farbe[] fa = {Farbe.HERZ, Farbe.KARO, Farbe.KREUZ, Farbe.PIK};
        Wert[] we = {Wert.SIEBEN, Wert.ACHT, Wert.NEUN, Wert.ZEHN, Wert.BUBE, Wert.DAME, Wert.KOENIG, Wert.AS};
        this.farbe = fa[f];
        this.wert = we[w];
        
    }
    
    public Wert getWert(){
        return wert;
    }
    
    public Farbe getFarbe(){
        return farbe;
    }
    
    public String toString(){
        return "[" + farbe + " " + wert + "]";
    }
    
}
