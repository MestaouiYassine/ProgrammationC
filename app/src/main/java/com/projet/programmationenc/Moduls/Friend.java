package com.projet.programmationenc.Moduls;

public class Friend {
    public String friendID, friendFirstName, friendLastName, friendAvatar, friendStatus,dateAdded;

    public Friend() {
    }

    public Friend(String friendID, String friendFirstName, String friendLastName, String friendAvatar, String friendStatus, String dateAdded) {
        this.friendID = friendID;
        this.friendFirstName = friendFirstName;
        this.friendLastName = friendLastName;
        this.friendAvatar = friendAvatar;
        this.friendStatus = friendStatus;
        this.dateAdded = dateAdded;
    }

    public String getFriendID() {
        return friendID;
    }

    public String getFriendFirstName() {
        return friendFirstName;
    }

    public String getFriendLastName() {
        return friendLastName;
    }

    public String getFriendAvatar() {
        return friendAvatar;
    }

    public String getFriendStatus() {
        return friendStatus;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setFriendID(String friendID) {
        this.friendID = friendID;
    }

    public void setFriendFirstName(String friendFirstName) {
        this.friendFirstName = friendFirstName;
    }

    public void setFriendLastName(String friendLastName) {
        this.friendLastName = friendLastName;
    }

    public void setFriendAvatar(String friendAvatar) {
        this.friendAvatar = friendAvatar;
    }

    public void setFriendStatus(String friendStatus) {
        this.friendStatus = friendStatus;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
