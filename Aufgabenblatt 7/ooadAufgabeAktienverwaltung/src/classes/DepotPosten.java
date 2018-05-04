package classes;

import java.util.Date;

public class DepotPosten {
    private int id;
    private int anzahl;
    private Date erstellDatum;
    private Aktie aktie;

    public DepotPosten() {
    }

    /*Änderung: Anpassung Konstruktor um Referenz auf Aktie übergeben zu können
    Von DepotPosten(int,int) zu DepotPosten(int, Aktie, int)*/
    public DepotPosten(int id, Aktie aktie, int anzahl) {
        this.id = id;
        this.aktie = aktie;
        this.anzahl = anzahl;
        this.erstellDatum = new Date(); 
    }
    
    public void aktienAnzahlAendern(int aktienAnzahl){
        this.anzahl = aktienAnzahl;
    }

    @Override
    public String toString() {
        return "DepotPosten{" + "id=" + id + ", anzahl=" + anzahl + ", erstellDatum=" + erstellDatum + ", aktie=" + aktie + '}';
    }
    
    
}
