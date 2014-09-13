package com.linuxgroup.homeschool.client.domain;

public class RecentEntity {
	private int avatar;
	private String account;
	private String nick;
	private String content;
	private String time;
	private boolean isRead;
	
	public RecentEntity(String account, String nick, String content, String time, int avatar, boolean isRead){
		this.avatar=avatar;
		this.account=account;
		this.nick=nick;
		this.content=content;
		this.time=time;
		this.isRead=isRead;
	}

	public int getAvatar() {
		return avatar;
	}

	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	
	public String toString() {
		return "account: " + account + " nick: " + nick
				+ " content: " + content + " time: " + time
				+ "isRead: " + isRead;
	}
}
