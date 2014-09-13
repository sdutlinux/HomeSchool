package com.linuxgroup.homeschool.client.domain;

public class ChatEntity {
	private int avatar;
	private String content;
	private String sendTime;
	private boolean isLeft;
	
	public ChatEntity(String content,String time, int avatar, boolean isLeft){
		this.avatar = avatar;
		this.content = content;
		this.sendTime = time;
		this.isLeft = isLeft;
	}
	
	public int getAvatar() {
		return avatar;
	}
	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return sendTime;
	}
	public void setTime(String time) {
		this.sendTime = time;
	}
	public boolean isLeft() {
		return isLeft;
	}
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}
}
