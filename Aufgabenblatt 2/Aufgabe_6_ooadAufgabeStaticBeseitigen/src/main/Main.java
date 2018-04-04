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
public class Main {
    static Verwaltung verwaltung = new Verwaltung();
    public static void main(String[] s){
        System.out.println("Verwaltung von Leistungspunkten");
        int eingabe = -1;
        while (eingabe != 0) {
            System.out.print(""
                    + "0 - Programm beenden\n"
                    + "1 - Leistung hinzufuegen\n"
                    + "2 - Leistungspunkte fuer Matrikelnummer ausgeben: ");
            
            eingabe = Eingabe.leseInt();
            if (eingabe == 1) {
                System.out.print("Matrikelnummer: ");
                int matnr = Eingabe.leseInt();
                System.out.print("Fach: ");
                String fach = Eingabe.leseString();
                System.out.print("Leistungspunkte: ");
                int lp = Eingabe.leseInt();
                Student tempStudent = verwaltung.getStudent(matnr);
                if(tempStudent != null){
                    tempStudent.courses.add(new Course(fach, lp));
                }else{
                    tempStudent = new Student(matnr);
                    verwaltung.addStudent(tempStudent);
                    tempStudent.courses.add(new Course(fach, lp));
                }

                }
             if (eingabe == 2) {
                System.out.print("Matrikelnummer: ");
                int matnr = Eingabe.leseInt();
                Student tempStudent = verwaltung.getStudent(matnr);
                if(tempStudent != null){
                    System.out.println(tempStudent.toString());
                    System.out.println("Hat " + tempStudent.getSum() + " Leistungspunkte");
                }
            }
            }
    }
}
