package boundary;

import control.AktienverwaltungInterface;
import control.AktienverwaltungInterfaceIntern;
import control.DepotverwaltungInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tabellenprototyp.Auswertung;
import tabellenprototyp.Tabellenprototyp;

/* Prototypische Implementierung, um Datenzusammenhaenge zu visualisieren */
public class GUI extends Application implements Auswertung {

    private GridPane root;

    private Tabellenprototyp tbAktie = new Tabellenprototyp(this);
    private ScrollPane scAktie = new ScrollPane();
    private AktienverwaltungInterfaceIntern av;
    private int aktienIDGenerator = 42;

    private Tabellenprototyp tbDepot = new Tabellenprototyp(this);
    private ScrollPane scDepot = new ScrollPane();
    private DepotverwaltungInterface dv;
    private int dvIDGenerator = 442;

    private Tabellenprototyp tbDepotposten = new Tabellenprototyp(this);
    private ScrollPane scDepotposten = new ScrollPane();

    /**
     * Methode sucht passende Klassen, die die Interfaces
     * AktienverwaltungInterfaceIntern und DepotverwaltungInterface realisieren
     */
    private void starten(){
        Alle.alleKlassen().forEach(k ->{
            if(Alle.klasseImplementiertInterface(k
                    , "control.AktienverwaltungInterfaceIntern")){
                try {
                    this.av = (AktienverwaltungInterfaceIntern) Class
                            .forName(k).newInstance();
                } catch (ClassNotFoundException | InstantiationException 
                        | IllegalAccessException ex) {
                    System.out.println("Implementierung von "
                            + "AktienverwaltungInterface " + k + "fehlt "
                            + "sichtbarer parameterloser Konstruktor");
                } 
            }
            if(Alle.klasseImplementiertInterface(k
                    , "control.DepotverwaltungInterface")){
                try {
                    this.dv = (DepotverwaltungInterface) Class
                            .forName(k).newInstance();
                } catch (ClassNotFoundException | InstantiationException 
                        | IllegalAccessException ex) {
                    System.out.println("Implementierung von "
                            + "DepotverwaltungInterface " + k + "fehlt "
                            + "sichtbarer parameterloser Konstruktor");
                } 
            }
        });
        if (this.av == null || this.dv == null){
            System.out.println(av + " " + dv);
            System.out.println("Implementierung der geforderten Interfaces mit "
                    + "sichtbarem parameterlosen Konstruktor nicht gefunden");
            System.exit(-1);
        }
        this.dv.setAktienverwaltung(this.av);
    }
    
    @Override
    public void init() {

        this.starten();
        this.av.neueAktie(this.aktienIDGenerator++, "Kwik-E_mart", 50, 47);
        this.av.neueAktie(this.aktienIDGenerator++, "Mapple Store", 2, 1);
        this.av.neueAktie(this.aktienIDGenerator++, "Krusty Burger", 23, 21);
        this.av.neueAktie(this.aktienIDGenerator++, "Duff", 123, 100);
        this.av.neueAktie(this.aktienIDGenerator++, "Buzz Cola", 456, 366);

        this.dv.neuesDepot(this.dvIDGenerator++, 73, 10000);
        this.dv.neuesDepot(this.dvIDGenerator++, 73, 20000);
        this.dv.neuesDepot(this.dvIDGenerator++, 74, 10000);
        this.dv.neuesDepot(this.dvIDGenerator++, 75, 40000);
        this.dv.neuesDepot(this.dvIDGenerator++, 76, 30000);
        this.dv.neuesDepot(this.dvIDGenerator++, 77, 20000);
        
        this.dv.neuerDepotposten(442, 42, 10);
        this.dv.neuerDepotposten(442, 43, 1000);
        this.dv.neuerDepotposten(442, 44, 200);
        this.dv.neuerDepotposten(443, 44, 187);
        this.dv.neuerDepotposten(443, 45, 4);
        this.dv.neuerDepotposten(444, 45, 100);
        this.dv.neuerDepotposten(445, 46, 20);
    }

