
package com.linuxgroup.homeschool.client.domain;

public class BuddyEntity {
	private int avatar;
	private String account;
	private String nick;
	
	public BuddyEntity(String account,String nick,int avatar){
		this.avatar=avatar;
		this.account=account;
		this.nick=nick;
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

//	public String getTrends() {
//		return trends;
//	}

//	public void setTrends(String trends) {
//		this.trends = trends;
//	}	
}
