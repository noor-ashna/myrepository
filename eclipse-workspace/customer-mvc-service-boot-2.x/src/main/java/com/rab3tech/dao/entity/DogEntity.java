package com.rab3tech.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data    
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
}
