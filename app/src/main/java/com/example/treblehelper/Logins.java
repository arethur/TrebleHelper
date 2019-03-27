package com.example.treblehelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Logins extends AppCompatActivity {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference myRef = database.getReference("Hello World!");

    // myRef.setValue("Hello World!");



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
        usernameEditText = findViewById(R.id.Username);
        passwordEditText = findViewById(R.id.Password);

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

    public void addStudent(Users user) {
        UserMapManager mngr = new UserMapManager();
        student.clear();
        student = mngr.getUserMap(this);
        student.put(user.getUsername(),user);
        mngr.saveUserMap(student, this);
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

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();


        Log.d("J-DEBUG","contains key?: " + teacher.containsKey(username));
//        Log.d("DEBUG","correct password?: " + teacher.get(username).getPassword().equals(password));
        if(teacher.containsKey(username) && teacher.get(username).getPassword().equals(password)){

            Log.i("LoginMatchTeacher", "The Username and Password match a teacher's account");

            Teacher teacherUser = (Teacher) teacher.get(username);
            TeacherView TV = new TeacherView(teacherUser);
            Intent intent = new Intent(this, TV.getClass());

            Log.i("TeacherView", "Teacher intent was created");

            startActivity(intent);

        }else if(student.containsKey(username) && student.get(username).getPassword() == password){

            Log.i("LoginMatchStudent", "The Username and Password match a student's account");

            Student studentUser = (Student) student.get(username);
            StudentView SV = new StudentView(studentUser);
            Intent intent = new Intent(this, SV.getClass());

            Log.i("StudentView", "Student intent was created.");

            startActivity(intent);
        } else
            Toast.makeText(this,"Invalid Username or Password.",Toast.LENGTH_LONG).show();
            usernameEditText.getText().clear();
            passwordEditText.getText().clear();
    }

    public void addTeacher(Users users){
        Log.d("J-DEBUG","Teacher: " + users.getUsername());
        UserMapManager mngr = new UserMapManager();
        if (teacher.size() > 0)
            teacher.clear();
        teacher = mngr.getUserMap(this);
        teacher.put(users.getUsername(), users);
        mngr.saveUserMap(teacher, this);
        Log.d("J-DEBUG","contains key?: " + teacher.containsKey(users.getUsername()));
    }


}
