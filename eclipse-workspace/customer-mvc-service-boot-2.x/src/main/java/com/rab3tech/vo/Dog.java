package com.rab3tech.vo;

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
}
