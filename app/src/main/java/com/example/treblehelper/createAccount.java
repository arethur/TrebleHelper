package com.example.treblehelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class createAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        //add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //implements the back button
        if (id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    /****Back Button Finished */

    public void addStudent(View view) {
        EditText fName = findViewById(R.id.firstName);
        EditText lName = findViewById(R.id.lastName);
        EditText birthday = findViewById(R.id.birthday);
        EditText phoneNum = findViewById(R.id.phoneNum);
        EditText email = findViewById(R.id.email);
        EditText instrument = findViewById(R.id.instrument);
        EditText userName = findViewById(R.id.userName);
        EditText password = findViewById(R.id.password);
        EditText password2 = findViewById(R.id.password2);

        if(!password.equals(password2)){
            Toast.makeText(createAccount.this, "Passwords do not match.",Toast.LENGTH_LONG).show();
            password.getText().clear();
            password2.getText().clear();
            return;
        }

        String phone = phoneNum.getText().toString();
        int phoneNumber = Integer.parseInt(phone);

        int age = AgeCalculation(birthday);

        Student student = new Student((fName.getText().toString()), lName.getText().toString(),
                birthday.getText().toString(), phoneNumber, email.getText().toString(),
                instrument.getText().toString(),userName.getText().toString(), password.getText().toString(), age);

//        HashMap<String, Users> hashmap = (HashMap<String, Users>) getIntent().getSerializableExtra("student");

        Logins.addStudent(student);

//        hashmap.put(student.getUsername(), student);

        Log.d("StudentAccount", "A student account was made.");
        Toast.makeText(createAccount.this, "Account for " + student.getFirstName() + " Created.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, Logins.class);
        startActivity(intent);

    }

    public void addTeacher(View View) {
        EditText fName = (EditText) findViewById(R.id.firstName);
        EditText lName = (EditText) findViewById(R.id.lastName);
        EditText birthday = (EditText) findViewById(R.id.birthday);
        EditText phoneNum = (EditText) findViewById(R.id.phoneNum);
        EditText email = (EditText) findViewById(R.id.email);
        EditText instrument = (EditText) findViewById(R.id.instrument);
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.password);
        EditText password2 = findViewById(R.id.password2);

        if(password.getText() != password2.getText()){
            Toast.makeText(createAccount.this, "Passwords do not match.",Toast.LENGTH_LONG).show();
            password.getText().clear();
            password2.getText().clear();
            return;
        }

        String phone= phoneNum.getText().toString();
        int phoneNumber=Integer.parseInt(phone);

        int age = AgeCalculation(birthday);

        Teacher teacher = new Teacher((fName.getText().toString()), lName.getText().toString(),
                birthday.getText().toString(), phoneNumber, email.getText().toString(),
                instrument.getText().toString(),userName.getText().toString(), password.getText().toString(), age);

        Logins.addTeacher(teacher);

        Log.d("TeacherAccount", "Teacher account has been created");
        Toast.makeText(createAccount.this, "Account for " + teacher.getFirstName() + " Created.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, Logins.class);
        startActivity(intent);

    }

    public static int AgeCalculation (EditText birthday){
        int Age =0;
        System.out.println(birthday.toString());
        return Age;
    }
}
