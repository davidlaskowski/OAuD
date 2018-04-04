/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Objects;

/**
 *
 * @author David
 */
public class Sammelbild {
    String series;
    int number;

    @Override
    public String toString() {
        return "[Bild{" + series + ", " + number + "}]";
    }

    public Sammelbild(String series, int number) {
        this.series = series;
        this.number = number;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.series);
        hash = 79 * hash + this.number;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sammelbild other = (Sammelbild) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.series, other.series)) {
            return false;
        }
        return true;
    }
}
