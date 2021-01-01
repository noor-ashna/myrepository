package com.spring.model;

import java.sql.Timestamp;

public class Jocker {
                                     // First created this  1
	private int jid;
	private String name;
	private int age;
	private float price;
	private String email;
	private Timestamp doe;

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "Jocker [jid=" + jid + ", name=" + name + ", age=" + age + ", price=" + price + ", email=" + email
				+ ", doe=" + doe + "]";
	}

}
