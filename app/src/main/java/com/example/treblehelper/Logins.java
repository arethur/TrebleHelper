package com.example.treblehelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;
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

    public void create(View v){
        Intent intent = new Intent(this, createAccount.class);
        intent.putExtra("student", (Serializable) student);
        intent.putExtra("teacher", (Serializable) teacher);
        startActivity(intent);
    }

    void addStudent(Users user) {
        student.put(user.getUsername(),user);
    }

    void login(Users users) {

    }

    public void addTeacher(){

    }
}
