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
public abstract class Nutzer {
    private String passwort;
    private String login;
    
    Nutzer(){}
    
    public Nutzer(String passwort, String login){
        this.passwort = passwort;
        this.login = login;
    }
    
    public String toString(){
        return "  login: "+this.login+", passwort: "+this.passwort+"\n"
                +"  darfDatenBearbeiten: "+this.darfDatenBearbeiten()
                +"\n  darfTabelleBearbeiten: "+this.darfTabelleBearbeiten()
                +"\n  darfNutzerAnlegen: "+this.darfNutzerAnlegen()+"\n";
    }
    
    public String getPasswort(){
        return this.passwort;
    }
    
    public void setPasswort(String passwort){
        this.passwort = passwort;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public abstract boolean darfDatenBearbeiten();
    public abstract boolean darfTabelleBearbeiten();
    public abstract boolean darfNutzerAnlegen();
    
}
