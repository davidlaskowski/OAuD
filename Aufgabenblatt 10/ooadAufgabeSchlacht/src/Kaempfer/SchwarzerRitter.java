/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kaempfer;

import Ausruestung.Ruestung;
import Ausruestung.Waffe;
import Kaempfer.Kaempfer;
import java.util.Random;

/**
 *
 * @author Johanna
 */
public class SchwarzerRitter extends Kaempfer {

    public SchwarzerRitter() {
        super(500, 10, 77, "SchwarzerRitter");
    }

    @Override
    public int kaempfen() {
        return new Random().nextInt(30) + 10;
    }

    @Override
    public int abwehren(int angriff) {
        //System.out.println("sr: "+this.getGesundheit()+"-"+angriff);
        int temp = this.getGesundheit()-angriff;
        this.setGesundheit(temp);
        return temp;
    }

    @Override
    public void nimmRuestung(Ruestung r) {}

    @Override
    public void nimmWaffe(Waffe w) {}

    @Override
    public String toStringKampf() {
        return "Gesundhaeit vom "+super.toString()+": "+this.getGesundheit();
    }
    
}
