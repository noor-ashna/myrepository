package com.rab3tech.controller;

public class Dog {

	private int did; 
	private String name;
	private String color;
	private String email;
	private int tail;
	private String bread;
	private byte[] photo;

	public Dog() {
		super();

	}

	public Dog(int did, String name, String color, String email, int tail, String bread, byte[] photo) {
		super();
		this.did = did;
		this.name = name;
		this.color = color;
		this.email = email;
		this.tail = tail;
		this.bread = bread;
		this.photo = photo;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}

	public String getBread() {
		return bread;
	}

	public void setBread(String bread) {
		this.bread = bread;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Dog [did=" + did + ", name=" + name + ", color=" + color + ", email=" + email + ", tail=" + tail
				+ ", bread=" + bread + ", photo=" + photo + "]";
	}

}
