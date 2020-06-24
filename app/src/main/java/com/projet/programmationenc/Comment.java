package com.projet.programmationenc;

import java.util.Date;

public class Comment {
//    private int commentID,postID;
    public String descriptionComment,fullNameComment,avatarComment,commentID;
    public String dateComment;

    public Comment() {
    }

    public Comment(String descriptionComment, String fullNameComment, String avatarComment, String commentID, String dateComment) {
        this.descriptionComment = descriptionComment;
        this.fullNameComment = fullNameComment;
        this.avatarComment = avatarComment;
        this.commentID = commentID;
        this.dateComment = dateComment;
    }

    public String getDescriptionComment() {
        return descriptionComment;
    }

    public String getFullNameComment() {
        return fullNameComment;
    }

    public String getAvatarComment() {
        return avatarComment;
    }

    public String getCommentID() {
        return commentID;
    }

    public String getDateComment() {
        return dateComment;
    }

    public void setDescriptionComment(String descriptionComment) {
        this.descriptionComment = descriptionComment;
    }

    public void setFullNameComment(String fullNameComment) {
        this.fullNameComment = fullNameComment;
    }

    public void setAvatarComment(String avatarComment) {
        this.avatarComment = avatarComment;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public void setDateComment(String dateComment) {
        this.dateComment = dateComment;
    }

}
