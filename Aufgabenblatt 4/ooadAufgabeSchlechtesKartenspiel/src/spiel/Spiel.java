/*
b) Regelverstoß:
    - keine sprechende Namen
    - nicht eine Sprache (toString, Karte)
    - ! bei allen aus mehreren Wörtern zusammengesetzten Namen werden ab dem zweiten Wort
      die ersten Buchstaben jeweils großgeschrieben (k1anz)
    - Schlüsselwort this verwenden (return wert;)
    - Jede Variable wird in einer eigenen Zeile deklariert (KARO("Karo"), HERZ("Herz"), KREUZ("Kreuz"), PIK("Pik");)
    - Der break-Befehl wird ausschließlich in switch-case-Befehlen genutzt (if(...){..breake;})
    - doppeldeklaration (global variable pos & lokale pos)
    - @Override vergessen bei toString
    - ähnlicher Code doppelt
*/

package spiel;

import java.util.Scanner;
import karte.Karte;

public class Spiel {

    private static Karte[] stapel = new Karte[32];
    private static Karte[] k1 = new Karte[32];
    private static Karte[] k2 = new Karte[32];
    private static int[] ableg = new int[32];
    public static int sanz, k1anz, k2anz, aanz;
    private static Karte karte;
    private static int zaehler1, zaehler2, pos, eingabe;

    public static void main(String[] s) {
        System.out.println("Willkommen zu MauMau!");
        for (zaehler1 = 0; zaehler1 < 4; zaehler1++) {
            for (zaehler2 = 0; zaehler2 < 8; zaehler2++) {
                stapel[zaehler2 * 4 + zaehler1] = new Karte(zaehler1, zaehler2);
            }
        }

        for (zaehler1 = 0; zaehler1 < 5; zaehler1++) {
            int pos = (int) (Math.random() * (32 - zaehler1));
            k1[zaehler1] = stapel[pos];
            for (zaehler2 = pos; zaehler2 < 31 - zaehler1; zaehler2++) {
                stapel[zaehler2] = stapel[zaehler2 + 1];
            }
        }
        k1anz = 5;

        for (zaehler1 = 0; zaehler1 < 5; zaehler1++) {
            int pos = (int) (Math.random() * (27 - zaehler1));
            k2[zaehler1] = stapel[pos];
            for (zaehler2 = pos; zaehler2 < 26 - zaehler1; zaehler2++) {
                stapel[zaehler2] = stapel[zaehler2 + 1];
            }
        }
        k2anz = 5;

        pos = (int) (Math.random() * 22);
        karte = stapel[pos];
        for (zaehler1 = pos; zaehler1 < 21; zaehler1++) {
            stapel[zaehler1] = stapel[zaehler1 + 1];
        }
        sanz = 21;

        while (true) {
            //spieler
            System.out.println("Auf dem Tisch liegt: " + karte);
            System.out.print("Ihre Karten: [ ");
            for (zaehler1 = 0; zaehler1 < k1anz; zaehler1++) {
                System.out.print(k1[zaehler1] + " ");
            }
            System.out.println("]");

            aanz = 0; // kann ich was machen? aanz = 0 ->nein
            for (zaehler1 = 0; zaehler1 < k1anz; zaehler1++) {
                if (k1[zaehler1].getFarbe() == karte.getFarbe() || k1[zaehler1].getWert() == karte.getWert()) {
                    ableg[aanz++] = zaehler1;
                }
            }
            if (aanz == 0) {
                System.out.println("Sie können nicht anlegen und ziehen.");
                if (sanz == 0) {
                    System.out.println("Keine Karten mehr da, Unentschieden.");
                    break;
                } else {
                    pos = (int) (Math.random() * sanz);
                    k1[k1anz++] = stapel[pos];
                    for (zaehler1 = pos; zaehler1 < sanz - 1; zaehler1++) {
                        stapel[zaehler1] = stapel[zaehler1 + 1];
                    }
                    sanz--;
                }
            } else {
                System.out.println("Was wollen Sie machen?\n(0) ziehen");
                for (zaehler1 = 1; zaehler1 <= aanz; zaehler1++) {
                    System.out.println("(" + zaehler1 + ") " + k1[ableg[zaehler1 - 1]] + " ablegen");
                }
                eingabe = new Scanner(System.in).nextInt();
                if (eingabe < 0 || eingabe > aanz) {
                    eingabe = 0;
                }
                if (eingabe == 0) { // ziehen
                    System.out.println("Sie ziehen.");
                    if (sanz == 0) {
                        System.out.println("Keine Karten mehr da, Unentschieden.");
                        break;
                    } else {
                        pos = (int) (Math.random() * sanz);
                        k1[k1anz++] = stapel[pos];
                        for (zaehler1 = pos; zaehler1 < sanz - 1; zaehler1++) {
                            stapel[zaehler1] = stapel[zaehler1 + 1];
                        }
                        sanz--;
                    }
                } else { // karte ablegen
                    karte = k1[ableg[eingabe - 1]];
                    for (zaehler1 = ableg[eingabe - 1]; zaehler1 < k1anz - 1; zaehler1++) {
                        k1[zaehler1] = k1[zaehler1 + 1];
                    }
                    k1anz--;
                    if (k1anz == 0) {
                        System.out.println("Sie haben gewonnen.");
                        break;
                    }
                }
            }
            
            //computer
            aanz = 0;
            for (zaehler1 = 0; zaehler1 < k2anz; zaehler1++) {
                if (k2[zaehler1].getFarbe() == karte.getFarbe() || k2[zaehler1].getWert() == karte.getWert()) {
                    ableg[aanz++] = zaehler1;
                }
            }
            if (aanz == 0) {
                System.out.println("Computer kann nicht anlegen und zieht.");
                if (sanz == 0) {
                    System.out.println("Keine Karten mehr da, Unentschieden.");
                    break;
                } else {
                    pos = (int) (Math.random() * sanz);
                    k2[k2anz++] = stapel[pos];
                    for (zaehler1 = pos; zaehler1 < sanz - 1; zaehler1++) {
                        stapel[zaehler1] = stapel[zaehler1 + 1];
                    }
                    sanz--;
                }
            } else {
                karte = k2[ableg[0]];
                System.out.println("Computer spielt " + karte + ".");
                for (zaehler1 = ableg[0]; zaehler1 < k2anz - 1; zaehler1++) {
                    k2[zaehler1] = k2[zaehler1 + 1];
                }
                k2anz--;
                if (k2anz == 0) {
                    System.out.println("Computer hat gewonnen.");
                    break;
                }
            }
            System.out.println("Computer hat " + k2anz + " Karten.");
        }
    }

}

