package classes;

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

    @Override
    public String toString() {
        return "Aktie{" + "id=" + id + ", name=" + name + ", verkaufsPreis=" + verkaufsPreis + ", einkaufsPreis=" + einkaufsPreis + '}';
    }
    
    
}
