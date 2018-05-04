package tabellenprototyp;

import java.util.List;


public interface Auswertung {
    
    /**
     * Methode erhaelt eine Liste von Werten uebergeben, die in die
     * Tabelle eingefuegt werden sollen, das Ergebnis sollte beschreiben,
     * ob die Aktion erfolgreich war oder den Grund des Misserfolgs.
     * @param eingaben einzutragende Werte
     * @param id Identifikator, um Eingaben diesen Daten zuordnen zu koennen
     * @return Antwort, die Zur Ausgabe als Reaktion auf die Eingabe
     *         genutzt wird
     */
    public String eingeben(List<String> eingaben, final String id);
    
    /** Methode wird bei der Aenderung eines Eintrags in der Zeile zeile und
     * der Spalte Spalte vom Wert alt in den Wert neu in einer Zeile
     * mit dem urspruenglichen Inhalt alteWerte aufgerufen, das Ergebnis 
     * sollte beschreiben, ob die Aktion erfolgreich war oder den Grund des 
     * Misserfolgs. 
     * 
     * @param alteWerte vollstaendige Zeile mit urspruenglichen Werten
     * @param zeile Zeile des neuen Eintrags (die erste Zeilennummer ist 0)
     * @param spalte Spalte des neuen Eintrags (die erste Spaltennummer ist 0)
     * @param alt alter Wert in der betrachteten Zelle
     * @param neu neuer Wert in der Zelle, die uebernommen werden soll
     * @param id Bezeichner der fgenutzten Tabelle
     * @return Antwort, die Zur Ausgabe als Reaktion auf die Eingabe
     *         genutzt wird
     */
    public String aendern(List<String> alteWerte, final int zeile
            , final int spalte, final String alt, final String neu
            , final String id);
    
    /** Methode wird beim Loeschen eines Eintrags in der Zeile zeile 
     * aufgerufen, das Ergebnis 
     * sollte beschreiben, ob die Aktion erfolgreich war oder den Grund des 
     * Misserfolgs.     * 
     * @param alteWerte vollstaendige Zeile mit urspruenglichen Werten
     * @param zeile Zeile des neuen Eintrags (die erste Zeilennummer ist 0)
     * @param id Bezeichner der genutzten Tabelle
     * @return Antwort, die Zur Ausgabe als Reaktion auf die Eingabe
     *         genutzt wird
     */
    public String loeschen(List<String> alteWerte, int zeile, final String id);
}
