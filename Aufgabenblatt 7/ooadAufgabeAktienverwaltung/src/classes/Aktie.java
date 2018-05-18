package classes;

import java.util.ArrayList;
import java.util.List;

public class Aktie {
    private int id;
    private String name;
    private int verkaufsPreis;
    private int einkaufsPreis;

    public Aktie() {
    }

    public Aktie(int id, String name, int verkaufsPreis, int einkaufsPreis) {
        this.id = id;
        this.name = name;
        this.verkaufsPreis = verkaufsPreis;
        this.einkaufsPreis = einkaufsPreis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVerkaufsPreis() {
        return verkaufsPreis;
    }

    public void setVerkaufsPreis(int verkaufsPreis) {
        this.verkaufsPreis = verkaufsPreis;
    }

    public int getEinkaufsPreis() {
        return einkaufsPreis;
    }

    public void setEinkaufsPreis(int einkaufsPreis) {
        this.einkaufsPreis = einkaufsPreis;
    }

    public List<String> toStringList(){
        List result = new ArrayList<>();
        result.add(Integer.toString(this.id));
        result.add(this.name);
        result.add(Integer.toString(this.verkaufsPreis));
        result.add(Integer.toString(this.einkaufsPreis));
        return result;
    }
    
    @Override
    public String toString() {
        return "Aktie{" + "id=" + id + ", name=" + name + ", verkaufsPreis=" + verkaufsPreis + ", einkaufsPreis=" + einkaufsPreis + '}';
    }
    
    
}
