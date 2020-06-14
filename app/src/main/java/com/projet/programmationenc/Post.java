package com.projet.programmationenc;

import android.net.Uri;

import java.util.Date;

public class Post {
//    public int postID;
    public String studentAvatar;
    public String questionPost,descriptionPost,studentFullName,studentID;
    public String datePost;

    public Post() {
    }

    public Post(String studentAvatar, String questionPost, String descriptionPost, String studentFullName, String studentID,String datePost) {
        this.studentAvatar = studentAvatar;
        this.questionPost = questionPost;
        this.descriptionPost = descriptionPost;
        this.studentFullName = studentFullName;
        this.studentID = studentID;
        this.datePost = datePost;
    }

    public String getStudentAvatar() {
        return studentAvatar;
    }

    public String getQuestionPost() {
        return questionPost;
    }

    public String getDescriptionPost() {
        return descriptionPost;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getDatePost() {
        return datePost;
    }
}
