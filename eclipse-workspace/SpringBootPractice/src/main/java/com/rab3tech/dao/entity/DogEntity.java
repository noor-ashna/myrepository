package com.rab3tech.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="dogs_tbl")
@Entity
public class DogEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int did;
	
	private String name;
    private String color;
    private String email;
    private int tail;
    private String breed;
    @Column(columnDefinition="longblob")
    private byte[] photo;
	public DogEntity(String name, String color, String email, int tail, String breed, byte[] photo) {
		super();
		this.name = name;
		this.color = color;
		this.email = email;
		this.tail = tail;
		this.breed = breed;
		this.photo = photo;
	}
	public DogEntity() {
		
		
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
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
    
    
    
}
