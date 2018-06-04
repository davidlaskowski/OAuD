package io.commands;

import helper.language.Messages;
import business.Rechner;

public class SpeicherSubtrahieren implements Command {
  private Rechner rechner;
  
  public SpeicherSubtrahieren(Rechner rechner){
    this.rechner = rechner;
  }

  @Override
  public Command execute() {
    Undo tempUndo = new Undo(rechner.getSpeicher(), rechner.getAnzeige(), rechner);
    this.rechner.speicherSubtrahieren();
    return tempUndo;
  }
  
  @Override
  public String toString(){
    return Messages.getString("Command.4");   //$NON-NLS-1$
  }

}