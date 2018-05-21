package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    // TODO: kennt Model und alle Views
    private Model model;
    private List<View> listener;
    private String aendern;

    public Controller() {
        this.model = new Model(1);
        this.aendern = "Wert:";
        this.listener = new ArrayList<>();
    }

    // Methode dialog darf nicht veraendert werden
    public void dialog() {
        int eingabe = -1;
        while (eingabe != 0) {
            System.out.println("(0) Programm beenden"
                    + "\n(1) neuen View erstellen"
                    + "\n(2) Controller zum Steuern nutzen");
            eingabe = Eingabe.leseInt();
            switch (eingabe) {
                case 1: {
                    neuerView();
                    break;
                }
                case 2: {
                    controllerNutzen();
                    break;
                }
            }
        }
    }

    public void neuerView() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Welches Ausgabezeichen? ");
        // TODO
        View temp = new View(this.model, sc.next().charAt(0));
        this.listener.add(temp);
    }

    public void controllerNutzen() {
        System.out.print("neuer Modellwert: ");
        int eingabe = Eingabe.leseInt();
        // TODO
        this.model.wertAendern(eingabe);
        for (View m : this.listener) {
            m.wertaenderung();
        }        
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) {
        new Controller().dialog();
    }
}
