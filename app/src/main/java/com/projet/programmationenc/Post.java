package com.projet.programmationenc;

import java.util.Date;

public class Post {
    private int postID;
    private String questionPost,descriptionPost,studentID;
    private Date datePost;

    public int getPostID() {
        return postID;
    }

    public String getQuestionPost() {
        return questionPost;
    }

    public String getDescriptionPost() {
        return descriptionPost;
    }

    public String getStudentID() {
        return studentID;
    }

    public Date getDatePost() {
        return datePost;
    }
}
