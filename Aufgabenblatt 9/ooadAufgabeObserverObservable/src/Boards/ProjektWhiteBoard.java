/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boards;

import Mitarbeiter.Mitarbeiter;
import Mitarbeiter.MitarbeiterInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class ProjektWhiteBoard extends ProjektBoardVerwaltung implements ProjektWhiteBoardInterface{
    private String nachricht;
    List<AbteilungsWhiteBoard> abteilungsWhiteBoards;
    
    public ProjektWhiteBoard(String projektName){
        super(projektName);
        abteilungsWhiteBoards = new ArrayList<>();
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
        super.benachrichtigen();
    }

    public String getNachricht() {
        return nachricht;
    }
    
    public void neuesAbteilungsWhiteBoard(AbteilungsWhiteBoard aWB){
        this.abteilungsWhiteBoards.add(aWB);
        aWB.anmelden(this);
    }
    
    @Override
    public void nachrichtAusgeben(String abteilungsName){
        for(AbteilungsWhiteBoard aWB : abteilungsWhiteBoards){
            if(aWB.getAbteilungsName().equals(abteilungsName)){
                this.setNachricht(aWB.getNachricht());
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
