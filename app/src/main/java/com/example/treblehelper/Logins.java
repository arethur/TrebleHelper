package com.example.treblehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class Logins extends AppCompatActivity {

    public Map<String, Users> student;
    public Map<String, Users> teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public Logins() {
        student = new HashMap<>();
    }

    void addUser() {

    }

    void addTeacher() {

    }

    void addStudent(Users user) {
        student.put(user.getUsername(),user);
    }

    void login(Users users) {

    }





}
