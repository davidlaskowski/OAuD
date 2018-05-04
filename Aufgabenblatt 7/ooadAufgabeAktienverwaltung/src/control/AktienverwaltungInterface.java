package control;

import java.util.Arrays;
import java.util.List;

public interface AktienverwaltungInterface {

    /**
     * Der Einkaufspreis einer Aktie mit der Id aktienID wird
     * auf preisneu gesetzt.
     * @param aktienID Id der zu aendernden Aktie
     * @param preisneu neuer Einkaufspreis
     */
    void einkaufspreisAendern(int aktienID, int preisneu);

    /**
     * Es wird eine neue Aktie mit der Id id, dem Namen name, dem
     * Einkaufspreis epreis und dem Verkaufspreis vpreis angelegt.
     * @param id Id der neuen Aktie
     * @param name Name der neuen Aktie
     * @param epreis Einkaufspreis der neuen Aktie
     * @param vpreis Verkaufsptreis der neuen Aktie
     */
    void neueAktie(int id, String name, int epreis, int vpreis);

    /**
     * Es wird eine Aktie mit der Id id gesucht, ist sie vorhanden, wird
     * sie zurueckgegeben, ansonsten null zurueckgegeben.
     * @param id Id der gesuchten Aktie
     * @return gefundene Aktie oder null, wenn nicht gefunden
     */
    //Aktie sucheAktie(int id);

     /**
     * Der Verkaufspreis einer Aktie mit der Id aktienID wird
     * auf preisneu gesetzt.
     * @param aktienID Id der zu aendernden Aktie
     * @param preisneu neuer Verkaufspreis
     */
    void verkaufspreisAendern(int aktienID, int preisneu);
    
    /**
     * Methode gibt eine Liste aller Aktien zurueck, dabei wird jede
     * Aktie selbst als String-Liste zurueckgegeben. Diese String-Liste
     * pro Aktie enthaelt in dieser Reihenfolge folgende Werte:
     * Id, Name, Einkaufspreis, Verkaufspreis 
     * @return Liste aller Aktien, die jeweils als String-Liste
     *         zurueckgegeben werden
     */
    List<List<String>> aktien();
    
    // Hinweis: default-Methoden in Interfaces müssen nicht ueberschrieben 
    // werden. Sie sind einfache Moeglichkeiten Interfaces zu erweitern.
    /**
     * Es wird eine Liste der Ueberschriften einer Tabelle fuer die Ausgabe
     * von Aktien zurueckgegeben. Die Ueberschriften passen zu einer Zeile, 
     * die im Ergebnis der Methode aktien() steht.
     * @return Liste der Ueberschriften zur Ausga be von Aktien
     */
    default public List<String> ueberschriften() {
        return Arrays.asList("Id", "Name", "Einkaufspreis", "Verkaufspreis");
    }
    
}
