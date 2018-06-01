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
public class ProjektBoardVerwaltung {
    private String projektName;
    List<MitarbeiterInterface> mitarbeiterList;

    protected ProjektBoardVerwaltung(String projektName) {
        this.projektName = projektName;
        mitarbeiterList = new ArrayList<>();
    }
    
    public void benachrichtigen(){
        for(MitarbeiterInterface m : mitarbeiterList){
            m.nachrichtAusgeben(projektName);
        }
    }
    
    public void anmelden(MitarbeiterInterface mitarbeiter){
        this.mitarbeiterList.add((Mitarbeiter)mitarbeiter);
    }
    
    public void abmelden(MitarbeiterInterface mitarbeiter){
        this.mitarbeiterList.remove((Mitarbeiter)mitarbeiter);
    }

    public String getProjektName() {
        return projektName;
    }

    @Override
    public String toString() {
        return projektName + ": " + mitarbeiterList;
    }
    
    
    
}
