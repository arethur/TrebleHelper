package com.example.treblehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Announcements {
    private List<String> announcements;
    private Context cntx;

    public Announcements(Context context) {
        announcements = new ArrayList<>();
        cntx = context;
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

    public List<String> viewAnnouncements() {
        for (String anouce : announcements) {
            String outlook = "";
            if (announcements.size() > 0) {
                // Just get the first item in the outlook descriptions...
                outlook = announcements.get(0);
            }
            // Prepare a string that has the time and the outlook
            String results = outlook;
        }
        return announcements;
    }
}
