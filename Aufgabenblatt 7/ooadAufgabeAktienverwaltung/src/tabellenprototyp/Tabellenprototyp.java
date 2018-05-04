package tabellenprototyp;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/*
Sollte in einer der Aktionen von Auswertung (eingeben, aendern, loeschen)
ein Neuzeichnen aufgerufen werden, ist dieses in
ein Platform.invokelater() einzubetten !!
    Platform.runLater(() -> {
        //erst nach Abarbeitung des zugehoerigen Events
        this.TabelleNeuZeichnen()
    });
*/

/*
TODO:
- bei Eingabe wird z. Zt. nur das aktuelle Feld uebernommen,
  sinnvoll waere die Uebernahme der gesamten Zeile
- bei Eingaben in Tabelle auch ChoiceBox erlauben, dies
  muss dann statt der Liste mit aenderbaren Feldindexen
  uebergeben werden
- nicht nur ChoiceBox sondern auch Ergaenzung um neue
  Eingabemoeglichkeit ergaenzen
- ersten beiden Kopfzeilen sollten nicht mitscrollen
 */
public class Tabellenprototyp {

    private final Auswertung auswertung;
    private final Label kommentar = new Label();

    private int zeilen;
    private int spalten;
    private Control[][] elemente;
    private GridPane ergebnis = new GridPane();
    private boolean fokus = false;
    private int fokusx;
    private int fokusy;

    public Tabellenprototyp(Auswertung auswertung) {
        this.auswertung = auswertung;
    }

