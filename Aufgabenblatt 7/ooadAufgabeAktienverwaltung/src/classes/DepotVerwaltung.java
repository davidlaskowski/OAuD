package classes;

import control.AktienverwaltungInterfaceIntern;
import control.DepotverwaltungInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepotVerwaltung implements DepotverwaltungInterface {
    AktienVerwaltung aktienVerwaltung;
    private Map<Integer, Depot> depotListe;

    public DepotVerwaltung() {
        this.aktienVerwaltung = new AktienVerwaltung();
        this.depotListe = new HashMap<>();
    }

    @Override
    public boolean aktienanzahlAendern(int depotID, int postenID, int anzahl) {
        Depot currentDepot = depotListe.get(depotID);
        if(currentDepot == null)
            return false;
        DepotPosten currentDepotPosten = currentDepot.depotPostenSuchen(postenID);
        if(currentDepotPosten == null)
            return false;
        if(currentDepotPosten.getAktie().getEinkaufsPreis() * anzahl > currentDepot.getBarReserven())
            return false;
        currentDepotPosten.aktienAnzahlAendern(anzahl);
        return true;
        
    }

    @Override
    public boolean neuerDepotposten(int depotID, int aktienID, int anzahl) {
        Depot currentDepot = depotListe.get(depotID);
        if(currentDepot == null)
            return false;
        Aktie currentAktie = aktienVerwaltung.sucheAktie(aktienID);
        if(currentAktie == null)
            return false;
        if(currentAktie.getEinkaufsPreis() * anzahl > currentDepot.getBarReserven())
            return false;
        currentDepot.neuenDepotPostenAnlegen(currentAktie, anzahl);
        return true;
    }

    @Override
    public void neuesDepot(int id, int kundennummer, int barreserve) {
        Depot neuesDepot = new Depot(id, kundennummer, barreserve);
        depotListe.put(id, neuesDepot);
    }

    @Override
    public void setAktienverwaltung(AktienverwaltungInterfaceIntern aktienVerwaltung) {
        this.aktienVerwaltung = (AktienVerwaltung) aktienVerwaltung;
    }

    @Override
    public List<List<String>> depots() {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, Depot> map = depotListe;
        List<Depot> alleDepots = new ArrayList<>(depotListe.values());
        for(Map.Entry<Integer, Depot> me : map.entrySet()){
            result.add(me.getValue().toStringList());
        }
        return result;
    }

    @Override
    public List<List<String>> depotposten(int depotId) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, DepotPosten> map = depotListe.get(depotId).getDepotPostenListe();
        for(Map.Entry<Integer, DepotPosten> me : map.entrySet()){
            result.add(me.getValue().toStringList());
        }
        return result;
    }

    @Override
    public Depot sucheDepot(int id) {
        return depotListe.get(id);
    }
    
}
