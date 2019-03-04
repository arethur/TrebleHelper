package com.example.treblehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class createAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

    }

    public void addStudent(View view) {
        EditText fName = (EditText) findViewById(R.id.editText);
        EditText lName = (EditText) findViewById(R.id.editText2);
        EditText birthday = (EditText) findViewById(R.id.editText3);
        EditText phoneNum = (EditText) findViewById(R.id.editText4);
        EditText email = (EditText) findViewById(R.id.editText5);
        EditText instrument = (EditText) findViewById(R.id.editText6);
        EditText userName = (EditText) findViewById(R.id.editText7);
        EditText password = (EditText) findViewById(R.id.editText8);

        String phone= phoneNum.getText().toString();
        int phoneNumber=Integer.parseInt(phone);

        Student student = new Student((fName.getText().toString()), lName.getText().toString(),
                birthday.getText().toString(), phoneNumber, email.getText().toString(),
                instrument.getText().toString(),userName.getText().toString(), password.getText().toString());

        HashMap<String, Users> hashmap = (HashMap<String, Users>) getIntent().getSerializableExtra("student");

        Logins.MasteraddStudent(student);

        hashmap.put(student.getUsername(), student);

        Toast.makeText(createAccount.this, "Account for " + student.getFirstName() + " Created.", Toast.LENGTH_LONG).show();;

    }

    void addTeacher() {
        EditText fName = (EditText) findViewById(R.id.editText);
        EditText lName = (EditText) findViewById(R.id.editText2);
        EditText birthday = (EditText) findViewById(R.id.editText3);
        EditText phoneNum = (EditText) findViewById(R.id.editText4);
        EditText email = (EditText) findViewById(R.id.editText5);
        EditText instrument = (EditText) findViewById(R.id.editText6);
        EditText userName = (EditText) findViewById(R.id.editText7);
        EditText password = (EditText) findViewById(R.id.editText8);

        String phone= phoneNum.getText().toString();
        int phoneNumber=Integer.parseInt(phone);

        Teacher teacher = new Teacher(fName.getText().toString(), lName.getText().toString(),
                birthday.getText().toString(),phoneNumber, email.getText().toString(),
                instrument.getText().toString(), userName.getText().toString(), password.getText().toString());

        Logins.MasteraddTeacher(teacher);

        Toast.makeText(createAccount.this, "Account for " + teacher.getFirstName() + " Created.", Toast.LENGTH_LONG).show();;

    }
}
