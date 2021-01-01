package com.web.dao;

public class Jocker {
	String name = "Jhon";
	int age = 20;

	public Jocker() {
		name = "Danger";
		age = 55;
	}

	public Jocker(String pname, int page) {
		name = pname;
		age = page;
	}

	public void show() {
		System.out.println("Name = " + name + " , age = " + age);

	}

}
