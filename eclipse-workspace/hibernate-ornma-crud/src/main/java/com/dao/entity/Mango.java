package com.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity //Hey Mango your instance can be persist into db  (persistence means save)
@Table(name="fruits_tbl")    // @Table means in which table 
public class Mango {
	
	@Id     // This means it is primary key(mid)
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // generated value means it is auto generated. Identity means mid value does not need -
	private int mid;                                   // to be set, it is primary key and it will be auto generated 

	@Column(length=12)     // @column is the length of String that we give, but by default it will be 256
	private String color;
	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	private float price;
	
	@Column(length=20)
	private String taste;
	
	@Column(length=200)
	private String description;
	
	@Column(length=200)
	private String url;
		
	private Timestamp dob;
	
	

}
