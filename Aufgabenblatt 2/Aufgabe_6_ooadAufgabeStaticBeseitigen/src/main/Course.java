/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author David
 */
public class Course {
    String name;
    int points;

    public Course(String name, int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public String toString() {
        return name + ": " + points;
    }
    
    
}
