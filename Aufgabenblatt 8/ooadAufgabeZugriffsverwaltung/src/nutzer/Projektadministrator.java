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
public class Projektadministrator extends Nutzer {
    
    Projektadministrator(){}
    public Projektadministrator(String passwort, String login){
        super(passwort, login);
    }
    
    @Override
    public String toString(){
        return " Projektadministrator:\n"+super.toString();
    }

    @Override
    public boolean darfDatenBearbeiten() {
        return true;
    }

    @Override
    public boolean darfTabelleBearbeiten() {
        return true;
    }

    @Override
    public boolean darfNutzerAnlegen() {
        return false;
    }
    
}
