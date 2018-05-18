package classes;

import control.AktienverwaltungInterface;
import control.AktienverwaltungInterfaceIntern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AktienVerwaltung implements AktienverwaltungInterfaceIntern{
    private Map<Integer, Aktie> aktienListe;

    public AktienVerwaltung() {
        this.aktienListe = new HashMap<Integer, Aktie>();
    }
    
    @Override
    public void einkaufspreisAendern(int aktienID, int preisneu) {
        this.aktienListe.get(aktienID).setEinkaufsPreis(preisneu);
    }

    @Override
    public void neueAktie(int id, String name, int epreis, int vpreis) {
        this.aktienListe.put(id, new Aktie(id, name, epreis, vpreis));
    }

    @Override
    public void verkaufspreisAendern(int aktienID, int preisneu) {
        this.aktienListe.get(aktienID).setVerkaufsPreis(preisneu);
    }

    @Override
    public List<List<String>> aktien() {
        List<List<String>> result = new ArrayList<>();
        List<Aktie> alleAktien = new ArrayList<>(aktienListe.values());
        for(Aktie a : alleAktien){
            result.add(a.toStringList());
        }
        return result;
    }

    @Override
    public Aktie sucheAktie(int id) {
        return aktienListe.get(id);
    }
    
    
}
