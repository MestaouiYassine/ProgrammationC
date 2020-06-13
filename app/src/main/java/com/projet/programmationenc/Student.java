package com.projet.programmationenc;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Student implements Serializable {
    @SerializedName("studentID")
    private String studentID;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("pass")
    private String pass;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("completedBasic")
    private String completedBasic;
    @SerializedName("completedCondLoop")
    private String completedCondLoop;
    @SerializedName("completedFuncArrPoint")
    private String completedFuncArrPoint;
    @SerializedName("completedStrings")
    private String completedStrings;
    @SerializedName("completedEnumStruct")
    private String completedEnumStruct;
    @SerializedName("completedFiles")
    private String completedFiles;

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

    public String getPass() {
        return pass;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getCompletedBasic() {
        return completedBasic;
    }

    public String getCompletedCondLoop() {
        return completedCondLoop;
    }

    public String getCompletedFuncArrPoint() {
        return completedFuncArrPoint;
    }

    public String getCompletedStrings() {
        return completedStrings;
    }

    public String getCompletedEnumStruct() {
        return completedEnumStruct;
    }

    public String getCompletedFiles() {
        return completedFiles;
    }
}
