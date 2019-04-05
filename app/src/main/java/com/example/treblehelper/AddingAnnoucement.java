package com.example.treblehelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddingAnnoucement extends AppCompatActivity {

    private Announcements announcements = new Announcements(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_annoucement);
    }

    public void Save(View view){
        EditText annouce = findViewById(R.id.Annouce);
        String NewAnnouce = annouce.getText().toString();
        announcements.addAnnounce(NewAnnouce);
        Log.d("Adding", "The announcement was added." + NewAnnouce);
        Intent intent = new Intent(this, TeacherView.class);
        startActivity(intent);

    }
}
