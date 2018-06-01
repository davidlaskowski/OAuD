/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class AbteilungsBoardVerwaltung {
    private String abteilungsName;
    private int abteilungsNummer;
    private List<ProjektWhiteBoardInterface> whiteBoards;
    
    protected AbteilungsBoardVerwaltung(String abteilungsName, int abteilungsNummer){
        this.abteilungsName = abteilungsName;
        this.abteilungsNummer = abteilungsNummer;
        this.whiteBoards = new ArrayList<>();
    }
    public void benachrichtigen(){
        for(ProjektWhiteBoardInterface whiteBoard : whiteBoards){
            whiteBoard.nachrichtAusgeben(this.abteilungsName);
            
        }
    }
    public void anmelden(ProjektWhiteBoardInterface whiteBoard){
        if(whiteBoard != null)
            this.whiteBoards.add(whiteBoard);
    }
    public void abmelden(ProjektWhiteBoardInterface whiteBoard){
        if(whiteBoard != null)
            this.whiteBoards.remove(whiteBoard);
    }

    public String getAbteilungsName() {
        return this.abteilungsName;
    }

    @Override
    public String toString() {
        return this.abteilungsName + " (" + this.abteilungsNummer + "): " + whiteBoards;
    }
    
    
    
}
