package com.example.treblehelper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapStudentUsernameTest {
    @Test
    public void CanAddAndRetrieveUserNameTest() {
        Student s= new Student();
        Student p =new Student();
        s.setUsername("Johnny");
        p.setUsername("James");
        Logins l = new Logins();
        l.MasteraddStudent(s);
        l.MasteraddStudent(p);
        assertEquals("Johnny", l.student.get("Johnny").getUsername());
        assertEquals("James", l.student.get("James").getUsername());

    }
}