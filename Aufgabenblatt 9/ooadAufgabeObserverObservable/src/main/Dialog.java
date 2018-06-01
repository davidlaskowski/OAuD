package main;

import Boards.AbteilungsBoardVerwaltung;
import Boards.AbteilungsWhiteBoard;
import Boards.ProjektBoardVerwaltung;
import Boards.ProjektWhiteBoard;
import Mitarbeiter.Mitarbeiter;
import java.util.ArrayList;
import java.util.List;


// TODO
// Diese Klasse ist zu erweitern, die angegebenen Methoden u. a. 
// zu ergaenzen.

public class Dialog {
    List<Mitarbeiter> mitarbeiterList;
    List<ProjektWhiteBoard> projektWhiteBoards;
    List<AbteilungsWhiteBoard> abteilungsWhiteBoards;
    
    public Dialog(){
        this.mitarbeiterList = new ArrayList<>();
        this.projektWhiteBoards = new ArrayList<>();
        this.abteilungsWhiteBoards = new ArrayList<>();
    }

    public int auswahl() {
        System.out.print("Was wollen Sie machen?\n"
                + " (0) Programm beenden\n"
                + " (1) Mitarbeiter anlegen\n"
                + " (2) Projektwhiteboard anlegen\n"
                + " (3) Abteilungswhiteboard anlegen\n"
                + " (4) Mitarbeiter bei Projektwhiteboard anmelden\n"
                + " (5) Projekt bei Abteilungswhiteboard anmelden\n"
                + " (6) Information auf Projektwhiteboard\n"
                + " (7) Information auf Abteilungswhiteboard\n"
                + " (8) Uebersicht\n"
        );
        return Eingabe.leseInt();
    }

    public void schleife() {
        int eingabe = -1;
        while (eingabe != 0) {
            eingabe = this.auswahl();
            switch (eingabe) {
                case 1: {
                    mitarbeiterHinzufuegen();
                    break;
                }
                case 2: {
                    projektwhiteboardHinzufuegen();
                    break;
                }
                case 3: {
                    abteilungswhiteboardHinzufuegen();
                    break;
                }
                case 4: {
                    mitarbeiterAnmelden();
                    break;
                }
                case 5: {
                    projektAnmelden();
                    break;
                }
                case 6: {
                    projektwhiteboardBeschreiben();
                    break;
                }
                case 7: {
                    abteilungswhiteboardBeschreiben();
                    break;
                }
                case 8: {
                    uebersichtAnzeigen();
                    break;
                }                
            }
        }
    }

    public int auswahl(List<?> liste) {
        System.out.println(" (0) Aktion abbrechen");
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(" (" + (i + 1) + ") " + liste.get(i));
        }
        System.out.print("Welches Element: ");
        return Eingabe.leseInt() - 1;
    }

    public void mitarbeiterHinzufuegen() {
        System.out.print("Name: ");
        String name = Eingabe.leseString();
        System.out.print("Mitarbeiternummer: ");
        int minr = Eingabe.leseInt();
        Mitarbeiter mitarbeiter = new Mitarbeiter(minr, name);
        this.mitarbeiterList.add(mitarbeiter);
        
    }

    public void projektwhiteboardHinzufuegen() {
        System.out.print("Projekt: ");
        String projekt = Eingabe.leseString();
        ProjektWhiteBoard projektWhiteBoard = new ProjektWhiteBoard(projekt);
        this.projektWhiteBoards.add(projektWhiteBoard);
    }

    public void abteilungswhiteboardHinzufuegen() {
        System.out.print("Abteilung: ");
        String abteilung = Eingabe.leseString();
        System.out.print("Abteilungsnummer: ");
        int abtnr = Eingabe.leseInt();
        AbteilungsWhiteBoard abteilungsWhiteBoard = new AbteilungsWhiteBoard(abteilung, abtnr);
        this.abteilungsWhiteBoards.add(abteilungsWhiteBoard);
        
    }

    public void mitarbeiterAnmelden() {
        System.out.println("Welcher Mitarbeiter?");
        System.out.println("(0) Aktion abbrechen");
        for(int i = 0; i < this.mitarbeiterList.size(); i++){
            System.out.println("(" + (i+1) + ") " + this.mitarbeiterList.get(i).toString());
        }
        int mitarbeiterAuswahl = Eingabe.leseInt();
        if(mitarbeiterAuswahl == 0)
            return;
        
        
        System.out.println("Bei welchem Projekt?");
        System.out.println("(0) Aktion abbrechen");
        for(int i = 0; i < this.projektWhiteBoards.size(); i++){
            System.out.println("(" + (i+1) + ") " + this.projektWhiteBoards.get(i).toString());
        }
        int projektAuswahl = Eingabe.leseInt();
        if(projektAuswahl == 0)
            return;
        this.mitarbeiterList.get(mitarbeiterAuswahl-1).neuesProjektBoard(this.projektWhiteBoards.get(projektAuswahl-1));
    }

    public void projektAnmelden() {
        System.out.println("Welches Projekt?");
        System.out.println("(0) Aktion abbrechen");
        for(int i = 0; i < this.projektWhiteBoards.size(); i++){
            System.out.println("(" + (i+1) + ") " + this.projektWhiteBoards.get(i).toString());
        }
        int projektAuswahl = Eingabe.leseInt();
        if(projektAuswahl == 0)
            return;
        
        
        System.out.println("Bei welcher Abteilung?");
        System.out.println("(0) Aktion abbrechen");
        for(int i = 0; i < this.abteilungsWhiteBoards.size(); i++){
            System.out.println("(" + (i+1) + ") " + this.abteilungsWhiteBoards.get(i).toString());
        }
        int abteilungsAuswahl = Eingabe.leseInt();
        if(abteilungsAuswahl == 0)
            return;
        this.projektWhiteBoards.get(projektAuswahl-1).neuesAbteilungsWhiteBoard(this.abteilungsWhiteBoards.get(abteilungsAuswahl-1));
    }

    public void projektwhiteboardBeschreiben() {
        System.out.println("Welches Projekt?");
        System.out.println("(0) Aktion abbrechen");
        for(int i = 0; i < this.projektWhiteBoards.size(); i++){
            System.out.println("(" + (i+1) + ") " + this.projektWhiteBoards.get(i).toString());
        }
        int projektAuswahl = Eingabe.leseInt();
        if(projektAuswahl == 0)
            return;
        
        System.out.print("Projektnachricht: ");
        String nachricht = Eingabe.leseString();
        this.projektWhiteBoards.get(projektAuswahl-1).setNachricht(nachricht);

    }

    public void abteilungswhiteboardBeschreiben() {
        System.out.println("Welche Abteilung?");
        System.out.println("(0) Aktion abbrechen");
        for(int i = 0; i < this.abteilungsWhiteBoards.size(); i++){
            System.out.println("(" + (i+1) + ") " + this.abteilungsWhiteBoards.get(i).toString());
        }
        int abteilungsAuswahl = Eingabe.leseInt();
        if(abteilungsAuswahl == 0)
            return;
        
        System.out.print("Abteilungsnachricht: ");
        String nachricht = Eingabe.leseString();
        this.abteilungsWhiteBoards.get(abteilungsAuswahl-1).setNachricht(nachricht);
        
    }
    
    public void uebersichtAnzeigen(){
        System.out.println(mitarbeiterList);
        System.out.println(projektWhiteBoards);
        System.out.println(abteilungsWhiteBoards);

        
    }
}
