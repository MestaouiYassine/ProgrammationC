package com.projet.programmationenc;

import android.net.Uri;

import java.util.Date;

public class Student {
    private String studentID,firstName,lastName,password,avatar;
    private String[] completedCourses;

//    public Student() {}
//
//    public Student(String id, String firstname, String lastname, String password) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.password = password;
//        this.avatar = "android.resource://com.projet.programmationenc/mipmap/ic_person_grayv2_round";
//    }

//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }


    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public String[] getCompletedCourses() {
        return completedCourses;
    }
}
