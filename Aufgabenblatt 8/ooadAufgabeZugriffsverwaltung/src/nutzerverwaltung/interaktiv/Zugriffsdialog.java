package nutzerverwaltung.interaktiv;


public class Zugriffsdialog {

    // TODO
    private Zugriffsverwaltung zv = new Zugriffsverwaltung();

    public void nutzungsdialog() {
        int eingabe = -1;
        while (eingabe != 0) {
            System.out.println(
                    "---------------\n"
                    + //$NON-NLS-1$
                    Messages.getString("Zugriffsdialog.1") //$NON-NLS-1$
                    + Messages.getString("Zugriffsdialog.2") //$NON-NLS-1$
                    + Messages.getString("Zugriffsdialog.3") //$NON-NLS-1$
                    + Messages.getString("Zugriffsdialog.4") //$NON-NLS-1$
                    + Messages.getString("Zugriffsdialog.5") //$NON-NLS-1$
                    + Messages.getString("Zugriffsdialog.6") //$NON-NLS-1$
                    + Messages.getString("Zugriffsdialog.7")); //$NON-NLS-1$
            eingabe = Eingabe.leseInt();
            switch (eingabe) {
                case 1:
                    this.nutzerWechseln();
                    break;
                case 2:
                    this.nutzerHinzufuegen();
                    break;
                case 3:
                    this.passwortAendern();
                    break;
                case 4:
                    this.loginVeraendern();
                    break;
                case 5:
                    this.nutzerAnzeigen();
                    break;
            }
        }
    }

    public void nutzerAnzeigen() {
        this.zv.nutzerAnzeigen();
    }

    public void loginVeraendern() {
        System.out.print(Messages.getString("Zugriffsdialog.8")); //$NON-NLS-1$
        String alt = Eingabe.leseString();
        System.out.print(Messages.getString("Zugriffsdialog.9")); //$NON-NLS-1$
        String neu = Eingabe.leseString();
        boolean ergebnis = this.zv.loginAendern(alt, neu);
        if (ergebnis) {
            System.out.println(Messages.getString("Zugriffsdialog.10")); //$NON-NLS-1$
        } else {
            System.out.println(Messages.getString("Zugriffsdialog.11")); //$NON-NLS-1$
        }
    }

    public void nutzerHinzufuegen() {
        System.out.print(Messages.getString("Zugriffsdialog.12")); //$NON-NLS-1$
        String login = Eingabe.leseString();
        System.out.print(Messages.getString("Zugriffsdialog.13")); //$NON-NLS-1$
        String passwort = Eingabe.leseString();
        int eingabe = 0;
        while (eingabe < 1 || eingabe > 3) {
            System.out.println(Messages.getString("Zugriffsdialog.14") //$NON-NLS-1$
                    + Messages.getString("Zugriffsdialog.15") //$NON-NLS-1$
                    + Messages.getString("Zugriffsdialog.16") //$NON-NLS-1$
                    + Messages.getString("Zugriffsdialog.17")); //$NON-NLS-1$
            eingabe = Eingabe.leseInt();
        }
        boolean ergebnis = false;
        switch (eingabe) {
            case 1:
                ergebnis = this.zv.systemadministratorHinzufuegen(login,
                        passwort);
                break;
            case 2:
                ergebnis = this.zv.projektadministratorHinzufuegen(login,
                        passwort);
                break;
            case 3:
                ergebnis = this.zv.entwicklerHinzufuegen(login,
                        passwort);
                break;
        }
        if (ergebnis) {
            System.out.println(Messages.getString("Zugriffsdialog.18")); //$NON-NLS-1$
        } else {
            System.out.println(Messages.getString("Zugriffsdialog.19")); //$NON-NLS-1$
        }
    }

    public void passwortAendern() {
        System.out.print(Messages.getString("Zugriffsdialog.20")); //$NON-NLS-1$
        String altesPasswort = Eingabe.leseString();
        System.out.print(Messages.getString("Zugriffsdialog.21")); //$NON-NLS-1$
        String neuesPasswort = Eingabe.leseString();
        boolean ergebnis = this.zv.passwortAendern(altesPasswort, neuesPasswort);
        if (ergebnis) {
            System.out.println(Messages.getString("Zugriffsdialog.22")); //$NON-NLS-1$
        } else {
            System.out.println(Messages.getString("Zugriffsdialog.23")); //$NON-NLS-1$
        }
    }

    public void nutzerWechseln() {
        System.out.print(Messages.getString("Zugriffsdialog.24")); //$NON-NLS-1$
        String login = Eingabe.leseString();
        System.out.print(Messages.getString("Zugriffsdialog.25")); //$NON-NLS-1$
        String passwort = Eingabe.leseString();
        boolean ergebnis = this.zv.authentifizieren(login, passwort);
        if (ergebnis) {
            System.out.println(Messages.getString("Zugriffsdialog.26")); //$NON-NLS-1$
        } else {
            System.out.println(Messages.getString("Zugriffsdialog.27")); //$NON-NLS-1$
        }
    }
}
