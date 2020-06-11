package com.projet.programmationenc;

import java.util.Date;

public class Comment {
    private int commentID,postID;
    private String descriptionComment,studentID;
    private Date dateComment;

    public int getCommentID() {
        return commentID;
    }

    public int getPostID() {
        return postID;
    }

    public String getDescriptionComment() {
        return descriptionComment;
    }

    public String getStudentID() {
        return studentID;
    }

    public Date getDateComment() {
        return dateComment;
    }
}
