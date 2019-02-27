package com.example.treblehelper;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Users {
    public List<Users> students;
    private Announcements announcements;

    public Teacher() {
        students = new ArrayList<>();
    }

    public Teacher(List<Users> students, Announcements announcements) {
        this.students = students;
        this.announcements = announcements;
    }

    public List<Users> getStudents() {
        return students;
    }

    public void setStudents(List<Users> students) {
        this.students = students;
    }

    public Announcements getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Announcements announcements) {
        this.announcements = announcements;
    }

    public void addStudent(Users student) {

        students.add(student);
    }

    public void showStudents() {

        for(Users users :students){
            System.out.println(users.getFirstName() + " " + users.getLastName());
        }
    }

    public void showAnnounce() {

    }

    public void sortList() {

    }

    public void viewOneStudent() {

    }


}
