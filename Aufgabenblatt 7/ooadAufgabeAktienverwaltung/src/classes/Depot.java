package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Depot {
    private int id;
    private int kundenNummer;
    private int barReserven;
    private Map<Integer,DepotPosten> depotPostenListe;

    public Depot() {
        this.depotPostenListe = new HashMap<>();
    }

    public Depot(int id, int kundenNummer, int barReserven) {
        this.id = id;
        this.kundenNummer = kundenNummer;
        this.barReserven = barReserven;
        this.depotPostenListe = new HashMap();
    }

    public int getBarReserven() {
        return barReserven;
    }
    
    

    public Map<Integer, DepotPosten> getDepotPostenListe() {
        return this.depotPostenListe;
    }
    
    public DepotPosten depotPostenSuchen(int index){
        return this.depotPostenListe.get(index);
    }
    
    public void neuenDepotPostenAnlegen(Aktie aktie, int anzahl){
        DepotPosten neuerDepotPosten = new DepotPosten(this.id, this.id * 1000 + this.depotPostenListe.size(),aktie, anzahl);
        this.depotPostenListe.put(this.depotPostenListe.size(), neuerDepotPosten);
    }
    
    public List<String> toStringList(){
        List result = new ArrayList<>();
        result.add(Integer.toString(this.id));
        result.add(Integer.toString(this.kundenNummer));
        result.add(Integer.toString(this.barReserven));
        return result;
    }
}
