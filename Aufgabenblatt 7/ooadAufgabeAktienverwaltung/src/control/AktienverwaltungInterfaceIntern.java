package control;
import classes.Aktie;

public interface AktienverwaltungInterfaceIntern extends AktienverwaltungInterface{
    /**
     * Es wird eine Aktie mit der Id id gesucht, ist sie vorhanden, wird
     * sie zurueckgegeben, ansonsten null zurueckgegeben.
     * @param id Id der gesuchten Aktie
     * @return gefundene Aktie oder null, wenn nicht gefunden
     */
    Aktie sucheAktie(int id);
}

