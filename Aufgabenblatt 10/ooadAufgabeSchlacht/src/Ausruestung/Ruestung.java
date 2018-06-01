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
public class Ruestung extends Ausruestung{
    
    private int schutz;

    public Ruestung(String name, int preis, int schutz) {
        super(name, preis);
        this.schutz = schutz;
    }
    
    public int abwehr(int angriff){
        return angriff-schutz <= 0 ? 0 :angriff-schutz;
    }

    public int getSchutz() {
        return schutz;
    }

    public void setSchutz(int schutz) {
        this.schutz = schutz;
    }
    
}
