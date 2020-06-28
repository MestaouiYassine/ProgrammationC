package com.projet.programmationenc;

public class LastChat {
    public String lastMessage,senderId,receiverId,receiverFirstName,receiverLastName,receiverAvatar,messageDate;

    public LastChat(String lastMessage, String senderId, String receiverId, String receiverFirstName, String receiverLastName, String receiverAvatar, String messageDate) {
        this.lastMessage = lastMessage;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
        this.receiverAvatar = receiverAvatar;
        this.messageDate = messageDate;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public String getReceiverAvatar() {
        return receiverAvatar;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public void setReceiverAvatar(String receiverAvatar) {
        this.receiverAvatar = receiverAvatar;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }
}