    @Override
    public String aendern(final List<String> alles, final int zeile, final int spalte,
             final String alt, final String neu, final String id) {
        this.kommentareLoeschen();
        switch (id) {
            case "Aktie": {
                try {
                    int aid = Integer.parseInt(alles.get(0));
                    int ein = Integer.parseInt(alles.get(2));
                    if (spalte == 2){
                        ein = Integer.parseInt(neu);
                    }
                    int ver = Integer.parseInt(alles.get(3));
                    if (spalte == 3){
                        ver = Integer.parseInt(neu);
                    }
                    if (ein < 0 || ver < 0){
                        Platform.runLater(() -> {
                            this.aktienZeigen();
                        });
                        return ("keine negativen Eingaben");
                    }
                    
                    this.av.einkaufspreisAendern(aid, ein);
                    this.av.verkaufspreisAendern(aid, ver);
                    Platform.runLater(() -> {
                            this.aktienZeigen();
                    });
                    return "Eingaben uebernommen";
                } catch (Exception e) {
                    Platform.runLater(() -> {
                            this.aktienZeigen();
                    });
                    return "Eingaben fehlerhaft";
                }
            }
            case "Depot": {
                try { // zur Zeit keine Aenderungen in Tabelle moeglich
                } catch (Exception e) {
                    return "Eingaben fehlerhaft";
                }
            }
            case "Depotposten": {
                try {  
                    int depot = Integer.parseInt(alles.get(0));
                    int posten = Integer.parseInt(alles.get(1));
                    int anzahl = Integer.parseInt(neu);
                                       
                    if (anzahl < 0){
                        Platform.runLater(() -> {
                            this.depotpostenZeigen();
                        });
                        return "keine negativen Eingaben";
                    }
                    if(this.dv.aktienanzahlAendern(depot, posten, anzahl)){
                        Platform.runLater(() -> {
                            this.depotsZeigen();
                            this.depotpostenZeigen();
                        });
                        return "Aenderung erfolgreich";
                    } else {
                        Platform.runLater(() -> {
                            this.depotpostenZeigen();
                        });
                        return "Aenderung nicht durchfüehrbar";
                    }
               
                } catch (Exception e) {
                    return "Eingaben fehlerhaft";
                }
            }
        }
                
                
        return alles + " " + zeile + " " + spalte + " " + alt + " " + neu;
    }

    @Override
    public String eingeben(List<String> eingaben, String id) {
        this.kommentareLoeschen();
        switch (id) {
            case "Aktie": {
                try {
                    int ein = Integer.parseInt(eingaben.get(2));
                    int ver = Integer.parseInt(eingaben.get(3));
                    
                    if (ein < 0 || ver < 0){
                        this.aktienZeigen();
                        return ("keine negativen Eingaben");
                    }
                    
                    if (eingaben.get(1).trim().equals("")){
                        this.aktienZeigen();
                        return ("keine leeren Namen");
                    }
                    this.av.neueAktie(this.aktienIDGenerator++,
                             eingaben.get(1), ein, ver);
                    this.aktienZeigen();
                    this.depotpostenZeigen();
                    return "Eingaben uebernommen";
                } catch (Exception e) {
                    return "Eingaben fehlerhaft";
                }
            }
            case "Depot": {
                try {
                    int knr = Integer.parseInt(eingaben.get(1));
                    int bar = Integer.parseInt(eingaben.get(2));
                    if (knr < 0 || bar < 0){
                        this.aktienZeigen();
                        return ("keine negativen Eingaben");
                    }
                    
                    this.dv.neuesDepot(this.dvIDGenerator++, knr, bar);
                    this.depotsZeigen();
                    this.depotpostenZeigen();
                    return "Eingaben uebernommen";
                } catch (Exception e) {
                    return "Eingaben fehlerhaft";
                }
            }
            case "Depotposten": {
                try {
                    int depot = Integer.parseInt(eingaben.get(0));
                    int anzahl = Integer.parseInt(eingaben.get(2));
                    int aktie = Integer.parseInt(eingaben.get(3));
                    if (anzahl < 0){
                        this.aktienZeigen();
                        return ("keine negativen Eingaben");
                    }
                    
                    if (this.dv.neuerDepotposten(depot, aktie, anzahl)) {                       
                        this.depotsZeigen();
                        this.depotpostenZeigen();
                        return "Eingaben uebernommen";
                    } else {
                        return "Die Kohle reicht nicht aus";
                    }
                } catch (Exception e) {
                    return "Eingaben fehlerhaft";
                }
            }
        }
        return eingaben.toString();
    }

