package com.projet.programmationenc;

import android.net.Uri;

import java.util.Date;

public class CardViewForum {
    private Uri forumAvatar;
    private String forumQuestion,forumFullname;
    private Date forumDatePost;

    public CardViewForum(Uri forumAvatar, String forumQuestion, String forumFullname, Date forumDatePost) {
        this.forumAvatar = forumAvatar;
        this.forumQuestion = forumQuestion;
        this.forumFullname = forumFullname;
        this.forumDatePost = forumDatePost;
    }

    public Uri getForumAvatar() {
        return forumAvatar;
    }

    public String getForumQuestion() {
        return forumQuestion;
    }

    public String getForumFullname() {
        return forumFullname;
    }

    public Date getForumDatePost() {
        return forumDatePost;
    }
}
