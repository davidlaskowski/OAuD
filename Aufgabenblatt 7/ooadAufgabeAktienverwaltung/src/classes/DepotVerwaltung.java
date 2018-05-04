package classes;


import control.AktienverwaltungInterfaceIntern;
import control.DepotverwaltungInterface;
import java.util.ArrayList;
import java.util.List;

public class DepotVerwaltung implements DepotverwaltungInterface {
    List<Depot> depotListe;

    public DepotVerwaltung() {
        depotListe = new ArrayList<Depot>();
    }
    
    @Override
    public boolean aktienanzahlAendern(int depotID, int postenID, int anzahl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean neuerDepotposten(int depotID, int aktienID, int anzahl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void neuesDepot(int id, int kundennummer, int barreserve) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAktienverwaltung(AktienverwaltungInterfaceIntern aktienverwaltung) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<String>> depots() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<String>> depotposten(int depotId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> ueberschriftenDepots() {
        return DepotverwaltungInterface.super.ueberschriftenDepots(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> ueberschriftenDepotposten() {
        return DepotverwaltungInterface.super.ueberschriftenDepotposten(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
