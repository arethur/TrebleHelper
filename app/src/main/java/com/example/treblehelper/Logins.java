package com.example.treblehelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Logins extends AppCompatActivity {

    public FirebaseDatabase myref = FirebaseDatabase.getInstance();
    public DatabaseReference FirebaseStudent = myref.getReference("/users/Q6i1lwnmJhmuVXAz1qgO/student");
    public DatabaseReference FirebaseTeacher = myref.getReference("/users/Q6i1lwnmJhmuVXAz1qgO/teacher");

    public Map<String, Users> student;
    public Map<String, Users> teacher;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();


    private EditText passwordEditText;
    private EditText usernameEditText;

    private CheckBox rememberMe;
    private SharedPreferences myPrefs;
    private UserMapManager mapManager;
    private static final String PREFS_NAME = "myPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        bindWidget();
        getPreferencesData();

        mAuth = FirebaseAuth.getInstance();
        mapManager = new UserMapManager();
        student = new HashMap<>();
        teacher = new HashMap<>();


        //Authentication for Firebase
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("SingIn", "signInAnonymously:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("SingIn", "signInAnonymously:failure", task.getException());
                            Toast.makeText(Logins.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }

                    }
                });


    }

    @Override
    public void onResume() {
        super.onResume();
        student = mapManager.getUserMap(this, "STUDENT");
        teacher = mapManager.getUserMap(this, "TEACHER");
        getPreferencesData();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Implements the back button
        if (id == android.R.id.home)
        {
            finish();
        }
        return Logins.super.onOptionsItemSelected(item);
    }

    private void getPreferencesData() {
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        if (sp.contains("pref_name")) {
            String u = sp.getString("pref_name", "Not Found");
            usernameEditText.setText(u);
        }
        if (sp.contains("pref_pass")) {
            String p = sp.getString("pref_pass", "Fot Found");
            passwordEditText.setText(p);
        }
        if (sp.contains("pref_check")) {
            Boolean b = sp.getBoolean("pref_check", false);
            rememberMe.setChecked(b);
        } else {
        }
    }
    private void bindWidget() {
        rememberMe = findViewById(R.id.checkBoxRememberMe);
        usernameEditText = findViewById(R.id.Username);
        passwordEditText = findViewById(R.id.Password);

    }


    public void Logins(){
        student = new HashMap<>();
        teacher = new HashMap<>();
        FirebaseStudent.addListenerForSingleValueEvent(new ValueEventListener() {

            //Event Listeners that check the and update the maps every time the app starts up.
            // This is for the student map.
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                student = (Map) dataSnapshot.getValue();
                Iterator<String> itr = student.keySet().iterator();
                while ((itr).hasNext()) {
                    Log.i("Mapreding","This is in the map " + ((Iterator) itr).next());
                }

                String message = (String) dataSnapshot.getValue();
                Log.d("ReadingFirebase", "This is the message in firebase " + message);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("ErrorWithFirebase", "Error! Database Cancelled");

            }


        });

        //This event listener is for the Teacher map.
        FirebaseTeacher.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                teacher = (Map) dataSnapshot.getValue();
                Iterator<String> itr = teacher.keySet().iterator();
                while ((itr).hasNext()) {
                    Log.d("CheckingIterator","This is in the map " + ((Iterator) itr).next());
                }

                String message = (String) dataSnapshot.getValue();
                Log.d("ReadingFirebase", "This is the message in firebase " + message);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("ErrorWithFirebase", "Error! Database Cancelled");

            }
        });
    }
//    //This is a test.
//    Student TestStudent = new Student("Gary","Robert",
//            "May 20 1997",55065252,
//            "gary@gmail.com", "piano",
//            "GarBot", "123", 14);
//
//            student.put(TestStudent.getUsername(), TestStudent);
//
//            FirebaseStudent.setValue(student);
//
//    Teacher TestTeacher = new Teacher( "Hannah", "Smith",
//            "November 2, 2016", 55026982,
//            "hannah@gmail.com", "piano",
//            "HanahBot", "123", 31 );
//
//            teacher.put(TestTeacher.getUsername(), TestTeacher);
//              FirebaseTeacher.setValue(teacher);
//            System.out.println("This is the test in Create account");


    public void create(View v){
        Intent intent = new Intent(this, createAccount.class);
        startActivity(intent);
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
                    "Settings have been saved",Toast.LENGTH_SHORT).show();
        }else {
            myPrefs.edit().clear().apply();
        }

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(teacher.containsKey(username) && teacher.get(username).getPassword().equals(password)){

            Log.i("LoginMatchTeacher", "The Username and Password match a teacher's account");

            Intent intent = new Intent(this, TeacherView.class);
            Gson gson = new Gson();
            String stringTeach = gson.toJson(teacher.get(username));
            intent.putExtra("teacher", stringTeach);

            Log.i("TeacherView", "Teacher intent was created");

            startActivity(intent);

        }else if(student.containsKey(username) && student.get(username).getPassword().equals(password)){

            Log.i("LoginMatchStudent", "The Username and Password match a student's account");


            Intent intent = new Intent(this, StudentView.class);
            Gson gson = new Gson();
            String stringStudent = gson.toJson(student.get(username));
            intent.putExtra("student", stringStudent);

            Log.i("StudentView", "Student intent was created.");

            startActivity(intent);
        } else
            Toast.makeText(this,"Invalid Username or Password.",Toast.LENGTH_LONG).show();
            usernameEditText.getText().clear();
            passwordEditText.getText().clear();
    }

}
