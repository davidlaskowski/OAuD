package main;

import java.util.ArrayList;
import java.util.List;

public class Verwaltung {
    List<Student> students;

    public Verwaltung() {
        students = new ArrayList<Student>();
    }
    
    public Student getStudent(int matnr){
        for (Student student : students) {
            if(student.matrikelNummer == matnr){
                return student;
            }
        }
        return null;
    }
    
    public void addStudent(Student student){
        students.add(student);
    }
    
}