    /**
     * Methode zur Ausgabe einer Tabelle, die als Liste von Listen üebergeben
     * wird. Die Parameter ermoeglich die Nutrzung einer Eingabezeile.
     *
     * @param ueberschriften Liste der Ueberschriften der Spalten
     * @param ergebnisse Liste von Listen der auszugebenden Werte, jede innere
     * Liste entspricht einer Zeile
     * @param action Liste von Spaltennummern von Spalten, deren Inhalt
     * veraendert werden kann, Spaltennummern beginnen mit 0
     * @param eingabearten Liste der Arten der Eingabe pro Spalte, dabei haben
     * die folgende Werte eine Bedeutung: 
     * null: Wert kann nicht eingegeben
     * werden 
     * leere Liste: einfaches Eingabefeld für neuen Wert 
     * gefuellte Liste:
     * Auswahlfeld (Dropdown) mit den uebergebenen Werten
     * @param id: um mehrere Tabellen bei Eingaben unterscheiden zu koennen,
     * wird dieser Parameter bei Eingaben wieder mit uebergeben.
     * @return Tabelle mit optionalen Eingabemoeglichkeiten
     */
    public GridPane fuelleErgebnisausgabe(List<String> ueberschriften,
            List<List<String>> ergebnisse, List<Integer> action,
            List<List<String>> eingabearten, String id) {

        this.zeilen = ergebnisse.size();
        this.spalten = ueberschriften.size();

        // Zusatzzeile fuer Ueberschriften
        this.elemente = new Control[this.zeilen + 2][this.spalten];
        this.ergebnis = new GridPane();
        this.ergebnis.setPadding(new Insets(5));
        ergebnisse.add(0, ueberschriften);
        //this.ergebnisausgabe.setGridLinesVisible(true);
        this.ergebnis.setHgap(5);
        
        // Steuerung fuer Eingabefelder
        EventHandler<ActionEvent> enterTaste = e -> {
            List<String> werte = new ArrayList<>(); // eingegebene Werte
            for (int i = 0; i < eingabearten.size(); i++) {
                List<String> art = eingabearten.get(i);
                if (art == null) {
                    werte.add(null);
                } else {
                    if (art.isEmpty()) {
                        werte.add(((TextField) (this.elemente[0][i])).getText());
                    } else {
                        werte.add(((ChoiceBox) (this.elemente[0][i]))
                                .getSelectionModel().getSelectedItem().toString());
                    }
                }
            }
            this.kommentar.setText(this.auswertung.eingeben(werte, id));

        };

        //Erstellung der Eingabezeile und des Knopfes
        int eingabe = 2; // zwei Eingabezeilen zusaetzlich (0 wenn keine Eingabe)
        for (int i = 0; i < eingabearten.size(); i++) { // Erstellung Eingabefelder
            List<String> art = eingabearten.get(i);
            if (art == null) {
                this.elemente[0][i] = null;
                //Label leer = new Label("");               
            } else {
                if (art.isEmpty()) {
                    TextField feld = new TextField("");
                    feld.setOnAction(enterTaste);
                    this.ergebnis.add(feld, i, 1);
                    this.elemente[0][i] = feld;
                } else {
                    ChoiceBox<String> feld = new ChoiceBox<>();
                    ObservableList list = FXCollections.observableArrayList();
                    list.addAll(art);
                    feld.setItems(list);
                    feld.getSelectionModel().select(0);
                    this.elemente[0][i] = feld;
                    this.ergebnis.add(feld, i, 1);
                }
            }
        }

        Button eintragen = new Button("eintragen");

        GridPane.setHalignment(eintragen, HPos.RIGHT);
        this.ergebnis.add(eintragen, ueberschriften.size() - 1, 0);
        eintragen.setOnAction(enterTaste);
        this.ergebnis.add(this.kommentar, 0, 0, ueberschriften.size() - 1, 1);

        // eigentliche Tabelle
        for (int i = 0; i < ergebnisse.size(); i++) {
            List<String> tmp = ergebnisse.get(i);
            if (tmp.size() != ueberschriften.size()) {
                throw new IllegalArgumentException(
                        "Zeile hat falsche Laenge: " + tmp
                        + "\n hat Laenge: " + tmp.size()
                        + " geforderte Laenge: " + ueberschriften.size());
            }

            for (int j = 0; j < tmp.size(); j++) {
                if (action.contains(j) && i != 0) { // aenderbares Feld
                    final int zeile = i;
                    final int spalte = j;
                    final String inhalt = tmp.get(j);
                    TextField feld = new TextField(inhalt);
                    feld.setOnAction(e -> {
                        //System.out.println("tmp: " + tmp);
                        this.kommentar.setText(this.auswertung.aendern(tmp
                                 , zeile - eingabe
                                 , spalte, inhalt, feld.getText(), id));
                        this.fokus = true;
                        this.fokusx = zeile+1;
                        this.fokusy = spalte;
                    });
                    this.ergebnis.add(feld, j, i + eingabe);
                    this.elemente[i + 1][j] = feld;
                } else {
                    Label lbl = new Label(tmp.get(j));
                    if (i == 0) { // Ueberschrift
                        Font font = lbl.getFont();
                        lbl.setFont(Font.font(font.getName(),
                                FontWeight.EXTRA_BOLD, font.getSize() + 1));
                        lbl.setTextAlignment(TextAlignment.CENTER);
                        lbl.setUnderline(true);
                    } else {
                        lbl.setMinHeight(20);
                    }

                    this.ergebnis.add(lbl, j, i + eingabe);
                    this.elemente[i + 1][j] = lbl;
                }
            }
            if (i != 0) {
                final int zeile = i;
                Button loeschen = new Button("X");
                loeschen.setOnAction(e -> {
                    this.kommentar.setText(this.auswertung.loeschen(tmp, zeile, id));
                });
                this.ergebnis.add(loeschen, this.spalten, i + eingabe);

            }
        }
        ergebnisse.remove(0);

        if (this.fokus) {
            Platform.runLater(() -> {
                this.elemente[this.fokusx][this.fokusy].requestFocus();
            });
            this.fokus = false;
        }
        return this.ergebnis;
    }

    /**
     * Methode zur Aenderung des in der Tabelle angezeigten Kommentars. Die kann
     * notwendig sein, wenn der Text veraltet ist, oder ein neuer Hinweis
     * ausgegeben werden soll.
     *
     * @param text auszugebender Text
     */
    public void kommentar(String text) {
        this.kommentar.setText(text);
    }
}
