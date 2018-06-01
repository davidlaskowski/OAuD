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
public class Waffe extends Ausruestung{
    
    private int staerke;

    public Waffe(String name, int preis, int staerke) {
        super(name, preis);
        this.setStaerke(staerke);
    }
    
    public int zuhauen(int geschick){
        return this.staerke*geschick/10;
    }

    public int getStaerke() {
        return staerke;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }
    
}
