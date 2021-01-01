package com.web.controller.vo;

import lombok.Data;


public class EmailVO {

	private String to;
	private String subject;
	private String currentRoles;
	private String newRoles;
	private String from;
	private String name;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCurrentRoles() {
		return currentRoles;
	}
	public void setCurrentRoles(String currentRoles) {
		this.currentRoles = currentRoles;
	}
	public String getNewRoles() {
		return newRoles;
	}
	public void setNewRoles(String newRoles) {
		this.newRoles = newRoles;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmailVO [to=" + to + ", subject=" + subject + ", currentRoles=" + currentRoles + ", newRoles="
				+ newRoles + ", from=" + from + ", name=" + name + "]";
	}
	
	
	
}
