package control;

import java.util.Arrays;
import java.util.List;

public interface DepotverwaltungInterface {

    /**
     * Es wird versucht die Aktienanzahl des Depotpostens mit der Id postenId
     * im Depot mit der Id depotId auf die Anzahl anzahl zu aendern, das 
     * Ergebnis gibt an, ob die Aktion erfolgreich war.
     * @param depotID Id des zu bearbeitenden Depots
     * @param postenID Id des Depotpostens im zu bearbeitenden Depot
     * @param anzahl neue Anzahl der Aktie im Depotposten
     * @return war die Aenderung erfolgreich?
     */ 
    boolean aktienanzahlAendern(int depotID, int postenID, int anzahl);

    /**
     * Es wird versucht, dem Depot mit der Id depotID einen neuen Depotposten
     * mit anzahl Aktien der Aktie mit der Id aktienID hinzuzufuegen, das 
     * Ergebnis gibt an, ob die Aktion erfolgreich war.
     * @param depotID Id des zu bearbeitenden Depots
     * @param aktienID Id der hinzuzufuegenden Aktie
     * @param anzahl Anzahl der Aktien, die zum Depotposten gehoeren
     * @return war das Hinzufuegen erfolgreich?
     */
    boolean neuerDepotposten(int depotID, int aktienID, int anzahl);

    /**
     * Es wird ein neues Depot mit der Id id für den Kunden mit der 
     * Kundennummer kundennumer und der Barreserve barreserve angelegt.
     * @param id Id des zu erstellenden Depots
     * @param kundennummer Kundennummer
     * @param barreserve Barreserve des neuen Depots
     */
    void neuesDepot(int id, int kundennummer, int barreserve);

    /**
     * Methode uebergibt ein Objekt, das das Interface AktienveraltungsInterface
     * realisiert.
     * @param aktienverwaltung uebergebenes Objekt zur Aktienverwaltung 
     */
    void setAktienverwaltung(AktienverwaltungInterfaceIntern aktienverwaltung);
    
    /**
     * Es wird ein Depot mit der Id id gesucht, ist es vorhanden, wird
     * es zurueckgegeben, ansonsten null zurueckgegeben.
     * @param id Id des gesuchten Depots
     * @return gefundenes Depot oder null, wenn nicht gefunden
     */
    //Depot sucheDepot(int id);

        /**
     * Es wird ein Depotposten mit der Id postenID im Depot mit der
     * Id depotID gesucht, ist es vorhanden, wird
     * es zurueckgegeben, ansonsten null zurueckgegeben.
     * @param depotID Id des Depots, in dem gesucht werden soll
     * @param postenID Id des Depotpostens, der gesucht werden soll
     * @return gefundenes Depot oder null, wenn nicht gefunden
     */
    //Depotposten sucheDepotpostennummer(int depotID, int postenID);
    
    /**
     * Methode gibt eine Liste aller Depots zurueck, dabei wird jedes
     * Depot wieder als String-Liste zurueckgegeben. Diese String-Liste
     * pro Depot enthaelt in dieser Reihenfolge folgende Werte:
     * Id, Name, Einkaufspreis, Verkaufspreis 
     * Die zum Depot gehoerenden Depotposten werden nicht zurueckgegeben.
     * @return Liste aller Depots, die jeweils als String-Liste
     *         zurueckgegeben werden
     */
    List<List<String>> depots();
    
    /**
     * Methode gibt eine Liste aller Depotposten des Depots mit der Id depotId
     * zurueck, dabei wird jeder Depotposten
     * wieder als String-Liste zurueckgegeben. Diese String-Liste
     * pro Depotposten enthaelt in dieser Reihenfolge folgende Werte:
     * Id des Depots zu dem der Posten gehört, Id des Postens, 
     * Anzahl der Aktien, Name der Aktie, Erstellungsdatum des Postens 
     * @param depotId Id des Depots dessen Depotposten zurueckgegeben 
     *         werden sollen
     * @return Liste aller Depotposten, die jeweils als String-Liste
     *         zurueckgegeben werden
     */
    List<List<String>> depotposten(int depotId);
    
    /**
     * Es wird eine Liste der Ueberschriften einer Tabelle fuer die Ausgabe
     * von Depots zurueckgegeben. Die Ueberschriften passen zu einer Zeile, 
     * die im Ergebnis der Methode depot() steht.
     * @return Liste der Ueberschriften zur Ausgabe von Depots
     */
    default public List<String> ueberschriftenDepots(){
        return Arrays.asList("Id","Kundennr.","Barreserve");
    }
    
    /**
     * Es wird eine Liste der Ueberschriften einer Tabelle fuer die Ausgabe
     * von Depotposten zurueckgegeben. Die Ueberschriften passen zu einer Zeile, 
     * die im Ergebnis der Methode depotposten(int) steht.
     * @return Liste der Ueberschriften zur Ausgabe von Depotposten
     */
    default public List<String> ueberschriftenDepotposten() {
        return Arrays.asList("DepotId", "PostenId", "Anzahl" 
                ,"AktienId", "Aktienname", "Erstellt am");
    }
    
}
