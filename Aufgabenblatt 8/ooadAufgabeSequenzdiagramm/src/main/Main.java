package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import mvc.Controller;
import mvc.Model;
import mvc.View;

public class Main {

    private Model model;
    private List<Controller> controller;

    public Main() {
        //Locale.setDefault(new Locale("en","US")); 
        this.model = new Model(1);
        this.controller = new ArrayList<>();
        int eingabe = -1;
        while (eingabe != 0) {
            System.out.println(Messages.getString("Main.0") //$NON-NLS-1$
                    + Messages.getString("Main.1") //$NON-NLS-1$
                    + Messages.getString("Main.2") //$NON-NLS-1$
                    + Messages.getString("Main.3") //$NON-NLS-1$
                    + Messages.getString("Main.4")); //$NON-NLS-1$
            eingabe = new Scanner(System.in).nextInt();
            switch (eingabe) {
                case 1: {
                    neuerView();
                    break;
                }
                case 2: {
                    neuerController();
                    break;
                }
                case 3: {
                    controllerNutzen();
                    break;
                }
            }
        }
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private void neuerView() {
        Scanner sc = new Scanner(System.in);
        System.out.print(Messages.getString("Main.6")); //$NON-NLS-1$
        new View(this.model, sc.next().charAt(0));
    }

    private void neuerController() {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.print(Messages.getString("Main.8")); //$NON-NLS-1$
        String aufforderung = sc.next();
        this.controller.add(new Controller(this.model, aufforderung));
    }

    private void controllerNutzen() {
        if (!this.controller.isEmpty()) {
            System.out.print(Messages.getString("Main.9") //$NON-NLS-1$
                    + this.controller.size() + ")? "); //$NON-NLS-1$
            this.controller.get((new Scanner(System.in).nextInt()) - 1)
                      .eingabeSteuern();
        }
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) {
        new Main();
    }
}
