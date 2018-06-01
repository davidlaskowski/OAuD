/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kaempfer;

import Ausruestung.Ruestung;
import Ausruestung.Waffe;

/**
 *
 * @author Johanna
 */
public abstract class Kaempfer {
    
    private Ruestung ruestung;
    private int gesundheit;
    private int geschick;
    private int sold;
    private String name;

    public Kaempfer(int gesundheit, int geschick, int sold, String name){
        this.gesundheit = gesundheit;
        this.setGeschick(geschick);
        this.sold = sold;
        this.name = name;
    }
    
    public abstract int kaempfen();
    public abstract int abwehren(int angriff);
    public abstract void nimmRuestung(Ruestung r);
    public abstract void nimmWaffe(Waffe w);
    public abstract String toStringKampf();
    
    public String toString(){
        return this.name+" (Sold: "+this.sold+")";
    }

    public Ruestung getRuestung() {
        return ruestung;
    }

    public int getGesundheit() {
        return gesundheit;
    }

    public void setGesundheit(int gesundheit) {
        this.gesundheit = gesundheit;
    }

    public int getGeschick() {
        return geschick;
    }

    public void setGeschick(int geschick) {
        this.geschick = ((geschick > 10 || geschick < 0) ? 0 : geschick);
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
    
}
