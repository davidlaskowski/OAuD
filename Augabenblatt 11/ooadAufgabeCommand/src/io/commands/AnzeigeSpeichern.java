package io.commands;

import helper.language.Messages;
import business.Rechner;

public class AnzeigeSpeichern implements Command {
  private Rechner rechner;
  
  public AnzeigeSpeichern(Rechner rechner){
    this.rechner = rechner;
  }

  @Override
  public Command execute() {
   Undo tempUndo = new Undo(rechner.getSpeicher(), rechner.getAnzeige(), rechner);
   this.rechner.speichern();
   return tempUndo;
  }
  
  @Override
  public String toString(){
    return Messages.getString("Command.2");   //$NON-NLS-1$
  }

}