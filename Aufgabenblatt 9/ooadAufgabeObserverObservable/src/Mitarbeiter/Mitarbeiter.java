/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mitarbeiter;

import Boards.ProjektWhiteBoard;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class Mitarbeiter implements MitarbeiterInterface{
    private int mitarbeiterNummer;
    private String name;
    List<ProjektWhiteBoard> projektBoards;
    
    public Mitarbeiter(int mitarbeiterNummer, String name){
        this.mitarbeiterNummer = mitarbeiterNummer;
        this.name = name;
        this.projektBoards = new ArrayList<>();
    }

    @Override
    public void nachrichtAusgeben(String projektName) {
        for(ProjektWhiteBoard pWB : projektBoards){
            if(pWB.getProjektName().equals(projektName)){
                        System.out.println("An " + this.name + "(" + this.mitarbeiterNummer + "): " + pWB.getNachricht());
            }
        }
    }

    public void neuesProjektBoard(ProjektWhiteBoard pWB){
        this.projektBoards.add(pWB);
        pWB.anmelden(this);
    }
    
    @Override
    public String toString() {
        return name + "(" + mitarbeiterNummer + ")";
    }
    
    
    
    
}