    @Override
    public String loeschen(List<String> alteWerte, int zeile, final String id){
        this.kommentareLoeschen();
        return "folgt im naechsten Sprint";
        //return alteWerte + " loeschen folgt im naechsten Sprint";
    }
    
    private void kommentareLoeschen(){
        this.tbAktie.kommentar("");
        this.tbDepot.kommentar("");
        this.tbDepotposten.kommentar("");
    }
            
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.root = new GridPane();
        this.root.setPadding(new Insets(5));
        this.root.setHgap(5);
        this.root.setVgap(5);

        this.root.add(new Label("Depots"), 0, 0);
        this.depotsZeigen();
        this.scDepot.setMinHeight(250);
        this.scDepot.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.root.add(this.scDepot, 0, 1);

        this.root.add(new Label("Aktien"), 1, 0);
        this.aktienZeigen();
        this.scAktie.setMinHeight(250);
        this.scAktie.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.root.add(this.scAktie, 1, 1);

        this.root.add(new Label("Depotposten"), 0, 2);
        this.depotpostenZeigen();
        this.scDepotposten.setMinHeight(250);
        this.scDepotposten.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.root.add(this.scDepotposten, 0, 3, 2, 1);

        Scene scene = new Scene(root); 
        //Scene scene = new Scene(new ScrollPane(root)); //,1214,658);
        primaryStage.setTitle("Depotverwaltung (Prototyp)");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
        });
        primaryStage.show();
    }

    private void aktienZeigen() {
        
        List<List<String>> tmp = new ArrayList<>();
        tmp.add(null);
        tmp.add(new ArrayList<>());
        tmp.add(new ArrayList<>());
        tmp.add(new ArrayList<>());
        this.scAktie.setContent(this.tbAktie.fuelleErgebnisausgabe
                (this.av.ueberschriften(),
                 this.av.aktien(), new ArrayList<>(Arrays.asList(2, 3)),
                 tmp, "Aktie"));
    }

    private void depotsZeigen() {
        List<List<String>> tmp = new ArrayList<>();
        tmp.add(null);
        tmp.add(new ArrayList<>());
        tmp.add(new ArrayList<>());
        this.scDepot.setContent(this.tbDepot.fuelleErgebnisausgabe
                (this.dv.ueberschriftenDepots()
                 , this.dv.depots(), new ArrayList<>(Arrays.asList())
                 , tmp, "Depot"));
    }

    private void depotpostenZeigen() {
        List<List<String>> daten = new ArrayList<>();
        List<String> depotIds = new ArrayList<>();
        this.dv.depots().forEach(d -> {
            depotIds.add(d.get(0));
            daten.addAll(this.dv.depotposten(Integer.parseInt(d.get(0))));
        });

        List<String> aktieIds = new ArrayList<>();
        this.av.aktien().forEach(a -> {
            aktieIds.add(a.get(0));
        });

        List<List<String>> tmp = new ArrayList<>();
        tmp.add(depotIds);
        tmp.add(null);
        tmp.add(new ArrayList<>());
        tmp.add(aktieIds);
        tmp.add(null);

        this.scDepotposten.setContent(this.tbDepotposten.fuelleErgebnisausgabe
                (this.dv.ueberschriftenDepotposten()
                 ,daten, new ArrayList<>(Arrays.asList(2))
                 ,tmp, "Depotposten"));
    }

    public static void main(String[] args) {
        GUI.launch(args);
    }
}
