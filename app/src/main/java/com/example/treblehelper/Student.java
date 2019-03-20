package com.example.treblehelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student extends Users {
    private List<Teacher> teachers;
    private List<String> tasks;
    //There needs to a variable here about recordings.


    public Student() {
        teachers = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public Student(List<Teacher> teachers, List<String> tasks) {
        this.teachers = teachers;
        this.tasks = tasks;
    }

    public Student(String firstName, String lastName, String birthday,
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
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public void getRecording(){}

    public void searchTeaachers(){}

}



