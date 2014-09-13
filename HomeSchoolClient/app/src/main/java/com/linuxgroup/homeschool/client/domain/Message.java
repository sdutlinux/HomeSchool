package com.linuxgroup.homeschool.client.domain;
import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {
	int type;
	String sender;
	String senderNick;
	int senderAvatar;
	String receiver;
	String content;
	String sendTime;
	User user;
	List<User> userList;
	List<Message> messages;
	
	public String getContent() {
		return content;
	}
	public List<Message> getMessages() {
		return messages;
	}
	
	public String getReceiver() {
		return receiver;
	}
	public String getSender() {
		return sender;
	}
	public int getSenderAvatar() {
		return senderAvatar;
	}
	public String getSenderNick() {
		return senderNick;
	}
	public String getSendTime() {
		return sendTime;
	}
	public int getType() {
		return type;
	}
	public User getUser() {
		return user;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public void setSenderAvatar(int senderAvatar) {
		this.senderAvatar = senderAvatar;
	}
	public void setSenderNick(String senderNick) {
		this.senderNick = senderNick;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public String toString() {
		return "receiver: " + receiver + " sender: " + sender + " content: " + content + " sendtime: " + sendTime;
	}
}
