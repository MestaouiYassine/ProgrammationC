package com.projet.programmationenc;

import android.net.Uri;

import java.util.Date;

public class Student {
    public String id,firstname,lastname,password;
    public String avatarUri;

    public Student() {}

    public Student(String id, String firstname, String lastname, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.avatarUri = "android.resource://com.projet.programmationenc/mipmap/ic_person_grayv2_round";
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatarUri) {
        this.avatarUri = avatarUri;
    }

}
