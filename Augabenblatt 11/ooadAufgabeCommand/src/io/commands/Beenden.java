/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.commands;

import helper.language.Messages;

/**
 *
 * @author David
 */
public class Beenden implements Command{
    @Override
    public Command execute() {
        System.exit(0);
        return null;
    }  
    
     @Override
  public String toString(){
    return Messages.getString("Command.6");   //$NON-NLS-1$
  }
}
