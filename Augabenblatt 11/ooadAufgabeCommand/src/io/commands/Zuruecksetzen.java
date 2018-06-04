/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.commands;

import business.Rechner;
import helper.language.Messages;
import io.commands.Command;

/**
 *
 * @author David
 */
public class Zuruecksetzen implements Command {
    private Rechner rechner;

    public Zuruecksetzen(Rechner rechner) {
        this.rechner = rechner;
    }

    @Override
    public Command execute() {
        Undo tempUndo = new Undo(rechner.getSpeicher(), rechner.getAnzeige(), rechner);
        this.rechner.zuruecksetzen();
        return tempUndo;
    }
    
     @Override
  public String toString(){
    return Messages.getString("Command.9");   //$NON-NLS-1$
  }
    
}
