package com.example.treblehelper;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Announcements {
    private ListView lv;
    private List<String> announcements;
//    public Context cnxt;

    public Announcements() {
        announcements = new ArrayList<>();
    }

//    public Announcements(Context context) {
//        this.cnxt = context;
//    }

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

    public void viewAnnouncements(Context context) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1);
        lv = lv.findViewById(R.id.annoucements);
        lv.setAdapter(arrayAdapter);

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
