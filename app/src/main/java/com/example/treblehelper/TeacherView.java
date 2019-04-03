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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherView extends AppCompatActivity {

    private Teacher teacher;
    private ArrayList<Student> studentList;
    private ListView SL;
    private Gson gson = new Gson();


//    public TeacherView(Teacher teachers1){
//        this.teacher = teachers1;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String stringTeach = null;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                stringTeach = null;
            } else {
                stringTeach = extras.getString("teacher");
                teacher = gson.fromJson(stringTeach, Teacher.class);
            }
        }

        TextView name = findViewById(R.id.textView2);
        name.setText(teacher.getFirstName() + " " + teacher.getLastName());

        Log.i("Listviews", "Starting on list views.");
//
//        Announcements announcements = new Announcements(this);
//        announcements.viewAnnouncements();
//
//        Log.d("AnoucementsList", "Announcement listView was made.");
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
//        SL = SL.findViewById(R.id.studentslist);
//        SL.setAdapter(arrayAdapter);
//
//        for(Users students : studentList) {
//            String outlook = " ";
//            if (studentList.size() > 0) {
//                outlook = String.valueOf(studentList.get(0));
//            }
//            arrayAdapter.add(outlook);
//        }
//
//        Log.d("StudentsList","Student ListView was made");
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

//   public Addstudents(View view){
//    Map<String, Users> Students;
//
//   }
}
