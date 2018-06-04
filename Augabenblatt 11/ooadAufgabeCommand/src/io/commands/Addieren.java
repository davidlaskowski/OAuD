package io.commands;

import helper.language.Messages;
import business.Rechner;
import main.Eingabe;

public class Addieren implements Command {
  private Rechner rechner;
  
  public Addieren(Rechner rechner){
    this.rechner = rechner;
  }

  @Override
  public Command execute() {
    Undo tempUndo = new Undo(rechner.getSpeicher(), rechner.getAnzeige(), rechner);
    System.out.print(Messages.getString("Command.0"));   //$NON-NLS-1$
    this.rechner.addieren(Eingabe.leseInt());
    return tempUndo;
  }
  
  @Override
  public String toString(){
    return Messages.getString("Command.1");   //$NON-NLS-1$
  }

}
