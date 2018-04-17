package stapel;

import karte.Karte;

public class Stapel {
    
    private Karte[] stapel = new Karte[32];
    private int kartenImStapel = 32;
    
    Stapel(){
        int tempAnzahlFarbe;
        int tempAnzahlWert;
        for (tempAnzahlFarbe = 0; tempAnzahlFarbe < 4; tempAnzahlFarbe++) {
            for (tempAnzahlWert = 0; tempAnzahlWert < 8; tempAnzahlWert++) {
                this.stapel[tempAnzahlWert * 4 + tempAnzahlFarbe] = new Karte(tempAnzahlFarbe, tempAnzahlWert);
            }
        }
    }
    
    public Karte ziehen(){
        int pos = (int) (Math.random() * this.kartenImStapel);
        Karte karte = stapel[pos];
        for (int temp = pos; temp < this.kartenImStapel; temp++) {
            this.stapel[temp] = this.stapel[temp + 1];
        }
        this.kartenImStapel--;
        return karte;
    }
    
}
