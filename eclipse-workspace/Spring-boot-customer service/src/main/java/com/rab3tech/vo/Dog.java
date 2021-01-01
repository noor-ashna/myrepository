package com.rab3tech.vo;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Dog {
	private int did;
	private String name;
    private String color;
    private String email;
    private int tail;
    private String breed;
    private byte[] photo;
	public int getDid() {
		return did;
	}
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public String getEmail() {
		return email;
	}
	public int getTail() {
		return tail;
	}
	public String getBreed() {
		return breed;
	}
	public byte[] getPhoto() {
		return photo;
	}
	@Override
	public String toString() {
		return "Dog [did=" + did + ", name=" + name + ", color=" + color + ", email=" + email + ", tail=" + tail
				+ ", breed=" + breed + ", photo=" + Arrays.toString(photo) + "]";
	}
    
    
}
