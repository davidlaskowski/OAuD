package main;

public class Model {

    private int wert;

    public Model(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return this.wert;
    }

    public void wertAendern(int wert) {
        this.wert = wert;
    }
}