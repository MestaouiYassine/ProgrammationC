package com.projet.programmationenc.Moduls;

public class Chat {
    public String message,sender,receiver,date,avatarReceiver;

    public Chat() {
    }

    public Chat(String message, String sender, String receiver, String date, String avatarReceiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.avatarReceiver = avatarReceiver;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getDate() {
        return date;
    }

    public String getAvatarReceiver() {
        return avatarReceiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAvatarReceiver(String avatarReceiver) {
        this.avatarReceiver = avatarReceiver;
    }
}
