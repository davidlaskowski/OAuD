/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutzer;

/**
 *
 * @author Johanna
 */
public class Entwickler extends Nutzer {
    
    Entwickler(){}
    public Entwickler(String passwort, String login){
        super(passwort, login);
    }
    
    @Override
    public String toString(){
        return " Entwickler:\n"+super.toString();
    }

    @Override
    public boolean darfDatenBearbeiten() {
        return true;
    }

    @Override
    public boolean darfTabelleBearbeiten() {
        return false;
    }

    @Override
    public boolean darfNutzerAnlegen() {
        return false;
    }
    
}
