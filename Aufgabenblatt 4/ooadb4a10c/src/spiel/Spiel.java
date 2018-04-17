/*
b) Regelverstoß:
   . - keine sprechende Namen
   . - ! bei allen aus mehreren Wörtern zusammengesetzten Namen werden ab dem zweiten Wort
      die ersten Buchstaben jeweils großgeschrieben (kartenSpielerAnz)
   . - Schlüsselwort this verwenden (return wert;)
   . - Jede Variable wird in einer eigenen Zeile deklariert (KARO("Karo"), HERZ("Herz"), KREUZ("Kreuz"), PIK("Pik");)
   . - Der break-Befehl wird ausschließlich in switch-case-Befehlen genutzt (if(...){..breake;})/*
   . - doppeldeklaration (global variable pos & lokale pos)
   . - @Override vergessen bei toString 
    - ähnlicher Code doppelt
   . - einrückung nicht immer korrekt
   . - Zeilenumbrüche nicht einheitlich
 */
package spiel;

import java.util.Scanner;
import karte.Karte;

public class Spiel {

    private static Karte[] stapel = new Karte[32];
    private static Karte[] kartenSpieler = new Karte[32];
    private static Karte[] kartenComputer = new Karte[32];
    private static int[] ableg = new int[32];
    public static int anzKartenImStapel, kartenSpielerAnz, kartenComputerAnz, anzahlMoeglichkeiten;
    private static Karte karte;
    private static int anzahlFarbe, anzahlWert, pos, eingabe;
    private static boolean ende;
    
    public static void ziehen(Karte[] karten, int anzahl, int anzahlKartenStapel){
        for (int i = 0; i < anzahl; i++) {
            int tempPos = (int) (Math.random() * (anzahlKartenStapel - i));
            karten[i] = stapel[tempPos];
            for (int j = tempPos; j < (anzahlKartenStapel-1) - i; j++) {
                stapel[j] = stapel[j + 1];
            }
        }
    }
    
    public static void ablegen(Karte[] kartenstapel, int eingabe, int anzahl){
        karte = kartenstapel[ableg[eingabe]];
        for (int i = ableg[eingabe]; i < anzahl - 1; i++) {
            kartenstapel[i] = kartenstapel[i + 1];
        }
    }
    
    public static void main(String[] s) {
        ende = false;
        System.out.println("Willkommen zu MauMau!");
        for (anzahlFarbe = 0; anzahlFarbe < 4; anzahlFarbe++) {
            for (anzahlWert = 0; anzahlWert < 8; anzahlWert++) {
                stapel[anzahlWert * 4 + anzahlFarbe] = new Karte(anzahlFarbe, anzahlWert);
            }
        }

        ziehen(kartenSpieler, 5, kartenSpieler.length);
        kartenSpielerAnz = 5;

        ziehen(kartenComputer, 5, kartenComputer.length);
        kartenComputerAnz = 5;

        Karte[] tempK = new Karte[1];
        ziehen(tempK, 1, 22);
        karte = tempK[0];
        anzKartenImStapel = 21;

        while (!ende) {
            //spieler
            System.out.println("Auf dem Tisch liegt: " + karte);
            System.out.print("Ihre Karten: [ ");
            for (anzahlFarbe = 0; anzahlFarbe < kartenSpielerAnz; anzahlFarbe++) {
                System.out.print(kartenSpieler[anzahlFarbe] + " ");
            }
            System.out.println("]");

            anzahlMoeglichkeiten = 0; // kann ich was machen? anzahlMoeglichkeiten = 0 ->nein
            for (anzahlFarbe = 0; anzahlFarbe < kartenSpielerAnz; anzahlFarbe++) {
                if (kartenSpieler[anzahlFarbe].getFarbe() == karte.getFarbe() || kartenSpieler[anzahlFarbe].getWert() == karte.getWert()) {
                    ableg[anzahlMoeglichkeiten++] = anzahlFarbe;
                }
            }
            
            if (anzahlMoeglichkeiten == 0) {
                System.out.println("Sie können nicht anlegen und ziehen.");
                if (anzKartenImStapel == 0) {
                    System.out.println("Keine Karten mehr da, Unentschieden.");
                    ende = true;
                } else {
                    ziehen(tempK, 1, anzKartenImStapel);
                    kartenSpieler[kartenSpielerAnz++] = tempK[0];
                    anzKartenImStapel--;
                }
            } else {
                System.out.println("Was wollen Sie machen?\n(0) ziehen");
                for (anzahlFarbe = 1; anzahlFarbe <= anzahlMoeglichkeiten; anzahlFarbe++) {
                    System.out.println("(" + anzahlFarbe + ") " + kartenSpieler[ableg[anzahlFarbe - 1]] + " ablegen");
                }
                eingabe = new Scanner(System.in).nextInt();
                if (eingabe < 0 || eingabe > anzahlMoeglichkeiten) {
                    eingabe = 0;
                }
                if (eingabe == 0) { // ziehen
                    System.out.println("Sie ziehen.");
                    if (anzKartenImStapel == 0) {
                        System.out.println("Keine Karten mehr da, Unentschieden.");
                        ende = true;
                    } else {
                        ziehen(tempK, 1, anzKartenImStapel);
                        kartenSpieler[kartenSpielerAnz++] = tempK[0];
                        anzKartenImStapel--;
                    }
                } else { // karte ablegen
                    ablegen(kartenSpieler, eingabe -1, kartenSpielerAnz);
                    kartenSpielerAnz--;
                    if (kartenSpielerAnz == 0) {
                        System.out.println("Sie haben gewonnen.");
                        ende = true;
                    }
                }
            }

            if (!ende) {
                //computer
                anzahlMoeglichkeiten = 0;
                for (anzahlFarbe = 0; anzahlFarbe < kartenComputerAnz; anzahlFarbe++) {
                    if (kartenComputer[anzahlFarbe].getFarbe() == karte.getFarbe() || kartenComputer[anzahlFarbe].getWert() == karte.getWert()) {
                        ableg[anzahlMoeglichkeiten++] = anzahlFarbe;
                    }
                }
                if (anzahlMoeglichkeiten == 0) {
                    System.out.println("Computer kann nicht anlegen und zieht.");
                    if (anzKartenImStapel == 0) {
                        System.out.println("Keine Karten mehr da, Unentschieden.");
                        ende = true;
                    } else {
                        ziehen(tempK, 1, anzKartenImStapel);
                        kartenComputer[kartenComputerAnz++] = tempK[0];
                        anzKartenImStapel--;
                    }
                } else {
                    ablegen(kartenComputer, 0, kartenComputerAnz);
                    System.out.println("Computer spielt " + karte + ".");
                    kartenComputerAnz--;
                    if (kartenComputerAnz == 0) {
                        System.out.println("Computer hat gewonnen.");
                        ende = true;
                    }
                }
                System.out.println("Computer hat " + kartenComputerAnz + " Karten.");
            }
        }
    }

}
