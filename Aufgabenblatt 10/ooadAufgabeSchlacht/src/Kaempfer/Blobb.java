/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kaempfer;

import Ausruestung.Ruestung;
import Ausruestung.Waffe;
import Kaempfer.Kaempfer;

/**
 *
 * @author Johanna
 */
public class Blobb extends Kaempfer {
    
    private Waffe w;

    public Blobb(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold, "Blobb");
    }

    @Override
    public String toStringKampf() {
        return "Gesundhaeit vom "+super.toString()+": "+this.getGesundheit();
    }

    @Override
    public int kaempfen() {
        int temp = w.zuhauen(this.getGeschick());
        System.out.println("Blobb haut zu");
        return w.zuhauen(this.getGeschick());
    }

    @Override
    public int abwehren(int angriff) {
        int temp = this.getGesundheit()-angriff;
        this.setGesundheit(temp);
        return temp;
    }

    @Override
    public void nimmWaffe(Waffe w) {
        this.w = w;
    }

    @Override
    public void nimmRuestung(Ruestung r) {System.out.println("Blobb darf keine Rüstung haben!");}
    
}
