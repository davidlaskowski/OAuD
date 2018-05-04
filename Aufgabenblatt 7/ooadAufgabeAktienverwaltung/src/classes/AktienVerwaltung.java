package classes;

import control.AktienverwaltungInterface;
import control.AktienverwaltungInterfaceIntern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AktienVerwaltung implements AktienverwaltungInterface,AktienverwaltungInterfaceIntern{
    private Map<Integer, Aktie> aktienListe;

    public AktienVerwaltung() {
        this.aktienListe = new HashMap<Integer, Aktie>();
    }
    
    @Override
    public void einkaufspreisAendern(int aktienID, int preisneu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void neueAktie(int id, String name, int epreis, int vpreis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verkaufspreisAendern(int aktienID, int preisneu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<String>> aktien() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> ueberschriften() {
        return AktienverwaltungInterfaceIntern.super.ueberschriften(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aktie sucheAktie(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
