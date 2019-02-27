package com.example.treblehelper;

class Users {

    private String FirstName;
    private String LastName;
    private String Birthday;
    private int phoneNumber;
    private String Email;
    private String instrument;
    private String Username;
    private String Password;

    public Users() {
        FirstName = "";
        LastName = "";
        Birthday = "";
        phoneNumber = 0;
        Email = "";
        instrument = "";
        Password = "";
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

}
