
package nutzerverwaltung.interaktiv;

import java.util.ArrayList;
import java.util.List;
import nutzer.Nutzer;
import nutzer.Entwickler;
import nutzer.Projektadministrator;
import nutzer.Systemadministrator;

/**
 *
 * @author Johanna
 */
public class Zugriffsverwaltung {
    
    private Nutzer aktuellerNutzer;
    private List<Nutzer> nutzer;
    
    Zugriffsverwaltung(){
        this.nutzer = new ArrayList<Nutzer>();
        this.nutzer.add(new Systemadministrator("test", "test"));
        this.aktuellerNutzer = null;
    }

    void nutzerAnzeigen() {
        System.out.print("alle Nutzer: \n");
        for(Nutzer n:this.nutzer){
            System.out.print(n.toString());
        }
    }

    boolean loginAendern(String alt, String neu) {
        if(this.aktuellerNutzer != null && this.aktuellerNutzer.getLogin().equals(alt)) {
            for(Nutzer n:this.nutzer){
                if(n.getLogin().equals(alt) && n.getPasswort().equals(this.aktuellerNutzer.getPasswort())){
                    this.aktuellerNutzer.setLogin(neu);
                    n.setLogin(neu);
                    return true;
                }
            }
        }
        return false;
    }

    boolean systemadministratorHinzufuegen(String login, String passwort) {
        if(this.aktuellerNutzer != null && this.aktuellerNutzer.darfNutzerAnlegen()){
            this.nutzer.add(new Systemadministrator(passwort, login));
            return true;
        }
        return false;
    }

    boolean projektadministratorHinzufuegen(String login, String passwort) {
        if(this.aktuellerNutzer != null && this.aktuellerNutzer.darfNutzerAnlegen()){
            this.nutzer.add(new Projektadministrator(passwort, login));
            return true;
        }
        return false;
    }

    boolean entwicklerHinzufuegen(String login, String passwort) {
        if(this.aktuellerNutzer != null && this.aktuellerNutzer.darfNutzerAnlegen()){
            this.nutzer.add(new Entwickler(passwort, login));
            return true;
        }
        return false;
    }

    boolean passwortAendern(String altesPasswort, String neuesPasswort) {
        if(this.aktuellerNutzer != null && this.aktuellerNutzer.getPasswort().equals(altesPasswort)) {
            for(Nutzer n:this.nutzer){
                if(n.getLogin().equals(this.aktuellerNutzer.getLogin()) && n.getPasswort().equals(altesPasswort)){
                    this.aktuellerNutzer.setPasswort(neuesPasswort);
                    n.setPasswort(neuesPasswort);
                    return true;
                }
            }
        }
        return false;
    }

    boolean authentifizieren(String login, String passwort) {
        for(Nutzer n:this.nutzer){
            if(n.getLogin().equals(login) && n.getPasswort().equals(passwort)){
                this.aktuellerNutzer = n;
                return true;
            }
        }
        return false;
    }
    
}
