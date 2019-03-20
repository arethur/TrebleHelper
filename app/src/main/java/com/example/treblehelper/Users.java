package com.example.treblehelper;

import java.util.Comparator;

class Users {

    private String FirstName;
    private String LastName;
    private String Birthday;
    private int phoneNumber;
    private String Email;
    private String instrument;
    private String Username;
    private String Password;
    private int age;

    public Users() {
        FirstName = "";
        LastName = "";
        Birthday = "";
        phoneNumber = 0;
        Email = "";
        instrument = "";
        Password = "";
        age = 0;
    }

    public Users(String firstName, String lastName, String birthday,
                 int phoneNumber, String email,
                 String instrument, String username, String password) {
        FirstName = firstName;
        LastName = lastName;
        Birthday = birthday;
        this.phoneNumber = phoneNumber;
        Email = email;
        this.instrument = instrument;
        Username = username;
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    /************These Are the Sorting Functions********************************************/


    //FIRST NAME SORT
    public static Comparator<Student> StuFirstNameComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            String StudentName1 = s1.getFirstName().toUpperCase();
            String StudentName2 = s2.getFirstName().toUpperCase();

            //ascending order
            return StudentName1.compareTo(StudentName2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};


    //LAST NAME SORT
    public static Comparator<Student> StuLastNameComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            String StudentName1 = s1.getFirstName().toUpperCase();
            String StudentName2 = s2.getFirstName().toUpperCase();

            //ascending order
            return StudentName1.compareTo(StudentName2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }
    };


    //AGE SORT
    public static Comparator<Student> StuAge = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {

            int Age = s1.getAge();
            int Age2 = s2.getAge();

            /*For ascending order*/
            return Age-Age2;

            /*For descending order*/
            //rollno2-rollno1;
        }};

    //INSTRUMENT SORT
    public static Comparator<Student> StuInstrumentComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            String Instrument1 = s1.getInstrument().toUpperCase();
            String Instrument2 = s2.getInstrument().toUpperCase();

            //ascending order
            return Instrument1.compareTo(Instrument2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};
}
