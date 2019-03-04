package com.example.treblehelper;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingCreatingTeacherAccount {

    @Test
    public void testingAddingAccoutnsToTeacherMap(){
        Logins l = new Logins();
        Teacher teach = new Teacher("John", "Doe",
                "May 23,1996", 505639879, "john@bs.com",
                "Paino", "JonnyBoy", "happyboy");
        l.MasteraddTeacher(teach);
        assertEquals(true, l.teacher.containsKey("JonnyBoy"));
    }
}
