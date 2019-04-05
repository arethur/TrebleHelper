package com.example.treblehelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TeacherView extends AppCompatActivity {

    private Teacher teacher;
    private ArrayList<Student> studentList;
    private ListView SL;
    private Gson gson = new Gson();
    private List<String> arrayAdapter = new ArrayList<>();

//    public TeacherView(Teacher teachers1){
//        this.teacher = teachers1;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_view);

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
        Log.d("Annoucements", "Starting on the announcements");
        AnnocumentViewlist();
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

    public void AnnocumentViewlist() {

        Announcements announcements = new Announcements(this);
        List<String> Aview = announcements.viewAnnouncements();

        if (Aview.size() == 0)
        {
            Aview.add("You currently have no Announcements");
        }

        CustomArrayAdapterAnnoucemet Alist = new CustomArrayAdapterAnnoucemet(this, Aview);

        Log.d("AnnouceListview", "The Array adapter has been made and converted over ");



        ListView lv = findViewById(R.id.Alistview);
        lv.setAdapter(Alist);

        Log.d("AnoucementsList", "Announcement listView was made.");
    }

    public void AddAnnouncement(View View){
        Intent intent= new Intent(this, AddingAnnoucement.class);
        startActivity(intent);

    }
//   public Addstudents(View view){
//    Map<String, Users> Students;
//
//   }
}
