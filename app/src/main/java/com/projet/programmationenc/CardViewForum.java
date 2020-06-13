package com.projet.programmationenc;

import android.net.Uri;

import java.util.Date;

public class CardViewForum {
    private Uri forumAvatar;
    private String forumQuestion,forumFullName;
    private Date forumDatePost;

    public CardViewForum(Uri forumAvatar, String forumQuestion, String forumFullName, Date forumDatePost) {
        this.forumAvatar = forumAvatar;
        this.forumQuestion = forumQuestion;
        this.forumFullName = forumFullName;
        this.forumDatePost = forumDatePost;
    }

    public Uri getForumAvatar() {
        return forumAvatar;
    }

    public String getForumQuestion() {
        return forumQuestion;
    }

    public String getForumFullName() {
        return forumFullName;
    }

    public Date getForumDatePost() {
        return forumDatePost;
    }
}
