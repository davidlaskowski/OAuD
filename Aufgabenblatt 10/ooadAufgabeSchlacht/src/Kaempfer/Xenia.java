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
public class Xenia extends Kaempfer {
    
    private Waffe w;
    private Ruestung r;

    public Xenia(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold, "Xenia");
    }

    @Override
    public String toStringKampf() {
        return "Gesundhaeit vom "+super.toString()+": "+this.getGesundheit();
    }

    @Override
    public int kaempfen() {
        System.out.println("Xenia tritt zu");
        return this.w.zuhauen(this.getGeschick());
    }

    @Override
    public int abwehren(int angriff) {
        int temp = this.getGesundheit()-angriff;
        this.setGesundheit(temp);
        return temp;
    
    }

    @Override
    public void nimmRuestung(Ruestung r) {
        this.r = r;
    }

    @Override
    public void nimmWaffe(Waffe w) {
        this.w = w;
    }
    
}
