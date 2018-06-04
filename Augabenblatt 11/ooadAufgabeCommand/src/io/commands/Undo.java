/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.commands;

import business.Rechner;
import helper.language.Messages;

/**
 *
 * @author David
 */
public class Undo implements Command{
    private int altSpeicher;
    private int altAnzeige;
    private Rechner rechner;

    public Undo(int altSpeicher, int altAnzeige, Rechner rechner) {
        this.altSpeicher = altSpeicher;
        this.altAnzeige = altAnzeige;
        this.rechner = rechner;
    }
    
    @Override
    public Command execute() {
        Undo tempUndo = new Undo(rechner.getSpeicher(), rechner.getAnzeige(), rechner);
        rechner.setAnzeige(altAnzeige);
        rechner.setSpeicher(altSpeicher);
        return tempUndo;
    }

    @Override
    public String toString() {
        return Messages.getString("Command.7");
    }
    
    
}
