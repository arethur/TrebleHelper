package com.example.treblehelper;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Announcements {

    ArrayAdapter<String> arrayAdapter;
    private List<String> announcements;


    public Announcements() {
        announcements = new ArrayList<>();
//  Need to make listview and add id to this line.

//    ListView listView = findViewById(R.id.listViewForecast);
//        listView.setAdapter(arrayAdapter);
    }

    public Announcements(List<String> announcements) {
        this.announcements = announcements;
    }

    public List<String> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<String> announcements) {
        this.announcements = announcements;
    }

    public void addAnnounce(String newAnnouncement) { announcements.add(newAnnouncement); }

    public void viewAnnouncements() {
        for (String anouce : announcements) {
            String outlook = "";
            if (announcements.size() > 0) {
                // Just get the first item in the outlook descriptions...
                outlook = announcements.get(0);
            }

            // Prepare a string that has the time and the outlook
            String results = outlook;

            arrayAdapter.add(results);
        }
    }
}
