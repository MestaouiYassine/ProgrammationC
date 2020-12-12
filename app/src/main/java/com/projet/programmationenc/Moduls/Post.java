package com.projet.programmationenc.Moduls;

import android.net.Uri;

import java.util.Date;

public class Post {
//    public int postID;
    public String studentAvatar;
    public String questionPost,descriptionPost,studentFullName,studentID;
    public String datePost;
    public int votes;

    public Post() {
    }

    public Post(String studentAvatar, String questionPost, String descriptionPost, String studentFullName, String studentID,String datePost,int votes) {
        this.studentAvatar = studentAvatar;
        this.questionPost = questionPost;
        this.descriptionPost = descriptionPost;
        this.studentFullName = studentFullName;
        this.studentID = studentID;
        this.datePost = datePost;
        this.votes = votes;
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

    public int getVotes() {
        return votes;
    }

    public void setStudentAvatar(String studentAvatar) {
        this.studentAvatar = studentAvatar;
    }

    public void setQuestionPost(String questionPost) {
        this.questionPost = questionPost;
    }

    public void setDescriptionPost(String descriptionPost) {
        this.descriptionPost = descriptionPost;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
