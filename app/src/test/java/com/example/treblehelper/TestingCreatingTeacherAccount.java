package com.example.treblehelper;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestingCreatingTeacherAccount {

    @Test
    public void testingAddingAccoutnsToTeacherMap(){
        Logins l = new Logins();
        Teacher teach = new Teacher("John", "Doe",
                "May 23,1996", 505639879, "john@bs.com",
                "Paino", "JonnyBoy", "happyboy");
        l.addTeacher(teach);
        assertEquals(true, l.teacher.containsKey("JonnyBoy"));

        System.out.println("The teachers memory location is " + teach);
        System.out.println("The map has it in " + Arrays.asList(l.teacher));
        System.out.println(teach.getFirstName() + " " + teach.getLastName());
    }
}
