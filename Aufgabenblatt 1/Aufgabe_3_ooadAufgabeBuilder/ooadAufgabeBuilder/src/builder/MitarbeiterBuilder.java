package builder;

import entity.Fachgebiet;
import entity.Mitarbeiter;


public class MitarbeiterBuilder {
    Mitarbeiter mitarbeiter;
    
    public static MitarbeiterBuilder createBuilder(){
        MitarbeiterBuilder mitarbeiterBuilder = new MitarbeiterBuilder();
        mitarbeiterBuilder.mitarbeiter = new Mitarbeiter("Eva","Mustermann");
        return mitarbeiterBuilder;
    }
    
    public MitarbeiterBuilder vorname(String vorname){
        mitarbeiter.setVorname(vorname);
        return this;
    }
    
    public MitarbeiterBuilder nachname(String nachname){
        mitarbeiter.setNachname(nachname);
        return this;
    }
    
    public MitarbeiterBuilder mitFachgebiet(Fachgebiet fachgebiet){
        mitarbeiter.addFachgebiet(fachgebiet);
        return this;
    }
    
    public Mitarbeiter build(){
        return mitarbeiter;
    }
}

