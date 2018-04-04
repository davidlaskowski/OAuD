package main;

import com.google.common.collect.HashMultiset;
import java.util.Iterator;

public class Zugriffsdialog {

    HashMultiset<Sammelbild> sammelbilder;

    public Zugriffsdialog() {
        this.sammelbilder = HashMultiset.create();
    }

    public void nutzungsdialog() {
        int eingabe = -1;
        while (eingabe != 0) {
            System.out.println(
                    "---------------\n"
                    + " (0) Programm beenden\n"
                    + " (1) Sammelbild hinzufuegen\n"
                    + " (2) Sammelbilder herausgeben\n"
                    + " (3) Nummern einer Serie zeigen\n"
                    + " (4) Gesamtbestand anzeigen:");
            eingabe = Eingabe.leseInt();
            switch (eingabe) {
                case 1:
                    this.sammelbildHinzufuegen();
                    break;
                case 2:
                    this.sammelbilderHerausgeben();
                    break;
                case 3:
                    this.serienbilderZeigen();
                    break;
                case 4:
                    this.gesamtbestand();
                    break;
            }
        }
    }

    public void gesamtbestand() {
        System.out.println(sammelbilder);
    }

    public void sammelbildHinzufuegen() {
        System.out.print("Welche Serie? "); 
        String serie = Eingabe.leseString();
        System.out.print("Welche Nummer? " ); 
        int nr = Eingabe.leseInt();
        sammelbilder.add(new Sammelbild(serie, nr));
    }

    public void sammelbilderHerausgeben() {
        System.out.print("Welche Serie? "); 
        String serie = Eingabe.leseString();
        System.out.print("Welche Nummer? " ); 
        int nr = Eingabe.leseInt();
        int anzahl = 0;
        while (anzahl < 1) {
            System.out.print("Wieviele? ");
            anzahl = Eingabe.leseInt();
        }
        Sammelbild temp = new Sammelbild(serie, nr);
        if(sammelbilder.contains(temp) && sammelbilder.count(temp) >= anzahl)
            sammelbilder.remove(temp, anzahl);
        else
            System.out.println("Herausgeben der Bilder war nicht erfolgreich!");
        
    }

    public void serienbilderZeigen() {
        System.out.print("Welche Serie? "); 
        String serie = Eingabe.leseString();
        
        for(Object sammelbild : this.sammelbilder.elementSet().toArray()){
            if(((Sammelbild)sammelbild).series.equals(serie)){
                System.out.print(((Sammelbild)sammelbild).number + " x " + sammelbilder.count(sammelbild));
            }
        }
        System.out.println();
    }
}
