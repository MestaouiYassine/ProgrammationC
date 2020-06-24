package com.projet.programmationenc;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Student {
    public String studentID, firstName, lastName, pass, avatar, completedBasic, completedCondLoop, completedFuncArrPoint, completedStrings, completedEnumStruct, completedFiles;
    public String status;

    public Student() {
    }

    public Student(String studentID, String firstName, String lastName, String pass, String avatar, String status) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pass = pass;
        this.avatar = avatar;
        this.completedBasic = "null";
        this.completedCondLoop = "null";
        this.completedFuncArrPoint = "null";
        this.completedStrings = "null";
        this.completedEnumStruct = "null";
        this.completedFiles = "null";
        this.status = status;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setCompletedBasic(String completedBasic) {
        this.completedBasic = completedBasic;
    }

    public void setCompletedCondLoop(String completedCondLoop) {
        this.completedCondLoop = completedCondLoop;
    }

    public void setCompletedFuncArrPoint(String completedFuncArrPoint) {
        this.completedFuncArrPoint = completedFuncArrPoint;
    }

    public void setCompletedStrings(String completedStrings) {
        this.completedStrings = completedStrings;
    }

    public void setCompletedEnumStruct(String completedEnumStruct) {
        this.completedEnumStruct = completedEnumStruct;
    }

    public void setCompletedFiles(String completedFiles) {
        this.completedFiles = completedFiles;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
