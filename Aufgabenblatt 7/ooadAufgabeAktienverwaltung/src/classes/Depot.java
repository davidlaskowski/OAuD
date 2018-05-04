package classes;

import java.util.ArrayList;
import java.util.List;

public class Depot {
    private int id;
    private int kundenNummer;
    private int barResever;
    private List<DepotPosten> depotPostenListe;

    public Depot() {
    }

    public Depot(int id, int kundenNummer, int barResever) {
        this.id = id;
        this.kundenNummer = kundenNummer;
        this.barResever = barResever;
        this.depotPostenListe = new ArrayList<DepotPosten>();
    }
    
    public DepotPosten depotPostenSuchen(int index){
        return null;
    }
    
    public void neuenDepotPostenAnlegen(int index, int aktienIndex){
        
    }
    
    public boolean gibtEsAktieId(int index){
        return false;
    }
    
    public void pruefungBarReserve(){
        
    }
    
}
