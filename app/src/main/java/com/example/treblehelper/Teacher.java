package com.example.treblehelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teacher extends Users {
    public List<Student> students;
//    private Announcements announcements;

    public Teacher(String Username){
        setUsername(Username);
    }
    public Teacher(String firstName, String lastName, String birthday,
                   int phoneNumber, String email,
                   String instrument, String username, String password, int Age) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setInstrument(instrument);
        setUsername(username);
        setPassword(password);
        setAge(Age);

        students = new ArrayList<>();
//        announcements = new Announcements();
    }

    public void  Teacher(List<Student> students, Announcements announcements) {
        this.students = students;
//        this.announcements = announcements;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

//    public Announcements getAnnouncements() {
//        return announcements;
//    }
//
//    public void setAnnouncements(Announcements announcements) {
//        this.announcements = announcements;
//    }

    public void addStudent(Student student) {

        students.add(student);
    }

    public void showStudents() {

        for(Users users :students){
            System.out.println(users.getFirstName() + " " + users.getLastName());
        }
    }

    public void showAnnounce() {

    }

    public void sortListFname() {
        Collections.sort(this.students, Users.StuFirstNameComparator); }
    public void sortListLname() { Collections.sort(this.students, Users.StuLastNameComparator); }
    public void sortListAge() {
        Collections.sort(this.students, Users.StuAge);
    }
    public void sortListInstrument() {
        Collections.sort(this.students, Users.StuInstrumentComparator);
    }

    public void viewOneStudent() {

    }

}
