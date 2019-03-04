package com.example.treblehelper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingteachersAddingStudents {

    @Test
    public void teachersAddingstudents(){
        Student b = new Student();
        Student a = new Student();
        b.setFirstName("Jacob");
        b.setLastName("Hills");
        a.setFirstName("Arron");
        a.setLastName("Beverly");
        Teacher teacher = new Teacher("John", "Doe",
                "May 23,1996", 505639879, "john@bs.com",
                "Paino", "JonnyBoy", "happyboy");
        teacher.addStudent(b);
        teacher.addStudent(a);
        assertEquals(true, teacher.students.contains(b));
        assertEquals(true, teacher.students.contains(a));
        teacher.showStudents();

    }
}
