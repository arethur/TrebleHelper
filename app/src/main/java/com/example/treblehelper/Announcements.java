package com.example.treblehelper;

import java.util.ArrayList;
import java.util.List;

public class Announcements {
    private List<String> announcements;

    public Announcements() {
        announcements = new ArrayList<>();
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

    public void addAnnounce() {

    }

}
