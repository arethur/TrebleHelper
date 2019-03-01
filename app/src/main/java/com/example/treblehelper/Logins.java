package com.example.treblehelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        teacher = new HashMap<>;
    }

    public void create(View v){
        startActivity(new Intent(this, createAccount.class));
    }

    void addStudent(Users user) {
        student.put(user.getUsername(),user);
    }

    void loginButton(View view) {
        String Username;
        String password;
        Users user;

        if(student.containsKey(Username))
            Student(student.containsKey(Username));
    }

    public void addTeacher(Users user){ teacher.put(user.getUsername(), user); }
}
