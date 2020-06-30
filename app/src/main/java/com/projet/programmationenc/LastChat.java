package com.projet.programmationenc;

public class LastChat {
    public String lastMessage,senderId,receiverId,senderFirstName,receiverFirstName,senderLastName,receiverLastName,senderAvatar,receiverAvatar;
    public long lastChatMillis;

    public LastChat() {
    }

    public LastChat(String lastMessage, String senderId, String receiverId, String senderFirstName, String receiverFirstName, String senderLastName, String receiverLastName, String senderAvatar, String receiverAvatar, long lastChatMillis) {
        this.lastMessage = lastMessage;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderFirstName = senderFirstName;
        this.receiverFirstName = receiverFirstName;
        this.senderLastName = senderLastName;
        this.receiverLastName = receiverLastName;
        this.senderAvatar = senderAvatar;
        this.receiverAvatar = receiverAvatar;
        this.lastChatMillis = lastChatMillis;
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

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public String getSenderAvatar() {
        return senderAvatar;
    }

    public String getReceiverAvatar() {
        return receiverAvatar;
    }

    public long getLastChatMillis() {
        return lastChatMillis;
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

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public void setSenderAvatar(String senderAvatar) {
        this.senderAvatar = senderAvatar;
    }

    public void setReceiverAvatar(String receiverAvatar) {
        this.receiverAvatar = receiverAvatar;
    }

    public void setLastChatMillis(long lastChatMillis) {
        this.lastChatMillis = lastChatMillis;
    }
}
