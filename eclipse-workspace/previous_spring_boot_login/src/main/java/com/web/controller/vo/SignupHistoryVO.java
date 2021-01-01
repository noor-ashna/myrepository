package com.web.controller.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SignupHistoryVO {
	private int shid;
	private Timestamp intime;
	private Timestamp outtime;
	private String location;
	private String username;
	public int getShid() {
		return shid;
	}
	public void setShid(int shid) {
		this.shid = shid;
	}
	public Timestamp getIntime() {
		return intime;
	}
	public void setIntime(Timestamp intime) {
		this.intime = intime;
	}
	public Timestamp getOuttime() {
		return outtime;
	}
	public void setOuttime(Timestamp outtime) {
		this.outtime = outtime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
