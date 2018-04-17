package spiel;

import java.util.Scanner;
import karte.Karte;
import stapel.Stapel;

public class Spiel {

    private static Karte[] stapel = new Karte[32];
    private static Karte[] kartenSpieler = new Karte[32];
    private static Karte[] kartenComputer = new Karte[32];
    private static int[] ableg = new int[32];
    public static int anzKartenImStapel, kartenSpielerAnz, kartenComputerAnz, anzahlMoeglichkeiten;
    private static Karte karte;
    private static int anzahlFarbe, anzahlWert, pos, eingabe;
    private static boolean ende;

    public static void main(String[] s) {
        ende = false;
        System.out.println("Willkommen zu MauMau!");
        for (anzahlFarbe = 0; anzahlFarbe < 4; anzahlFarbe++) {
            for (anzahlWert = 0; anzahlWert < 8; anzahlWert++) {
                stapel[anzahlWert * 4 + anzahlFarbe] = new Karte(anzahlFarbe, anzahlWert);
            }
        }

        for (anzahlFarbe = 0; anzahlFarbe < 5; anzahlFarbe++) {
            int tempPos = (int) (Math.random() * (32 - anzahlFarbe));
            kartenSpieler[anzahlFarbe] = stapel[tempPos];
            for (anzahlWert = tempPos; anzahlWert < 31 - anzahlFarbe; anzahlWert++) {
                stapel[anzahlWert] = stapel[anzahlWert + 1];
            }
        }
        kartenSpielerAnz = 5;

        for (anzahlFarbe = 0; anzahlFarbe < 5; anzahlFarbe++) {
            int tempPos = (int) (Math.random() * (27 - anzahlFarbe));
            kartenComputer[anzahlFarbe] = stapel[tempPos];
            for (anzahlWert = tempPos; anzahlWert < 26 - anzahlFarbe; anzahlWert++) {
                stapel[anzahlWert] = stapel[anzahlWert + 1];
            }
        }
        kartenComputerAnz = 5;

        pos = (int) (Math.random() * 22);
        karte = stapel[pos];
        for (anzahlFarbe = pos; anzahlFarbe < 21; anzahlFarbe++) {
            stapel[anzahlFarbe] = stapel[anzahlFarbe + 1];
        }
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
                    pos = (int) (Math.random() * anzKartenImStapel);
                    kartenSpieler[kartenSpielerAnz++] = stapel[pos];
                    for (anzahlFarbe = pos; anzahlFarbe < anzKartenImStapel - 1; anzahlFarbe++) {
                        stapel[anzahlFarbe] = stapel[anzahlFarbe + 1];
                    }
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
                        pos = (int) (Math.random() * anzKartenImStapel);
                        kartenSpieler[kartenSpielerAnz++] = stapel[pos];
                        for (anzahlFarbe = pos; anzahlFarbe < anzKartenImStapel - 1; anzahlFarbe++) {
                            stapel[anzahlFarbe] = stapel[anzahlFarbe + 1];
                        }
                        anzKartenImStapel--;
                    }
                } else { // karte ablegen
                    karte = kartenSpieler[ableg[eingabe - 1]];
                    for (anzahlFarbe = ableg[eingabe - 1]; anzahlFarbe < kartenSpielerAnz - 1; anzahlFarbe++) {
                        kartenSpieler[anzahlFarbe] = kartenSpieler[anzahlFarbe + 1];
                    }
                    kartenSpielerAnz--;
                    if (kartenSpielerAnz == 0) {
                        System.out.println("Sie haben gewonnen.");
                        ende = true;
                    }
                }
            }
            
            if(!ende){
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
                        pos = (int) (Math.random() * anzKartenImStapel);
                        kartenComputer[kartenComputerAnz++] = stapel[pos];
                        for (anzahlFarbe = pos; anzahlFarbe < anzKartenImStapel - 1; anzahlFarbe++) {
                            stapel[anzahlFarbe] = stapel[anzahlFarbe + 1];
                        }
                        anzKartenImStapel--;
                    }
                } else {
                    karte = kartenComputer[ableg[0]];
                    System.out.println("Computer spielt " + karte + ".");
                    for (anzahlFarbe = ableg[0]; anzahlFarbe < kartenComputerAnz - 1; anzahlFarbe++) {
                        kartenComputer[anzahlFarbe] = kartenComputer[anzahlFarbe + 1];
                    }
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

