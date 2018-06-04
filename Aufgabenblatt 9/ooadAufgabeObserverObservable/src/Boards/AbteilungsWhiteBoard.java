/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boards;

import java.util.List;

/**
 *
 * @author David
 */
public class AbteilungsWhiteBoard extends AbteilungsBoardVerwaltung {
    private String nachricht;

    public AbteilungsWhiteBoard(String abteilungsName, int abteilungsNummer) {
        super(abteilungsName,abteilungsNummer);
    }

    public String getNachricht() {
        return nachricht;
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
        super.benachrichtigen();
    }
    

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
