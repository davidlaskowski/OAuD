package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DepotPosten {
    private int depotId;
    private int postenId;
    private int anzahl;
    private Date erstellDatum;
    private Aktie aktie;

    public DepotPosten() {
        aktie = new Aktie();
        erstellDatum = new Date();
    }

    /*Änderung: Anpassung Konstruktor um Referenz auf Aktie übergeben zu können
    Von DepotPosten(int,int) zu DepotPosten(int, Aktie, int)*/
    public DepotPosten(int depotId, int postenId, Aktie aktie, int anzahl) {
        this.depotId = depotId;
        this.postenId = postenId;
        this.aktie = aktie;
        this.anzahl = anzahl;
        erstellDatum = new Date();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,0);
        erstellDatum = c.getTime();
    }

    public Aktie getAktie() {
        return aktie;
    }
    
    
    public void aktienAnzahlAendern(int aktienAnzahl){
        
        this.anzahl = aktienAnzahl;
    }
    
    public List<String> toStringList(){
        List result = new ArrayList<>();
        result.add(Integer.toString(this.depotId));
        result.add(Integer.toString(this.postenId));
        result.add(Integer.toString(this.anzahl));
        result.add(Integer.toString(this.aktie.getId()));
        result.add(this.aktie.getName());
        result.add(this.erstellDatum.toString());
        return result;
    }

    @Override
    public String toString() {
        return "DepotPosten{ anzahl=" + anzahl + ", erstellDatum=" + erstellDatum + ", aktie=" + aktie + '}';
    }
    
    
}
