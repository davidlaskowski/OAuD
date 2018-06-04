/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ausruestung;

/**
 *
 * @author Johanna
 */
public class Ausruestung {
    
    private String name;
    private int preis;
    
    Ausruestung(String name, int preis){
        this.name = name;
        this.preis = preis;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString(){
        return this.name+" (Preis: "+this.preis+")";
    }
    
}
