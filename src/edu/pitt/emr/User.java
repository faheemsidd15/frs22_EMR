package edu.pitt.emr;

public abstract class User {
    /**
     * This is the Abstract User class
     */

    private String userID;
    private String firstName;
    private String lastName;
    private String ssn;
    private char gender;

    private String streetAddress;
    private String city;
    private String state;
    private String zip;

    public User(String firstName, String lastName, String ssn, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.gender = gender;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getUserID() {
        return userID;
    }

    public String getSsn() {
        return ssn;
    }

}
