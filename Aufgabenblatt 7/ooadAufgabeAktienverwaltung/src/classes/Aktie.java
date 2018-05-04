package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class Aktie {
    private int id;
    private String name;
    private int verkaufsPreis;
    private int einkaufsPreis;

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
