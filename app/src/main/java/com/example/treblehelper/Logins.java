package com.example.treblehelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Logins extends AppCompatActivity {

    public static Map<String, Users> student;
    public static Map<String, Users> teacher;

    private EditText passwordEditText;
    private EditText usernameEditText;

    private CheckBox rememberMe;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        bindWidget();

        getPreferencesData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Implements the back button
        if (id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getPreferencesData() {
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        if(sp.contains("pref_name")) {
            String u = sp.getString("pref_name","Not Found");
            usernameEditText.setText(u.toString());
        }
        if(sp.contains("pref_pass")) {
            String p = sp.getString("pref_pass", "Fot Found");
            passwordEditText.setText(p.toString());
        }
        if(sp.contains("pref_check")) {
            Boolean b = sp.getBoolean("pref_check", false);
            rememberMe.setChecked(b);
        }
    }

    private void bindWidget() {
        rememberMe = (CheckBox) findViewById(R.id.checkBoxRememberMe);
        usernameEditText = (EditText) findViewById(R.id.Username);
        passwordEditText = (EditText) findViewById(R.id.Password);

    }


    public Logins() {
        student = new HashMap<>();
        teacher = new HashMap<>();
    }

    public void create(View v){
        Intent intent = new Intent(this, createAccount.class);
        intent.putExtra("student", (Serializable) student);
        intent.putExtra("teacher", (Serializable) teacher);
        startActivity(intent);
    }

    public static void addStudent(Users user) {
        student.put(user.getUsername(),user);
    }

    public void login(View view) {
        if(rememberMe.isChecked()) {
            Boolean boolIsChecked = rememberMe.isChecked();
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.putString("pref_name", usernameEditText.getText().toString());
            editor.putString("pref_pass", passwordEditText.getText().toString());
            editor.putBoolean("pref_check", boolIsChecked);
            editor.apply();
            Toast.makeText(getApplicationContext(),
                    "Settings have been saved",Toast.LENGTH_LONG).show();
        }else {
            myPrefs.edit().clear().apply();
        }
        usernameEditText.getText().clear();
        passwordEditText.getText().clear();
    }

    public void addTeacher(Users users){
        teacher.put(users.getUsername(), users);
    }
}
