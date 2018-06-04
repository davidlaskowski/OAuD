package main;

import io.commands.Zuruecksetzen;
import helper.language.Messages;
import io.commands.Addieren;
import io.commands.AnzeigeSpeichern;
import io.commands.Command;
import io.commands.SpeicherAddieren;
import io.commands.SpeicherSubtrahieren;
import io.commands.Subtrahieren;
import io.commands.Beenden;

import java.util.HashMap;
import java.util.Map;

import business.Rechner;
import java.util.ArrayDeque;
import java.util.Deque;


public class Dialog {

    private Rechner rechner = new Rechner();
    private Map<Integer, Command> aktionen = new HashMap<>();
    private Deque<Command> zuletzt = new ArrayDeque<>();
    private Deque<Command> wieder = new ArrayDeque<>();
       
    public Dialog() {
        this.aktionen.put(0, new Beenden());
        this.aktionen.put(1, new Zuruecksetzen(this.rechner));
        this.aktionen.put(2, new Addieren(this.rechner));
        this.aktionen.put(3, new Subtrahieren(this.rechner));
        this.aktionen.put(4, new AnzeigeSpeichern(this.rechner));
        this.aktionen.put(5, new SpeicherAddieren(this.rechner));
        this.aktionen.put(6, new SpeicherSubtrahieren(this.rechner));
        
    }

    public void dialog() {
        int eingabe = -1;
        while (eingabe != 0) {
            eingabe = einSchritt();
        }
    }
    
    public void ausgabe(){ // gibt Auswahlmoeglichkeiten aus
        for (int tmp : this.aktionen.keySet()) {
            System.out.println("(" + tmp + ") " + this.aktionen.get(tmp));
        }       
        if(!zuletzt.isEmpty())
            System.out.println("(98) " + Messages.getString("Command.7"));
        if(!wieder.isEmpty())
            System.out.println("(99) " + Messages.getString("Command.8"));
    }

    public int einSchritt() {
        this.ausgabe();
        int eingabe = Eingabe.leseInt();
        Command com = this.aktionen.get(eingabe);
        if (com != null) {
            this.zuletzt.push(com.execute());
        }
        if(eingabe == 98 && !zuletzt.isEmpty()){
            Command tempZuletzt = zuletzt.pop();
            wieder.push(tempZuletzt.execute());
        }
        if(eingabe == 99 && !wieder.isEmpty()){
            Command tempWieder = wieder.pop();
            zuletzt.push(tempWieder.execute());
        }
        System.out.println(this.rechner);
        return eingabe;
    }
}
