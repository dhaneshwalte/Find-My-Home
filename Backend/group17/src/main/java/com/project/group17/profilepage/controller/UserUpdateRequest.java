package com.project.group17.profilepage.controller;

public class UserUpdateRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String city;
    private String province;
    private String streetAddress;
    private String gender;
    private String age;
    private String phoneNumber;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public String getCity() {
        return city;
    }
    public String getProvince() {
        return province;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getGender() {
        return gender;
    }
    public String getAge() {
        return age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }


    
}
