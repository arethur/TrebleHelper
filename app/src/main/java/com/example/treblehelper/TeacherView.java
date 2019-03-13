package com.example.treblehelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TeacherView extends AppCompatActivity {

    private Teacher teacher;
    private ArrayList<Users> students = (ArrayList<Users>) teacher.students;
    private ListView SL;

    TeacherView(Teacher teachers1){
        this.teacher = teachers1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i("Listviews", "Starting on list views.");

        TextView name = findViewById(R.id.textView2);
        name.setText(teacher.getFirstName() + " " + teacher.getLastName());

        Log.d("AnoucementsList", "Announcement listView was made.");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        SL = SL.findViewById(R.id.studentslist);
        SL.setAdapter(arrayAdapter);

        Log.d("StudentsList","Student ListView was made");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

//   public Addstudents(View view){
//
//
//   }
}
