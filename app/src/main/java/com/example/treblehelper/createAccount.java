package com.example.treblehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class createAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

    }

    void addUser() {
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

        Student student = new Student(fName.toString(), lName.toString(), birthday.toString(), phoneNumber, email.toString(), instrument.toString(),userName.toString(), password.toString());

    }

    void addTeacher() {
        EditText fName = (EditText) findViewById(R.id.editText);
        EditText lName = (EditText) findViewById(R.id.editText2);
        EditText birthday = (EditText) findViewById(R.id.editText3);
        EditText phoneNumber = (EditText) findViewById(R.id.editText4);
        EditText email = (EditText) findViewById(R.id.editText5);
        EditText instrument = (EditText) findViewById(R.id.editText6);
        EditText userName = (EditText) findViewById(R.id.editText7);
        EditText password = (EditText) findViewById(R.id.editText8);

    }
}
