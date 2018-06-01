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
public class Conan extends Kaempfer {
    
    private Waffe[] w;
    private Ruestung r;

    public Conan(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold, "Conan");
        w = new Waffe[2];
    }

    @Override
    public String toStringKampf() {
        return "Gesundhaeit vom "+super.toString()+": "+this.getGesundheit();
    }

    @Override
    public int kaempfen() {
        int temp = 0;
        for(int i = 0; i < this.w.length; i++){
            if(this.w[i] != null){
                System.out.println("Conan schlaegt zu");
                temp += this.w[i].zuhauen(this.getGeschick());
            }
        }
        return temp;
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
        if(this.w[0] == null){
            this.w[0] = w;
        } else if(this.w[1] == null){
            this.w[1] = w;
        } else {
            this.w[0] = this.w[1];
            this.w[1] = w;
        }
    }
    
}
