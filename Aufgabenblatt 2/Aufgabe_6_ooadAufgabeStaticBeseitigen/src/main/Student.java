/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class Student {
    int matrikelNummer;
    List<Course> courses;

    public Student(int matrikelNummer) {
        this.matrikelNummer = matrikelNummer;
        courses = new ArrayList<Course>();
    }
    
    public int getSum(){
        int summe = 0;
        for(Course course : courses){
            summe+=course.points;
        }
        return summe;
    }

    @Override
    public String toString() {
        String result = "";
        for(Course course : courses){
            result += course.toString() + "\n";
        }
        return result;
    }
}
